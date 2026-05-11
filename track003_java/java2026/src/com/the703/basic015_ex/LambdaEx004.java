package com.the703.basic015_ex;

import java.util.*;

interface ListPrinter { void printAll(List<String> list); }
interface ListSorter { void sort(List<Integer> list); }

public class LambdaEx004 {
    public static void main(String[] args) {
        
        List<String> foods = Arrays.asList("pizza", "ramen", "burger");
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 9, 1, 3));

        // 문제 1: 리스트 출력
        ListPrinter lp1 = new ListPrinter() {
            @Override
            public void printAll(List<String> list) {
                for(String s : list) System.out.println(s);
            }
        };
        lp1.printAll(foods);

        ListPrinter lp2 = list -> {
            for(String s : list) System.out.println(s);
        };
        lp2.printAll(foods);

        ListPrinter lp3 = list -> list.forEach(System.out::println);
        lp3.printAll(foods);


        // 문제 2: 리스트 정렬
        ListSorter ls1 = new ListSorter() {
            @Override
            public void sort(List<Integer> list) {
                Collections.sort(list);
            }
        };
        ls1.sort(numbers);
        System.out.println("익명객체 결과: " + numbers);

        numbers = new ArrayList<>(Arrays.asList(5, 2, 9, 1, 3));
        ListSorter ls2 = list -> Collections.sort(list);
        ls2.sort(numbers);
        System.out.println("람다식 결과: " + numbers);

        numbers = new ArrayList<>(Arrays.asList(5, 2, 9, 1, 3));
        ListSorter ls3 = list -> list.sort(Integer::compare);
        ls3.sort(numbers);
        System.out.println("메서드참조 결과: " + numbers);
    }
}


/*
package com.the703.basic015_ex;

import java.util.*;

interface ListPrinter { void printAll(List<String> list); }
interface ListSorter { void sort(List<Integer> list); }

public class LambdaEx005 {
    public static void main(String[] args) {
        
        List<String> foods = Arrays.asList("pizza", "ramen", "burger");
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 9, 1, 3));

        // 문제 1: 리스트 출력
        lp1.printAll(foods);

        lp2.printAll(foods);

        lp3.printAll(foods);


        // 문제 2: 리스트 정렬
        System.out.println("익명객체 결과: " + numbers);

        numbers = new ArrayList<>(Arrays.asList(5, 2, 9, 1, 3));
        System.out.println("람다식 결과: " + numbers);

        numbers = new ArrayList<>(Arrays.asList(5, 2, 9, 1, 3));
        System.out.println("메서드참조 결과: " + numbers);
    }
}


컬렉션 + 람다/메서드 참조 (Stream 없이)
패키지명 : com.the703.basic015_ex  
클래스명 : LambdaEx005

문제 1: 리스트 출력하기
설명: 문자열 리스트(List\<String\>)를 받아서 모든 요소를 출력하세요.
인터페이스 이름: ListPrinter
메서드: void printAll(List<String> list)
요구사항
익명 객체로 리스트 요소 출력하기
람다식으로 동일한 기능 구현하기
메서드 참조(::)로 동일한 기능 구현하기 (System.out::println 활용)

문제 2: 리스트 정렬하기
설명: 정수 리스트(List\<Integer\>)를 받아서 오름차순으로 정렬하세요.
인터페이스 이름: ListSorter
메서드: void sort(List<Integer> list)
요구사항
익명 객체로 Collections.sort() 사용하기
람다식으로 동일한 기능 구현하기
메서드 참조(::)로 동일한 기능 구현하기 (Integer::compare)

 

★ 참고사항
1. System.out::println
메서드 참조로 출력 기능을 바로 연결
예시: list.forEach(System.out::println);

2. Collections.sort(List<T>)
리스트를 오름차순으로 정렬
List<Integer> nums = Arrays.asList(3,1,2);
Collections.sort(nums); // [1,2,3]

3. List.sort(Comparator)
리스트를 원하는 기준으로 정렬
nums.sort(Integer::compare); 
*/