### 📁 1. 아키텍처(Feature-first)

```bash
flutter create mobile2
cd mobile2
flutter run
2
```

```
flutter pub add flutter_riverpod
flutter pub add dio
flutter pub add flutter_secure_storage
```

```text
mobile2/                        # 프로젝트 루트 폴더 이름 (flutter create로 생성한 이름)
├── lib/
│   ├── core/                   # 전역 공통 설정 (네트워크, 테마)
│   │   ├── network/
│   │   │   └── api_client.dart       # 🌐 서버 주소 동적 분기 (안드로이드/로컬)
│   │   └── theme/
│   │       └── app_theme.dart        # 🎨 라이트/다크 테마 설정
│   ├── features/               # 기능별 모듈 폴더 (유지보수의 핵심)
│   │   ├── auth/               # 인증 기능 (로그인, 회원가입, 유저정보)
│   │   │   ├── data/
│   │   │   │   └── auth_provider.dart    # 🧠 상태 관리 + Dio 인터셉터 (토큰 갱신)
│   │   │   └── presentation/
│   │   │       ├── login_page.dart       # 📱 로그인 화면
│   │   │       ├── signup_page.dart      # 📱 회원가입 화면
│   │   │       └── users_page.dart       # 📱 마이페이지(유저 정보)
│   │   └── post/               # 게시판 기능
│   │       ├── data/
│   │       │   └── post_provider.dart    # 🧠 게시글 데이터 상태 관리
│   │       └── presentation/
│   │           └── index_page.dart       # 📱 메인 게시글 목록 화면
│   ├── shared/                 # 여러 기능에서 공통으로 재사용하는 UI
│   │   └── components/
│   │       └── app_layout.dart       # 🎨 공통 앱바 및 레이아웃 틀
│   ├── app.dart                # 🗺️ 라우팅 및 테마 적용 (MaterialApp)
│   └── main.dart               # 🚀 앱의 진짜 진입점 (ProviderScope)
├── test/
│   └── auth_provider_test.dart
├── pubspec.yaml                # 패키지 의존성 관리 (riverpod, dio, secure_storage 등)
└── analysis_options.yaml

```

## 📁 1. 아키텍처 (Feature-first 폴더 구조)

프로젝트를 만들 때 파일들을 아무렇게나 놓으면 나중에 코드가 많아졌을 때 찾기 힘듭니다. 그래서 기능별로 폴더를 깔끔하게 나누는 방식(Feature-first)을 사용합니다.

* `core/`: 앱 전반에서 공통으로 쓰는 핵심 설정 (네트워크 연결 주소, 테마 등)
* `features/`: 로그인/회원가입(`auth`), 게시판(`post`)처럼 **기능 단위**로 모아둔 폴더입니다. 각 기능 안에는 데이터를 다루는 곳(`data`)과 화면을 보여주는 곳(`presentation`)이 나뉩니다.
* `shared/`: 여러 기능에서 공통으로 재사용하는 화면 디자인 조각들 (예: 상단바와 레이아웃 틀)
* `app.dart` / `main.dart`: 앱의 전체 길(라우팅)을 잡아주고, 맨 처음 실행시키는 진입점 파일입니다.

---

## 2. Core & Shared (공통 설정 및 레이아웃)

### ① `lib/core/network/api_client.dart` (서버 주소 설정)

* **하는 일**: 내 컴퓨터(백엔드 서버)와 통신할 때 접속할 서버 주소를 결정합니다.
* **쉽게 이해하기**: 안드로이드 에뮬레이터(가상 스마트폰)로 실행할 때는 내 컴퓨터를 부를 때 `[http://10.0.2.2:8080](http://10.0.2.2:8080)`을 써야 하고, 일반 웹이나 아이폰 시뮬레이터일 때는 `http://localhost:8080`을 써야 합니다. 이 파일은 지금 실행 중인 기기가 안드로이드인지 아이폰인지 체크해서 **알맞은 서버 주소를 자동으로 뱉어주는 역할**을 합니다.

### ② `lib/shared/components/app_layout.dart` (공통 앱 화면 틀)

