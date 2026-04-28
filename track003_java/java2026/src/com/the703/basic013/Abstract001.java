package com.the703.basic013;

abstract class Animal{
	String name;  //인스턴스변수 - heap area - new o - this 각각
	abstract void eat();  // 추상메서드 {} 구현부가 없음.
	abstract void sleep();// 추상메서드 추상클래스로 만들어줘야 함.
	abstract void poo();  // 추상화, 일반화, 설계 : 공통의 속성, 구체적인 내용 없음
}
class Cat extends Animal{ // 구현클래스 - 고양이는 동물이다
	@Override void eat()   { System.out.println(super.name + " 고양이 냠냠!"); }
	@Override void sleep() { System.out.println(super.name + " 고양이 수면!"); }
	@Override void poo()   { System.out.println(super.name + " 고양이 시원!"); }
}

class Dog extends Animal{// 구현클래스 - 강아지는 동물이다
	@Override void eat()   { System.out.println(super.name + " 강아지 냠냠!"); }
	@Override void sleep() { System.out.println(super.name + " 강아지 수면!"); }
	@Override void poo()   { System.out.println(super.name + " 강아지 시원!"); }
}

public class Abstract001 {
	public static void main(String[] args) {
		//1. abstract : 일반클래스 + 설계
		 //Animal ani = new Animal(); // new 메모리빌리고 객체생성, Animal 초기화 {} 구현부가 없음
		 //Cannot instantiate the type Animal
		 //abstract void eat();

		Animal ani = null;   // {name, eat(), sleep(), poo()}
		ani = new Cat();     // 부모 = 자식, 업캐스팅
		ani.name="sally";    ani.eat();
		
		ani = new Dog();
		ani.name="alpha";    ani.eat();
		
		//2. 사용목적
		Animal [] arr = {new Cat(), new Cat(), new Dog(), new Dog()};
		int cnt = 0;
		for( Animal a    : arr   ) { a.name = "ani" + ++cnt;  a.eat();  }
		// 각각 인스턴스에 이름 /  eat() 자식꺼 오버라이드 (최신기능)
	}
}

/*
Abstract (is A) 일반클래스 + 설계
    고양이도 동물이다
    개도    동물이다
      <<abstract>>
          Animal     {name / eat(), sleep(), poo()}
          ↑   ↑ 
       Cat    Dog    {@eat(), @sleep(), @poo()}   
*/
/*
1. 추상화( abstract )
- 실체화된 객체들 간 공통되는 특성을 추출
- 미완성적인 개념 (new 사용하지 못함)
- 공통된 필드와 메서드의 이름을 통일할 목적

2. 추상클래스


*/