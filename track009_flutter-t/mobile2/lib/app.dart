import 'package:flutter/material.dart';
import 'shared/components/app_layout.dart';
// 🌟 로그인, 회원가입 페이지 파일들을 임포트합니다.
import 'features/auth/presentation/login_page.dart';
import 'features/auth/presentation/signup_page.dart';
import 'features/auth/presentation/users_page.dart';

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
        '/users': (context) => const UsersPage(), // 🌟 마이페이지 라우터 등록!
      },
    );
  }
}


////////////////////////////////////////////////////// ver-2  레아아웃테스트
// import 'package:flutter/material.dart'; // 🌟 이 줄이 없으면 ThemeData나 AppBar를 절대 인식하지 못합니다!
// import 'shared/components/app_layout.dart';

// class App extends StatelessWidget {
//   const App({super.key});

//   @override
//   Widget build(BuildContext context) {
//     return MaterialApp(
//       title: '나의 소셜 앱',
//       debugShowCheckedModeBanner: false,
//       theme: ThemeData(
//         useMaterial3: true,
//         appBarTheme: const AppBarTheme(
//           backgroundColor: Colors.blue,
//           foregroundColor: Colors.white,
//         ),
//       ),
//       initialRoute: '/',
//       routes: {
//         '/': (context) => const AppLayout(
//               child: Center(
//                 child: Text(
//                   '이제 에러 없이 파란 상단바가 뜹니다! 🎉',
//                   style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
//                 ),
//               ),
//             ),
//       },
//     );
//   }
// }



//////////////////////////////////////////// ver-1
// import 'package:flutter/material.dart';

// class App extends StatelessWidget {
//   const App({super.key});

//   @override
//   Widget build(BuildContext context) {
//     return MaterialApp(
//       title: '나의 소셜 앱',
//       debugShowCheckedModeBanner: false,
//       initialRoute: '/',
//       routes: {
//         '/': (context) => Scaffold(
//               appBar: AppBar(title: const Text('1단계: 라우팅 테스트')),
//               body: const Center(child: Text('앱이 정상적으로 실행되었습니다! 🎉')),
//             ),
//       },
//     );
//   }
// }
