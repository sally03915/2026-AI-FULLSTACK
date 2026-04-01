package com.the703.basic004_ex;

import java.util.Scanner;

public class CastingEx003 {
	public static void main(String[] args) {
		//1. 문자는 저장시 숫자저장/ 출력시 문자
		System.out.println("1. " + 'A' + "\t" + (int)'A');  // 'A' 문자 , 65
		System.out.println("2. " + 'a' + "\t" + (int)'a');  // 'a' 문자 , 97
		System.out.println("3. " + "ABC".charAt(0)); // "ABC" 문자열
		System.out.println("3. " + "ABC".charAt(1)); //A (0) B(1)
		
		//변수
		char ch='\u0000' , lower='\u0000';
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("대문자입력 > ");  ch = scanner.next().charAt(0);
		//처리
		//a(97)= A(65) + 32
		//char  = char + int
		//2byte = 2byte  4byte [|]   [|||]
		lower   = (char) (ch   + 32);
		//출력
		System.out.println(ch + "를 소문자로 " + lower );
	}
}

/*
연습문제3)
패키지명 : com.the703.basic004_ex
클래스명 : CastingEx003
- 대문자입력받아서 소문자로 변경프로그램을 작성하시오.
*/