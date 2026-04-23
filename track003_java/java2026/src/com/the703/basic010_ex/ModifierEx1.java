package com.the703.basic010_ex;

import com.the703.basic010.Milk;   // basic010 패키지에 있는 Milk
public class ModifierEx1 {
	public static void main(String[] args) {
	      Milk m1 = new Milk();  
	      System.out.println( m1 );  
	      m1.setMprice(2000);       
	      System.out.println( m1 );
	}
}



/*
연습문제1)  지정접근자
패키지명 : com.the703.basic010_ex
클래스명 : ModifierEx1
다음과 같이 코드를 작성하시오.
ㅁ출력된화면
   Milk [mno=0, mname=null, mprice=0]
   Milk [mno=0, mname=null, mprice=2000]
   
ㅁ주어진조건
public class Milk{  // basic010에 설정해주세요!
   private int  mno;   
   private String mname;  
   private  int mprice;  
}

public class ModifierEx1{ // basic010_ex 패키지에 설정해주세요.
   public static void main(String[] args) {
      Milk m1 = new Milk();  
      System.out.println( m1 );  
      m1.setMprice(2000);       
      System.out.println( m1 );
   } // end main
} // end class


*/