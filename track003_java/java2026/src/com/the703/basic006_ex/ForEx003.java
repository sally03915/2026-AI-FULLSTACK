package com.the703.basic006_ex;

public class ForEx003 { 
	public static void main(String[] args) {
		//변수  
		int hap=0;
		//입력
		//처리 - 1~10까지의 합을 구하시오. 55
		//hap[누적박스:0]  → hap=0      0           
		//hap[누적박스:1]  → hap=1     (0)+1          hap=hap+1
		//hap[누적박스:3]  → hap=3     (0+1)+2        hap=hap+2
		//hap[누적박스:6]  → hap=6     (0+1+2)+3      hap=hap+3
		
		//출력  { }  {변수}
		for(int i=1; i<=10; i++){  hap=hap+i;  }
		
		System.out.println( hap );  
	} 
}

/*
연습문제3)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx003
출력내용 :   for 이용
1~10까지의 합을 구하시오. 
*/