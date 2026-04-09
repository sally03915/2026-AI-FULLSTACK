package com.the703.basic007_ex;

public class For2Ex001 {
	public static void main(String[] args) {
		//ver-1 눈에 보이는 그대로
		System.out.print('#');  System.out.print('#'); System.out.print('#');System.out.print('#'); System.out.println();
		System.out.print('#');  System.out.print('#'); System.out.print('#');System.out.print('#'); System.out.println();
		System.out.print('#');  System.out.print('#'); System.out.print('#');System.out.print('#'); System.out.println();
		System.out.print('#');  System.out.print('#'); System.out.print('#');System.out.print('#'); System.out.println();
		
		//ver-2 칸정리
		System.out.println();
		
		for(int i=1; i<=4; i++){  System.out.print('#');  }    System.out.println();
		for(int i=1; i<=4; i++){  System.out.print('#');  }    System.out.println();
		for(int i=1; i<=4; i++){  System.out.print('#');  }    System.out.println();
		for(int i=1; i<=4; i++){  System.out.print('#');  }    System.out.println();
		
		//ver-3 층정리	
		System.out.println();	
		for(int ch=1; ch<=4; ch++)
		{  	for(int i=1; i<=4; i++){  System.out.print('#');  }    System.out.println(); }

	}
}

/*

패키지명 : ccom.the703.basic007
클래스명 :  For2Ex001  (이중for 이용)

####
####
####
####

*/
