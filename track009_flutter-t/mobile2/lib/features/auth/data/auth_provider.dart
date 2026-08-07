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
      final response = await _dio.post('/auth/refresh');
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
      final response = await _dio.post('/auth/login', data: credentials);
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
      await _dio.post('/auth/logout');
    } catch (_) {}
    await _storage.delete(key: 'accessToken');
    state = const AuthState();
  }

  // 회원가입 비동기 액션
  // Future<bool> signup(Map<String, dynamic> data) async {
  //   state = AuthState(
  //     user: state.user,
  //     accessToken: state.accessToken,
  //     loading: true,
  //     error: null,
  //   );

  //   try {
  //     await _dio.post('/auth/signup', data: data);
  //     state = AuthState(
  //       user: state.user,
  //       accessToken: state.accessToken,
  //       loading: false,
  //       error: null,
  //     );
  //     return true;
  //   } catch (err) {
  //     state = AuthState(
  //       user: state.user,
  //       accessToken: state.accessToken,
  //       loading: false,
  //       error: '회원가입 실패: ${err.toString()}',
  //     );
  //     return false;
  //   }
  // }

// 회원가입 비동기 액션 (Multipart/FormData 방식으로 수정)
  Future<bool> signup(Map<String, dynamic> data) async {
    state = AuthState(
      user: state.user,
      accessToken: state.accessToken,
      loading: true,
      error: null,
    );

    try {
      // 🌟 서버가 멀티파트 폼데이터(MediaType.MULTIPART_FORM_DATA_VALUE)를 요구하므로 FormData로 감쌉니다.
      final formData = FormData.fromMap({
        'email': data['email'],
        'password': data['password'],
        'nickname': data['nickname'],
        // 만약 프로필 이미지 파일(ufile)도 같이 보낸다면 여기에 추가할 수 있습니다.
      });

      await _dio.post(
        '/auth/signup', 
        data: formData,
        // (선택) 헤더를 명시적으로 폼데이터로 지정
        options: Options(headers: {'Content-Type': 'multipart/form-data'}),
      );

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

// 이메일 중복 체크 (true면 이미 존재함 / false면 사용 가능)
Future<bool> checkEmailDuplicate(String email) async {
  try {
    final response = await _dio.get('/auth/check-email', queryParameters: {'email': email});
    return response.data; // 서버가 Boolean(true/false)을 리턴하므로 그대로 반환
  } catch (e) {
    return false;
  }
}

// 닉네임 중복 체크
Future<bool> checkNicknameDuplicate(String nickname) async {
  try {
    final response = await _dio.get('/auth/check-nickname', queryParameters: {'nickname': nickname});
    return response.data;
  } catch (e) {
    return false;
  }
}


}

// [리액트 비교] 최신 리버팟 NotifierProvider 등록 방식
final authProvider = NotifierProvider<AuthNotifier, AuthState>(() {
  return AuthNotifier();
});