* **하는 일**: 앱의 상단 바(AppBar)와 기본 뼈대를 공통으로 만들어 줍니다.
* **쉽게 이해하기**: 로그인이 되어 있으면 상단에 "OO님 환영합니다!"와 [로그아웃] 버튼을 보여주고, 로그인이 안 되어 있으면 [로그인] 버튼을 보여줍니다. 여러 페이지에서 반복되는 상단 메뉴바를 똑똑하게 재사용하기 위한 틀입니다.

---

## 3. Features: Auth (인증 기능 모듈)

### ① `lib/features/auth/data/auth_provider.dart` (로그인/회원가입 상태 관리의 핵심)

이 코드가 초보자분들에게 가장 어렵게 느껴지는 부분입니다. 서버와 통신하며 로그인 상태를 관리하는 **두뇌** 역할을 합니다.

* **AuthState (상태 데이터)**: 현재 로그인한 유저의 정보, 로그인 토큰, 로딩 중인지 여부, 에러 메시지를 담고 있는 그릇입니다.
* **AuthNotifier (상태 관리자)**:
* `_initDio()`: 서버와 통신(`Dio`)할 때, 스마트폰 금고(`FlutterSecureStorage`)에 저장된 로그인 열쇠(Access Token)를 자동으로 꺼내서 요청 헤더에 쏙 넣어줍니다. 만약 토큰이 만료되어 서버가 "401(권한 없음)" 에러를 주면, 자동으로 토큰을 새로 고침(`_refreshAccessToken`)해서 끊김 없이 통신을 이어줍니다.
* `login()`: 사용자가 입력한 이메일과 비밀번호를 서버로 보내고, 성공하면 토큰을 안전하게 저장한 뒤 로그인 상태로 전환합니다.
* `signup()`: 회원가입 정보를 서버에 전달합니다.
* `logout()`: 저장된 토큰을 지우고 로그인 상태를 초기화합니다.



### ② `lib/features/auth/presentation/login_page.dart` (로그인 화면)

* **하는 일**: 이메일과 비밀번호를 입력받아 로그인을 시도하는 화면입니다.
* **쉽게 이해하기**: 사용자가 입력한 텍스트를 가져와서 위에서 설명한 `authProvider`에게 로그인을 부탁(`login()`)합니다. 로그인이 성공하면 메인 페이지로 이동하고, 실패하면 빨간색 에러 메시지를 띄워줍니다.

### ③ `lib/features/auth/presentation/signup_page.dart` (회원가입 화면)

* **하는 일**: 이메일, 비밀번호, 닉네임을 입력받아 회원가입을 처리하는 화면입니다.
* **쉽게 이해하기**: 가입하기 버튼을 누르면 입력된 3가지 정보를 묶어서 서버로 보내고, 가입이 완료되면 "회원가입 완료!" 메시지를 띄우며 로그인 화면으로 되돌아갑니다(`Navigator.pop`).

### ④ `lib/features/auth/presentation/users_page.dart` (유저 정보 페이지)

* **하는 일**: 로그인한 유저의 닉네임과 이메일을 화면에 예쁘게 보여주는 페이지입니다.
* **쉽게 이해하기**: 공통 틀(`AppLayout`)을 감싸고 있어서 상단 바가 유지되며, 로그인이 안 되어 있다면 "로그인이 필요합니다"를 띄우고, 되어 있다면 내 닉네임과 이메일을 보여줍니다.

---

## 4. Features: Post (게시판 기능 모듈)

### ① `lib/features/post/data/post_provider.dart` (게시글 목록 데이터 관리)

* **하는 일**: 서버에서 게시글 목록(`posts`)을 인터넷을 통해 가져오는 역할을 합니다.
* **쉽게 이해하기**: `fetchPosts()` 함수가 실행되면 서버(`GET /api/posts`)에 접속해 글 목록을 가져오고, 성공하면 상태에 저장하여 화면이 이를 받아볼 수 있게 합니다.

### ② `lib/features/post/presentation/index_page.dart` (게시판 목록 화면)

