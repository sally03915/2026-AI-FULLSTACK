package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx004 {
	public static void main(String[] args) {
		//GIGO
		//1. 자바의 자료형 분류( 기본형 / 참조형 )
		//2. 기본형 : 값
		//2-1 논리형 : boolean  - true/false (1byte)	
		//2-2 정수형 : (byte-short- int★ -long(L) / 1,2,3 / 1-2-4-8)	
		//2-3 실수형 : (float(f)-double★ /3.14 / 4-8)   %.2f
		//변수
		float   fl = 3.14f;
		double dou = 3.14;
		Scanner scanner = new Scanner(System.in);
		
		//입력
		System.out.print("파이값을 입력하시오 >");
		dou = scanner.nextDouble();  // 3.1234567
		//처리 - x
		//출력
		System.out.println("파이값은 "+dou+"입니다.");  //3.1234567
		System.out.print  ("파이값은 "+dou+"입니다.\n");//3.1234567
		//System.out.printf ("파이값은 %f입니다.\n"     , dou);
		System.out.printf ("파이값은 %.0f입니다.\n"    , dou);//3
		System.out.printf ("파이값은 %.1f입니다.\n"   , dou); //3.1
		System.out.printf ("파이값은 %.2f입니다.\n"   , dou); //3.12
		System.out.printf ("파이값은 %.6f입니다.\n"   , dou); //3.123457
		
		System.out.println(10/3);  //정수/정수   3
		System.out.println(10/3f); //정수/실수   3.3333333
		System.out.println(10f/3); //실수/정수   3.3333333 
	}
}

/*

연습문제4)
패키지명 : com.the703.basic003_ex
클래스명 : DataTypeEx004
출력내용 :  Scanner이용해서 파이값을 입력받고 출력하시오. 
     파이값을 입력하시오 > _입력받기    3.141592    ( 자료형선택 )
     파이값은 **입니다.
*/