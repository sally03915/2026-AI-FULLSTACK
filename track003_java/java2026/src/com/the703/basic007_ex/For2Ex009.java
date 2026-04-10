package com.the703.basic007_ex;

public class For2Ex009 {

	public static void main(String[] args) {		
		//for
		System.out.println("<for>");
		for(char ch ='A';ch <='Z';ch++) {
			for(char ch2 = 'A'; ch2 <= ch;ch2++) {
				System.out.print(ch2);
			}
			System.out.println();
		}
		
		//while
		System.out.println("<while>");
		char ch3='A';
		while(ch3<='Z') {
			char ch4='A';
			while(ch4<=ch3){
				System.out.print(ch4);
				ch4++;
			}
			ch3++;
			System.out.println();
		}

		//do while
		System.out.println("<do while>");
		char ch5='A';
		do {
			char ch6='A';
			do {
				System.out.print(ch6);	
				ch6++;
			}while(ch6<=ch5);
			ch5++;
			System.out.println();
		}while(ch5<='Z');
		
	}
}

//이중for, 이중while, 이중do while 세가지 버젼으로 다음과 같이 출력하시오

//A
//AB
//중간생략...
//ABCDEFGHIJKLMNOPQRSTUVWXY
//ABCDEFGHIJKLMNOPQRSTUVWXYZ

//*
//**
//***

