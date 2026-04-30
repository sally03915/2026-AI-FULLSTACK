package com.the703.basic014_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1. 동적배열 : 콜렉션프레임워크
//List, Set, Map
//List(기차) : 순서(index) o, 중복 o
//add, get, size, remove, contains

public class ListEx002 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String>   numbers = new ArrayList<>();
		numbers.add("one");  numbers.add("two");  numbers.add("three");
		int num=-1;
		
		System.out.print("1,2,3 입력> ");
		num = scanner.nextInt();
		//ver-1
		//		     if(num == 1) {   System.out.println(numbers.get(0)); }  //num-1= 1-1 = 0
		//		else if(num == 2) {   System.out.println(numbers.get(1)); }  //num-1= 2-1 = 1
		//		else if(num == 3) {   System.out.println(numbers.get(2)); }  //num-1= 3-1 = 2
		
		//ver-2
		//		switch(num) {
		//			case 1: System.out.println(numbers.get(0));  break;
		//			case 2: System.out.println(numbers.get(1));  break;
		//			case 3: System.out.println(numbers.get(2));  break;
		//		}
		
		//ver-3
		if(num>=1 && num<=3) { System.out.println(numbers.get(num-1)); }
		else                 { System.out.println("1,2,3 중에 입력하세요.");}
	}
}
/*
연습문제1)  Collection  Framework
패키지명 : com.the703.basic014_ex
클래스명 : ListEx002
다음과 같이 코드를 작성하시오.
1.  ArrayList이용해서  numbers 만들기
2.  one, two, three 데이터 추가
3.  사용자에게 1,2,3 입력받기
4.  1을 입력받으면 one 출력
    2를입력받으면 two 출력
    3을입력받으면 three 출력
*/