* **하는 일**: 앱이 처음 켜졌을 때 서버에서 게시글을 불러와서 리스트 형태로 화면에 뿌려주는 메인 화면입니다.
* **쉽게 이해하기**:
* `initState()` 안에 있는 `Future.microtask`는 "화면이 켜지자마자 바로 서버에서 글 목록을 가져와!"라고 명령하는 코드입니다.
* 데이터가 로딩 중일 때는 동그란 로딩 바(`CircularProgressIndicator`)를 보여주고, 로딩이 끝나면 `ListView.builder`를 이용해 게시글 내용과 작성자 닉네임을 줄줄이 예쁘게 보여줍니다.



---

## 5. App Setup & Main (`app.dart`, `main.dart`, `app_theme.dart`)

### ① `lib/core/theme/app_theme.dart` (앱 테마 설정)

* **하는 일**: 앱 전체의 색상과 디자인 스타일(라이트 모드 / 다크 모드)을 정의합니다. 파란색(`Colors.blue`)을 기본 포인트 색상으로 지정해 두었습니다.

### ② `lib/app.dart` (앱의 길잡이 - 라우팅)

* **하는 일**: 우리 앱에 어떤 페이지들이 있는지 전체 지도를 그려주는 곳입니다.
* **쉽게 이해하기**:
* `routes`: 앱 안의 주소 길을 정리해 둔 것입니다.
* `/`: 맨 처음 켜지는 메인 게시판 화면 (`IndexPage`)
* `/login`: 로그인 페이지 (`LoginPage`)
* `/signup`: 회원가입 페이지 (`SignupPage`)
* `/users`: 내 정보 페이지 (`UsersPage`)



### ③ `lib/main.dart` (앱의 진짜 시작점)

* **하는 일**: 스마트폰이 앱을 가장 먼저 켤 때 실행되는 1번 타자 함수(`main`)입니다.
* **쉽게 이해하기**: 강제로 앱을 실행할 준비를 끝낸 뒤(`WidgetsFlutterBinding.ensureInitialized`), 앞서 만든 상태 관리 도구(`ProviderScope`)를 앱 전체에 입혀서(`runApp`) 전체 앱(`App`)을 실행합니다.


> lib/main.dart (진입점)

### 🚀 1단계: 기본 뼈대 및 라우팅 테스트 (진입점)

가장 먼저 앱이 정상적으로 켜지는지, 기본 화면이 뜨는지 확인합니다.

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
왜 이런 코드가 필요할까요?
- 우리가 만드는 앱이 실행되는 기기마다 내 컴퓨터(백엔드 서버)를 바라보는 주소가 다르기 때문입니다.
- 안드로이드 에뮬레이터(가상 가상머신)는 보안상 내 컴퓨터를 localhost로 부르지 못하고 특수한 주소인 10.0.2.2를 써야 합니다. 반면, 웹이나 아이폰 시뮬레이터는 평소처럼 localhost를 씁니다.
- 이 코드는 "지금 실행 중인 기기가 안드로이드니? 그럼 이 주소를 써!" 하고 상황에 맞는 서버 주소를 뱉어주는 똑똑한 유틸 함수입니다.

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




ver-2
```dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../features/auth/data/auth_provider.dart';

class AppLayout extends ConsumerWidget {
  final Widget child;

  const AppLayout({super.key, required this.child});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    // 전역 인증 상태 구독
    final authState = ref.watch(authProvider);

    return Scaffold(
      appBar: AppBar(
        title: const Text('나의 소셜 앱'),
        actions: [
          // 로그인이 되어 있다면 상단에 닉네임과 로그아웃 버튼 렌더링
          if (authState.user != null) ...[
            Center(
              child: Padding(
                padding: const EdgeInsets.symmetric(horizontal: 8.0),
                child: Text('${authState.user!['nickname'] ?? '사용자'}님 환영합니다!'),
              ),
            ),
            IconButton(
              icon: const Icon(Icons.logout),
              onPressed: () async {
                // 🌟 로그아웃 실행 후 로그인 페이지로 이동
                await ref.read(authProvider.notifier).logout();
                if (context.mounted) {
                  Navigator.pushReplacementNamed(context, '/login');
                }
              },
            ),
          ] else ...[
            // 로그인이 안 되어 있다면 로그인 버튼 렌더링
            TextButton(
              onPressed: () => Navigator.pushNamed(context, '/login'),
              child: const Text('로그인', style: TextStyle(color: Colors.white)),
            ),
          ],
        ],
      ),
      // 페이지마다 달라지는 본문 내용
      body: child,
    );
  }
}
```
리액트 개발자의 눈으로 이해하기
- ConsumerWidget: 리액트에서 Redux나 Recoil 상태를 구독(useSelector)하는 컴포넌트처럼, 전역 상태(authProvider)를 실시간으로 구독(Watch)하는 위젯입니다. 상태가 바뀌면 이 레이아웃도 알아서 리렌더링됩니다.
- final Widget child: 리액트 컴포넌트의 children props와 같습니다. 여러 페이지(게시판 목록, 마이페이지 등)에서 상단바의 디자인과 로그인 상태바가 계속 반복되니까, 이 AppLayout 하나로 감싸서 공통 껍데기(Layout)로 재사용하는 것입니다.


