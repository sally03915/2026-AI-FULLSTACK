package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx005 {
	public static void main(String[] args) {
		// GIGO
		// 변수 
		int kor=-1, eng=-1, math=-1, total=-1; double avg=0;
		Scanner scanner = new Scanner(System.in);
		// 입력
		System.out.print("국어점수를 입력하시오."); kor=scanner.nextInt();
		System.out.print("영어점수를 입력하시오."); eng=scanner.nextInt();
		System.out.print("수학점수를 입력하시오."); math=scanner.nextInt();
		
		// 처리  A=B
		total = kor + eng + math;
		//avg   = total/3f;       // 정수/정수  10/3
		avg   = total/3.0;      //정수/실수    
		// 출력
		System.out.println("총점 :"+total+" \n평균 :"+avg);
		System.out.print  ("총점 :"+total+" \n평균 :"+avg + "\n");
		System.out.printf ("총점 :%d \n평균 :%.2f",total,avg);  //##
	}
}
/*
연습문제5)

패키지명 : com.the703.basic003_ex
클래스명 : DataTypeEx005
출력내용 :  Scanner이용해서  성적처리를 입력받고 출력하시오.
   국어점수를 입력하시오.  _입력받기    100 
   영어점수를 입력하시오.  _입력받기    100 
   수학점수를 입력하시오.  _입력받기    99

   총점 :  299
   평균 :  99.67 

*/