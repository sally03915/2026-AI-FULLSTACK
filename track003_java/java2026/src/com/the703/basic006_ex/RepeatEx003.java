package com.the703.basic006_ex;

public class RepeatEx003 { 
	public static void main(String[] args) {
		//Q for     : 1~30사이에서 2의 배수이면서 3의 배수의 숫자와 갯수
		//		ver-1  말로 풀어쓰기 
		// 1이  2의 배수이면서 3의 배수라면 숫자출력, 갯수카운트
		// 2이  2의 배수이면서 3의 배수라면 숫자출력, 갯수카운트
		// 3이  2의 배수이면서 3의 배수라면 숫자출력, 갯수카운트
		
		//		ver-2  구조로 바꾸기 - 제어,반복 
		// if(1이  2의 배수이면서 3의 배수라면){ 숫자출력, 갯수카운트 }
		// if(2이  2의 배수이면서 3의 배수라면){ 숫자출력, 갯수카운트 }
		// if(3이  2의 배수이면서 3의 배수라면){ 숫자출력, 갯수카운트 }
		
		//		ver-3  코드로 풀기  
		//		int cnt=0;
		//		if(1%2==0  && 1%3==0){ System.out.println("2의 배수이면서 3의 배수의 숫자 : " + 1); cnt++; }
		//		if(2%2==0  && 2%3==0){ System.out.println("2의 배수이면서 3의 배수의 숫자 : " + 2); cnt++; }
		//		if(3%2==0  && 3%3==0){ System.out.println("2의 배수이면서 3의 배수의 숫자 : " + 3); cnt++; }
		
		int cnt=0; 
		for(int i=1; i<=30; i++){
			if(i%2==0  && i%3==0){ System.out.println("2의 배수이면서 3의 배수의 숫자 : " + i); cnt++; }
		}
		System.out.println("1~30사이에서 2의 배수이면서 3의 갯수: " + cnt );
		
		//Q while   : 1~30사이에서 2의 배수이면서 3의 배수의 숫자와 갯수
		cnt=0; int i=1; 
		while(i<=30){
			if(i%2==0  && i%3==0){ System.out.println("2의 배수이면서 3의 배수의 숫자 : " + i); cnt++; }
		    i++;
		}
		System.out.println("1~30사이에서 2의 배수이면서 3의 갯수: " + cnt );
		
		//Q do while: 1~30사이에서 2의 배수이면서 3의 배수의 숫자와 갯수
		cnt=0;  i=1; 
		do{
			if(i%2==0  && i%3==0){ System.out.println("2의 배수이면서 3의 배수의 숫자 : " + i); cnt++; }
		    i++;
		}while(i<=30);
		System.out.println("1~30사이에서 2의 배수이면서 3의 갯수: " + cnt );
		
	} 
}
// Q 1~30사이에서 2의 배수이면서 3의 배수의 숫자와 갯수
/*
ver-1  말로 풀어쓰기 
ver-2  구조로 바꾸기 - 제어,반복 
ver-3  코드로 풀기 
*/  
