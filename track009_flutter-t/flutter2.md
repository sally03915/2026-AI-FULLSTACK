요청해주신 **네트워크 환경 대응(로컬호스트/인터셉터), 네이티브 권한 설정, 그리고 배포 가이드**까지 모두 포함하여, Flutter 프로젝트의 **전체 구조와 구현 방법부터 실무 배포까지** 한눈에 보기 쉽게 처음부터 끝까지 다시 정리해 드리겠습니다!

---

# 🚀 Flutter + Riverpod + Dio 프로젝트 총정리 가이드

## 1. 📂 전체 프로젝트 구조 (Clean & Scalable)

React(Redux/Saga) 개발 경험을 살려, 관심사(State, UI, Model, Network)별로 깔끔하게 나눈 폴더 구조입니다.

```text
lib/
 ┣ core/                    # 공통 설정 (Dio, 인터셉터, 라우터 등)
 ┃  ┣ network/
 ┃  │  ┣ dio_client.dart    # Dio 초기 설정 및 인터셉터
 ┃  │  ┗ base_url.dart      # 환경별 BaseURL 정의
 ┃  ┗ constants/
 ┣ models/                  # 데이터 모델 (JSON 직렬화)
 ┃  ┣ user_model.dart
 ┃  ┗ post_model.dart
 ┣ providers/               # 상태 관리 (Riverpod)
 ┃  ┣ auth_provider.dart
 ┃  ┗ post_provider.dart
 ┣ views/                   # 화면 UI 컴포넌트
 ┃  ┣ auth/
 ┃  │  ┗ login_screen.dart
 ┃  ┗ post/
 ┃     ┗ post_list_screen.dart
 ┗ main.dart                # 앱 진입점 (ProviderScope 설정)

```

---

## 2. 🔌 네트워크 및 에러 핸들링 (핵심 실무 설정)

### ① BaseURL 설정 (환경별 대응)

Spring Boot 백엔드와 통신할 때, 실행 환경(에뮬레이터 vs 실제 기기)에 따라 주소가 달라져야 합니다.

```dart
// lib/core/network/base_url.dart
class BaseUrl {
  // 안드로이드 에뮬레이터 사용 시: http://10.0.2.2:8080
  // iOS 시뮬레이터 사용 시: http://localhost:8080
  // 실제 스마트폰(와이파이 연결) 사용 시: PC의 로컬 IP (예: http://192.168.0.10:8080)
  static const String serverUrl = 'http://10.0.2.2:8080'; 
}

```

### ② Dio 인터셉터 (자동 토큰 주입)

Axios 인터셉터처럼, 모든 API 요청 시 `flutter_secure_storage`에 저장된 `AccessToken`을 자동으로 헤더에 실어 줍니다.

```dart
// lib/core/network/dio_client.dart
import 'package:dio/dio.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import 'base_url.dart';

class DioClient {
  static final Dio dio = Dio(
    BaseOptions(
      baseUrl: BaseUrl.serverUrl,
      connectTimeout: const Duration(seconds: 5),
      receiveTimeout: const Duration(seconds: 5),
      headers: {'Content-Type': 'application/json'},
    ),
  )..interceptors.add(
      InterceptorsWrapper(
        onRequest: (options, handler) async {
          // 요청 보내기 전 Secure Storage에서 토큰 꺼내기
          const storage = FlutterSecureStorage();
          String? token = await storage.read(key: 'accessToken');
          
          if (token != null) {
            options.headers['Authorization'] = 'Bearer $token';
          }
          return handler.next(options);
        },
        onError: (DioException e, handler) {
          // 공통 에러 핸들링 (401 에러 시 로그아웃 처리 등)
          return handler.next(e);
        },
      ),
    );
}

```

---

## 3. 🛡️ 네이티브 권한 설정 (필수 기기 설정)

앱이 인터넷에 접근하거나 카메라/갤러리를 쓰려면 네이티브 설정 파일에 권한을 명시해야 강제 종료(Crash)가 나지 않습니다.

* **안드로이드 (`android/app/src/main/AndroidManifest.xml`)**
```xml
<!-- 인터넷 접근 권한 -->
<uses-permission android:name="android.permission.INTERNET" />
<!-- 갤러리 접근 권한 (추후 필요시) -->
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>

```


