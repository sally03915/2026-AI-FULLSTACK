package com.the703.basic015_ex;

import java.util.*;

interface MapPrinter { void printAll(Map<String, Integer> map); }
//interface ScoreCompare { int compare(int a, int b); }

public class LambdaEx005 {
    public static void main(String[] args) {
        
        Map<String, Integer> scores = Map.of("Alice", 90, "Bob", 75, "Charlie", 82);

        // 문제 1: 키-값 출력
        MapPrinter mp1 = new MapPrinter() {
            @Override
            public void printAll(Map<String, Integer> map) {
                for(Map.Entry<String, Integer> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }
            }
        };
        mp1.printAll(scores);

        MapPrinter mp2 = map -> {
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        };
        mp2.printAll(scores);

        MapPrinter mp3 = map -> map.forEach((k,v) -> System.out.println(k + " : " + v));
        mp3.printAll(scores);


        // 문제 2: 값 비교
        ScoreCompare sc1 = new ScoreCompare() {
            @Override
            public int compare(int a, int b) {
                return (a > b) ? a : b;
            }
        };
        System.out.println("익명객체 결과: " + sc1.compare(90, 75));

        ScoreCompare sc2 = (a, b) -> (a > b) ? a : b;
        System.out.println("람다식 결과: " + sc2.compare(82, 90));

        ScoreCompare sc3 = Math::max;
        System.out.println("메서드참조 결과: " + sc3.compare(70, 65));
    }
}


/*
연습문제 4) Map & Lambda
패키지명 : com.the703.basic015_ex  
클래스명 : LambdaEx004

package com.the703.basic015_ex;

import java.util.*;

interface MapPrinter { void printAll(Map<String, Integer> map); }
interface ScoreCompare { int compare(int a, int b); }

public class LambdaEx004 {
    public static void main(String[] args) {
        
        Map<String, Integer> scores = Map.of("Alice", 90, "Bob", 75, "Charlie", 82);

        // 문제 1: 키-값 출력
        mp1.printAll(scores);

        mp2.printAll(scores);

        mp3.printAll(scores);


        // 문제 2: 값 비교
 
        System.out.println("익명객체 결과: " + sc1.compare(90, 75));
 
        System.out.println("람다식 결과: " + sc2.compare(82, 90));
 
        System.out.println("메서드참조 결과: " + sc3.compare(70, 65));
    }
}



문제 1: 키-값 출력하기
설명: Map<String, Integer> 형태의 데이터를 받아서 모든 키-값을 출력하세요.

인터페이스 이름: MapPrinter

메서드: void printAll(Map<String, Integer> map)

요구사항
익명 객체로 Map의 모든 키-값 출력하기
Map<String, Integer> scores = Map.of("Alice", 90, "Bob", 75, "Charlie", 82);
mp1.printAll(scores);
// 출력내용:
// Alice : 90
// Bob : 75
// Charlie : 82

람다식으로 동일한 기능 구현하기
메서드 참조(::)로 동일한 기능 구현하기 (System.out::println 활용)

문제 2: 값 비교하기
설명: Map<String, Integer>에서 두 학생의 점수를 비교하여 더 높은 점수를 반환하세요.
인터페이스 이름: ScoreCompare
메서드: int compare(int a, int b)

요구사항
익명 객체로 (90, 75) → 90 반환하기
람다식으로 (82, 90) → 90 반환하기
메서드 참조(::)로 (70, 65) → 70 반환하기 (Math::max 활용)

※ 참고사항
1. Map.entrySet()
Map의 모든 키-값 쌍을 가져옴

예시:

java
for(Map.Entry<String,Integer> e : map.entrySet()) {
    System.out.println(e.getKey() + " : " + e.getValue());
}
2. Map.forEach(BiConsumer<K,V>)
Map의 모든 키-값을 순회하며 작업 수행

예시:

java
map.forEach((k,v) -> System.out.println(k + " : " + v));
3. Math.max(int a, int b)
두 수 중 큰 값을 반환

예시: Math.max(10, 3) → 10

*/