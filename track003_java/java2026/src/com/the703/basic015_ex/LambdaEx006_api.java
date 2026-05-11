import java.util.*;
import java.util.function.*;

public class LambdaPractice {
    public static void main(String[] args) {
        // 문제 1: 두 정수 합
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println("문제1: 3+5 = " + sum.apply(3, 5));

        // 문제 2: 문자열 길이
        Function<String, Integer> strLength = s -> s.length();
        System.out.println("문제2: 'Hello' 길이 = " + strLength.apply("Hello"));

        // 문제 3: 짝수 판별
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("문제3: 4는 짝수? " + isEven.test(4));

        // 문제 4: 문자열을 정수로 변환
        Function<String, Integer> strToInt = s -> Integer.parseInt(s);
        System.out.println("문제4: '123' → " + strToInt.apply("123"));

        // 문제 5: 리스트 이름 대문자 변환
        List<String> names = Arrays.asList("Kim", "Lee", "Park");
        names.stream().map(String::toUpperCase).forEach(n -> System.out.println("문제5: " + n));

        // 문제 6: 리스트에서 짝수만 필터링
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream().filter(isEven).forEach(n -> System.out.println("문제6: 짝수 = " + n));

        // 문제 7: 두 수의 최대값
        BiFunction<Integer, Integer, Integer> max = (a, b) -> a > b ? a : b;
        System.out.println("문제7: max(7, 10) = " + max.apply(7, 10));

        // 문제 8: 문자열 출력 Consumer
        Consumer<String> greet = s -> System.out.println("문제8: Hello, " + s);
        greet.accept("Lambda");
    }
}

/*
람다식 연습문제
1. 기초 연습
문제 1: 두 정수를 입력받아 합을 반환하는 람다식을 작성하세요.  예: (a, b) -> a + b
문제 2: 문자열을 입력받아 길이를 반환하는 람다식을 작성하세요.  예: (s) -> s.length()

2. 함수형 인터페이스 활용
문제 3: Predicate<Integer>를 이용해 정수가 짝수인지 판별하는 람다식을 작성하세요.
문제 4: Function<String, Integer>를 이용해 문자열을 정수로 변환하는 람다식을 작성하세요.

3. 컬렉션과 함께 사용하기
문제 5: 리스트 List<String> names = Arrays.asList("Kim", "Lee", "Park");  
→ 모든 이름을 대문자로 변환하는 람다식을 map과 함께 사용하세요.
문제 6: 리스트 List<Integer> numbers = Arrays.asList(1,2,3,4,5);  
→ 짝수만 필터링하여 출력하는 람다식을 작성하세요.

4. 조금 더 심화
문제 7: BiFunction<Integer, Integer, Integer>를 이용해 두 수의 최대값을 반환하는 람다식을 작성하세요.
문제 8: Consumer<String>을 이용해 문자열을 받아 "Hello, <문자열>" 형식으로 출력하는 람다식을 작성하세요.

Predicate<T> → 조건 판별 (true/false 반환)
Function<T,R> → 입력 T를 받아 R 반환
Consumer<T> → 입력 T를 받아 소비(출력 등)
Supplier<T> → 아무 입력 없이 T 반환

*/

// 📌 실행 결과 예시
// 문제1: 3+5 = 8
// 문제2: 'Hello' 길이 = 5
// 문제3: 4는 짝수? true
// 문제4: '123' → 123
// 문제5: KIM, LEE, PARK
// 문제6: 짝수 = 2, 4
// 문제7: max(7, 10) = 10

