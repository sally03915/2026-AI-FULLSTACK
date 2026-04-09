package com.the703.basic007_ex;

public class For2Ex002 {

	public static void main(String[] args) {
		 //ver-1 눈에 보이는 그대로
		System.out.print('@');  System.out.print('#'); System.out.print('#'); System.out.print('#');  System.out.println();
		System.out.print('#');  System.out.print('@'); System.out.print('#'); System.out.print('#');  System.out.println();
		System.out.print('#');  System.out.print('#'); System.out.print('@'); System.out.print('#');  System.out.println();
		System.out.print('#');  System.out.print('#'); System.out.print('#'); System.out.print('@');  System.out.println();
		
		//ver-2 칸정리
		System.out.println();   //     4번출력  - 첫번째 자리에 오면 @
		for(int i=1; i<=4; i++){       System.out.print( i==1 ?  '@' : '#');  }   System.out.println(); 
								//    4번출력  - 2번째 자리에 오면 @
		for(int i=1; i<=4; i++){       System.out.print( i==2 ?  '@' : '#');  }   System.out.println();
								//    4번출력  - 3번째 자리에 오면 @
		for(int i=1; i<=4; i++){       System.out.print( i==3 ?  '@' : '#');  }   System.out.println();
								//    4번출력  - 4번째 자리에 오면 @
		for(int i=1; i<=4; i++){       System.out.print( i==4 ?  '@' : '#');  }   System.out.println();
		
		//ver-3 층정리
		System.out.println();
		for (int a = 1; a <= 4; a++) {
			for (int i = 1; i <= 4; i++) {
				System.out.print(i == a ? '@' : '#');
			}
			System.out.println();
		}
	}

}

/*
패키지명 : ccom.the703.basic007_ex
클래스명 :  For2Ex002

@###
#@##
##@#
###@
*/