package com.the703.basic013_ex;


// 설계목적
interface Animal1 {
   String Company="(주) Thejoa 703";  
   public void sound();
} 
class Dog1 implements Animal1 {
   @Override
   public void sound() {
      System.out.println("멍멍!");
   }
   public void playFetch() {
      System.out.println("강아지가 공을 물어옵니다.");
   }
}
class Cat1 implements Animal1 {
   @Override
   public void sound() {
      System.out.println("야옹~");
   }
   public void scratch() {
      System.out.println("고양이가 발톱을 세웁니다.");
   }
}
class Bird1 implements Animal1 {
   @Override
   public void sound() {
      System.out.println("짹짹!");
   }
   public void fly() {
      System.out.println("새가 하늘을 납니다.");
   }
}
//Q1.  다음코드를 확인하고 오류나는 부분을 체크하시오 -  설계목적 , new (x)
//Q2. interface의 멤버변수에 자동으로 붙는 속성은?  sf : static final
//Q3. interface의 멤버함수에 자동으로 붙는 속성은?  a  : abstract
//Q4. ZooKeeper 클래스를 작성하시오. (조건: Animal의 sound()와 각 클래스의 고유 메서드를 모두 호출할 것)

public class Repeat005_oop { 
	public static void main(String[] args) {
      java.util.Scanner sc = new java.util.Scanner(System.in);

      //Q1. A1) Animal1 ani = new Animal1();
      //Q1. A2) 상수 - 수정못함.
	  //      Animal1.Company = "(주)네이버";
	  //      System.out.println(Animal1.Company);
      
      // Animal 배열에 미리 객체를 담아둠
      Animal1[] animals = { new Dog1(), new Cat1(), new Bird1() };
      

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
         Animal1 animal = animals[choice - 1];

         // ZooKeeper 클래스의 show() 메서드 호출
         ZooKeeper1 keeper = new ZooKeeper1();
         // 리턴값 메서드명(파라미터)
         // void  show(Animal1 ani){}
         keeper.show(animal);
         System.out.println();
      }
      sc.close();
	}

}
/*    Animal1{  Company / sound()  }
↑ 		 ↑ 		 	↑ 		
Dog1		Cat1		Bird1
{@sound()}  {@sound()}  {@sound()}
playFetch() scratch()   fly()
*/
class   ZooKeeper1{
	void  show(Animal1 ani){
		ani.sound();
			 if(ani  instanceof Dog1) {    ((Dog1) ani).playFetch();  }
		else if(ani  instanceof Cat1) {    ((Cat1) ani).scratch();    }
		else if(ani  instanceof Bird1) {   ((Bird1) ani).fly();       }
	}
}



/*


 
조건:
- interface Animal { String Company="(주) Thejoa 703"; public void sound(); }
- Dog, Cat, Bird 클래스는 각각 Animal을 구현하고, 고유 메서드를 가진다.
- ZooKeeper 클래스의 show() 메서드에서 Animal의 sound()와 각 클래스의 고유 메서드를 호출한다.

1. 주어진조건
interface Animal1 {
   String Company="(주) Thejoa 703";    // sf : static final
   public void sound();
} 
class Dog1 implements Animal1 {
   @Override
   public void sound() {
      System.out.println("멍멍!");
   }
   public void playFetch() {
      System.out.println("강아지가 공을 물어옵니다.");
   }
}
class Cat1 implements Animal1 {
   @Override
   public void sound() {
      System.out.println("야옹~");
   }
   public void scratch() {
      System.out.println("고양이가 발톱을 세웁니다.");
   }
}
class Bird1 implements Animal1 {
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
      Animal1[] animals = { new Dog1(), new Cat1(), new Bird1() };

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
         Animal1 animal = animals[choice - 1];

         // ZooKeeper 클래스의 show() 메서드 호출
//         ZooKeeper keeper = new ZooKeeper();
//         keeper.show(animal);
//         System.out.println();
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
 

*/