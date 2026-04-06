package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx002_3 {

	public static void main(String[] args) {
		//변수
		int a=-1;
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("숫자입력 > ");
		a = scanner.nextInt();
		//처리 + 출력
		switch(a/3) {
			//   3/3=1(몫)   4/3=1(몫)   5/3=1(몫)
			//case 3: case 4: case 5: System.out.println("봄"); break; 
			case 1: System.out.println("봄"); break; 
			//   6/3=2(몫)   7/3=2(몫)   8/3=2(몫)
			//case 6: case 7: case 8: System.out.println("여름"); break; 
			case 2 : System.out.println("여름"); break; 
			//   9/3=3(몫)   10/3=3(몫)   11/3=3(몫)
			//case 9: case 10: case 11: System.out.println("가을"); break; 
			case 3 : System.out.println("가을"); break; 
			//   12/3=4(몫)   1/3=0(몫)   2/3=0(몫)
			//case 12: case 1: case 2: System.out.println("겨울"); break;
			case 4: case 0: System.out.println("겨울"); break;
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