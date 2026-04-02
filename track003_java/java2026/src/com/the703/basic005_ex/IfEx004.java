package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx004 {

	public static void main(String[] args) {
		// 변수  - 문자한개를 입력받아 
		char ch = '\u0000';
		Scanner scanner = new Scanner(System.in);
		// 입력  
		System.out.print("문자한개를 입력 >");
		ch = scanner.next().charAt(0);
		// 처리  - 대문자인지,  소문자인지 
		//if(대문자){ 대문자} 
		//else if(소문자){소문자} 
		     if(ch>='A' && ch<='Z'){ System.out.println("대문자");} 
		else if(ch>='a' && ch<='z'){ System.out.println("소문자");} 
		// 출력

		System.out.println(  ch>='A' && ch<='Z' ? "대문자"
				:            ch>='a' && ch<='z' ? "소문자" : "");
	}

}


/*

연습문제4)
패키지명 : com.the703.basic005_ex
클래스명 :  IfEx004
출력내용 : 문자한개를 입력받아 
	대문자인지,  소문자인지 판별하는 프로그램을 작성하시오.
	※  대문자  ch>='A' && ch<='Z' / 소문자  ch>='a'  &&  ch<='z'  
   
*/