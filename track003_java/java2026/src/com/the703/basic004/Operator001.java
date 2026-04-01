package com.the703.basic004;

public class Operator001 {
	public static void main(String[] args) {
		//0.  먼저()  값(+ , - , * , / , %)  비교 조건 대입
		//■1.  값 ( + , - , * , / , % )
		int a=10,b=3;
		System.out.println(a+b);  //13
		System.out.println(a-b);  //7
		System.out.println(a*b);  //30
		System.out.println(a/b);  //3  (정수/정수→정수)
		System.out.println(a%b);  //1
		
		//Q1. 나머지연산자 - 짝수니? 홀수니? (2)   n%2  나머지 : 0 , 1
		// 							  0	           1	         0	           1
		System.out.println("Q1:  " + 0%2 + "\t" + 1%2 +  "\t" + 2%2 +  "\t" + 3%2);
		
		//Q2. 3의 배수?	 a가 3의 배수니? / b가 3의 배수니?   3의 나머지 0
		System.out.println(  "Q2:  " + a%3 + "\t" + b%3);  // 나머지 : 0 1 2 
		
		//Q3
		//a+b;
		int result = a+b;
		
		//■2.   비교( > , < , >= , <=, == 같다 ,!= 다르다)
		System.out.println( 10 >  3 );
		System.out.println( 10 == 3 );
		
		//Q1. a가 짝수라면 true
		System.out.println( a%2 ==  0);
		//Q2. b가 3의 배수가 아니라면 
		System.out.println( b%3 !=  0);  // 3의배수가 아니라면
		
		
		//■3.  조건  &&(모든조건을 만족시)   ||(여러조건중에서 하나라도 만족하면 true) 
		System.out.println( true   &    true);
		System.out.println( true   &&   true);
		System.out.println( false  &    true); // false
		System.out.println( false  &&   true); // false      Dead code
		
		System.out.println( true   |    true);
		System.out.println( true   ||   true);  // Dead code
		System.out.println( false  |    true); 
		System.out.println( false  ||   true); 
		
		//Q1. a가 2의 배수이면서 5의 배수라면 true / false
		//Q2. a가 2의 배수이거나 3의 배수라면 true / false
		System.out.println( a%2 == 0  &&   a%5==0   );
		System.out.println( a%2 == 0  ||   a%3==0   );   //() 값(+-*/%) 비교(<) 조건(&& ||)대입
		
		//■4. 삼항연산자  조건 ? 참 : 거짓 
		String answer =    a==10 ?  "10이다" : "10이 아니다" ;
		System.out.println(  answer  );

		//Q1. a가 양수라면 1 아니면 -1 삼항연산자
		//    (a가 양수라면)?  1 : -1
		int q1 = a>0 ? 1: -1;
		System.out.println(q1);   

		//■5. 대입연산
		a=10;  b=3; 
		a=a+b;        System.out.println(a);
		
		a=10;  b=3; 
		a+=b;        System.out.println(a);
		
		a=10;  b=3; 
		a-=b;        System.out.println(a);  //7
		
		
		//■6. 단항  ( ++ 1개 증가, --  1개 감소 )
		int a1=1, b1=1, c1=1,d1=1;
		
		System.out.println( ++a1); //2
		System.out.println(   a1); //2
		
		System.out.println( b1++); //1
		System.out.println( b1  ); //2

		System.out.println( --c1); //0
		System.out.println(   c1); //0
		
		System.out.println( d1--); //1
		System.out.println( d1  ); //0
		
	}
}


















