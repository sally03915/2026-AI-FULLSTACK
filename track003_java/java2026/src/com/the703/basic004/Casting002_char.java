package com.the703.basic004;

public class Casting002_char {
	public static void main(String[] args) {
		//#1. 문자 - 저장시 숫자 / 출력시 문자
		char ch1 = ' '; //공백한개라도 있어야 오류가 안남
		char ch2 = '\u0000';
		
		System.out.println("step1 : " + ch1 + "\t" + ch2);
		System.out.println("step2 : " + (int)ch1 + "\t" + (int)ch2);
		
		//#2. 문자
		char ch = 'A';
		System.out.println("step3 : " + ch + "\t" + (int)ch);
		System.out.println("step4 : " + (ch+1));  //66
		//2-1) 'A' + 1
		//2-2) char(65|2byte) + int(4byte)
		//2-3) 66
		System.out.println("step5 : " + (char)(ch+1)); 
		
		//Q.대문자 'A' 소문자'a'로 변환
		char q = 'A';
		char a = (char) (q + 32);   //char(65|2byte) + int(4byte)
		System.out.println('A' + "\t" + 'a');
		System.out.println((int)'A' + "\t" + (int)'a');  // 65    97
		System.out.println(q + " 를 소문자로 변환시킬려면 " + a);  // 97(a) = 65(A)+32
		
		
		
	}
}
//1. 자료형 ( 기본형 / 참조형 )
//2. 기본형 - boolean - true/false
//          정수형   : byte 1   < short 2 < int★ 4 < long 8L
//          실수형   : float 4f < double★ 8  
//3. #1.형변환 - 자동타입변환 (boolean 빼고)