```bash
flutter create mobile2
cd mobile2
flutter run
1
```

```
flutter pub add flutter_riverpod
flutter pub add dio
flutter pub add flutter_secure_storage
```

```
flutter clean
flutter pub get
flutter run -d chrome
```

window  R
ms-settings:developers
개발자모드 켬

## 1. 앱의 시작점
#### 1. `lib/main.dart` (앱의 시작점)

```dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'app.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(const ProviderScope(child: App()));
}

```

#### 2. `lib/app.dart` (전체 길잡이 라우터)

```dart
import 'package:flutter/material.dart';

class App extends StatelessWidget {
  const App({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '나의 소셜 앱',
      debugShowCheckedModeBanner: false,
      initialRoute: '/',
      routes: {
        '/': (context) => Scaffold(
              appBar: AppBar(title: const Text('1단계: 라우팅 테스트')),
              body: const Center(child: Text('앱이 정상적으로 실행되었습니다! 🎉')),
            ),
      },
    );
  }
}

```

* **테스트 방법**: `flutter run`을 실행하여 상단바에 "1단계: 라우팅 테스트"가 뜨는지 확인합니다.



## 2. Core & Shared (공통 설정 및 레이아웃)

#### 🌐 1. `lib/core/network/api_client.dart`

> **리액트로 치면?** 환경변수(`.env`)로 `API_BASE_URL`을 설정하는 것과 같습니다.

```dart
import 'package:flutter/foundation.dart'; // 웹 환경 체크용
import 'dart:io' show Platform;

class ApiClient {
  static String getBaseUrl() {
    // 웹 브라우저에서 실행 중일 때
    if (kIsWeb) {
      return 'http://localhost:8080';
    }
    
    // 모바일(안드로이드/아이폰)에서 실행 중일 때
    try {
      if (Platform.isAndroid) {
        return 'http://10.0.2.2:8080';
      }
    } catch (_) {}
    
    return 'http://localhost:8080';
  }
}
``` 
#### 🎨 2. lib/shared/components/app_layout.dart
리액트로 치면? 리액트의 Layout 컴포넌트 (공통 레이아웃) 와 100% 똑같습니다!

ver-1
*(아직 인증 코드가 없으므로 임시 가짜 데이터로 상단바를 먼저 테스트합니다)*

### 🛠️ 에러 안 나는 임시 `app_layout.dart` 코드

```dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class AppLayout extends ConsumerWidget {
  final Widget child;
  const AppLayout({super.key, required this.child});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    // [임시 테스트용] DateTime.now() 같은 동적 값을 활용하면 
    // 컴파일 시점에 결과가 고정되지 않으므로 dead code 경고가 절대 나지 않습니다!
    final bool isLogined =   DateTime.now().year < 2000; // < 항상 false이지만 컴파일러는 모름 (원하면 true로 테스트 가능)
    //final bool isLogined = true;
    return Scaffold(
      appBar: AppBar(
        title: const Text('나의 소셜 앱'),
        actions: [
          if (isLogined) ...[
            const Center(
              child: Padding(
                padding: EdgeInsets.symmetric(horizontal: 8.0),
                child: Text('테스트유저님 환영합니다!'),
              ),
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

// 리액트 개발자의 눈으로 이해하기
// - ConsumerWidget: 리액트에서 Redux나 Recoil 상태를 구독(useSelector)하는 컴포넌트처럼, 전역 상태(authProvider)를 실시간으로 구독(Watch)하는 위젯입니다. 상태가 바뀌면 이 레이아웃도 알아서 리렌더링됩니다.
// - final Widget child: 리액트 컴포넌트의 children props와 같습니다. 여러 페이지(게시판 목록, 마이페이지 등)에서 상단바의 디자인과 로그인 상태바가 계속 반복되니까, 이 AppLayout 하나로 감싸서 공통 껍데기(Layout)로 재사용하는 것입니다.

```

