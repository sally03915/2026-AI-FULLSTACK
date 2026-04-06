package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx006_2 {

	public static void main(String[] args) {
		// 변수
		String ch = "";
		Scanner scanner = new Scanner(System.in);
		// 입력
		System.out.println("요일입력 -M,T,W,F,S,U>");
		ch = scanner.next();
		// 처리
		// 출력
		switch(ch.charAt(0)) {
		case 'M' :  case 'm' :  System.out.println( "월요일: 공부하는 날"); break;
		case 'T' :  case 't' :  System.out.println( "화요일: 운동하는 날"); break;
		case 'W' :  case 'w' :  System.out.println( "수요일: 독서하는 날"); break;
		case 'F' :  case 'f' :  System.out.println( "금요일: 영화 보는 날"); break;
		case 'S' :  case 's' :  System.out.println( "토요일: 여행 가는 날"); break;
		case 'U' :  case 'u' :  System.out.println( "일요일: 휴식하는 날"); break;
		}

	}

}

/*

연습문제6)  
패키지명 : com.company.basic005_ex  
클래스명 : SwitchEx006  
출력내용 : switch 이용
문자 한 개 입력받아
   M이면 "월요일: 공부하는 날"
   T이면 "화요일: 운동하는 날"
   W이면 "수요일: 독서하는 날"
   F이면 "금요일: 영화 보는 날"
   S이면 "토요일: 여행 가는 날"
   U이면 "일요일: 휴식하는 날"
*/