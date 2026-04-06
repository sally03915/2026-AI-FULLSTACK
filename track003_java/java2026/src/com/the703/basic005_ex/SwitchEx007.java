package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx007 {

	public static void main(String[] args) {
		//변수
		double avg=0;
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("평균입력 > ");
		avg = scanner.nextDouble();
		//처리
		//출력
		//Cannot switch on a value of type double. Only convertible int values, 
		// strings or enum variables are permitted
		switch((int)avg/10) {  //89.9 → 우 : 89.9/10 →8.99→(int)8
			case 10: case 9: System.out.println("수"); break;
			case 8: System.out.println("우"); break;
			case 7: System.out.println("미"); break;
			case 6: System.out.println("양"); break;
			default : System.out.println("가");
		}

	}

}

/*
연습문제7)  
패키지명 : com.company.basic005_ex  
클래스명 : SwitchEx007 
출력내용 : switch 이용
평균 한 개 입력받아
    90~100점대면 수
    80~90점(90점미만)대면  우
    70~80점(80점미만)대면  미
    60~70점(70점미만)대면  양
    나머지 가

*/