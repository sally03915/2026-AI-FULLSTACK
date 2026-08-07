### 📁 1. 아키텍처(Feature-first)

```text
mobile/
├── lib/
│   ├── core/                        # 전역 공통 설정 (네트워크, 테마)
│   │   ├── network/
│   │   │   └── api_client.dart      # baseURL 및 디바이스 분기
│   │   └── theme/
│   │       └── app_theme.dart       # 라이트/다크 테마 설정
│   ├── features/                    # 기능별 폴더 (재사용 및 유지보수 핵심)
│   │   ├── auth/                    # 인증 기능 (로그인, 회원가입, 유저정보)
│   │   │   ├── data/
│   │   │   │   └── auth_provider.dart
│   │   │   └── presentation/
│   │   │       ├── login_page.dart
│   │   │       ├── signup_page.dart
│   │   │       └── users_page.dart
│   │   └── post/                    # 게시판 기능
│   │       ├── data/
│   │       │   └── post_provider.dart
│   │       └── presentation/
│   │           └── index_page.dart
│   ├── shared/                      # 여러 기능에서 공통으로 쓰는 UI 위젯
│   │   └── components/
│   │       └── app_layout.dart
│   ├── app.dart                     # 라우팅 및 앱 설정
│   └── main.dart                    # 진입점
├── test/                            # 테스트 코드
│   └── auth_provider_test.dart
├── pubspec.yaml
└── analysis_options.yaml

```
 
---

## 2. Core & Shared (공통 설정 및 레이아웃)

### ① `lib/core/network/api_client.dart`

```dart
import 'dart:io';

class ApiClient {
  static String getBaseUrl() {
    if (Platform.isAndroid) {
      return 'http://10.0.2.2:8080';
    } else {
      return 'http://localhost:8080';
    }
  }
}

```

### ② `lib/shared/components/app_layout.dart`

```dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../features/auth/data/auth_provider.dart';

class AppLayout extends ConsumerWidget {
  final Widget child;

  const AppLayout({super.key, required this.child});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final authState = ref.watch(authProvider);

    return Scaffold(
      appBar: AppBar(
        title: const Text('나의 소셜 앱'),
        actions: [
          if (authState.user != null) ...[
            Center(
              child: Padding(
                padding: const EdgeInsets.symmetric(horizontal: 8.0),
                child: Text('${authState.user!['nickname'] ?? '사용자'}님 환영합니다!'),
              ),
            ),
            IconButton(
              icon: const Icon(Icons.logout),
              onPressed: () => ref.read(authProvider.notifier).logout(),
            ),
          ] else ...[
            TextButton(
              onPressed: () => Navigator.pushNamed(context, '/login'),
              child: const Text('로그인', style: TextStyle(color: Colors.white)),
            ),
          ],
        ],
      ),
      body: child,
    );
  }
}

```

---

## 3. Features: Auth (인증 기능 모듈)

### ① `lib/features/auth/data/auth_provider.dart`

