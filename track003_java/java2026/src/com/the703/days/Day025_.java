//Q1. 다음의 상속도를 그리시오.
//Q2. 상속도에서  각각의 클래스에서 사용가능한 멤버변수/멤버함수를  적으시오.
/*
		Object
		  ↑
	   <<abstract>>
		Animal   {   name    / eat(), sleep(), poo()  }
	  ↑        					↑
	Dog       					Cat
{@eat(),@sleep(),@poo()  }		{@eat(),@sleep(),@poo()  }


abstract : 공통의 속성을  뽑아서 일반화

*/
//
//abstract class Animal{    
//	String name;    // 인스턴스변수 - heap area - new o - 생성자 - this 각각D:\hyojung2\2026-AI-FULLSTACK\track003_java\java2026\src
//	abstract void eat();   
//	abstract void sleep(); 
//	abstract void poo();  
//}
//class Cat  extends Animal{  // 구현클래스 - 고양이는 동물이다
//	@Override void eat()   {  System.out.println(super.name + "고양이 냠냠!");  }
//	@Override void sleep() {  System.out.println(super.name + "고양이 수면!");  }
//	@Override void poo()   {  System.out.println(super.name + "고양이 시원");  }
//}
//class Dog  extends Animal{  // 구현클래스 - 강아지는 동물이다
//	@Override void eat()   {  System.out.println(super.name + "강아지 냠냠!");  }
//	@Override void sleep() {  System.out.println(super.name + "강아지 수면!");  }
//	@Override void poo()   {  System.out.println(super.name + "강아지 시원");  }
//} 
//
//public class Day025_ {
//	public static void main(String[] args) {
//		//1. abstract  class : 일반클래스 + 설계
//		//Animal ani = new Animal();  // Q3. 이코드에서 오류나는 이유는? 
//		// { }이 없음   →  abstract void eat();  →  틀만 제공하고 실제동작을 구현하는 부분은 하위클래스에서 구현   
//	 
//		Animal ani = null; 
//		ani = new Cat();   //Q4.    업캐스팅/다운캐스팅 ?   업캐스팅  - 부모는 자식을 담을수 있다.
//		ani.name = "sally";   ani.eat();
//
//		//2. 사용목적
//		Animal [] arr = {new Cat() , new Cat() , new Dog() , new Dog() , };
//		int cnt=0;
//		
//		for(  Animal a : arr ) {   a.name = "ani" + ++cnt;    a.eat();        }
//		
//		//Q5.  다음이 출력되게 코드를 작성하시오.
//		/*ani1고양이 냠냠!
//		  ani2고양이 냠냠!
//		  ani3강아지 냠냠!
//		  ani4강아지 냠냠!   */
//	}
//}




//
//
////////////////////////////////////////////////////////////////////////////////////////// 복습문제 (2)
//
//// Q6. 오류나는 부분을 주석달고 이유를 적으시오. o
//
//class Papa{   int brain; }
//class Mama{   int brain; }
////class Son extends Papa, Mama{}   → 단일상속   6-1
//
//interface Animal2{
//	String company="(주) thejoa";    //Q7.  interface에서의 멤버변수에 붙는 키워드는? static final : sf
//	void eat();     //Q8.  interface에서의 멤버함수에 붙는 키워드는?  abstract : a
//}
//class Saram implements Animal2{ 
//	@Override public void eat() { 
//		//company="kakao";    → 상수, 수정 x,  값 재할당 x   6-2
//		System.out.println( Animal2.company  + " 랍스탑.... 냠냠 "   );
//	}
//} 

//////////////////////////////////////////////////////////////////////////////////////////// 복습문제 (3)
//
////Q9.  Driver 클래스를 작성하시오.   
/*
			Vehicle {  run() }    ← 	Driver { drive(Vehicle v);}
			↑ 			↑
MotorCycle				Car	
{ @run(/helmat()) }		{ @run() }
*/
//interface Vehicle {  public void run();    } 
//class MotorCycle implements Vehicle {
//   @Override   public void run() {   System.out.println("오토바이가 달립니다.");   }
//    public void helmat() {   System.out.println("헬멧을 착용합니다.");   }
//}
//class Car implements Vehicle {
//   @Override  public void run() {     System.out.println("자동차가 달립니다.");   }
//}
//class Driver{
//	 void  drive(Vehicle v) {  //Vehicle v = car   ,  Vehicle v=mo
//		 if(v instanceof   MotorCycle) { ((MotorCycle) v).helmat(); }
//		 								 //타입캐스팅
//		 v.run();
//	 }
//}
//// 6  6-1/6-2  1점
//// 9  성공~!    1점   
//// 응원콘테스트   1점
//public class Day025_ {
//	public static void main(String[] args) {
//
//      Driver driver = new Driver();
//      
//      Car car = new Car();
//      MotorCycle mo = new MotorCycle();
//      
//      driver.drive(car);   // 리턴값 메서드명(재료)
//      driver.drive(mo);    // void  drive(Vehicle){}
//	}
//}

//>> 실행화면
//자동차가 달립니다.
//
//헬멧을 착용합니다.
//오토바이가 달립니다.



