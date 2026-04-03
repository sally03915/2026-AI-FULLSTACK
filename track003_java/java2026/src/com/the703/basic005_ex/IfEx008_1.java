package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx008_1 {
	public static void main(String[] args) { 
		// GIGO
		// 변수
		String stdid="" , pass="불합격", level="가" , jang="";
		int kor=-1, eng=-1, math=-1 , total; double avg=0;
		Scanner scanner = new Scanner(System.in);
		
		// 입력
		System.out.print("학번 입력 > ");    stdid = scanner.next();
		System.out.print("국어점수 입력 > "); kor   = scanner.nextInt();
		System.out.print("수학점수 입력 > "); eng   = scanner.nextInt();
		System.out.print("영어점수 입력 > "); math  = scanner.nextInt(); 
		
		// 처리
		total = kor + eng + math; //		1. 총점 구하기
		avg   = total/3.0;        //		2. 평균 구하기 -   정수/실수
		
		//		3. if(평균이 60점이상이고  각과목이 40점 미만이면 아니라면){ 합격 } else{ 불합격}
		if( avg>=60 &&   kor >=40 && eng>=60 && math>=40){  pass = "합격";} 
		else{ pass = "불합격";}
		
		if(avg>=95){ jang="장학생";}  //		4. if(평균이 95점이상이면){ 장학생}
		
		//		5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 
		     if(avg>=90) {level = "수";}
		else if(avg>=80) {level = "우";}
		else if(avg>=70) {level = "미";}
		else if(avg>=60) {level = "양";}
		else             {level = "가";}
		
		// 출력  
		System.out.println("=======================================================================\n"
				+ "학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생\n"
				+ "=======================================================================");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\n"
				       ,stdid,kor,eng,math,total,avg,pass,level,jang);
	
	}
}
/*
연습문제8)  
패키지명 : com.the703.basic005_ex
클래스명 :  IfEx008
출력내용 :  성적처리 프로그램입니다.
1. 총점 구하기
2. 평균 구하기
3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
4. 평균이 95점이상이면 장학생
5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 

학번 입력 > std111
국어점수 입력 > 100
수학점수 입력 > 100
영어점수 입력 > 99
======================================================== 
학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
======================================================== 
std111   100   100   99   299   99.67   합격   수   장학생
*/