```dart
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:dio/dio.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import '../../../core/network/api_client.dart';

class AuthState {
  final Map<String, dynamic>? user;
  final String? accessToken;
  final bool loading;
  final String? error;

  AuthState({this.user, this.accessToken, this.loading = false, this.error});

  AuthState copyWith({
    Map<String, dynamic>? user,
    String? accessToken,
    bool? loading,
    String? error,
  }) {
    return AuthState(
      user: user ?? this.user,
      accessToken: accessToken ?? this.accessToken,
      loading: loading ?? this.loading,
      error: error,
    );
  }
}

class AuthNotifier extends StateNotifier<AuthState> {
  AuthNotifier() : super(AuthState()) {
    _initDio();
  }

  late final Dio _dio;
  final _storage = const FlutterSecureStorage();

  void _initDio() {
    _dio = Dio(BaseOptions(
      baseUrl: ApiClient.getBaseUrl(),
      headers: {'Content-Type': 'application/json'},
    ));

    _dio.interceptors.add(InterceptorsWrapper(
      onRequest: (options, handler) async {
        final token = await _storage.read(key: 'accessToken');
        if (token != null) {
          options.headers['Authorization'] = 'Bearer $token';
        }
        return handler.next(options);
      },
      onError: (DioException e, handler) async {
        if (e.response?.statusCode == 401) {
          final success = await _refreshAccessToken();
          if (success) {
            final token = await _storage.read(key: 'accessToken');
            e.requestOptions.headers['Authorization'] = 'Bearer $token';
            final clonedRequest = await _dio.fetch(e.requestOptions);
            return handler.resolve(clonedRequest);
          }
        }
        return handler.next(e);
      },
    ));
  }

  Future<bool> _refreshAccessToken() async {
    try {
      final response = await _dio.post('/api/auth/refresh');
      final newAccessToken = response.data['accessToken'];
      if (newAccessToken != null) {
        await _storage.write(key: 'accessToken', value: newAccessToken);
        state = state.copyWith(accessToken: newAccessToken);
        return true;
      }
    } catch (_) {
      await logout();
    }
    return false;
  }

  Future<bool> login(Map<String, dynamic> credentials) async {
    state = state.copyWith(loading: true, error: null);
    try {
      final response = await _dio.post('/api/auth/login', data: credentials);
      final accessToken = response.data['accessToken'];
      final user = response.data['user'];

      if (user != null && accessToken != null) {
        await _storage.write(key: 'accessToken', value: accessToken);
        state = state.copyWith(loading: false, user: user, accessToken: accessToken);
        return true;
      } else {
        state = state.copyWith(loading: false, error: '아이디 또는 비밀번호가 올바르지 않습니다.');
        return false;
      }
    } catch (err) {
      state = state.copyWith(loading: false, error: '로그인 실패: ${err.toString()}');
      return false;
    }
  }

  Future<void> logout() async {
    try {
      await _dio.post('/api/auth/logout');
    } catch (_) {}
    await _storage.delete(key: 'accessToken');
    state = AuthState();
  }

  Future<bool> signup(Map<String, dynamic> data) async {
    state = state.copyWith(loading: true, error: null);
    try {
      await _dio.post('/api/auth/signup', data: data);
      state = state.copyWith(loading: false);
      return true;
    } catch (err) {
      state = state.copyWith(loading: false, error: '회원가입 실패: ${err.toString()}');
      return false;
    }
  }
}

final authProvider = StateNotifierProvider<AuthNotifier, AuthState>((ref) => AuthNotifier());

```

### ② `lib/features/auth/presentation/login_page.dart`

```dart
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
      Navigator.pushReplacementNamed(context, '/');
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
          ],
        ),
      ),
    );
  }
}

```

### ③ `lib/features/auth/presentation/signup_page.dart`

```dart
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

  void _handleSignup() async {
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
    return Scaffold(
      appBar: AppBar(title: const Text('회원가입')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(controller: _emailController, decoration: const InputDecoration(labelText: '이메일')),
            TextField(controller: _passwordController, obscureText: true, decoration: const InputDecoration(labelText: '비밀번호')),
            TextField(controller: _nicknameController, decoration: const InputDecoration(labelText: '닉네임')),
            const SizedBox(height: 24),
            ElevatedButton(onPressed: _handleSignup, child: const Text('가입하기')),
          ],
        ),
      ),
    );
  }
}

```

### ④ `lib/features/auth/presentation/users_page.dart`

```dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../../shared/components/app_layout.dart';
import '../data/auth_provider.dart';

class UsersPage extends ConsumerWidget {
  const UsersPage({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final user = ref.watch(authProvider).user;

    return AppLayout(
      child: Padding(
        padding: const EdgeInsets.all(16.0),
        child: user == null
            ? const Center(child: Text('로그인이 필요합니다.'))
            : Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text('닉네임: ${user['nickname']}', style: const TextStyle(fontSize: 20)),
                  const SizedBox(height: 8),
                  Text('이메일: ${user['email']}', style: const TextStyle(fontSize: 16)),
                ],
              ),
      ),
    );
  }
}

```

