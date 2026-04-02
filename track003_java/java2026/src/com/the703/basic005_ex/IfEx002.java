package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx002 {
	public static void main(String[] args) {
		// 변수 - 숫자 한개를 입력받아 
		int num=0;
		Scanner scanner = new Scanner(System.in);
		// 입력 - 입력받기
		System.out.print("숫자한개입력 > ");
		num = scanner.nextInt();
		// 처리 - 
		//if(양수라면){ 양수}
		//else if( 음수라면){ 음수 }
		//else if( 0이라면 ){zero}
		     if(num  > 0 ) { System.out.println("양수");}
		else if(num  < 0 ) { System.out.println("음수");}
		else if(num == 0 ) { System.out.println("zero");}
		
	    // 출력                   조건 ?     참 : 거짓
		System.out.println(num  > 0  ? "양수" : (num<0 ? "음수" : "zero"));     
	}
}


/*

연습문제2)
패키지명 : com.the703.basic005_ex
클래스명 :  IfEx002
출력내용 : 숫자 한개를 입력받아 
	양수라면 양수  , 음수라면 음수  ,0이라면 zero를 출력하는 프로그램을 작성하시오.
   
*/