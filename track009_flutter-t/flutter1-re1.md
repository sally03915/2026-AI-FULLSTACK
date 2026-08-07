### 1. 📂 전체 프로젝트 구조 (유지 및 정돈)

```text
mobile/
├── lib/
│   ├── components/app_layout.dart
│   ├── pages/
│   │   ├── index_page.dart
│   │   ├── login_page.dart
│   │   ├── signup_page.dart
│   │   └── users_page.dart
│   ├── providers/
│   │   ├── auth_provider.dart
│   │   └── post_provider.dart
│   ├── styles/app_theme.dart
│   ├── utils/api_client.dart
│   ├── app.dart
│   └── main.dart
├── test/user_provider_test.dart
├── pubspec.yaml
└── analysis_options.yaml

```

---

## 2. 셋팅 파일 수정본

### ① `lib/utils/api_client.dart`

```dart
import 'dart:io';

String getBaseUrl() {
  if (Platform.isAndroid) {
    return 'http://10.0.2.2:8080';
  } else if (Platform.isIOS) {
    return 'http://localhost:8080';
  } else {
    return 'http://localhost:8080';
  }
}

```

---

## 3. Providers (상태 관리 및 비동기 로직)

### ① Auth Provider (`providers/auth_provider.dart`)

```dart
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:dio/dio.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import '../utils/api_client.dart';

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
      baseUrl: getBaseUrl(),
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

### ② Post Provider (`providers/post_provider.dart`)

```dart
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:dio/dio.dart';
import '../utils/api_client.dart';

class PostState {
  final List<dynamic> posts;
  final dynamic currentPost;
  final bool loading;
  final String? error;

  PostState({
    this.posts = const [],
    this.currentPost,
    this.loading = false,
    this.error,
  });

  PostState copyWith({
    List<dynamic>? posts,
    dynamic currentPost,
    bool? loading,
    String? error,
  }) {
    return PostState(
      posts: posts ?? this.posts,
      currentPost: currentPost ?? this.currentPost,
      loading: loading ?? this.loading,
      error: error,
    );
  }
}

