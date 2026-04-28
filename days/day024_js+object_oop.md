- Todo1:  JS
- Todo2:  OBJECT

---

### ■1. 복습문제   

.... JAVA 복습문제 먼저 준비~!

■ OOP
Q1. 클래스와 인스턴스의 관계를 설명하시오    
클래스는 객체를 만들기 위한 (①   설계도  ) 역할을 한다.
인스턴스는 클래스의 구조를 기반으로 (②   실체화   ) 되어 메모리에 생성된 실체이다.
같은 클래스라도 인스턴스는 서로 다른 (③  특징 / 주소  ) 값을 가질 수 있다.

Q2. 다음 코드의 실행 결과와 메모리 구조를 설명하시오
```java
Car myCar = new Car("Hyundai", 2023);
```
new Car(...)는 객체를 생성하고 (④   heap  / 힙   ) 영역에 저장된다.
myCar는 해당 객체의 (⑤   주소   ) 를 참조한다.
생성자 내부에서는 전달받은 값을 (⑥   초기화   ) 한다.

------------------------------------------------
method(정보) : Car.class [설계도]
------------------------------------------------
heap                            stack

[2번지]{"Kia", 2026 }         ← mycar2: 2번지
[1번지]{"Hyundai", 2023 }     ← mycar: 1번지
------------------------------------------------


Q3. 생성자에 대한 설명으로 옳은 것을 고르시오
--------------------------------------------------
Car myCar = new Car("Hyundai", 2023);
--------------------------------------------------

생성자는 클래스명과 (⑦   이름  ) 이 같아야 한다.
생성자는 객체 생성 시 자동으로 (⑧   호출  ) 된다.
생성자는 반환값이 (⑨  없다 / X     )

※ 초기값 > 명시적초기화 > 초기화블록  > 생성자


Q4. 기본 생성자가 자동으로 생성되지 않는 경우는?
클래스에 (⑩   오버로딩   ) 생성자가 이미 정의되어 있을 경우
상속받은 클래스에서 부모 생성자 호출이 필요한 경우

------------------------------------
Book b1 = new Book("Java", 500);
Book b2 = new Book();
------------------------------------

오버로딩 : 같은이름의 메서드 / 파라미터의 타입과 갯수


Q5. 다음 코드에서 객체가 저장되는 메모리 영역과 메서드 실행 흐름을 설명하시오
```java
Book b1 = new Book("Java", 500);
Book b2 = new Book();
b2.setTitle("Spring");
```
Book 클래스의 인스턴스는 (⑪   heap  ) 영역에 저장된다.
b1, b2는 각각 객체의 (⑫  주소   ) 를 참조한다.
setTitle() 메서드는 (⑬  stack   ) 영역에서 실행된다.

Q6. 자바 메모리 구조에서 각 영역의 역할을 설명하시오
Method Area : 클래스 정보 및 static 변수 저장
Heap Area : (⑭  인스턴스 객체    ) 저장, GC가 관리
Stack Area : (⑮ 지역변수    ) 저장, 메서드 호출 시 사용됨


Q7. 변수의 종류와 메모리 위치를 연결하시오
1) 클래스는 부품객체  
2) 상태(속성: 멤버변수-클래스변수/인스턴스변수 )와 행위(기능:멤버메서드 - 클래스메서드/인스턴스메서드)

클래스 변수 → (⑯    method   ) 영역   (static)
인스턴스 변수 → (⑰   heap   ) 영역
지역 변수 → (⑱    stack  ) 영역

Q8. 접근자를 넓은 범위에서 좁은 범위로 적으시오
(⑲  public  → ⑳  protected    → ㉑ default(package)   → ㉒  private )
 어디서든지       상속자식              해당폴더                클래스내부


Q9. 다음을 private으로 설정했다. 외부에서 접근 가능하게 설정해야 하는 것
(㉓  getter  / ㉔  setter  ) 이다. 

Q10. 상속에 대한 설명으로 옳은 것을 고르시오  
상속은 기존 클래스의 (㉕  속성 / 멤버변수  )와 기능을 재사용하기 위해 사용된다.
자식 클래스는 부모 클래스의 (㉖   필드/속성/멤버변수  )와 메서드를 물려받는다.
상속을 통해 코드의 (㉗  유지보수  )성과 재사용성을 높일 수 있다.
자바에서 상속은 (㉘ extends   ) 키워드를 사용하여 구현한다.

Q11. 오버로딩과 오버라이딩의 차이를 설명하시오  
오버로딩은 같은 클래스 내에서 (㉙  메서드이름  )이 같고 (㉚ 파라미터/알규먼트/재료   )이 다른 메서드를 정의하는 것.
오버라이딩은 부모 클래스의 메서드를 자식 클래스에서 (㉛  오버라이디 / Override  )하여 재정의하는 것.
오버로딩은 (㉜  컴파일  ) 시점에 결정되고, 오버라이딩은 (㉝ 실행   ) 시점에 결정된다.
오버라이딩 시 접근 제어자는 부모 메서드보다 (㉞  넓은  ) 범위로만 변경 가능하다.

 
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

 
