### 🚀 4단계: 첫 프로젝트 생성 & Hot Reload & 코드 수정 테스트
#### 1. 쉽게 프로젝트만들기 + 실행 (1)
> lib/main.dart

```dart
// [패키지 임포트] 플러터 UI 제작에 필요한 기본적인 머티리얼 디자인 위젯들을 불러옵니다.
import 'package:flutter/material.dart';

// [앱의 진입점] 프로그램이 실행될 때 가장 먼저 호출되는 main 함수입니다.
void main() {
  runApp(const MyApp()); // MyApp 위젯을 실행하여 화면에 띄웁니다.
}

// [최상위 앱 위젯] 앱 전체의 기본 틀과 테마를 설정하는 고정(Stateless) 위젯입니다.
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo', // 앱의 전체 타이틀
      theme: ThemeData(
        // 앱의 전체적인 색상 테마 설정 (기본 씨드 컬러: 보라색)
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'), // 앱이 켜질 때 처음 보여줄 화면
    );
  }
}

// [메인 화면 위젯] 내부 데이터(숫자 등)에 따라 화면이 동적으로 변해야 하므로 상태가 있는(Stateful) 위젯으로 선언합니다.
class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title; // 상위에서 전달받은 타이틀 제목 변수

  @override
  State<MyHomePage> createState() => _MyHomePageState(); // 상태를 관리할 State 객체를 연결합니다.
}

// [메인 화면 상태 관리 클래스] 실제 화면에 그려질 내용과 데이터 변화를 처리합니다.
class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0; // 버튼이 눌릴 때마다 카운트될 숫자를 저장하는 변수

  // 버튼을 누를 때 실행되는 함수: 숫자를 1 증가시키고 화면을 갱신합니다.
  void _incrementCounter() {
    setState(() {
      // setState: "데이터가 바뀌었으니 화면을 다시 그려줘!"라고 플러터에 알리는 역할
      _counter++; 
    });
  }

  @override
  Widget build(BuildContext context) {
    // Scaffold: 상단바, 본문, 우측 하단 버튼 등 앱의 표준 레이아웃 뼈대를 잡아줍니다.
    return Scaffold(
      appBar: AppBar(
        // 상단바 배경색 지정
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        // 상단바 타이틀 텍스트 설정
        title: Text(widget.title),
      ),
      body: Center(
        // Center: 자식 요소들을 화면 정중앙에 배치
        child: Column(
          // Column: 자식 요소들을 세로(위에서 아래로) 방향으로 나열
          mainAxisAlignment: MainAxisAlignment.center, // 세로 기준 중앙 정렬
          children: [
            const Text('You have pushed the button this many times:'), // 안내 문구 텍스트
            Text(
              '$_counter', // 현재 카운터 숫자 변수 출력
              style: Theme.of(context).textTheme.headlineMedium, // 텍스트 스타일 지정
            ),
          ],
        ),
      ),
      // 화면 우측 하단에 떠 있는 동그란 플러스(+) 버튼
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter, // 버튼을 누르면 위에서 정의한 _incrementCounter 함수 실행
        tooltip: 'Increment', // 길게 눌렀을 때 나오는 설명 툴팁
        child: const Icon(Icons.add), // 버튼 내부의 더하기(+) 아이콘
      ),
    );
  }
}

```

#### 1. 쉽게 프로젝트만들기 + 실행 (2)
> lib/main.dart

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