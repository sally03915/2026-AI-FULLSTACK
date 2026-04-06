package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx002_1 {

	public static void main(String[] args) {
		//변수
		int a=-1;
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("숫자입력 > ");
		a = scanner.nextInt();
		//처리 + 출력
		switch(a) {
			case 3: System.out.println("봄"); break;
			case 4: System.out.println("봄"); break;
			case 5: System.out.println("봄"); break;
			
			case 6: System.out.println("여름"); break;
			case 7: System.out.println("여름"); break;
			case 8: System.out.println("여름"); break;
			
			case 9: System.out.println("가을"); break;
			case 10: System.out.println("가을"); break;
			case 11: System.out.println("가을"); break;
			
			case 12: System.out.println("겨울"); break;
			case 1: System.out.println("겨울"); break;
			case 2: System.out.println("겨울"); break;
		}
		
	}

}

/*
연습문제2)  
패키지명 : com.company.basic005_ex
클래스명 :  SwitchEx002
출력내용 :   switch 이용
     숫자한개 입력받아
     3,4,5이면 봄
     6,7,8이면 여름
     9,10,11이면 가을
     12,1,2이면 겨울
*/