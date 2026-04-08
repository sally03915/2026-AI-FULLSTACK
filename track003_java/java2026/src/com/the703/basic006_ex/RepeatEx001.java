package com.the703.basic006_ex;

public class RepeatEx001 {

	public static void main(String[] args) {
		 // {반복}  {변수}  for(시작; 종료; 변화)   
		 System.out.println("\n\nQ1-1.  for       1 2 3 4 5");
		 for(int i=1; i<=5; i++){  System.out.print(i); }
		 
		 System.out.println("\n\nQ1-2.  while     1 2 3 4 5");
		 int i=1;  while(i<=5){  System.out.print(i);  i++;}
		 
		 System.out.println("\n\nQ1-3.  do while  1 2 3 4 5");
		 i=1;      do{  System.out.print(i);  i++;}while(i<=5);
		 
		 //--
		 System.out.println("\n\nQ2-1.  for       5 4 3 2 1");
		 for(int i2=5; i2>=1; i2--){  System.out.print(i2); }
		 
		 System.out.println("\n\nQ2-2.  while     5 4 3 2 1");
		 int i2=5; while(i2>=1){  System.out.print(i2);  i2--;}
		 
		 System.out.println("\n\nQ2-3.  do while  5 4 3 2 1");
		 i2=5;    do{  System.out.print(i2);  i2--;} while(i2>=1);

		 //--
		 System.out.println("\n\nQ3-1.  for       JAVA1   JAVA2  JAVA3");
		//		 System.out.print("JAVA"+1 + "\t");
		//		 System.out.print("JAVA"+2 + "\t");
		//		 System.out.print("JAVA"+3 + "\t");
		 
		 for(int i3=1; i3<=3; i3++){   System.out.print("JAVA"+i3 + "\t"); }
		 
		 
		 System.out.println("\n\nQ3-2.  while     JAVA1   JAVA2  JAVA3");
		 int i3=1;  while(i3<=3){   System.out.print("JAVA"+i3 + "\t");  i3++;}
		 
		 System.out.println("\n\nQ3-3.  do while  JAVA1   JAVA2  JAVA3");
		 i3=1;  do{   System.out.print("JAVA"+i3 + "\t");  i3++;}while(i3<=3);
	}

}

/*
연습문제7)  for/while/do while
패키지명 : ccom.the703.basic006
클래스명 :  RepeatEx001
1.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  1 2 3 4 5
2.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  5 4 3 2 1
3.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  JAVA1   JAVA2  JAVA3

*/