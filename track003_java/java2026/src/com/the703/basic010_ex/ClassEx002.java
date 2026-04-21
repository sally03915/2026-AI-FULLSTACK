package com.the703.basic010_ex;

import java.util.Scanner;

//1. 클래스는 부품객체
//2. 상태(멤버변수)와 행위(멤버함수)
class MyPrice001{
	//멤버변수 : 
	String name;  int price;
	
	//멤버함수 : void input()  입력받는 기능 / void show()  출력해주는 기능
	// 1) 모든클래스는 생성자 - 컴파일러가 기본생성자를 자동생성  MyPrice001()
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("상품이름 입력 >");  name = scanner.next(); 
		System.out.print("상품가격 입력 > "); price = scanner.nextInt();  
	}
	void show()  {
		System.out.printf("상품정보입니다\n"
				        + "상품이름 : %s  / 상품가격 : %d" , name, price);
	}
}
public class ClassEx002 {
	public static void main(String[] args) {
        MyPrice001   p1 = new MyPrice001();  
        //1) new 객체생성  2)  MyPrice001()  name=null,price=0 초기화  3) p1 1번주
        p1.input();   //1번지.input()
        p1.show();    //1번지.show() 
	}
}
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------
[METHOD:정보]   MyPrice001.class(설계도) , ClassEx002.class#1)
------------------------------------
[HEAP:동적]           			 |  [STACK:지역]

1번지 MyPrice001 (객체,Object, instance)
 {name="입력",price=1, input(),show()} ←  p1[1번지]	
								        main#2
------------------------------------	

*/
//////////////////////////////////////////////////////


/*
연습문제2)  class
패키지명 : com.the703.basic010_ex
클래스명 :  ClassEx002
class MyPrice001{
  멤버변수 : String name;  int price;
  멤버함수 : void input()  입력받는 기능 / void show()  출력해주는 기능
}
public class ClassEx002{
   public static void main(String[] args) {
        MyPrice001   p1 = new MyPrice001();
        p1.input();
        p1.show();
   }
}
출력내용 : 
  상품이름 입력 >  apple
  상품가격 입력 >  1500

  상품정보입니다
  상품이름 : apple  / 상품가격 : 1500

*/