- Todo1:  JS
- Todo2:  OBJECT

---

### ■1. 복습문제   

■ OOP
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

### ■3.   Todo2:  java  

## 📝 문제: OOP 개념(1)

다음 코드를 보고 질문에 답하시오.
Q1. OOP란 무엇인가?
Q2. OOP의 핵심 개념은 무엇인가?
Q3. 상속도를 그리시오.
Q4. 각 객체에서 사용할 수 있는 멤버변수와 메서드를 적으시오.
Q5. Parent p = new Child(); 실행 시 객체 생성, 초기화, 참조값을 설명하시오.
Q6. Parent 클래스의 멤버변수/메서드의 종류와 메모리 구조를 설명하시오.
Q7. 출력 결과를 쓰시오.
- p.x의 값은?  
- p.method() 실행 시 어떤 메서드가 호출되는가?  
- c.x의 값은?  
- c.method() 실행 시 어떤 메서드가 호출되는가?

Q8. @Override 키워드의 의미와 코드에서 오버라이딩된 부분을 설명하시오.
Q9. Child c = new Child(); 호출 시 생성자 호출 순서와 객체 생성 순서를 설명하시오.


 
class Parent {
    int x = 100;
    void method() { System.out.println("Parent method"); }
}

class Child extends Parent {
    int x = 200;
    void method() { System.out.println("Child method"); }
}

public class Repeat001_oop {
    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();

        System.out.println("p.x = " + p.x);
        p.method();

        System.out.println("c.x = " + c.x);
        c.method();
    }
}


---


📝 문제: OOP 개념(2) — 캡슐화 / static / final
Q1. 캡슐화(Encapsulation)란 무엇이며, 위 코드에서 어떻게 구현되었는지 설명하시오.
Q2. 접근제어자의 범위를 넓은 것부터 좁은 것까지 순서대로 쓰시오.
Q3. static 키워드의 의미를 메모리 구조와 연결지어 설명하고, 위 코드에서 어떤 변수에 적용되었는지 쓰시오.
Q4. final 키워드의 의미를 설명하고, 위 코드에서 어떤 변수에 적용되었는지 쓰시오.
Q5. Account.accountCount의 값은 얼마인가? 왜 그렇게 되는지 설명하시오.
Q6. a1.id와 a2.id의 값은 각각 얼마인가?
Q7. 출력 결과를 쓰시오.
Q8. static 메서드와 인스턴스 메서드의 차이를 설명하시오.
Q9. final 키워드가 변수, 메서드, 클래스에 각각 적용될 때 의미를 설명하시오.
Q10. 캡슐화의 장점은 무엇인가?

```
class Account {
    private int balance;              
    public static int accountCount=0; 
    public final int id;              

	public Account(){this.id = ++accountCount;}
    public Account(int id, int balance) {
        this();
        this.balance = balance; 
    }

    // getter/setter
    public int getBalance() { return balance; }
    public void deposit(int amount) { balance += amount; }
    public void withdraw(int amount) { balance -= amount; }

    @Override
    public String toString() {
        return "Account [id=" + id + ", balance=" + balance + "]";
    }
}

public class Repeat002_oop {
    public static void main(String[] args) {
        Account a1 = new Account(1, 100);
        Account a2 = new Account(2, 200);

        a1.deposit(50);
        a2.withdraw(30);

        System.out.println(a1);  
        System.out.println(a2); 

        System.out.println("총 계좌 수 = " + Account.accountCount); 
        System.out.println("a1.id = " + a1.id); 
        System.out.println("a2.id = " + a2.id); 
    }
}
```



---

## 📝 문제: OOP 다형성

다음 코드를 보고 질문에 답하시오.

Q1. 상속도를 그리시오.
Q2. 상속도에서 각 객체에서 사용할 수 있는 멤버변수와 멤버함수를 적으시오.

```
class Papa{
	int money=10;

	public Papa() { super(); }
	public Papa(int money) { super(); this.money = money; }
	@Override public String toString() { return "Papa [money=" + money + "]"; }
}
class Son extends Papa{
	int money=150;
	int car=2;
	
	public Son() { super(); }
	public Son(int money) { super(money); }
	public Son(int money, int car) { super(); this.money = money; this.car = car; }
	@Override public String toString() { return "Son [money=" + money + ", car=" + car + "]"; }
}
```


public class Repeat002_oop {
	public static void main(String[] args) {
		// Q3. Papa p1 = new Papa(); 실행 시 메모리 구조와 출력 결과를 설명하시오.
		// System.out.println(p1);의 결과는 무엇인가?
		Papa p1 = new Papa();   
		System.out.println(p1); 
		
		// Q4. Son s2 = new Son(); 실행 시 메모리 구조와 출력 결과를 설명하시오.
		// System.out.println(s2);의 결과는 무엇인가?
		Son s2 = new Son();   
		System.out.println(s2);   
		
		// Q5.Son s3 = (Son) new Papa(); 실행 시 어떤 문제가 발생하는가?
		Son s3 = (Son) new Papa();  
		
		// Q6. Papa p4 = new Son(); 실행 시 메모리 구조와 출력 결과를 설명하시오.
		// System.out.println(p4);의 결과는 무엇인가?
		// System.out.println(p4.money);의 결과는 무엇인가?
		Papa p4 = new Son();                               
		System.out.println(p4); 
		System.out.println(p4.money); 

		// Q7. p4에서 Son의 moeny를 사용하는 방법은? 
		 
	}
}


