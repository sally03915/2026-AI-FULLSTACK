package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx003 {

	public static void main(String[] args) {
		//변수
		char ch = '\u0000';
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("문자한개 입력>");
		ch = scanner.next().charAt(0);
		//처리
		//출력
		switch(ch) { 
			case 'a' : System.out.println("APPLE"); break;
			case 'b' : System.out.println("BANANA"); break;
			case 'c' : System.out.println("COCONUT"); break;
		}

	}

}

/*
연습문제3)  
패키지명 : com.company.basic005_ex
클래스명 :  SwitchEx003
출력내용 :   switch 이용
     문자한개 입력받아
     a이면 APPLE
     b이면 BANANA
     c이면 COCONUT
*/