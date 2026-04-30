- Todo1:  JS
- Todo2:  OBJECT

---

### ■1. 복습문제   

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
 




 
part1. 제어문-절차지향
part2. OOP  -객체지향 특징
	2-1. 클래스 사용  ( 클래스 VS 객체)
	2-2. 클래스 설정  ( static, final, public■캡슐화) 
	2-3. 클래스 ■상속 ( 재활용 )
	2-4. ■다형성(부모타입으로 자식타입들 관리)
	2-5. ■추상화(공통적인 속성 뽑기)
part3. OOP  -활용
	1. 콜렉션프레임워크
	2. lambda + stream
	3. io
	4. network (Thead)

 
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

협업마스터 :  손예진, 김주엽(2), 예진, 보라, 혜원, 수정, 욱진 