#### 🎨 3. 레이아웃
lib/app.dart 수정 (레이아웃 적용)
```dart
import 'package:flutter/material.dart'; // 🌟 이 줄이 없으면 ThemeData나 AppBar를 절대 인식하지 못합니다!
import 'shared/components/app_layout.dart';

class App extends StatelessWidget {
  const App({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '나의 소셜 앱',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        useMaterial3: true,
        appBarTheme: const AppBarTheme(
          backgroundColor: Colors.blue,
          foregroundColor: Colors.white,
        ),
      ),
      initialRoute: '/',
      routes: {
        '/': (context) => const AppLayout(
              child: Center(
                child: Text(
                  '이제 에러 없이 파란 상단바가 뜹니다! 🎉',
                  style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                ),
              ),
            ),
      },
    );
  }
}
``` 

* **테스트 방법**: `AppLayout`으로 감싼 화면을 `app.dart`의 `initialRoute`에 연결해 상단바와 버튼이 잘 나오는 확인합니다.






---



## 3.  🧩 리액트(Reducer & Saga) 관점에서 본 플러터 코드 해설

### 1. `lib/features/auth/data/auth_provider.dart`

```dart
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:dio/dio.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import '../../../core/network/api_client.dart';

// [리액트 비교] Redux의 초기 State 객체 역할
class AuthState {
  final Map<String, dynamic>? user; // 로그인된 유저 데이터 (닉네임, 이메일 등)
  final String? accessToken;        // 서버에서 발급받은 JWT Access Token
  final bool loading;               // 통신 중 로딩 스피너를 띄울지 여부
  final String? error;              // 로그인/가입 실패 시 띄울 에러 메시지

  const AuthState({
    this.user,
    this.accessToken,
    this.loading = false,
    this.error,
  });
}

// [리액트 비교] 리버팟 최신 표준 Notifier (Redux Toolkit의 Slice와 완벽히 동일한 개념)
class AuthNotifier extends Notifier<AuthState> {
  @override
  AuthState build() {
    // 초기 상태 정의
    _initDio();
    return const AuthState();
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
        state = AuthState(
          user: state.user,
          accessToken: newAccessToken,
          loading: state.loading,
          error: state.error,
        );
        return true;
      }
    } catch (_) {
      await logout();
    }
    return false;
  }

  // 로그인 비동기 액션
  Future<bool> login(Map<String, dynamic> credentials) async {
    // 최신 Notifier 표준에서는 state 변수를 다이렉트 수정/대입합니다.
    state = AuthState(
      user: state.user,
      accessToken: state.accessToken,
      loading: true,
      error: null,
    );

    try {
      final response = await _dio.post('/api/auth/login', data: credentials);
      final accessToken = response.data['accessToken'];
      final user = response.data['user'];

      if (user != null && accessToken != null) {
        await _storage.write(key: 'accessToken', value: accessToken);
        state = AuthState(
          user: user,
          accessToken: accessToken,
          loading: false,
          error: null,
        );
        return true;
      } else {
        state = AuthState(
          user: state.user,
          accessToken: state.accessToken,
          loading: false,
          error: '아이디 또는 비밀번호가 올바르지 않습니다.',
        );
        return false;
      }
    } catch (err) {
      state = AuthState(
        user: state.user,
        accessToken: state.accessToken,
        loading: false,
        error: '로그인 실패: ${err.toString()}',
      );
      return false;
    }
  }

  // 로그아웃 액션
  Future<void> logout() async {
    try {
      await _dio.post('/api/auth/logout');
    } catch (_) {}
    await _storage.delete(key: 'accessToken');
    state = const AuthState();
  }

  // 회원가입 비동기 액션
  Future<bool> signup(Map<String, dynamic> data) async {
    state = AuthState(
      user: state.user,
      accessToken: state.accessToken,
      loading: true,
      error: null,
    );

    try {
      await _dio.post('/api/auth/signup', data: data);
      state = AuthState(
        user: state.user,
        accessToken: state.accessToken,
        loading: false,
        error: null,
      );
      return true;
    } catch (err) {
      state = AuthState(
        user: state.user,
        accessToken: state.accessToken,
        loading: false,
        error: '회원가입 실패: ${err.toString()}',
      );
      return false;
    }
  }
}

// [리액트 비교] 최신 리버팟 NotifierProvider 등록 방식
final authProvider = NotifierProvider<AuthNotifier, AuthState>(() {
  return AuthNotifier();
});
```

