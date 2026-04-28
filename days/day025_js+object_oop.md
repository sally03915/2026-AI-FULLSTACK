- Todo1:  JS
- Todo2:  OBJECT

---

### ■1. 복습문제   

■ OOP
class A11 {
    int a; // (1) 
    A11() { } 
    A11(int a) { this.a = a; } // (2) 

    //(3) void show()
    void show() { 
        this.a = 11;     System.out.println(this.a); 
    } 
    //(4) static void classMethod()
    static void classMethod() { this.a = 12; }

    //(5) int showZ()
    int showZ() { 
        int a;  return a; 
    }
}

public class RepeatQ123 {
    public static void main(String []args) { 
        A11 a1 = new A11();    (b) 
    }
} // end class

Q1. 위의 문제에서 (1),(2),(3),(4),(5)를 [ 클래스변수, 인스턴스변수, 지역변수, 클래스메서드, 인스턴스메서드 ]에서 고르시오.

(1) 인스턴스변수 - heap area - new O - 생성자 - this 각각
(2) 생성자 안 
  A11(int a) { this.a = a; } 
               인스턴스변수 = 지역변수
(3) 인스턴스 메서드 - heap area - new O - 생성자 - this 각각
(4) 클래스메서드 - method area - new X- 생성자 x - 공용
(5) 인스턴스 메서드 - heap area - new O - 생성자 - this 각각

> 클래스는 부품객체
> 상태(속성/멤버변수)와         행위(기능/멤버함수)
 클래스변수, 인스턴스변수        클래스메서드, 인스턴스메서드


Q2. 클래스 A11에서 오류나는 곳을 수정하고 그 이유를 적으시오.
(4)   static에서 instance(this) 사용불가
(5)   지역변수는 수동 초기화 - int a=0; 

Q3. (b)번 위치에서
메모리 빌려오고, 객체 생성하는 역할 : (  new    )
String은 null, int는 0으로 초기화하는 역할 : (  A11()   )
new A11()한 주소를 갖고 있는 것은 : ( a1   )

Q4. 기본생성자를 반드시 선언해야하는 경우를 적으시오.
오버로딩(다른 생성자 생성 시) , 상속
```
    A11() { } 
    A11(int a) { this.a = a; } 
```

Q5. 다음 중 오버로딩이 성립하기 위한 조건이 아닌 것은? (모두 고르시오)
a. 메서드의 이름이 같아야 한다.   o
b. 매개변수의 개수나 타입이 달라야 한다. o
c. 리턴타입이 달라야 한다.  x
d. 매개변수의 이름이 달라야 한다.  x

c,d


Q6. 다형성이란? 
> 하나의 타입(부모)으로 여러타입(자식)을 관리
> 여러개의 형태를 띄는 성질

Q7. 다음코드에서 다음에 해당하는 부분을 작성하시오.
//7-1. 상속도 / 7-2. 각 클래스에서 사용할수 있는 멤버변수, 멤버함수

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
public class PolyEx002 {
   public static void main(String[] args) {
         Parent7 p = new Child7();     //부모  = 자식 (업캐스팅)
         // 7-3.    Parent7 p   보장하는 범위   
         // 7-4.    인스턴스화 했을때 사용가능한 범위  
         Child7 c = new Child7();  
         System.out.println("p.x = " + p.x);  // 7-5 출력되는 내용  
         p.method();  //7-6 출력되는 내용    
         System.out.println("c.x = " + c.x);   // 7-7  출력되는 내용 
         c.method();   //7-8. 출력되는 내용     
   }
}
/*      7-1         7-2
        Object   #3{                  }#4
          ↑
        Parent7  #2{ x=100 , method()}#5
          ↑
        Child7   #1{ x=200 , @method()}#6

        7-3  Parent7 p  (1번지)  => { x=100 , method()}
        7-4  new Child7() => 1번지{ x=200 , @method()} - { x=100 , method()}
        7-5. x=100
        7-6. Child Method
        7-7. x=200
        7-8. Child Method
*/
 
part1. 제어문-절차지향
part2. OOP  -객체지향 특징
2-1. 클래스 사용  ( 클래스 VS 객체)
2-2. 클래스 설정  ( static, final, public■캡슐화) 
2-3. 클래스 ■상속 ( 재활용 )
2-4. ■다형성(부모타입으로 자식타입들 관리)
2-5. ■추상화(공통적인 속성 뽑기)

 
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
 