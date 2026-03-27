package com.the703.basic001;

public class Basic003 {
	public static void main(String[] args) {
		//1. System.out.println();   줄바꿈o
		 System.out.println("Hello");
		 
		//2. System.out.print();     줄바꿈x 
		 System.out.print("A\t");  // \t탭누른효과
		 System.out.print("B\n");
		 System.out.print("a\t");
		 System.out.print("b\n");  // \n줄바꿈
		 
		//3. System.out.printf( "%s%d"  , "문자열" , 10 );
		 // %d 숫자, 정수, 1,2,3,
		 // %s 문자열, "abc"
		 System.out.printf("%d 더하기 %d 은 %s" , 1, 1 , "귀요" );
		 System.out.printf("%s하면 %d원\n" , "궁금", 500 );
		 
		//4. +의  의미
		 System.out.println(10+3);  //13
		 System.out.println(10+"3");//103
		 System.out.println("10"+3);//103
		 
		//Q. System.out.println(10 + 3 = 10+3);  //1. 오류없애기 2. 결과물: 10+3=13
		 System.out.println("10 + 3 = "+(10+3)); 
		 
		 
	}
}