---

### 2. `lib/features/auth/presentation/login_page.dart`

이 파일은 리액트에서 `useSelector`로 상태를 읽고, `useDispatch`나 함수 호출을 통해 로그인을 수행하는 **로그인 화면 컴포넌트**입니다.

* **`ConsumerStatefulWidget`**: 리액트에서 Redux 스토어의 상태를 구독(`useSelector`)하고 로컬 폼 상태(`useState`)를 함께 쓰는 컴포넌트와 비슷합니다.
* **`ref.read(authProvider.notifier).login(...)`**: 리액트 사가에서 액션을 디스패치(`dispatch({ type: 'LOGIN_REQUEST', ... })`)하는 것과 같습니다. 비동기 로그인 함수를 실행합니다.
* **`ref.watch(authProvider)`**: 상태가 바뀔 때마다 화면을 리렌더링(`useSelector`)하여 에러 메시지나 로딩 상태(`authState.loading`)를 화면에 반영합니다.

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
```

---

### 3. `lib/features/auth/presentation/signup_page.dart`

회원가입 폼을 다루는 화면입니다. 입력값을 모아서 `signup` 비동기 액션을 호출하고, 성공 시 이전 페이지로 돌아갑니다(`Navigator.pop`).

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
  // 회원가입 입력 필드 컨트롤러 3총사 (이메일, 비밀번호, 닉네임)
  final _emailController = TextEditingController();
  final _passwordController = TextEditingController();
  final _nicknameController = TextEditingController();

  // 가입하기 버튼 클릭 시 동작
  void _handleSignup() async {
    final data = {
      'email': _emailController.text.trim(),
      'password': _passwordController.text.trim(),
      'nickname': _nicknameController.text.trim(),
    };

    // authProvider의 signup 함수 호출하여 서버로 회원가입 요청 전송
    final success = await ref.read(authProvider.notifier).signup(data);
    if (success && mounted) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('회원가입 완료! 로그인해주세요.')),
      );
      Navigator.pop(context); // 가입 성공 시 이전 페이지(로그인 화면 등)로 돌아가기
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

---

### 4. `lib/features/auth/presentation/users_page.dart`

로그인된 유저의 마이페이지 화면입니다. `ConsumerWidget`을 사용하여 상태가 바뀔 때 유저 정보(`user`)를 실시간으로 가져와 화면에 렌더링합니다.

```dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../../shared/components/app_layout.dart';
import '../data/auth_provider.dart';

// 상태 변화만 구독하면 되므로 단순한 ConsumerWidget 사용 (리액트의 상태 구독 컴포넌트와 유사)
class UsersPage extends ConsumerWidget {
  const UsersPage({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    // 전역 스토어에서 현재 로그인된 유저 정보만 쏙 골라서 구독
    final user = ref.watch(authProvider).user;

    return AppLayout(
      child: Padding(
        padding: const EdgeInsets.all(16.0),
        // 유저 정보가 없으면 로그인이 안 된 상태이므로 안내 문구 띄우기
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


### 5.  lib/app.dart
lib/app.dart 파일을 열어서 아래와 같이 /login과 /signup 라우트를 등록해 주세요.

```Dart
import 'package:flutter/material.dart';
import 'shared/components/app_layout.dart';
// 🌟 로그인, 회원가입 페이지 파일들을 임포트합니다.
import 'features/auth/presentation/login_page.dart';
import 'features/auth/presentation/signup_page.dart';

class App extends StatelessWidget {
  const App({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '나의 소셜 앱',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        useMaterial3: true,
        appBarTheme: const AppBarTheme(
          backgroundColor: Colors.blue,
          foregroundColor: Colors.white,
        ),
      ),
      initialRoute: '/',
      // 🌟 라우터 길잡이 목록에 로그인/회원가입 경로를 추가합니다!
      routes: {
        '/': (context) => const AppLayout(
              child: Center(
                child: Text(
                  '메인 화면입니다! 우측 상단 로그인 버튼을 눌러보세요.',
                  style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                ),
              ),
            ),
        '/login': (context) => const LoginPage(),
        '/signup': (context) => const SignupPage(),
      },
    );
  }
}
```

