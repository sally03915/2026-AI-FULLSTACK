package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx001_2 {
	public static void main(String[] args) {
		// 평균을 입력받아 60점이상이면 합격,  불합격여부를 출력하는 프로그램을 IF로 작성하시오.
		// GIGO : 변수
		double avg = 0; String result = "불합격";
		Scanner scanner = new Scanner(System.in);
		
		// 입력
		System.out.print("평균을 입력> ");
		avg = scanner.nextDouble();
		
		// 처리 
		if(avg >= 60) { result = "합격";}
		
		// 출력  
		System.out.println(result);
	}
}

/*

연습문제1)
패키지명 : com.the703.basic005_ex
클래스명 :  IfEx001
출력내용 : 평균을 입력받아 60점이상이면 합격,  불합격여부를 출력하는 프로그램을 IF로 작성하시오.
   
*/