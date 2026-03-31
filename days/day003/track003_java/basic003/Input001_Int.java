package com.the703.basic003;

import java.util.Scanner;

public class Input001_Int {
	public static void main(String[] args) {
		// 자료형의 분류 : 기본형(값)  / 참조형(주소) 
		// 기본형의 종류 : 논리형(boolean-true/false) , 
		//             정수형(byte:1-short:2-int:4★-long:8L), 실수형 (float:4-double★:8)   
		
		// OOP? 클래스(부품객체) 조립해 완성해가는 프로그램
		int       one   =  0;     //one[0]
		Scanner   sc    =  new  Scanner(System.in) ;  // ctrl + shift + o (알파벳 o)
		//1. new 공간빌리기  1000번지
		//2. Scanner(System.in) Scanner를 사용할수 있게 초기화 - System.in 키보드입력
		//3. sc(1000번지) = 1000번지[Scanner ]
		//4. 사용법 : sc.next
		
		System.out.print("정수를 입력하세요>");
		one = sc.nextInt();
		System.out.println("입력한 정수는 "+ one + "입니다.");
		
		
	}
}
