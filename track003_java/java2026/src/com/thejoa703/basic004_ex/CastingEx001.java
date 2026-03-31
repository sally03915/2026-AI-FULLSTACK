package com.thejoa703.basic004_ex;

import java.util.Scanner;

public class CastingEx001 {
	public static void main(String[] args) {
		//GIGO
		//변수 
		int num1, num2;
		double result;
		Scanner scanner = new Scanner(System.in);
	    
		//입력
		//	      숫자입력1>  _입력받기  10   ( ☆자료형을 int )
		//	      숫자입력2>  _입력받기  3     ( ☆자료형을 int )   
		System.out.print("숫자입력1>"); num1= scanner.nextInt();
		System.out.print("숫자입력2>"); num2= scanner.nextInt();
	    
		//처리 - 10 (정수)/ 3.0(실수)      10.0 (실수)/ 3(정수) 
		result = (double)num1/num2;       //  10(정수-int)  / 3(정수-int)  
	    
		//출력   10/3=3.33
	    System.out.printf("%d/%d=%.2f",num1,num2,result);  
	}
}

/*
연습문제1)
패키지명 : com.company.java003_ex
클래스명 : CastingEx001
출력내용 :  Scanner이용해서 나누기 프로그램만들기 
   숫자입력1>  _입력받기  10   ( ☆자료형을 int )
   숫자입력2>  _입력받기  3     ( ☆자료형을 int )              
   
   10 / 3 = 3.33

주어진조건 : 
      //변수
      int num1, num2;
      double result;
      Scanner scanner = new Scanner(System.in);

   1단계)  변수 - 입력- 처리 - 출력
   2단계)  정수/정수 = 정수
              정수/실수 = 실수
              실수/정수 = 실수
              실수/실수 = 실수    
      ※  형변환법 :    by = (byte) in;   나 잠깐만 byte할게.... 데이터 누수있을수 있음!
          
*/