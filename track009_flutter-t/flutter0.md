

# ■ Flutter 학습 가이드 (Windows 기준)

### 🚀 1단계: Flutter SDK 설치
**[실습]**
- [x] Git으로 설치:
  ```bash
  git clone https://github.com/flutter/flutter.git -b stable C:\flutter
  ```
- [x] 환경 변수 설정:  
  시스템 환경 변수 편집 → Path → `C:\flutter\bin` 추가
- [x] 실행 테스트:
  ```bash
  flutter doctor
  ```
  ※ 안 되면:
  ```bash
  C:\flutter\bin\flutter.bat doctor
  ```

---

### 🚀 2단계: VS Code 설치 & 확장 프로그램
**[실습]**
- [x] VS Code 설치 ([공식 사이트](https://code.visualstudio.com/))  
    선택할 항목: C++를 사용한 데스크톱 개발 (Desktop development with C++)
- [x] 확장 프로그램 설치 (Ctrl+Shift+X):
  - Flutter  
  - Dart  

---

### 🚀 3단계: 앱 실행 방법 선택

#### (A) Android Studio + 에뮬레이터
**[실습]**
- [x] Android Studio 설치 ([공식 사이트](https://developer.android.com/studio))  
- [x] SDK Manager 설정  
  - SDK Platforms → 최신 API 레벨 설치 (예: **Android 14**)  
  - SDK Tools → Command-line Tools, Emulator, Platform-Tools, Build-Tools 체크  

```
flutter doctor 
```

```
PS D:\hyojung\msa-fullstack2025\track010_flutter> flutter doctor          
Doctor summary (to see all details, run flutter doctor -v):
[√] Flutter (Channel stable, 3.38.9, on Microsoft Windows [Version 10.0.19045.6466], locale ko-KR)
[√] Windows Version (10 Pro 64비트, 22H2, 2009)
[!] Android toolchain - develop for Android devices (Android SDK version 36.1.0)
    ! Some Android licenses not accepted. To resolve this, run: flutter doctor --android-licenses
[√] Chrome - develop for the web
[√] Visual Studio - develop Windows apps (Visual Studio Community 2026 18.2.1)
[√] Connected device (3 available)
[√] Network resources

! Doctor found issues in 1 category.
PS D:\hyojung\msa-fullstack2025\track010_flutter>
```

<br/>
<br/>   

---


### 🚀 4단계: 첫 프로젝트 생성 & Hot Reload & 코드 수정 테스트
#### 쉽게 프로젝트만들기 + 실행
**[실습]** 
- [x] 실행:
  ```bash
  flutter create mobile1
  cd mobile1
  flutter run
  2
  ```
  ```bash
  flutter devices 
  flutter run -d chrome
  ```


**[실습]**
- [x] `lib/main.dart` 수정:
  ```dart
  home: Scaffold(
    appBar: AppBar(
      title: Text('내 첫 Flutter 앱'),
    ),
    body: Center(
      child: Text('Hello Flutter!'),
    ),
  ),
  ```

#### 1. `home` 속성
* 앱이 실행되었을 때 가장 먼저 화면에 보여줄 시작 페이지(기본 화면)를 지정하는 속성입니다.

#### 2. `Scaffold` 위젯
* 플러터 앱에서 화면의 전체적인 뼈대(틀)를 잡아주는 기본 위젯입니다.
* 상단바(AppBar), 본문(body), 하단 탭(BottomNavigationBar) 등 화면을 구성하는 표준적인 배치 공간을 제공합니다.

#### 3. `appBar` 속성과 `AppBar` 위젯
* 앱 화면의 가장 상단에 위치하는 바(Header)를 만듭니다.
* `title` 속성에 `Text('내 첫 Flutter 앱')`을 넣어 상단바 가운데(또는 왼쪽)에 앱의 제목을 텍스트로 표시합니다.

#### 4. `body` 속성과 `Center` 위젯
* 앱의 **실제 콘텐츠가 들어가는 본문 영역**입니다.
* `Center` 위젯을 사용하여 그 아래에 들어가는 자식 위젯을 **화면 정중앙**에 배치합니다.

#### 5. `child` 속성과 `Text` 위젯
* `Center` 위젯 내부에 포함된 자식 요소로, 화면 중앙에 'Hello Flutter!'라는 문자열 텍스트를 출력합니다.



- [x] 앱 실행 중 터미널에서:
  - `r` → Hot Reload  
  - `R` → Hot Restart  
- [x] 저장 후 Hot Reload → 화면 반영  

 

### 💡 터미널 단축키 기능

* **`r` (Hot Reload):** 코드를 수정하고 저장한 뒤 터미널에서 `r`을 누르면, 앱을 껐다 켜지 않고도 상태를 유지한 채 변경된 화면을 즉시 반영(새로고침)합니다.
* **`R` (Hot Restart):** 앱을 완전히 재시작하여 **초기화면부터 다시 빌드**합니다.

---

### 🚀 5단계: 필수 패키지 설치
**[실습]**
- [x] `pubspec.yaml` 수정:
  ```yaml
  dependencies:
    flutter:
      sdk: flutter
    http: ^1.1.0
    provider: ^6.1.1
    shared_preferences: ^2.2.2
    go_router: ^12.1.3
  ```
- [x] 패키지 설치:
  ```bash
  flutter pub get
  flutter pub add http
  flutter pub add provider
  ```

###### 1. `pubspec.yaml` 수정
- Flutter 프로젝트의 **환경 설정 파일**이에요.  
- 여기에 어떤 패키지를 사용할지 선언하면, Flutter가 해당 패키지를 다운로드하고 프로젝트에 연결해 줍니다.

###### 2. 주요 패키지들의 역할
- **http: ^1.1.0**  
  → 서버와 통신할 때 쓰는 패키지. REST API 호출, 데이터 가져오기 등에 사용됩니다.  
  *예: 로그인 요청 보내기, 뉴스 기사 불러오기.*

- **provider: ^6.1.1**  
  → 상태 관리 패키지. 앱 내 데이터(로그인 상태, 장바구니 등)를 효율적으로 관리하고 UI와 연결해 줍니다.  
  *예: 버튼 클릭 시 화면 전체가 자동으로 업데이트.*

- **shared_preferences: ^2.2.2**  
  → 간단한 데이터(설정값, 로그인 토큰 등)를 **로컬 저장소**에 저장할 수 있게 해줍니다.  
  *예: 앱을 껐다 켜도 다크모드 설정 유지.*

- **go_router: ^12.1.3**  
  → 화면 이동(Navigation)을 쉽게 관리하는 패키지.  
  *예: 로그인 후 홈 화면으로 이동, URL 기반 라우팅.*
 

---

### 🚀 6단계: 앱 실행 & 테스트

```dart
// 1. lib/basic.dart
// 2. dart run lib/basic.dart
// Flutter/Dart 기본 문법 연습용 예제

void main() {
  // 1. 변수 선언
  int number = 10;
  double pi = 3.14;
  String name = "Flutter";
  bool isAwesome = true;

  print("number: $number, pi: $pi, name: $name, isAwesome: $isAwesome");

  // 2. 리스트(List)
  List<String> fruits = ["apple", "banana", "cherry"];
  fruits.add("orange");
  print("fruits: $fruits");

  // 3. 맵(Map)
  Map<String, int> scores = {"math": 90, "english": 85};
  scores["science"] = 95;
  print("scores: $scores");

  // 4. 조건문
  if (number > 5) {
    print("number는 5보다 큽니다");
  } else {
    print("number는 5 이하입니다");
  }

  // 5. 반복문
  for (var fruit in fruits) {
    print("과일: $fruit");
  }

  // 6. 함수(Function)
  int sum(int a, int b) {
    return a + b;
  }
  print("sum(3, 5) = ${sum(3, 5)}");

  // 7. 클래스(Class)
  Person p = Person("홍길동", 20);
  p.sayHello();

  // 8. 비동기 처리 (Future, async/await)
  fetchData().then((value) => print("then: $value"));
  testAsync();
}

// 클래스 예제
class Person {
  String name;
  int age;

  Person(this.name, this.age);

  void sayHello() {
    print("안녕하세요, 저는 $name이고 나이는 $age살입니다.");
  }
}

// 비동기 함수 예제
Future<String> fetchData() async {
  await Future.delayed(Duration(seconds: 2));
  return "서버에서 데이터 가져오기 완료!";
}

void testAsync() async {
  String result = await fetchData();
  print("await: $result");
}

```

---

### 🚀 Windows 7 특화 팁
**[실습]**
- [ ] PowerShell 실행 정책:
  ```bash
  Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
  ```
- [ ] VS Code 단축키 활용:
  - F5 → 디버그 실행  
  - Ctrl+F5 → 디버그 없이 실행  
  - Ctrl+Shift+P → Flutter 명령어 실행  
- [ ] Hot Reload:
  - `r` → UI 업데이트  
  - `R` → 앱 전체 재시작  
 