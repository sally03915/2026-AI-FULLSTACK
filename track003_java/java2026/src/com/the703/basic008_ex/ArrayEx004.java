package com.the703.basic008_ex;

public class ArrayEx004 {
	public static void main(String[] args) {
		//	    1. 배열명 : ch
		//	    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
		//	    3. ch 배열에서 a의 갯수 세기
		//	    4. 출력된화면 :  a의 갯수 3  
		char [] ch = {'B' , 'a' , 'n' , 'a', 'n' , 'a'};
		int count=0;
		//	    3. ch 배열에서 a의 갯수 세기
		//ver-0   'B'가  소문자 a라면 카운트
		//ver-1   ch[0]  소문자 a라면 카운트
		//ver-2   if(ch[0]  소문자 a라면){ 카운트}
		//ver-3   if(ch[0]== 'a'){ count++; }
		//        if(ch[1]== 'a'){ count++; }
		
		for(int i=0; i< ch.length; i++) {
			if(ch[i]== 'a'){ count++; }
		}
		
		System.out.println("a의 갯수 :" + count);
	}
}


/*
연습문제4)  array
패키지명 : com.the703.basic008_ex
클래스명 :  ArrayEx004
    1. 배열명 : ch
    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
    3. ch 배열에서 a의 갯수 세기
    4. 출력된화면 :  a의 갯수 3    

*/