package com.the703.basic006;

public class WhileBasic {

	public static void main(String[] args) {
		// for   1 2 3 출력
		// {반복}   {변수}   for(시작; 종료;변화)
		System.out.println("\n\nver-0");
		System.out.print(1);
		System.out.print(2);
		System.out.print(3);
		
		System.out.println("\n\nver-1 for");
		for(int i=1; i<=3; i++){ System.out.print(i);}
		

		System.out.println("\n\nver-2 while");
		int i=1;
		while( i<=3  ){ System.out.print(i);    i++; }
		
		System.out.println("\n\nver-3 while");
		int i1=1;
		do{ System.out.print(i1);    i1++; }while( i1<=3  );
		
	} 
}
