package com.the703.basic008_ex;

public class ArrayEx002 {
	public static void main(String[] args) {
//	    1. 배열명 : arr
//	    2. 값 넣기 : 'A' , 'B' , 'C' , 'D'
//	    3. for + length 로 출력
		char [] arr ={'A' , 'B' , 'C' , 'D'};  //4 : 0~3
		
		System.out.printf("%c\t", arr[0]);
		System.out.printf("%c\t", arr[1]);
		System.out.printf("%c\t", arr[2]);
		System.out.printf("%c\t", arr[3]);
		
		System.out.println();
		for(int i=0; i<arr.length; i++){System.out.printf("%c\t", arr[i]);}
	}
}

/*

연습문제2)  array
패키지명 : com.the703.basic008_ex
클래스명 :  ArrayEx002
    1. 배열명 : arr
    2. 값 넣기 : 'A' , 'B' , 'C' , 'D'
    3. for + length 로 출력

*/