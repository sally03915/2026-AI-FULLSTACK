package com.the703.basic007_ex;

public class For2Ex010 {

	public static void main(String[] args) {
		//for
		System.out.println("<for>");		
		for(char ch='Z';ch>='A';ch--) {
			for(char ch2='A';ch2<=ch;ch2++) {
				System.out.print(ch2);
				}
			System.out.println();
		}		
		
		//while
		System.out.println("<while>");
		char ch3 = 'Z';
		while(ch3>='A') {
			char ch4='A';
			while(ch4<=ch3) {
				System.out.print(ch4);
				ch4++;
			}
			ch3--;
			System.out.println();
		}

		//do while
		System.out.println("<do while>");
		char ch5='Z';
		do {
			char ch6='A';
			do {
				System.out.print(ch6);
				ch6++;
			}while(ch6<=ch5);
			ch5--;
			System.out.println();
		}while(ch5>='A');
		
	}
}

//이중for, 이중while, 이중do while 세가지 버젼으로 다음과 같이 출력하시오
//ABCDEFGHIJKLMNOPQRSTUVWXYZ
//ABCDEFGHIJKLMNOPQRSTUVWXY
//중간생략...
//AB
//A


//System.out.print("*"); System.out.print("*"); System.out.print("*"); System.out.println();
//System.out.print("*"); System.out.print("*"); System.out.println();
//System.out.print("*"); System.out.println();

//for(int i=1; i<=3;i++) {System.out.print("*");}System.out.println();
//for(int i=1; i<=2;i++) {System.out.print("*");}System.out.println();
//for(int i=1; i<=1;i++) {System.out.print("*");}System.out.println();

//***
//**
//* 





