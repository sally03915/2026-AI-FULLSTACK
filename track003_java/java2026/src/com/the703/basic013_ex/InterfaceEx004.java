package com.the703.basic013_ex;


interface Drink { public void serve(); }

class Coffee implements Drink {
   @Override public void serve() { System.out.println("커피가 준비되었습니다."); }
   public void addSugar() { System.out.println("커피에 설탕을 넣습니다."); }
}
class Tea implements Drink {
   @Override public void serve() { System.out.println("차가 준비되었습니다."); }
   public void addLemon() { System.out.println("차에 레몬을 넣습니다."); }
}
class Juice implements Drink {
   @Override public void serve() { System.out.println("주스가 준비되었습니다."); }
   public void addIce() { System.out.println("주스에 얼음을 넣습니다."); }
}
/*****
Drink  {serve()}
↑      ↑          ↑
Coffee	  Tea	     Juice
{@serve()}	 {@serve()}	 {@serve()}
addSugar()   addLemon()  addIce()
*/
class   Barista{
	void  make(Drink d) {
	      // menu[0] = {@serve() , addSugar() } - {---}
	      // menu[1] = {@serve() , addLemon() } - {---}
	      // menu[2] = {@serve() , addIce() } - {---}
				d.serve();
		     if(d instanceof Coffee) {  ((Coffee) d).addSugar(); }
		else if(d instanceof Tea)    {  ((Tea) d).addLemon(); }
		else if(d instanceof Juice)  {  ((Juice) d).addIce(); }
	}
}
public class InterfaceEx004 { 
	public static void main(String[] args) {
	      java.util.Scanner sc = new java.util.Scanner(System.in);
	      Barista barista = new Barista();

	      // 배열에 객체들을 담아둠
	      // 부모	   =	자식  (업캐스팅)		
	      Drink[] menu = { new Coffee(), new Tea(), new Juice() };
	      //                menu[0]      menu[1]     menu[2]
	      // menu[0] = {@serve() , addSugar() } - {---}
	      // menu[1] = {@serve() , addLemon() } - {---}
	      // menu[2] = {@serve() , addIce() } - {---}
	       
	       
	      while (true) {
	         System.out.println("=== 카페 메뉴판 ===");
	         System.out.println("1. 커피");      //   choice:  1 menu[1-1]   menu[0]
	         System.out.println("2. 차");       //    choice:  2 menu[2-1] menu[1] 
	         System.out.println("3. 주스");      //   choice:  3  menu[3-1] menu[2] 
	         System.out.println("0. 종료");
	         System.out.print("선택: ");
	         int choice = sc.nextInt();  //1~3

	         if (choice == 0) { System.out.println("카페 주문을 종료합니다."); break; }

	         if (choice >= 1 && choice <= menu.length) {
	            Drink drink = menu[choice - 1]; // 배열에서 꺼내오기     menu[0] 
	            barista.make(drink);
	            //리턴값 메서드명(파라미터)
	            //void  make(Drink drink)
	            
	         } else { System.out.println("잘못된 선택입니다."); }
	         System.out.println();
	      }
	      sc.close();

	}
}


/*******
연습문제4)  
패키지명 :  package com.company.java013_ex;
클래스명 :  public class InterfaceEx004

1. Barista 클래스를 작성하시오.  
2. 주어진조건
interface Drink {
   public void serve();
} 
class Coffee implements Drink {
   @Override
   public void serve() {
      System.out.println("커피가 준비되었습니다.");
   }
   public void addSugar() {
      System.out.println("커피에 설탕을 넣습니다.");
   }
}
class Tea implements Drink {
   @Override
   public void serve() {
      System.out.println("차가 준비되었습니다.");
   }
   public void addLemon() {
      System.out.println("차에 레몬을 넣습니다.");
   }
}
class Juice implements Drink {
   @Override
   public void serve() {
      System.out.println("주스가 준비되었습니다.");
   }
   public void addIce() {
      System.out.println("주스에 얼음을 넣습니다.");
   }
}

3. 메인화면
public class InterfaceEx004 {
   public static void main(String[] args) {
      java.util.Scanner sc = new java.util.Scanner(System.in);
      Barista barista = new Barista();

      // 배열에 객체들을 담아둠
      Drink[] menu = { new Coffee(), new Tea(), new Juice() };

      while (true) {
         System.out.println("=== 카페 메뉴판 ===");
         System.out.println("1. 커피");
         System.out.println("2. 차");
         System.out.println("3. 주스");
         System.out.println("0. 종료");
         System.out.print("선택: ");
         int choice = sc.nextInt();

         if (choice == 0) {
            System.out.println("카페 주문을 종료합니다.");
            break;
         }

         if (choice >= 1 && choice <= menu.length) {
            Drink drink = menu[choice - 1]; // 배열에서 꺼내오기
            barista.make(drink);
         } else {
            System.out.println("잘못된 선택입니다.");
         }
         System.out.println();
      }
      sc.close();
   }
}

4. 실행화면
=== 카페 메뉴판 ===
1. 커피
2. 차
3. 주스
0. 종료
선택: 1
커피가 준비되었습니다.
커피에 설탕을 넣습니다.

선택: 2
차가 준비되었습니다.
차에 레몬을 넣습니다.

선택: 3
주스가 준비되었습니다.
주스에 얼음을 넣습니다.

선택: 0
카페 주문을 종료합니다.

*/