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





// import 'package:flutter/material.dart';
// import 'package:flutter_riverpod/flutter_riverpod.dart';

// class AppLayout extends ConsumerWidget {
//   final Widget child;
//   const AppLayout({super.key, required this.child});

//   @override
//   Widget build(BuildContext context, WidgetRef ref) {
//     // [임시 테스트용] DateTime.now() 같은 동적 값을 활용하면 
//     // 컴파일 시점에 결과가 고정되지 않으므로 dead code 경고가 절대 나지 않습니다!
//     final bool isLogined =   DateTime.now().year < 2000; // < 항상 false이지만 컴파일러는 모름 (원하면 true로 테스트 가능)
//     //final bool isLogined = true;
//     return Scaffold(
//       appBar: AppBar(
//         title: const Text('나의 소셜 앱'),
//         actions: [
//           if (isLogined) ...[
//             const Center(
//               child: Padding(
//                 padding: EdgeInsets.symmetric(horizontal: 8.0),
//                 child: Text('테스트유저님 환영합니다!'),
//               ),
//             ),
//           ] else ...[
//             TextButton(
//               onPressed: () => Navigator.pushNamed(context, '/login'),
//               child: const Text('로그인', style: TextStyle(color: Colors.white)),
//             ),
//           ],
//         ],
//       ),
//       body: child,
//     );
//   }
// }

// // 리액트 개발자의 눈으로 이해하기
// // - ConsumerWidget: 리액트에서 Redux나 Recoil 상태를 구독(useSelector)하는 컴포넌트처럼, 전역 상태(authProvider)를 실시간으로 구독(Watch)하는 위젯입니다. 상태가 바뀌면 이 레이아웃도 알아서 리렌더링됩니다.
// // - final Widget child: 리액트 컴포넌트의 children props와 같습니다. 여러 페이지(게시판 목록, 마이페이지 등)에서 상단바의 디자인과 로그인 상태바가 계속 반복되니까, 이 AppLayout 하나로 감싸서 공통 껍데기(Layout)로 재사용하는 것입니다.
