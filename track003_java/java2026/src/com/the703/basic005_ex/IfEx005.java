package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx005 {
	public static void main(String[] args) {
		// 변수
		char ch= '\u0000' , answer = '\u0000';
		Scanner scanner = new Scanner(System.in);
		// 입력
		System.out.print("문자한개를 입력 > ");
		ch = scanner.next().charAt(0);
		// 처리 - if(대문자인지){ 소문자로} else if(  소문자이면 ){대문자} 
		if(  ch >= 'A'  && ch <='Z' )
		{ 
			// a (97) = A(65) + 32 
			// 2byte  = 2byte + 4byte
			   answer =    (char) (ch + 32);
		} 
		else if(  ch >= 'a'  && ch <='z'  )
		{
			// A(65) = a (97) - 32
			   answer =    (char) (ch - 32); 
		}  
		// 출력
		System.out.println( ch + "를 변환 " + answer);
		
	}
}
/*


연습문제5)
패키지명 : com.company.java004_ex
클래스명 :  IfEx005
출력내용 : 문자한개를 입력받아 
	대문자인지 이면 소문자로,  소문자이면 대문자로 변경하는 프로그램을 작성하시오.
	※  a = 'A' + 32    
   
*/