---

## 🛠️ 백엔드(Spring Boot + JWT + Redis)와의 궁합 점검

결론부터 말씀드리면, **이 코드는 Spring Boot + JWT + Redis 구조와 아주 잘 어울리며 실무에서도 정석으로 쓰는 구조**입니다.

1. **JWT 토큰 인증 (`Authorization: Bearer <token>`)**
* 스프링 시큐리티는 요청 헤더에 담긴 `Bearer 토큰`을 검증합니다. `auth_provider.dart`의 `onRequest` 인터셉터가 매번 요청마다 스마트폰 금고(`FlutterSecureStorage`)에서 토큰을 꺼내 헤더에 쏙 넣어주므로 스프링의 JWT 필터와 완벽하게 연동됩니다.


2. **Access Token 만료 시 Refresh Token 처리 (Redis 활용)**
* 백엔드(Spring)에서 보통 보안을 위해 Access Token의 유효기간을 짧게(예: 30분) 잡고, Refresh Token은 서버의 **Redis**에 저장해 관리합니다.
* 프론트엔드 코드의 `onError` 인터셉터를 보면, 서버가 `401(Unauthorized)` 응답을 주었을 때 **자동으로 `/api/auth/refresh`를 호출**하여 토큰을 재발급받고, 실패했던 원래 요청(`clonedRequest`)을 다시 재시도(Retry)합니다. 이는 리액트 사가(Saga)나 악시오스 인터셉터에서 구현하던 **토큰 재발급 로직과 정확히 일치**합니다.



---

## 🧩 리액트(Reducer & Saga) 관점에서 본 플러터 코드 해설

### 1. `lib/features/auth/data/auth_provider.dart`

이 파일은 리액트의 Reducer(상태 정의 및 변경)와 Redux-Saga(비동기 API 통신 및 인터셉터 제어)가 하나로 합쳐진 '통합 상태 관리 클래스'입니다.

* **`AuthState` (리액트의 State / Reducer State 역할)**
* 현재 로그인된 유저 정보, 토큰, 로딩 상태(`loading`), 에러 메시지(`error`)를 담고 있는 불변(Immutable) 상태 객체입니다. 리액트 Redux의 초기 스테이트와 같습니다.
* `copyWith`: 리액트에서 상태를 불변성 유지하며 업데이트할 때 `({ ...state, loading: true })` 하듯, 기존 상태를 복사하면서 원하는 값만 바꿔주는 메서드입니다.


* **`AuthNotifier` (리액트의 Saga + Reducer Action 핸들러 역할)**
* **`_initDio()` (Axios Interceptor)**: 리액트에서 API 통신을 위해 `axios.interceptors`를 설정하는 것과 똑같습니다. 요청 보낼 때 토큰을 채워주고, 401 에러가 나면 토큰을 갱신하는 비동기 흐름을 제어합니다.
* **`login()`, `signup()`, `logout()` (Saga의 Effect 역할)**: 리액트 사가에서 `call(api)`, `put(action)`을 쓰며 비동기 통신을 하던 로직이 여기서는 `async/await` 기반의 `Future` 함수로 깔끔하게 구현되어 있습니다. 성공 시 `state = state.copyWith(...)`를 통해 리액트의 `dispatch`처럼 상태를 갱신합니다.



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