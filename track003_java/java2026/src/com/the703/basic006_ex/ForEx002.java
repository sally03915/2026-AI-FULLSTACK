package com.the703.basic006_ex;

import java.util.Scanner;

public class ForEx002 {
	public static void main(String[] args) {
		//변수
		int dan=0;
		Scanner scanner = new Scanner(System.in);
		//입력  예) 2단입력받기
		System.out.print("원하는 단을 입력 > ");
		dan = scanner.nextInt();  //2
		//처리 + 출력
		//ver-1 눈에 보이는 그대로 출력
		//  2*1=2  System.out.printf("%d*%d=%d" , 2,1,2*1  );
		//  2*2=4  System.out.printf("%d*%d=%d" , 2,2,2*2  );
		//  2*3=6  System.out.printf("%d*%d=%d" , 2,3,2*3  );
		 
		//ver-2 눈에 보이는 그대로 출력
		//  2*1=2  System.out.printf("%d*%d=%d" , dan,1,dan*1  );
		//  2*2=4  System.out.printf("%d*%d=%d" , dan,2,dan*2  );
		//  2*3=6  System.out.printf("%d*%d=%d" , dan,3,dan*3  );
		for(int i=1; i<=9; i++)
		{ System.out.printf("%d*%d=%d\n" , dan,i,dan*i  );   }  //{반복} , {변수}
	}
}
/*
연습문제2)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx002
출력내용 :   for 이용

   사용자에게 단을 입력받아 해당하는 
   구구단을 출력해주는 프로그램을 작성하시오. FOR문을 이용하시오.
*/