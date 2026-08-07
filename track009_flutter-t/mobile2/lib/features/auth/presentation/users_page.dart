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