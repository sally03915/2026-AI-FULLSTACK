package com.the703.basic013_ex;

/*		 Vehicle {run()}            ←  Driver
		↑		↑
   MotorCycle   Car
   {@run()}     {@run()}
 */

interface Vehicle { public void run(); } 
class MotorCycle implements Vehicle {
	@Override public void run() { System.out.println("오토바이가 달립니다."); }
	public void helmet() {  System.out.println("헬맷을 착용합니다."); }
}

class Car implements Vehicle {
	@Override public void run() { System.out.println("자동차가 달립니다."); }
}
class Driver {
	void drive(Vehicle v) {    // Vehicle  v = car     , Vehicle v = mo 
		// 만약에 모터사이클이라면   helmet()  호출
		if(v instanceof MotorCycle) {   ((MotorCycle)v).helmet(); }  
		v.run();    // 기본 다형성동작 - override 된 자식메서드
	}
}
public class InterfaceEx002 {
	public static void main(String[] args) {
	      Driver driver = new Driver(); 
	      Car car = new Car();
	      MotorCycle mo = new MotorCycle(); 
	//리턴값       메서드명(파라미터){        }
	//                 car , mo 두개의 값을 다 담을수 있는 자료형   부모 = 자식   
	//void       drive(Vehicle v)      
	      driver.drive(car); //	      자동차가 달립니다.
	      driver.drive(mo);  //	      오토바이가 달립니다. 
	}
}

/*
연습문제2)  
패키지명 :  com.the703.basic013_ex;
클래스명 :  InterfaceEx002


1. Driver 클래스를 작성하시오.  
2. 주어진조건
interface Vehicle {
   public void run();
} 
class MotorCycle implements Vehicle {
   @Override
   public void run() {
      System.out.println("오토바이가 달립니다.");
   }
}
class Car implements Vehicle {
   @Override
   public void run() {
      System.out.println("자동차가 달립니다.");
   }
}

3. 메인화면
public class InterfaceEx002{
   public static void main(String[] args) {
      Driver driver = new Driver();
      
      Car car = new Car();
      MotorCycle mo = new MotorCycle();
      
      driver.drive(car);
      driver.drive(mo);
   }
}

4. 실행화면
자동차가 달립니다.
오토바이가 달립니다.

*/