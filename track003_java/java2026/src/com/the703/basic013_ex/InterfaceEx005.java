package com.the703.basic013_ex;

public class InterfaceEx005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


/*


연습문제4)  
패키지명 :  com.the703.basic013_ex;
클래스명 :  InetrfaceEx004

1. 인터페이스를 활용한 점심 주문 시뮬레이션
다음은 점심 메뉴 주문을 인터페이스로 추상화한 프로그램이다. 
Launch 인터페이스는 모든 메뉴가 공통적으로 가져야 할 기능을 정의하며, 
Burger, KimchiStew 클래스는 이를 구현하여 각각의 메뉴 정보를 제공한다. 
User 클래스는 메뉴를 주문하고, 주문 내역을 출력하는 기능을 담당한다.

2. 주어진 조건
interface Launch {
    int MONEY = 10000;
    void eat();
}
class Burger      implements Launch{ 
	int price;
	public Burger() { this.price = 3900; }
	@Override public String toString() { return "Burger"; }
	@Override public void eat() { System.out.println("Burger 냠냠!"); } 
}
class KimchiStew  implements Launch{ 
	int price;
	public KimchiStew() { this.price = 4000; }
	@Override public String toString() { return "KimchiStew"; }
	@Override public void eat() { System.out.println("KimchiStew 냠냠!"); } 
}
class User {  
    int money;
    int cnt;
    Launch[] plate;
- order(Launch a) 메서드로 메뉴 주문
  주문 시 메뉴 종류에 따라 가격 확인
  잔액 부족 시 주문 거절
  주문 성공 시 배열에 저장
- show() 메서드로 주문 내역 출력
  주문한 메뉴 목록
  총 주문 금액
  잔액
  오늘 날짜
  각 메뉴의 eat() 호출
}
3. main
public class InetrfaceEx004 {
	public static void main(String[] args) {
		 User launch_order = new User();
		 								     //리턴값 메서드명(파라미터)
		 launch_order.order(new Burger());   //void order(Launch a){}
		 launch_order.order(new KimchiStew());   //Launch a = new Kimchi()  부모=자식
		 launch_order.order(new Burger());   //Launch a = new Burger()  부모=자식
		 									
		 launch_order.show();//리턴값 메서드명(파라미터)
		 				     // void   show(){}
	}
}


4. 실행 예시 
버거하나요~ 
Burger 냠냠!
김치찌개하나요~ 
KimchiStew 냠냠!
버거하나요~ 
Burger 냠냠!


주문 :  Burger, KimchiStew, Burger
주문금액 : 11800
잔액    : -1800
2025년 9월 30일
Burger 냠냠!
KimchiStew 냠냠!
Burger 냠냠!
※ 실제 실행 결과는 날짜 및 주문 순서에 따라 달라질 수 있습니다.

*/