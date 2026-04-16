package com.the703.basic009_ex;

public class MethodEx002 {

	public static  void test1( int a) { System.out.println(a); }   
	
	public static  void test2( double a) {  System.out.println(a); } 
	
	////////////////////////////////////////////////////////////
	public static void main(String[] args) {
	    // public static  리턴값 메서드명(파라미터)
	    test1(10);    // public static void test1( 10에  해당하는 자료형) { 10 출력 - 해당정수값 출력 }        
	    test2(1.2);   // public static void test2( 1.2에 해당하는 자료형) {  1.2 출력- 해당실수값 출력 }  
	    hap(3,5);     // public static void hap( 숫자, 숫자){ 3+4+5한값  12 출력 - 두수 사이의 합 }
	    disp(7, '*'); // public static void disp(숫자, 문자){   *******출력 - 갯수만큼 해당 문자 출력  }
	}
	///////////////////////////////////////////////////////////
	public static void hap( int start, int end){ 
		int box=0;
		//		box+=3;  	box+=4;  	box+=5;
		for(int i=start; i<=end; i++){ 	box+=i; } 
		System.out.println(box);
	}
	
	public static void disp(int num, char c){   
		for(int i=0; i<num; i++){  System.out.print(c); }
	}
	
} 

/*
연습문제2)  methodㅏㅁ
패키지명 : com.the703.basic009_ex
클래스명 :  MethodEx002
다음과 같이 test1(), test2(), hap(), disp()메서드를 정의하시오.

public static void main(String[] args) {
    // public static  리턴값 메서드명(파라미터)
    test1(10);    //10 출력
     test2(1.2);   // 1.2 출력
     hap(3,5);     // 3+4+5한값  12 출력
     disp(7, '*');  // *******출력
}

*/