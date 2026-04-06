package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx001 {
	public static void main(String[] args) {
		//변수
		int a=-1;
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("숫자입력 > ");
		a = scanner.nextInt();
		//처리 + 출력
		switch(a) { //1. 대상
			case 3 : System.out.println("봄");break;
			case 6 : System.out.println("여름");break;
			case 9 : System.out.println("가을");break;
			case 12 : System.out.println("겨울");break; 
			default : System.out.println("3,6,9,12 중에 숫자를 입력하세요.");
		}
	}
}

/*
연습문제1)  
패키지명 : com.company.basic005_ex
클래스명 :  SwitchEx001
출력내용 :  switch 이용
     숫자한개 입력받아
     3이면 봄
     6이면 여름
     9이면 가을
     12이면 겨울
*/