---

## 4. Features: Post (게시판 기능 모듈)

### ① `lib/features/post/data/post_provider.dart`

```dart
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:dio/dio.dart';
import '../../../core/network/api_client.dart';

class PostState {
  final List<dynamic> posts;
  final bool loading;
  final String? error;

  PostState({this.posts = const [], this.loading = false, this.error});

  PostState copyWith({List<dynamic>? posts, bool? loading, String? error}) {
    return PostState(
      posts: posts ?? this.posts,
      loading: loading ?? this.loading,
      error: error,
    );
  }
}

class PostNotifier extends StateNotifier<PostState> {
  PostNotifier() : super(PostState()) {
    _dio = Dio(BaseOptions(baseUrl: ApiClient.getBaseUrl()));
  }

  late final Dio _dio;

  Future<void> fetchPosts() async {
    state = state.copyWith(loading: true, error: null);
    try {
      final response = await _dio.get('/api/posts');
      state = state.copyWith(loading: false, posts: response.data);
    } catch (err) {
      state = state.copyWith(loading: false, error: err.toString());
    }
  }
}

final postProvider = StateNotifierProvider<PostNotifier, PostState>((ref) => PostNotifier());

```

### ② `lib/features/post/presentation/index_page.dart`

```dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../../shared/components/app_layout.dart';
import '../data/post_provider.dart';

class IndexPage extends ConsumerStatefulWidget {
  const IndexPage({super.key});

  @override
  ConsumerState<IndexPage> createState() => _IndexPageState();
}

class _IndexPageState extends ConsumerState<IndexPage> {
  @override
  void initState() {
    super.initState();
    Future.microtask(() => ref.read(postProvider.notifier).fetchPosts());
  }

  @override
  Widget build(BuildContext context) {
    final postState = ref.watch(postProvider);

    return AppLayout(
      child: postState.loading
          ? const Center(child: CircularProgressIndicator())
          : ListView.builder(
              itemCount: postState.posts.length,
              itemBuilder: (context, index) {
                final post = postState.posts[index];
                return ListTile(
                  title: Text(post['content'] ?? '내용 없음'),
                  subtitle: Text(post['user']?['nickname'] ?? '작성자'),
                );
              },
            ),
    );
  }
}

```

---

## 5. App Setup & Main (`app.dart`, `main.dart`, `app_theme.dart`)

### ① `lib/core/theme/app_theme.dart`

```dart
import 'package:flutter/material.dart';

class AppTheme {
  static ThemeData get lightTheme => ThemeData(
        useMaterial3: true,
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.blue, brightness: Brightness.light),
        appBarTheme: const AppBarTheme(backgroundColor: Colors.blue, foregroundColor: Colors.white, centerTitle: true),
      );

  static ThemeData get darkTheme => ThemeData(
        useMaterial3: true,
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.blue, brightness: Brightness.dark),
      );
}

```

### ② `lib/app.dart`

```dart
import 'package:flutter/material.dart';
import 'core/theme/app_theme.dart';
import 'features/auth/presentation/login_page.dart';
import 'features/auth/presentation/signup_page.dart';
import 'features/auth/presentation/users_page.dart';
import 'features/post/presentation/index_page.dart';

class App extends StatelessWidget {
  const App({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '나의 소셜 앱',
      debugShowCheckedModeBanner: false,
      theme: AppTheme.lightTheme,
      darkTheme: AppTheme.darkTheme,
      initialRoute: '/',
      routes: {
        '/': (context) => const IndexPage(),
        '/login': (context) => const LoginPage(),
        '/signup': (context) => const SignupPage(),
        '/users': (context) => const UsersPage(),
      },
    );
  }
}

```

### ③ `lib/main.dart`

```dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'app.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(const ProviderScope(child: App()));
}

```