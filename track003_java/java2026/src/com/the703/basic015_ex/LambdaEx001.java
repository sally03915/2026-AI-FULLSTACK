package com.the703.basic015_ex;

interface Printer { void print(String msg); }
interface Calculator { int add(int a, int b); } 
public class LambdaEx001 {
    public static void main(String[] args) {
    	//interface Printer { void print(String msg); }
		//1.    익명 객체로 "Message: <문자열>" 형식으로 출력하기
    	Printer p1 = new Printer() { 
			@Override public void print(String msg) { System.out.println("Message: " + msg); }
		}; p1.print("Hello World");   //출력내용:  Message: Hello World
		
		//2.    람다식으로 동일한 기능 구현하기
		Printer p2 = msg->  System.out.println("Message: " + msg); 
		p2.print("Lambda Rocks!"); //출력내용:  Message: Lambda Rocks!
 
    	//interface Calculator { int add(int a, int b); }
		//3.    익명 객체로 두 수의 합을 반환하기
		Calculator  c1 = new Calculator() { 
			@Override public int add(int a, int b) { return a+b; }
		}; System.out.println("익명객체 결과: " + c1.add(3, 5)); 
		
		//4.    람다식으로 동일한 기능 구현하기
		Calculator  c2 = (a,b)->a+b; 
		System.out.println("람다식 결과: " + c2.add(10, 20));
    }
}




/*
package com.the703.basic015_ex;

interface Printer { void print(String msg); }
interface Calculator { int add(int a, int b); }

public class LambdaEx001 {
    public static void main(String[] args) {
    	//interface Printer { void print(String msg); }
		//1.    익명 객체로 "Message: <문자열>" 형식으로 출력하기
		//    	p1.print("Hello World");   //출력내용:  Message: Hello World
		//2.    람다식으로 동일한 기능 구현하기
		//      p2.print("Lambda Rocks!"); //출력내용:  Message: Lambda Rocks!
 

    	//interface Calculator { int add(int a, int b); }
		//3.    익명 객체로 두 수의 합을 반환하기
    	//      System.out.println("익명객체 결과: " + c1.add(3, 5)); 
		//4.    람다식으로 동일한 기능 구현하기
    	//      System.out.println("람다식 결과: " + c2.add(10, 20));
    }
}



연습문제2) Collection Framework  
패키지명 : com.the703.basic015_ex
클래스명 : LambdaEx001 

문제 1: 매개변수 O, 리턴값 X
설명: 문자열을 받아서 출력하는 기능을 구현하세요.
인터페이스 이름: Printer
메서드: void print(String msg)

요구사항:
익명 객체로 "Message: <문자열>" 형식으로 출력하기
람다식으로 동일한 기능 구현하기
 
문제 2: 매개변수 O, 리턴값 O
설명: 두 정수를 받아 합을 반환하는 기능을 구현하세요.
인터페이스 이름: Calculator
메서드: int add(int a, int b)

요구사항:
익명 객체로 두 수의 합을 반환하기
람다식으로 동일한 기능 구현하기

출력내용 : 
Message: Hello World
Message: Lambda Rocks!

익명객체 결과: 8
람다식 결과: 30

*/