* **아이폰 (`ios/Runner/Info.plist`)**
```xml
<!-- 갤러리 권한 메시지 -->
<key>NSPhotoLibraryUsageDescription</key>
<string>프로필 사진 변경을 위해 갤러리 접근 권한이 필요합니다.</string>

```



---

## 4. 🧠 상태 관리 (Riverpod Provider 예시)

리액트의 리덕스처럼 상태를 관리하는 Riverpod 코드 구조입니다.

```dart
// lib/providers/post_provider.dart
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../core/network/dio_client.dart';

// 1. Post 상태를 관리하는 Notifier
class PostNotifier extends StateNotifier<AsyncValue<List<dynamic>>> {
  PostNotifier() : super(const AsyncValue.loading()) {
    fetchPosts();
  }

  Future<void> fetchPosts() async {
    try {
      state = const AsyncValue.loading();
      // DioClient를 통한 API 통신
      final response = await DioClient.dio.get('/posts');
      state = AsyncValue.data(response.data);
    } catch (e, st) {
      state = AsyncValue.error(e, st);
    }
  }
}

// 2. 외부에서 사용할 수 있도록 Provider 선언
final postProvider = StateNotifierProvider<PostNotifier, AsyncValue<List<dynamic>>>(
  (ref) => PostNotifier(),
);

```

---

## 5. 📱 빌드 및 배포 가이드 (내 폰에 설치하기 vs 스토어 올리기)

웹(React)과 달리 모바일 앱은 목적에 따라 설치 및 배포 방식이 다릅니다.

### ① 개발 및 테스트용 (내 폰이나 친구 폰에 직접 설치)

* **안드로이드 (Android):**
* **USB 연결 테스트:** 스마트폰 개발자 옵션(USB 디버깅)을 켜고 PC에 연결 후 터미널에 입력:
```bash
flutter run

```


* **APK 파일 추출 (설치 파일 공유용):**
```bash
flutter build apk --release

```


* 생성된 경로: `build/app/outputs/flutter-apk/app-release.apk`
* 이 파일을 카카오톡이나 구글 드라이브로 안드로이드 폰에 옮겨서 설치하면 끝납니다!




* **아이폰 (iOS):**
* 보안이 엄격하여 APK 같은 단독 파일 설치가 어렵습니다. 맥(Mac)과 Xcode 프로그램이 필수로 요구되며, 애플 개발자 계정이 연결되어 있어야 내 아이폰에 테스트 빌드가 가능합니다.

 

---

### ② 정식 서비스 배포용 (스토어 등록) - *이어지는 내용*

1. **구글 플레이스토어 (Android)**
* [구글 플레이 콘솔](https://play.google.com/console) 가입 (개발자 등록비 평생 1회 $25)
* 스토어 표준 배포 파일인 **AAB(Android App Bundle)** 빌드:
```bash
flutter build appbundle

```


* 생성된 `build/app/outputs/bundle/release/app-release.aab` 파일을 플레이 콘솔에 업로드하고 스토어 정보(설명, 스크린샷, 개인정보 처리방침 등)를 채운 뒤 심사를 요청합니다.


2. **애플 앱스토어 (iOS)**
* [애플 개발자 프로그램](https://developer.apple.com/) 가입 (연간 $99)
* 맥(Mac) 환경에서 프로젝트의 `ios` 폴더를 **Xcode**로 엽니다.
* 상단 메뉴에서 `Product > Archive`를 눌러 아카이브(Archive) 빌드를 진행합니다.
* 빌드가 완료되면 열리는 창(Organizer)에서 **Distribute App**을 눌러 **App Store Connect**로 업로드합니다.
* [App Store Connect](https://appstoreconnect.apple.com/) 사이트에 접속하여 앱 메타데이터를 작성하고 최종 심사를 제출합니다.



---

### 💡 최종 요약

리액트(Redux/Saga) 경험이 있으시다면 위 구조와 가이드를 바탕으로 **Flutter + Riverpod + Dio** 조합을 매우 빠르게 적응하여 개발하실 수 있을 것입니다.

* **개발 중 테스트:** `flutter run` 또는 `flutter build apk --release`로 APK 추출 후 폰에 직접 설치
* **네트워크 연동:** 에뮬레이터 환경에 따른 `BaseURL` 세팅(`10.0.2.2` 등)과 `Dio Interceptor`를 통한 토큰 자동 관리 필수
* **최종 배포:** Google Play Console(AAB)과 App Store Connect(Xcode Archive)를 통한 스토어 심사 출시
 