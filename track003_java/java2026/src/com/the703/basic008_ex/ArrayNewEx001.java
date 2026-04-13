package com.the703.basic008_ex;

public class ArrayNewEx001 { 
	public static void main(String[] args) {
		//	    1. 배열명 : arr      new 연산자 이용해서 배열만들기
		//	    2. 값 넣기 : 1.1  , 1.2  , 1.3  , 1.4  , 1.5      for+length 이용해보기
		//	    3. for + length 로 출력
		double [] arr = new double[5];
		double data=1.1;
		//arr[0] = 1.1;  
		//		arr[0] = data;   /* 1.1넣고*/ data+=0.1;  /* 0.1증가*/
		//		arr[1] = data;   /* 1.2넣고*/ data+=0.1;  /* 0.1증가*/
		//		arr[2] = data;   /* 1.3넣고*/ data+=0.1;  /* 0.1증가*/
		//		arr[3] = data;   /* 1.4넣고*/ data+=0.1;  /* 0.1증가*/
		//		arr[4] = data;   /* 1.5넣고*/ data+=0.1;  /* 0.1증가*/
		
		for(int i=0; i<arr.length; i++) {  arr[i] = data;    data+=0.1;         }
		for(int i=0; i<arr.length; i++) { System.out.printf("%.1f\t" , arr[i] );}
	} 
}

/*
연습문제6)  array
패키지명 : com.company.java007_ex
클래스명 :  ArrayNewEx001
    new 연산자 이용해서 배열만들기
    1. 배열명 : arr     
    2. 값 넣기 : 1.1  , 1.2  , 1.3  , 1.4  , 1.5    
       for+length 이용해보기
    3. for + length 로 출력
*/