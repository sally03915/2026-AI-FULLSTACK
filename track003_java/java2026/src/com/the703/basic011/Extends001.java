package com.the703.basic011;
//1. 클래스는 부품객체
//2. 상태(멤버변수:클래스변수(static), 인스턴스변수)와 행위(멤버함수)
//3. 상속 - 클래스의 재사용
/*
   Object #4. {                  }#5 
     ↑
   	 A    #3. {              a=10}#6
   	 ↑
   	 B    #2. {              b=20}#7   
   	 ↑ 
   	 C    #1. {              c=30}#8          
   	 ------------------------------
   	 C my = new C(); 
   	 ------------------------------
   	 1) extends 상속
   	 2) is a  :  A는 Object 이다.  B도 Object이다
   	 3) 생성자호출순서 : C() →B() → A()  → Object()  1 2 3 4
   	 4) 객체가 생성   : Object → A → B → C          5 6 7 8 
*/
class A extends Object { int a = 10;	public A() { super(); }}
class B extends A      { int b = 20;  	public B() { super(); }}
class C extends B      { 	
	int c=30;  
	void show() { System.out.println(a + "\t" + b + "\t" + c); }
	public C() { super(); }
}
public class Extends001 {
	public static void main(String[] args) {
		C my = new C(); //1) new 객체생성 2) C() 초기화  3) my 주소 
		my.show();
	}
}


/******
1. 상속?  클래스의 재사용 - 새로운 부분만 추가, 수정해서 사용

2. super   vs   sub
   부모			자식	
   상위			하위
   parent		child
   super		sub
   
3. 모든 클래스는 Object 클래스를 상속
4. UML    부모 ← 자식 

5. 장점 - 빠른개발, 코드의 중복제거, 다형성(하나의 타입으로 여러타입을 관리)

6. 문법
	class  자식클래스  extends 부모클래스  (O)
	class  자식클래스  extends 부모클래스1, 부모클래스2 (X)  

7. 상속시 부모속성을 사용할수 있는 이유는?
 	- 부모생성자를 호출해서 
 	  부모의 인스턴스변수를 초기화해 사용가능하게 만들어줌

8. 오버라이드
   - @Override
   - 상속시 부모의 메서드와 동일, 자식클래스에 맞게 수정해서 사용 

*/






