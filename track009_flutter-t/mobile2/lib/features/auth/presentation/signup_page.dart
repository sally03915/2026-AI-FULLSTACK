import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../data/auth_provider.dart';

class SignupPage extends ConsumerStatefulWidget {
  const SignupPage({super.key});

  @override
  ConsumerState<SignupPage> createState() => _SignupPageState();
}

class _SignupPageState extends ConsumerState<SignupPage> {
  final _emailController = TextEditingController();
  final _passwordController = TextEditingController();
  final _nicknameController = TextEditingController();

  // 🌟 중복 확인 여부를 체크하는 상태 변수
  bool _isEmailChecked = false;
  bool _isNicknameChecked = false;

  @override
  void dispose() {
    _emailController.dispose();
    _passwordController.dispose();
    _nicknameController.dispose();
    super.dispose();
  }

  // 🌟 이메일 중복 확인 로직
  void _checkEmail() async {
    final email = _emailController.text.trim();
    if (email.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('이메일을 입력해주세요.')));
      return;
    }

    final exists = await ref.read(authProvider.notifier).checkEmailDuplicate(email);
    if (exists) {
      if (mounted) ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('이미 사용 중인 이메일입니다.')));
      setState(() => _isEmailChecked = false);
    } else {
      if (mounted) ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('사용 가능한 이메일입니다.')));
      setState(() => _isEmailChecked = true);
    }
  }

  // 🌟 닉네임 중복 확인 로직
  void _checkNickname() async {
    final nickname = _nicknameController.text.trim();
    if (nickname.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('닉네임을 입력해주세요.')));
      return;
    }

    final exists = await ref.read(authProvider.notifier).checkNicknameDuplicate(nickname);
    if (exists) {
      if (mounted) ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('이미 사용 중인 닉네임입니다.')));
      setState(() => _isNicknameChecked = false);
    } else {
      if (mounted) ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('사용 가능한 닉네임입니다.')));
      setState(() => _isNicknameChecked = true);
    }
  }

  // 가입하기 버튼 클릭 시 동작
  void _handleSignup() async {
    // 선택 사항: 중복 확인을 거치지 않았다면 가입 막기
    if (!_isEmailChecked) {
      ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('이메일 중복 확인을 해주세요.')));
      return;
    }
    if (!_isNicknameChecked) {
      ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('닉네임 중복 확인을 해주세요.')));
      return;
    }

    final data = {
      'email': _emailController.text.trim(),
      'password': _passwordController.text.trim(),
      'nickname': _nicknameController.text.trim(),
    };

    final success = await ref.read(authProvider.notifier).signup(data);
    if (success && mounted) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('회원가입 완료! 로그인해주세요.')),
      );
      Navigator.pop(context); 
    }
  }

  @override
  Widget build(BuildContext context) {
    final authState = ref.watch(authProvider);

    return Scaffold(
      appBar: AppBar(title: const Text('회원가입')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            // 이메일 입력 + 중복확인 버튼
            Row(
              children: [
                Expanded(
                  child: TextField(
                    controller: _emailController, 
                    decoration: const InputDecoration(labelText: '이메일'),
                    onChanged: (_) => setState(() => _isEmailChecked = false), // 입력이 바뀌면 다시 체크 필요
                  ),
                ),
                const SizedBox(width: 8),
                ElevatedButton(onPressed: _checkEmail, child: const Text('중복확인')),
              ],
            ),
            const SizedBox(height: 12),
            TextField(controller: _passwordController, obscureText: true, decoration: const InputDecoration(labelText: '비밀번호')),
            const SizedBox(height: 12),
            // 닉네임 입력 + 중복확인 버튼
            Row(
              children: [
                Expanded(
                  child: TextField(
                    controller: _nicknameController, 
                    decoration: const InputDecoration(labelText: '닉네임'),
                    onChanged: (_) => setState(() => _isNicknameChecked = false), // 입력이 바뀌면 다시 체크 필요
                  ),
                ),
                const SizedBox(width: 8),
                ElevatedButton(onPressed: _checkNickname, child: const Text('중복확인')),
              ],
            ),
            const SizedBox(height: 16),
            if (authState.error != null)
              Text(authState.error!, style: const TextStyle(color: Colors.red)),
            const SizedBox(height: 24),
            SizedBox(
              width: double.infinity,
              child: ElevatedButton(
                onPressed: authState.loading ? null : _handleSignup,
                child: authState.loading 
                    ? const CircularProgressIndicator(color: Colors.white) 
                    : const Text('가입하기'),
              ),
            ),
          ],
        ),
      ),
    );
  }
}