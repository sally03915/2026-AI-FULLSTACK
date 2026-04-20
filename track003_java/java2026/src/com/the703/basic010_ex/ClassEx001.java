package com.the703.basic010_ex;

//1. 클래스는 부품객체
//2. 상태(멤버변수)와 행위(멤버함수)
//3. 설계도 → 부품객체 → 사용
class Student001{
//	  멤버변수 
	String name;  int no, kor, eng, math;
//	  멤버함수 
	void info() {
		System.out.println("이름 : " + name);
		System.out.println("총점 : " + (kor + eng + math));
		System.out.printf( "평균 : %.2f" , (kor + eng + math)/3.0);
	}
}
public class ClassEx001 {
	public static void main(String[] args) {
	      Student001   s1 = new Student001(); //1) new 번지, 객체생성 2) 생성자-초기화 3) s1주소
	      s1.name="first";  s1.no=11; s1.kor=100; s1.eng=100; s1.math=99;
	      s1.info();
	}
}
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------
[METHOD:정보]  Student001 ,   ClassEx001  #1
------------------------------------
[HEAP:동적]            						|  [STACK:지역]

1번지:Student001{							← s1 [1번지]
  name=null, no=0, kor=0, eng=0, math=0 
  info() 
}
						 					main  #2
------------------------------------
*/
//////////////////////////////////////////////////////


/****
연습문제1)  class
패키지명 : com.company.com.the703.basic010_ex
클래스명 :  ClassEx001
class Student001{
  멤버변수 : String name;  int no, kor, eng, math;
  멤버함수 : void info()
}

public class ClassEx001{
   public static void main(String[] args) {
      Student001   s1 = new Student001();
     s1.name="first";  s1.no=11; s1.kor=100; s1.eng=100; s1.math=99;
     s1.info();
   }
}
출력내용 : 
  이름: first
  총점 : 299
  평균 : 99.67
*/