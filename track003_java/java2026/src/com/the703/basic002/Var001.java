package com.the703.basic002;

public class Var001 {
	public static void main(String[] args) { 
		// 1. "abc" 문자열 String
		// 2. 10    정수     int
		// 3. 변수? 변하는 수  / 형식 - 자료형 변수명( $ _ 소문자 )
		int a;   // 1) 공간  a [   ]
		a = 10;  // 2) A=B  B를 작업해서 A에 대입, 넣으세요. 
		System.out.println("1)  변하는 값 : " + a);
		a = 20;
		System.out.println("1)  상태확인 : " + a);
		
		a=1000;
		System.out.println("오늘의 특별 할인, 단돈"  +  a   + "원에 즐겨보세요.");
		System.out.println(a + "번을 시도해도 포기하지 않는 게 진짜 실력이다.");
		System.out.println(a + "개의 별빛이 밤하늘을 수놓는다.");
		
		// 4. 변수의 범위
		{  // 여기서부터
			int b=999; System.out.println("특별할인! " + b + "모셔요~!");  
		}  //여기까지

		//System.out.println("특별할인! " + b + "모셔요~!");

		// 5. 변수명   $ _ 소문자
		int $1=1;  int _2=2; int a3bc=3;  	int HOME=4;
		//int int;
		//int void;
		int main;
		
	} //  end 전원버튼
} //end 부품객체

//		System.out.println("오늘의 특별 할인, 단돈"  +  500   + "원에 즐겨보세요.");
//		System.out.println(500 + "번을 시도해도 포기하지 않는 게 진짜 실력이다.");
//		System.out.println(500 + "개의 별빛이 밤하늘을 수놓는다.");
//		오늘의 특별 할인, 단돈 500원에 즐겨보세요.
//		500번을 시도해도 포기하지 않는 게 진짜 실력이다.
//		500개의 별빛이 밤하늘을 수놓는다.ㄴ