class PostNotifier extends StateNotifier<PostState> {
  PostNotifier() : super(PostState()) {
    _dio = Dio(BaseOptions(baseUrl: getBaseUrl()));
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

  Future<void> fetchPost(int postId) async {
    state = state.copyWith(loading: true, error: null);
    try {
      final response = await _dio.get('/api/posts/$postId');
      state = state.copyWith(loading: false, currentPost: response.data);
    } catch (err) {
      state = state.copyWith(loading: false, error: err.toString());
    }
  }

  Future<bool> createPost(Map<String, dynamic> dto) async {
    state = state.copyWith(loading: true, error: null);
    try {
      final response = await _dio.post('/api/posts', data: dto);

      state = state.copyWith(
        loading: false,
        posts: [response.data, ...state.posts],
      );
      return true;
    } catch (err) {
      state = state.copyWith(loading: false, error: err.toString());
      return false;
    }
  }

  Future<bool> updatePost(int postId, Map<String, dynamic> dto) async {
    state = state.copyWith(loading: true, error: null);
    try {
      final response = await _dio.put('/api/posts/$postId', data: dto);

      final updatedPosts = state.posts.map((p) => p['id'] == postId ? response.data : p).toList();
      
      state = state.copyWith(
        loading: false, 
        posts: updatedPosts,
        currentPost: response.data,
      );
      return true;
    } catch (err) {
      state = state.copyWith(loading: false, error: err.toString());
      return false;
    }
  }

  Future<bool> deletePost(int postId) async {
    try {
      await _dio.delete('/api/posts/$postId');
      final updatedPosts = state.posts.where((p) => p['id'] != postId).toList();
      state = state.copyWith(posts: updatedPosts);
      return true;
    } catch (err) {
      state = state.copyWith(error: err.toString());
      return false;
    }
  }
}

final postProvider = StateNotifierProvider<PostNotifier, PostState>((ref) => PostNotifier());

```

---

## 4. Components & Pages (UI 컴포넌트 및 화면)

### ① App Layout (`components/app_layout.dart`)

```dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../providers/auth_provider.dart';

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
              onPressed: () {
                ref.read(authProvider.notifier).logout();
              },
            ),
          ] else ...[
            TextButton(
              onPressed: () {
                Navigator.pushNamed(context, '/login');
              },
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

### ② 로그인 페이지 (`pages/login_page.dart`)

```dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../providers/auth_provider.dart';

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
            TextField(
              controller: _emailController,
              decoration: const InputDecoration(labelText: '이메일'),
            ),
            const SizedBox(height: 12),
            TextField(
              controller: _passwordController,
              obscureText: true,
              decoration: const InputDecoration(labelText: '비밀번호'),
            ),
            const SizedBox(height: 24),
            if (authState.error != null)
              Text(authState.error!, style: const TextStyle(color: Colors.red)),
            const SizedBox(height: 12),
            SizedBox(
              width: double.infinity,
              child: ElevatedButton(
                onPressed: authState.loading ? null : _handleLogin,
                child: authState.loading
                    ? const SizedBox(
                        height: 20, 
                        width: 20, 
                        child: CircularProgressIndicator(color: Colors.white, strokeWidth: 2),
                      )
                    : const Text('로그인'),
              ),
            ),
            const SizedBox(height: 12),
            TextButton(
              onPressed: () {
                Navigator.pushNamed(context, '/signup');
              },
              child: const Text('계정이 없으신가요? 회원가입'),
            ),
          ],
        ),
      ),
    );
  }
}

```

### ③ 회원가입 페이지 (`pages/signup_page.dart`)

```dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../providers/auth_provider.dart';

class SignupPage extends ConsumerStatefulWidget {
  const SignupPage({super.key});

  @override
  ConsumerState<SignupPage> createState() => _SignupPageState();
}

class _SignupPageState extends ConsumerState<SignupPage> {
  final _emailController = TextEditingController();
  final _passwordController = TextEditingController();
  final _nicknameController = TextEditingController();

  @override
  void dispose() {
    _emailController.dispose();
    _passwordController.dispose();
    _nicknameController.dispose();
    super.dispose();
  }

  void _handleSignup() async {
    final data = {
      'email': _emailController.text.trim(),
      'password': _passwordController.text.trim(),
      'nickname': _nicknameController.text.trim(),
    };

    final success = await ref.read(authProvider.notifier).signup(data);
    if (success && mounted) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('회원가입이 완료되었습니다. 로그인해주세요!')),
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
            TextField(controller: _emailController, decoration: const InputDecoration(labelText: '이메일')),
            const SizedBox(height: 12),
            TextField(controller: _passwordController, obscureText: true, decoration: const InputDecoration(labelText: '비밀번호')),
            const SizedBox(height: 12),
            TextField(controller: _nicknameController, decoration: const InputDecoration(labelText: '닉네임')),
            const SizedBox(height: 24),
            if (authState.error != null)
              Text(authState.error!, style: const TextStyle(color: Colors.red)),
            const SizedBox(height: 12),
            SizedBox(
              width: double.infinity,
              child: ElevatedButton(
                onPressed: authState.loading ? null : _handleSignup,
                child: const Text('가입하기'),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

```

### ④ 메인 피드 페이지 (`pages/index_page.dart`)

```dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../components/app_layout.dart';
import '../providers/post_provider.dart';

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

### ⑤ 사용자 정보 페이지 (`pages/users_page.dart`)

```dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../components/app_layout.dart';
import '../providers/auth_provider.dart';

class UsersPage extends ConsumerWidget {
  const UsersPage({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final authState = ref.watch(authProvider);
    final user = authState.user;

    return AppLayout(
      child: Padding(
        padding: const EdgeInsets.all(16.0),
        child: user == null
            ? const Center(child: Text('로그인이 필요합니다.'))
            : Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text('닉네임: ${user['nickname'] ?? ''}', style: const TextStyle(fontSize: 20)),
                  const SizedBox(height: 8),
                  Text('이메일: ${user['email'] ?? ''}', style: const TextStyle(fontSize: 16)),
                ],
              ),
      ),
    );
  }
}

```

---

## 5. Styles & Entrypoints

### ① 테마 설정 (`styles/app_theme.dart`)

```dart
import 'package:flutter/material.dart';

class AppTheme {
  static ThemeData get lightTheme {
    return ThemeData(
      useMaterial3: true,
      colorScheme: ColorScheme.fromSeed(
        seedColor: Colors.blue,
        brightness: Brightness.light,
      ),
      appBarTheme: const AppBarTheme(
        backgroundColor: Colors.blue,
        foregroundColor: Colors.white,
        elevation: 0,
        centerTitle: true,
      ),
      elevatedButtonTheme: ElevatedButtonThemeData(
        style: ElevatedButton.styleFrom(
          backgroundColor: Colors.blue,
          foregroundColor: Colors.white,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(8),
          ),
        ),
      ),
      inputDecorationTheme: InputDecorationTheme(
        border: OutlineInputBorder(
          borderRadius: BorderRadius.circular(8),
        ),
        filled: true,
        fillColor: Colors.grey[100],
      ),
    );
  }

  static ThemeData get darkTheme {
    return ThemeData(
      useMaterial3: true,
      colorScheme: ColorScheme.fromSeed(
        seedColor: Colors.blue,
        brightness: Brightness.dark,
      ),
      appBarTheme: AppBarTheme(
        backgroundColor: Colors.grey[900],
        foregroundColor: Colors.white,
        elevation: 0,
        centerTitle: true,
      ),
    );
  }
}

```

### ② 앱 설정 (`app.dart`)

```dart
import 'package:flutter/material.dart';
import 'styles/app_theme.dart';
import 'pages/index_page.dart';
import 'pages/login_page.dart';
import 'pages/signup_page.dart';
import 'pages/users_page.dart';

class App extends StatelessWidget {
  const App({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '나의 소셜 앱',
      debugShowCheckedModeBanner: false,
      theme: AppTheme.lightTheme,
      darkTheme: AppTheme.darkTheme,
      themeMode: ThemeMode.system,
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

### ③ 실행 진입점 (`main.dart`)

```dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'app.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();

  runApp(
    const ProviderScope(
      child: App(),
    ),
  );
}

```