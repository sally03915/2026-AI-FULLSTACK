package com.the703.basic006_ex;

public class RepeatEx002 { 
	public static void main(String[] args) { 
		//Q for     :  1~10사이에서 3의 배수의 누적합 : 18 , 갯수세기 : 3
		//ver-1  말로 풀어서 쓰기
		//1이 3의 배수라면  누적합 , 카운트
		//2이 3의 배수라면  누적합 , 카운트
		//3이 3의 배수라면  누적합 , 카운트

		//ver-2  구조
		//if( 1이 3의 배수라면 ){ 누적합, 카운트 }
		//if( 2이 3의 배수라면 ){ 누적합, 카운트 }
		//if( 3이 3의 배수라면 ){ 누적합, 카운트 }

		//ver-3  코드
		//if( 1%3==0 ){ hap += 1; cnt++;}
		//if( 2%3==0 ){ hap += 2; cnt++;}
		//if( 3%3==0 ){ hap += 3; cnt++;}
		int hap=0 , cnt=0;
		for(int i=1; i<=10; i++){  if( i%3==0 ){ hap += i;  cnt++; } }
		System.out.println("1~10사이에서 3의 배수의 누적합 : " + hap + " , 갯수 : " + cnt); 
		 
		//Q while   :  1~10사이에서 3의 배수의 누적합 : 18
		int i=1;   hap=0; cnt=0;
		while(i<=10){  if( i%3==0 ){ hap += i; cnt++; }  i++;}
		System.out.println("1~10사이에서 3의 배수의 누적합 : " + hap + " , 갯수 : " + cnt); 
		
		//Q do while:  1~10사이에서 3의 배수의 누적합 : 18
		i=1;   hap=0; cnt=0;
		do{  if( i%3==0 ){ hap += i;   cnt++; }  i++;}while(i<=10);
		System.out.println("1~10사이에서 3의 배수의 누적합 : " + hap + " , 갯수 : " + cnt); 
	 
	} 
}

		
		
// Q 1~10사이에서 3의 배수의 누적합 : 18
/*
ver-1  말로 풀어쓰기
  만약 1이 3의 배수의 누적합 
  만약 2이 3의 배수의 누적합 
  만약 3이 3의 배수의 누적합 
ver-2  구조로 바꾸기 - 제어,반복
  if(만약 1이 3의 배수의){ 누적합 }
  if(만약 2이 3의 배수의){ 누적합 }
  if(만약 3이 3의 배수의){ 누적합 }
ver-3  코드로 풀기
  int hap=0;
  if(1%3==0){ hap+=1; }
  if(2%3==0){ hap+=2; }
  if(3%3==0){ hap+=3; }
*/  
