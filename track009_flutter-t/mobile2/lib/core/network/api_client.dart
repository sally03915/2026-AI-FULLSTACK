// #### 🌐 1. `lib/core/network/api_client.dart`
// > **리액트로 치면?** 환경변수(`.env`)로 `API_BASE_URL`을 설정하는 것과 같습니다. 


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



// * **왜 이런 코드가 필요할까요?**
// * 우리가 만드는 앱이 실행되는 기기마다 내 컴퓨터(백엔드 서버)를 바라보는 주소가 다르기 때문입니다.
// * 안드로이드 에뮬레이터(가상 가상머신)는 보안상 내 컴퓨터를 `localhost`로 부르지 못하고 특수한 주소인 `10.0.2.2`를 써야 합니다. 반면, 웹이나 아이폰 시뮬레이터는 평소처럼 `localhost`를 씁니다.
// * 이 코드는 **"지금 실행 중인 기기가 안드로이드니? 그럼 이 주소를 써!"** 하고 상황에 맞는 서버 주소를 뱉어주는 똑똑한 유틸 함수입니다.