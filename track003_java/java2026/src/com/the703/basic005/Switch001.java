package com.the703.basic005;

public class Switch001 { 
	public static void main(String[] args) {
		//1.        if( 1이면 ){ 1이다}         조건이 맞다
		//     else if( 2이면 ){ 2이다}   틀린데 조건이 맞다
		//	   else if( 3이면 ){ 3이다}   틀린데 조건이 맞다
		int a=2;
		
		     if( a==1 ){ System.out.println("1이다");}  
		else if( a==2 ){ System.out.println("2이다");}  
		else if( a==3 ){ System.out.println("3이다");}  
		 
		//2. switch
		/*     switch(대상){
		 	     조건1 :  처리  break; (처리후 나와!)
		 	     조건2 :  처리  break; 
		 	     default : 조건이 아닐때
		  	   }
		 */
		switch(a){
			case 1: System.out.println("1이다"); break;
			case 2: System.out.println("2이다"); break; 
			case 3: System.out.println("3이다"); break; 
			default : System.out.println("1,2,3이 아니다");
		}
	}
}
