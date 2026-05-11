package com.the703.basic015_ex;

interface StringLength { int getLength(String s); }
interface StringCompare { int compare(String a, String b); }

public class LambdaEx002 {
    public static void main(String[] args) {
    	//    	interface StringLength { int getLength(String s); }	
        // 문제 1: 문자열 길이 반환
        // 1. 익명 객체 
    	StringLength  sl1 = new StringLength() {
			@Override public int getLength(String s) { return s.length(); }
    	};
        System.out.println("익명객체 결과: " + sl1.getLength("hello")); // 5
        
        // 2. 람다식 
        // StringLength  sl2 = (String s)->{ return s.length(); };
        StringLength  sl2 =    s ->  s.length();  
        System.out.println("람다식 결과: " + sl2.getLength("lambda")); // 6
        
        // 3. 메서드 참조 
        StringLength  sl3 =    String::length;  // 
        System.out.println("메서드참조 결과: " + sl3.getLength("reference")); // 9

        //  interface StringCompare { int compare(String a, String b); }
        // 문제 2: 문자열 비교
        // 1. 익명 객체 
        StringCompare sc1 = new StringCompare() {
			@Override public int compare(String a, String b) { return a.compareTo(b); }
        }; 
        System.out.println("익명객체 결과: " + sc1.compare("apple", "banana")); // -1
        
        // 2. 람다식 
        //StringCompare sc2 = (String a, String b)->{ return a.compareTo(b); };
        StringCompare sc2   = (       a,        b)->  a.compareTo(b); 
        System.out.println("람다식 결과: " + sc2.compare("grape", "grape")); // 0
        
        // 3. 메서드 참조 
        StringCompare sc3   = String::compareTo;
        System.out.println("메서드참조 결과: " + sc3.compare("pear", "orange")); // 양수
    }
}



/*
연습문제 2) Lambda & Method Reference
패키지명 : com.the703.basic015_ex  
클래스명 : LambdaEx002

문제 1: 매개변수 O, 리턴값 O
설명: 문자열을 받아 길이를 반환하는 기능을 구현하세요.
인터페이스 이름: StringLength
메서드: int getLength(String s)

요구사항
익명 객체로 문자열 길이를 반환하기
System.out.println("익명객체 결과: " + sl1.getLength("hello")); // 결과: 5

람다식으로 동일한 기능 구현하기
System.out.println("람다식 결과: " + sl2.getLength("lambda")); // 결과: 6

메서드 참조(::)로 동일한 기능 구현하기
System.out.println("메서드참조 결과: " + sl3.getLength("reference")); // 결과: 9


실행결과 

익명객체 결과: 5
람다식 결과: 6
메서드참조 결과: 9


문제 2: 매개변수 O, 리턴값 O
설명: 두 문자열을 받아 사전순 비교 결과를 반환하세요.
인터페이스 이름: StringCompare
메서드: int compare(String a, String b)

요구사항

익명 객체로 compareTo 기능 구현하기
System.out.println("익명객체 결과: " + sc1.compare("apple", "banana")); // 결과: -1

람다식으로 동일한 기능 구현하기
System.out.println("람다식 결과: " + sc2.compare("grape", "grape")); // 결과: 0
메서드 참조(::)로 동일한 기능 구현하기

System.out.println("메서드참조 결과: " + sc3.compare("pear", "orange")); // 결과: 양수
 

실행결과 
익명객체 결과: -1
람다식 결과: 0
메서드참조 결과: 1

*/