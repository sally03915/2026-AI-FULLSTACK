package com.the703.basic008_ex;

public class ArrayEx005 { 
	public static void main(String[] args) {
		//	    1. 배열명 : ch
		//	    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
		//	    3. ch 배열에서 대문자의 갯수카운트, 소문자의 갯수 카운트

		char [] ch = {'B' , 'a' , 'n' , 'a', 'n' , 'a'};
		int upper=0, lower=0;
		//ver-1  'B'가 대문자라면 대문자 카운트, 소문자라면 소문자 카운트 
		//ver-2  if('B'가 대문자라면){ 대문자 카운트} else if( 소문자라면){ 소문자 카운트} 
		//ver-3  if(ch[0] 대문자범위){ 대문자 카운트} else if(ch[0] 소문자범위){ 소문자 카운트} 
		//		if(ch[0]>='A' && ch[0] <='Z'){ upper++;} else if(ch[0]>='a' && ch[0]<='z'){lower++;}
		//		if(ch[1]>='A' && ch[1] <='Z'){ upper++;} else if(ch[1]>='a' && ch[1]<='z'){lower++;}
		for(int i=0; i<ch.length; i++){
			if(ch[i]>='A' && ch[i] <='Z'){ upper++;} 
			else if(ch[i]>='a' && ch[i]<='z'){lower++;}
		}
		
		System.out.println("대문자 갯수 : " + upper);
		System.out.println("소문자 갯수 : " + lower);
	} 
}

/*
연습문제5)  array
패키지명 : com.the703.basic008_ex
클래스명 :  ArrayEx005
    1. 배열명 : ch
    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
    3. ch 배열에서 대문자의 갯수카운트, 소문자의 갯수 카운트


*/