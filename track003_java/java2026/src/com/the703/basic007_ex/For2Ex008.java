package com.the703.basic007_ex;

public class For2Ex008 {

	public static void main(String[] args) {		
		//for
		System.out.println("<for>");
		for(int i=1;i<=5;i++) {
			for(int i1=5;i1>=1;i1--) {
				if(i+i1==6) {
					System.out.print(i+"+"+i1+"="+(i+i1));
				}
			}
			System.out.println();
		}
		
		//while
		System.out.println("<while>");
		int i2=1;		
		while(i2<=5) {	
			int i3=5;
			while(i3>=1) {
				if(i2+i3 ==6) {
					System.out.print(i2+"+"+i3+"="+(i2+i3));
				}
				i3--;			}
			i2++;
			System.out.println();
		}
		
		//do while
		System.out.println("<do while>");
		int i4=1;
		do {
			int i5=5;
			do {
				if(i4+i5==6) {
					System.out.print(i4+"+"+i5+"="+(i4+i5));
				}
				i5--;
			}while(i5>=1);
			i4++;
			System.out.println();
		}while(i4<=5);
		

	}
}
//두개의 주새위를 던졌을 때 눈의 합이 b가 되는
//모든 경우의 수를 출력하는 프로그램을 작성하시오.
//이중  for, 이중 while, do while 세가지버전으로 작성하시오.

//1+5=b
//2+4=b
//3+3=b
//4+2=b
//5+1=b