package com.the703.basic012;

/*
//1. 클래스는 부품객체
//2. 상속은 재활용
	Object					 
	  ↑					       
	TestA2 (int a, toString)					 
	  ↑					 
 	TestB2 (int b, toString)		 
 */

class TestA2 extends Object {
	int a=10;
	@Override public String toString() { return "TestA2 [a=" + a + "]"; }
} // end class
class TestB2 extends TestA2 {
	int b=20;
	@Override public String toString() { return "TestB2 [b=" + b + "]"; } 
} // end class
public class Poly002 {
	public static void main(String[] args) {
		// 부모 ← 자식 (업캐스팅)
		TestA2  ta = new TestB2();
		//1) TestA2  ta { a, toString}
		//2) new TestB2()
		// 1번지 :  TestB2()     →    TestA2()    →    Object()
		//        {b, @toString}      {a, toString}      {    }
		//3) ta{ a, toString}  [1번지]  =  [1번지] {b=20, @toString}-{a=10, toString} 
		System.out.println(ta);   // TestB2 [b=20]
		System.out.println(ta.a); // 10
		System.out.println(((TestB2)ta).b);// ta.b 사용방법은?
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


