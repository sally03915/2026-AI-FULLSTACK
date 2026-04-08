package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001_3_ {
	public static void main(String[] args) {
		//변수
		// 자료형 : 기본형/참조형 (String)
		// 기본형 - 정수: byte(1)<short/char(2)<int★(4)<long(8) / 실수 : float(4)<double★(8) / boolean 빼고 타입형변환가능
		String stdid="" , pass="불합격" , level="가" , jang="";
		int kor = -1, eng = -1, mat = -1, total = -1;  /* ■1) 0~100사이의 아닌값    */
		double avg = -1;
		Scanner scanner = new Scanner(System.in);  
		//입력   0. 국어,영어, 수학(0~100만입력받기)  무한반복 
		//      문자열: next() / 정수형(10) : nextInt() / 실수형(1.23) : nextDouble() / 문자: next().charAt(0)
		
		System.out.print("학번 입력 >");  stdid=scanner.next();
		for(;;){  //5) 여기와서 
			//if(  !(kor>=0 && kor<=100) ){  //■2) kor = -1
			if(  kor<0 || kor>100 ){ 	
				System.out.print("국어점수 입력 >");     kor = scanner.nextInt(); //3)
				continue; //4) 이아래코드들 진행안함 
			}

			//if(  !(mat>=0 && mat<=100) ){ 
			if(       mat<0 || mat>100   ){ 
				System.out.print("수학점수 입력 >");     mat = scanner.nextInt();
				continue;
			}

			if(  !(eng>=0 && eng<=100) ){ 
				System.out.print("영어점수 입력 >");     eng = scanner.nextInt(); 
				continue;
			}
			
			break;   // kor, eng, math 입력을 잘한경우
		}
		/*	 
		 * 	for(;;){  //무한반복
		 * 		    if(국어점수의 범위가 아니라면){  //-1     (0~100 사이가 아니므로)
		 * 				1. 국어점수 입력 > 100    입력받기
		 * 				2. 건너뛰기  (continue)
		 * 			}
		 * 		    if(영어점수의 범위가 아니라면){
		 * 				1. 영어점수 입력 > 100    입력받기
		 * 				2. 건너뛰기(continue)
		 * 			}
		 * 
		 * 		    if(수학점수의 범위가 아니라면){
		 * 				1. 수학점수 입력 > 100    입력받기
		 * 				2. 건너뛰기(continue)
		 * 			}
		 * 			// break; 나오기  -  이위치까지 왔다면 잘입력한것!
		 		} 
		 */
		//처리  - 연산자 먼저()  값(++,--,산술)  비교(<,>)  조건(&& || 삼항) 대입(=)
		//     - 제어문 (#if/ #switch)  반복(#for/while/do while)
		total = kor + eng + mat ;   //		1. 총점 구하기
		avg   = total/3.0;          //		2. 평균 구하기 (강제형변화)  정수/실수
		pass  = avg < 60? "불합격" : kor<40 || eng<40|| mat<40 ?"불합격" :"합격"; //		3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
		if(avg>=95) { jang="장학생"; }                                         //		4. 평균이 95점이상이면 장학생
		
		switch((int)avg/10) {  //95->9 수
			case 10:  case 9 : level="수";  break;
			case 8 :           level="우";  break;
			case 7:  		   level="미";  break;
			case 6:  		   level="양";  break;
		}         //		5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 		
		
		//출력 
		System.out.println("=================================================================================== \r\n"
				+ "학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생\r\n"
				+ "=================================================================================== ");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\r\n" 
				,stdid,kor,eng,mat,total,avg,pass,level,jang);
			
	}
}

/*
연습문제1)   
패키지명 : com.company.java004_ex
클래스명 :   ForIn001
출력내용 :  성적처리 프로그램입니다.

0. 국어,영어, 수학(0~100만입력받기)  무한반복
1. 총점 구하기
2. 평균 구하기
3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
4. 평균이 95점이상이면 장학생
5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 

학번 입력 > std111
국어점수 입력 > 100    (0~100만입력받기)   for(;;){}
수학점수 입력 > 100    (0~100만입력받기)   for(;;){}
영어점수 입력 > 99     (0~100만입력받기)   for(;;){}
=================================================================================== 
학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
=================================================================================== 
std111   100   100   99   299   99.67   합격   수   장학생
*/