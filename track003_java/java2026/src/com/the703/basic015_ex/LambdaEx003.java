package com.the703.basic015_ex;

interface MovieTitle { String convert(String title); }
interface FoodLength { int getLength(String food); }
interface ScoreCompare { int compare(int a, int b); }

public class LambdaEx003 {
    public static void main(String[] args) {
        
        // 문제 1: 영화 제목 대문자 변환 
    	MovieTitle m1 = new MovieTitle() {
			@Override public String convert(String title) { return title.toUpperCase(); }
		};
        System.out.println("익명객체 결과: " + m1.convert("avengers"));
 
        MovieTitle m2 = title-> title.toUpperCase();
        System.out.println("람다식 결과: " + m2.convert("inception"));
 
        MovieTitle m3 = String::toUpperCase;
        System.out.println("메서드참조 결과: " + m3.convert("matrix"));
 
        // 문제 2: 음식 이름 길이 반환 
        FoodLength f1 = new FoodLength() {
			@Override public int getLength(String food) { return food.length(); }
		};
        System.out.println("익명객체 결과: " + f1.getLength("pizza"));
 
        FoodLength f2 = food-> food.length();
        System.out.println("람다식 결과: " + f2.getLength("hamburger"));
 
        FoodLength f3 = String::length;
        System.out.println("메서드참조 결과: " + f3.getLength("ramen"));
 
        // 문제 3: 점수 비교 
        ScoreCompare s1 = new ScoreCompare() {
			@Override public int compare(int a, int b) { return Math.max(a, b); }
		};
        System.out.println("익명객체 결과: " + s1.compare(85, 92));
 
        ScoreCompare s2 = (a, b)-> Math.max(a, b);
        System.out.println("람다식 결과: " + s2.compare(70, 65));
 
        ScoreCompare s3 = Math::max;
        System.out.println("메서드참조 결과: " + s3.compare(100, 99));
    }
}
/*


📘 연습문제 3) Lambda & Method Reference
패키지명 : com.the703.basic015_ex  
클래스명 : LambdaEx003
package com.the703.basic015_ex;

interface MovieTitle { String convert(String title); }
interface FoodLength { int getLength(String food); }
interface ScoreCompare { int compare(int a, int b); }

public class LambdaEx003 {
    public static void main(String[] args) {
        
        // 문제 1: 영화 제목 대문자 변환 
        System.out.println("익명객체 결과: " + m1.convert("avengers"));
 
        System.out.println("람다식 결과: " + m2.convert("inception"));
 
        System.out.println("메서드참조 결과: " + m3.convert("matrix"));


        // 문제 2: 음식 이름 길이 반환 
        System.out.println("익명객체 결과: " + f1.getLength("pizza"));
 
        System.out.println("람다식 결과: " + f2.getLength("hamburger"));
 
        System.out.println("메서드참조 결과: " + f3.getLength("ramen"));


        // 문제 3: 점수 비교 
        System.out.println("익명객체 결과: " + s1.compare(85, 92));
 
        System.out.println("람다식 결과: " + s2.compare(70, 65));
 
        System.out.println("메서드참조 결과: " + s3.compare(100, 99));
    }
}



문제 1: 매개변수 O, 리턴값 O
설명: 영화 제목을 받아서 대문자로 변환하는 기능을 구현하세요.
인터페이스 이름: MovieTitle
메서드: String convert(String title)

요구사항
익명 객체로 "avengers" → "AVENGERS" 변환하기
람다식으로 "inception" → "INCEPTION" 변환하기
메서드 참조(::)로 "matrix" → "MATRIX" 변환하기

문제 2: 매개변수 O, 리턴값 O
설명: 음식 이름을 받아 길이를 반환하세요.

인터페이스 이름: FoodLength
메서드: int getLength(String food)
요구사항
익명 객체로 "pizza" → 5 반환하기
람다식으로 "hamburger" → 9 반환하기
메서드 참조(::)로 "ramen" → 5 반환하기

문제 3: 매개변수 O, 리턴값 O
설명: 두 점수를 받아 더 큰 점수를 반환하세요.
인터페이스 이름: ScoreCompare
메서드: int compare(int a, int b)
요구사항
익명 객체로 (85, 92) → 92 반환하기
람다식으로 (70, 65) → 70 반환하기
메서드 참조(::)로 (100, 99) → 100 반환하기


※  참고사항
1. String.toUpperCase()
문자열을 모두 대문자로 변환
예시: "hello".toUpperCase() → "HELLO"

2. String.length()
문자열의 길이를 반환
예시: "banana".length() → 6

3. String.compareTo(String another)
두 문자열을 사전순으로 비교
같으면 0
앞에 오면 음수
뒤에 오면 양수
예시: "apple".compareTo("banana") → -1

4. Math.max(int a, int b)
두 수 중 큰 값을 반환
예시: Math.max(10, 3) → 10

5. Math.min(int a, int b)
두 수 중 작은 값을 반환
예시: Math.min(10, 3) → 3

6. Math.abs(int a)
절대값 반환
예시: Math.abs(-10) → 10
*/