Q8 오버로딩/오버라이딩이란?



---

📝 문제: OOP 개념(4) — 추상화 / 인터페이스
Q1. abstract란 무엇인가?  
Q2. interface란 무엇인가?  
Q3. abstract와 interface의 공통점과 차이점을 설명하시오.
Q4. 다음과 같이 출력되게 코드를 작성하시오.
1) 출력 화면:
사과는 빨갛다.
바나나는 노랗다.
코코넛은 코코하다.

2) 상속도:

코드
     Fruit
↑       ↑       ↑
Apple  Banana  Coconut

3) 주어진코드
abstract class Fruit {
    @Override public String toString() { return "Fruit"; }
    public abstract void myfruit();
}
public class Abstract005 {
    public static void main(String[] args) {
        Fruit[] fruits = { new Apple(), new Banana(), new Coconut() };
        for (Fruit f : fruits) {
            f.myfruit();
        }
    }
}



---



Q1.  다음코드를 확인하고 오류나는 부분을 체크하시오
Q2. interface의 멤버변수에 자동으로 붙는 속성은?
Q3. interface의 멤버함수에 자동으로 붙는 속성은?
Q4. ZooKeeper 클래스를 작성하시오. (조건: Animal의 sound()와 각 클래스의 고유 메서드를 모두 호출할 것)
 
조건:
- interface Animal { String Company="(주) Thejoa 703"; public void sound(); }
- Dog, Cat, Bird 클래스는 각각 Animal을 구현하고, 고유 메서드를 가진다.
- ZooKeeper 클래스의 show() 메서드에서 Animal의 sound()와 각 클래스의 고유 메서드를 호출한다.

1. 주어진조건
interface Animal {
   String Company="(주) Thejoa 703";  
   public void sound();
} 
class Dog implements Animal {
   @Override
   public void sound() {
      System.out.println("멍멍!");
   }
   public void playFetch() {
      System.out.println("강아지가 공을 물어옵니다.");
   }
}
class Cat implements Animal {
   @Override
   public void sound() {
      System.out.println("야옹~");
   }
   public void scratch() {
      System.out.println("고양이가 발톱을 세웁니다.");
   }
}
class Bird implements Animal {
   @Override
   public void sound() {
      System.out.println("짹짹!");
   }
   public void fly() {
      System.out.println("새가 하늘을 납니다.");
   }
}

2. 메인화면
public class Repeat005_oop {
   public static void main(String[] args) {
      java.util.Scanner sc = new java.util.Scanner(System.in);

      // Animal 배열에 미리 객체를 담아둠
      Animal[] animals = { new Dog(), new Cat(), new Bird() };

      while (true) {
         System.out.println("=== 동물원 메뉴판 ===");
         System.out.println("1. 강아지");
         System.out.println("2. 고양이");
         System.out.println("3. 새");
         System.out.println("0. 종료");
         System.out.print("선택: ");
         int choice = sc.nextInt();

         if (choice == 0) {
            System.out.println("동물원 관람을 종료합니다.");
            break;
         }

         if (choice < 1 || choice > animals.length) {
            System.out.println("잘못된 선택입니다.");
            continue;
         }

         // 배열에서 바로 꺼내오기
         Animal animal = animals[choice - 1];

         // ZooKeeper 클래스의 show() 메서드 호출
         ZooKeeper keeper = new ZooKeeper();
         keeper.show(animal);
         System.out.println();
      }
      sc.close();
   }
}

3. 실행화면
=== 동물원 메뉴판 ===
1. 강아지
2. 고양이
3. 새
0. 종료
선택: 1
멍멍!
강아지가 공을 물어옵니다.

선택: 2
야옹~
고양이가 발톱을 세웁니다.

선택: 3
짹짹!
새가 하늘을 납니다.

선택: 0
동물원 관람을 종료합니다.
 






---


 

★협업마스터 - 
 

| 이름 | 특징 | 링크 |
|------|------|------|
| **이정민 포트폴리오** | 미니멀한 UI, 섹션별 애니메이션 효과 | [leejeongmin.vercel.app](https://leejeongmin.vercel.app) |
| **박세빈 포트폴리오** | 감성적인 컬러와 인터랙션, 프로젝트 중심 구성 | [savinpark.github.io/portfolio](https://savinpark.github.io/portfolio) |
| **강모대 포트폴리오** | Azure 기반 배포, 깔끔한 구성 | [onlyone-modaekang.azurewebsites.net](https://onlyone-modaekang.azurewebsites.net) |
| **이보아 포트폴리오** | 디자이너 감성의 레이아웃, 섬세한 타이포그래피 | [leeboa.com](http://leeboa.com) |


---

### ■4.  복습문제


