package com.the703.basic009_ex;

public class MethodEx001 {
	//1.  구조 :   리턴값 메서드명(파라미터)
	public static void dog()  {  System.out.println("멍멍");    }
	public static void line() {  System.out.println("=======");}
	public static void cat()  {  System.out.println("야옹");    }
	
	/////////////////////////////////////////////////
	public static void main(String[] args) {
		  //2. 호출 :  메서드(파라미터)
		  dog();  // 멍멍 출력
		  line();   //========= 출력 
		  cat();    // 야옹 출력
		  line();   //========= 출력
	}
	/////////////////////////////////////////////////

}


/*
연습문제1)  method
패키지명 : com.the703.basic009_ex
클래스명 :  MethodEx001
다음과 같이 dog(), line(), cat() 메서드를 정의하시오.

public static void main(String[] args) {
  dog();  // 멍멍 출력
  line();   //========= 출력 
  cat();    // 야옹 출력
  line();   //========= 출력
}


*/