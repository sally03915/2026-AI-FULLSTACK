import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../data/auth_provider.dart';

class LoginPage extends ConsumerStatefulWidget {
  const LoginPage({super.key});

  @override
  ConsumerState<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends ConsumerState<LoginPage> {
  final _emailController = TextEditingController();
  final _passwordController = TextEditingController();

  @override
  void dispose() {
    _emailController.dispose();
    _passwordController.dispose();
    super.dispose();
  }

  void _handleLogin() async {
    final email = _emailController.text.trim();
    final password = _passwordController.text.trim();

    if (email.isEmpty || password.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('이메일과 비밀번호를 입력해주세요.')),
      );
      return;
    }

    final success = await ref.read(authProvider.notifier).login({'email': email, 'password': password});
    if (success && mounted) {
      Navigator.pushReplacementNamed(context, '/users');
    }
  }

  @override
  Widget build(BuildContext context) {
    final authState = ref.watch(authProvider);

    return Scaffold(
      appBar: AppBar(title: const Text('로그인')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            TextField(controller: _emailController, decoration: const InputDecoration(labelText: '이메일')),
            const SizedBox(height: 12),
            TextField(controller: _passwordController, obscureText: true, decoration: const InputDecoration(labelText: '비밀번호')),
            const SizedBox(height: 24),
            if (authState.error != null)
              Text(authState.error!, style: const TextStyle(color: Colors.red)),
            const SizedBox(height: 12),
            SizedBox(
              width: double.infinity,
              child: ElevatedButton(
                onPressed: authState.loading ? null : _handleLogin,
                child: authState.loading ? const CircularProgressIndicator(color: Colors.white) : const Text('로그인'),
              ),
            ),
            const SizedBox(height: 12),
            // 🌟 회원가입 페이지로 이동하는 텍스트 버튼 추가
            TextButton(
              onPressed: () {
                Navigator.pushNamed(context, '/signup');
              },
              child: const Text('계정이 없으신가요? 회원가입하기'),
            ),
          ],
        ),
      ),
    );
  }
}