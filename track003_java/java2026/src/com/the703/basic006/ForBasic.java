package com.the703.basic006;

public class ForBasic { 
	public static void main(String[] args) { 
		//step1)  줄바꿈안된 print 이용해서 1   2   3
		System.out.println("\n■ STEP1)  출력");
		System.out.print(1);
		System.out.print(2);
		System.out.print(3);

		System.out.println("\n■ STEP2)  for");
		// for(;;){빠져나올조건}
		//step2-1) 반복되는 영역              System.out.print(1);
		//step2-2) 반복되는 영역 → 변수찾기     System.out.print(1,2,3으로 바뀜);
		//step2-3) 패턴찾기 (초기값;조건문;증감문)    시작:1 , 종료:3, 변화:1
		for(int i=1; i<=3; i++) {  System.out.print(i);  }

		//step3)  
		System.out.println("\n■STEP3)  for 연습"); 
		// 패턴 : 시작 1; 종료 10;변화 1    
		for(int i=1; i<=10; i++) {  System.out.print(i);  }  System.out.println();

		// 패턴 : 시작 2; 종료 8;변화 1    
		for(int i=2; i<=8; i++) {  System.out.print(i);  }  System.out.println();
		
		// 패턴 : 시작 3; 종료 9;변화 3    
		for(int i=3; i<=9; i=i+3) {  System.out.print(i);  }  System.out.println();

		// 패턴 : 시작 5; 종료 1;변화 2개씩 빼기    
		for(int i=5; i>=1; i=i-2) {  System.out.print(i);  }  System.out.println();
		
		// Hi1   Hi2  Hi3    {}   {변수}  for(시작; 종료; 변화)
		System.out.print("Hi" + 1);  //시작
		System.out.print("Hi" + 2);  //변화 1
		System.out.print("Hi" + 3);  //종료
		
		for(int i=1; i<=3; i++){   System.out.print("Hi" + i);  }
	} 
}
