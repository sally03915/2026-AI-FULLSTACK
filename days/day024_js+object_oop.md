- Todo1:  JS
- Todo2:  OBJECT

---

### ■1. 복습문제   

.... JAVA 복습문제 먼저 준비~!

■ OOP
class A11 {
    int a; // (1)

    A11() { }

    A11(int a) { this.a = a; } // (2)

    //(3) void show()
    void show() { 
        this.a = 11; 
        System.out.println(this.a); 
    }

    //(4) static void classMethod()
    static void classMethod() { this.a = 12; }

    //(5) int showZ()
    int showZ() { 
        int a; 
        return a; 
    }
}

public class RepeatQ123 {
    public static void main(String []args) { 
        A11 a1 = new A11(); 
        (b) 
    }
} // end class

Q1. 위의 문제에서 (1),(2),(3),(4),(5)를 [ 클래스변수, 인스턴스변수, 지역변수, 클래스메서드, 인스턴스메서드 ]에서 고르시오.

Q2. 클래스 A11에서 오류나는 곳을 수정하고 그 이유를 적으시오.

Q3. (b)번 위치에서

메모리 빌려오고, 객체 생성하는 역할 : (          )
String은 null, int는 0으로 초기화하는 역할 : (     )
new A11()한 주소를 갖고 있는 것은 : (      )

Q4. 기본생성자를 반드시 선언해야하는 경우를 적으시오.

Q5. 다음 중 오버로딩이 성립하기 위한 조건이 아닌 것은? (모두 고르시오)
a. 메서드의 이름이 같아야 한다.
b. 매개변수의 개수나 타입이 달라야 한다.
c. 리턴타입이 달라야 한다.
d. 매개변수의 이름이 달라야 한다.


Q6. 다형성이란? 

Q7. 다음코드에서 다음에 해당하는 부분을 작성하시오.

//7-1. 상속도
//7-2. 각 클래스에서 사용할수 있는 멤버변수, 멤버함수

package com.the703.basic012_ex;

class Parent7  extends Object{
      int x = 100;
      public Parent7() { super(); }
      void method() { System.out.println("Parent Method"); }
} 
class Child7 extends Parent7 {
   int x = 200;
   public Child7() { super(); }
   @Override  void method() { System.out.println("Child Method"); }
}
/*
Object
  ↑
Parent7 {x=100 , method()}  Parent
  ↑
Child7  {x=200 , method()}  Child
*/
public class PolyEx002 {
   public static void main(String[] args) {
         Parent7 p = new Child7();     //부모  = 자식 (업캐스팅)
         // 7-3.    Parent7 p   보장하는 범위  
         // 7-4.    인스턴스화 했을때 사용가능한 범위 : new Child7()   
         Child7 c = new Child7();  

         System.out.println("p.x = " + p.x);  // 7-5 출력되는 내용  
         p.method();  //7-6 출력되는 내용    
         
         System.out.println("c.x = " + c.x);   // 7-7  출력되는 내용 
         c.method();   //7-8. 출력되는 내용     
   }
}

 
---

### ■2. Todo1:  js
 


---

### ■3.   Todo2:  java  method
 
 

★협업마스터 - 
 

| 이름 | 특징 | 링크 |
|------|------|------|
| **이정민 포트폴리오** | 미니멀한 UI, 섹션별 애니메이션 효과 | [leejeongmin.vercel.app](https://leejeongmin.vercel.app) |
| **박세빈 포트폴리오** | 감성적인 컬러와 인터랙션, 프로젝트 중심 구성 | [savinpark.github.io/portfolio](https://savinpark.github.io/portfolio) |
| **강모대 포트폴리오** | Azure 기반 배포, 깔끔한 구성 | [onlyone-modaekang.azurewebsites.net](https://onlyone-modaekang.azurewebsites.net) |
| **이보아 포트폴리오** | 디자이너 감성의 레이아웃, 섬세한 타이포그래피 | [leeboa.com](http://leeboa.com) |


---

### ■4.  복습문제
 



//////////////////////////////////////////////////////////////////////////////////////// 복습문제 (1)
Q1. 다음의 상속도를 그리시오.
Q2. 상속도에서  각각의 클래스에서 사용가능한 멤버변수/멤버함수를  적으시오.

abstract class Animal{    
	String name; 
	abstract void eat();   
	abstract void sleep(); 
	abstract void poo();  
}
class Cat  extends Animal{  // 구현클래스 - 고양이는 동물이다
	@Override void eat()   {  System.out.println(super.name + "고양이 냠냠!");  }
	@Override void sleep() {  System.out.println(super.name + "고양이 수면!");  }
	@Override void poo()   {  System.out.println(super.name + "고양이 시원");  }
}
class Dog  extends Animal{  // 구현클래스 - 강아지는 동물이다
	@Override void eat()   {  System.out.println(super.name + "강아지 냠냠!");  }
	@Override void sleep() {  System.out.println(super.name + "강아지 수면!");  }
	@Override void poo()   {  System.out.println(super.name + "강아지 시원");  }
}
public class Abstract001 {
	public static void main(String[] args) {
		//1. abstract  class : 일반클래스 + 설계
		Animal ani = new Animal();   Q3. 이코드에서 오류나는 이유는? 
	 
		Animal ani = null;
		ani = new Cat();   //Q4.    업캐스팅/다운캐스팅 ?
		ani.name = "sally";   ani.eat();
 
		
		//2. 사용목적
		Animal [] arr = {new Cat() , new Cat() , new Dog() , new Dog() , };
		int cnt=0;
		//Q5.  다음이 출력되게 코드를 작성하시오.
		/*ani1고양이 냠냠!
		  ani2고양이 냠냠!
		  ani3강아지 냠냠!
		 ani4강아지 냠냠!   */
	}
}


//////////////////////////////////////////////////////////////////////////////////////// 복습문제 (2)

// Q6. 오류나는 부분을 주석달고 이유를 적으시오.

class Papa{   int brain; }
class Mama{   int brain; }
class Son extends Papa, Mama{}  

interface Animal2{
	String company="(주) thejoa";    //Q7.  interface에서의 멤버변수에 붙는 키워드는? 
	void eat();     //Q8.  interface에서의 멤버함수에 붙는 키워드는? 
}
class Saram implements Animal2{ 
	@Override public void eat() { 
		company="kakao";  
		System.out.println( Animal2.company  + " 랍스탑.... 냠냠 "   );
	}
} 
 

////////////////////////////////////////////////////////////////////////////////////////// 복습문제 (3)

//Q9.  Driver 클래스를 작성하시오.   

interface Vehicle {  public void run();    } 
class MotorCycle implements Vehicle {
   @Override   public void run() {   System.out.println("오토바이가 달립니다.");   }
    public void helmat() {   System.out.println("헬멧을 착용합니다.");   }
}
class Car implements Vehicle {
   @Override  public void run() {     System.out.println("자동차가 달립니다.");   }
}
public class InterfaceEx002{
   public static void main(String[] args) {
      Driver driver = new Driver();
      
      Car car = new Car();
      MotorCycle mo = new MotorCycle();
      
      driver.drive(car);
      driver.drive(mo);
   }
}

>> 실행화면
자동차가 달립니다.

헬멧을 착용합니다.
오토바이가 달립니다.
 