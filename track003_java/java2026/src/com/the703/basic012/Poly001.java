package com.the703.basic012;

/*
//1. 클래스는 부품객체
//2. 상속은 재활용
	Object					Object	
	  ↑					      ↑	
	TestA1					TestB1
	(int a)					(int b)
	110v (=)				220v (oo)
 */

class TestA1 extends Object{  int a; }
class TestB1 extends Object{  int b; }

public class Poly001 {
	public static void main(String[] args) {
		TestA1 ta1 = new TestA1();
		//TestB1 tb1 = ta1;   
		// 오류 나는 이유는?
		//Type mismatch: cannot convert from TestA1 to TestB1
		//클래스도 자료형 (틀 - Object)
	}
}

/*
1. 다형성
- 많은 형상을 띄는 성품
- 여러타입의 객체를 하나의 타입으로 관리

2. 부모는 자식을 담을 수 있다. (업캐스팅)
------------------------------------------
<<class>> Animal [이름, 나이 / 먹기, 자기, 배변]
			↑  
<<class>> Cat    [동물등록증 / 꾹꾹이 하기]
------------------------------------------

Animal ani = new Cat()

1)  Animal ani     {  이름, 나이 / 먹기, 자기, 배변 }
2)              Cat()  → Animal()                   → Object()
{동물등록증 / 꾹꾹이 하기} + {이름, 나이 / 먹기, 자기, 배변 }

3. 자식은 부모를 담을 수 있다. (다운캐스팅)
------------------------------------------
<<class>> Animal [이름, 나이 / 먹기, 자기, 배변]
			↓  
<<class>> Cat    [동물등록증 / 꾹꾹이 하기]
------------------------------------------
Cat  cat = new Animal()
1) Cat  cat;
{동물등록증 / 꾹꾹이 하기} + {이름, 나이 / 먹기, 자기, 배변 }

2) new Animal()
{이름, 나이 / 먹기, 자기, 배변}

3) 만족 못 시키는 범위가 생김
{동물등록증 / 꾹꾹이 하기} 



4. 쓰는 이유는?
- 부모타입으로 자식 객체들을 관리가능

Animal []  anis = {  new Cat() , new Cat(), new Person() ,  new Person() };

*/


