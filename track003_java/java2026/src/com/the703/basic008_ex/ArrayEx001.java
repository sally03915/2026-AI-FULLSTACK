package com.the703.basic008_ex;

public class ArrayEx001 {
	public static void main(String[] args) {
		//	    1. 배열명 : arr
		//	    2. 값 넣기 : 1.1  , 1.2  , 1.3  , 1.4  , 1.5
		//	    3. for + length 로 출력
		double [] arr = {1.1  , 1.2  , 1.3  , 1.4  , 1.5};  // 5 : 0~4
		 
		System.out.print(arr[0] + "\t");
		System.out.print(arr[1] + "\t");
		System.out.print(arr[2] + "\t");
		System.out.print(arr[3] + "\t");
		System.out.print(arr[4] + "\t");
		
		System.out.println();
		for(int i=0; i<arr.length; i++) {System.out.print(arr[i] + "\t");}
	}
}

/*
연습문제1)  array
패키지명 : com.the703.basic008_ex
클래스명 :  ArrayEx001
    1. 배열명 : arr
    2. 값 넣기 : 1.1  , 1.2  , 1.3  , 1.4  , 1.5
    3. for + length 로 출력

*/