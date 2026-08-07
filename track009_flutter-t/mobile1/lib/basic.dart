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