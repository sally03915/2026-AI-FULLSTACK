package com.the703.basic013_ex_before;

import java.util.ArrayList;
 
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
 


public class Repeat003_oop {
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


// Q8 오버로딩/오버라이딩이란?

/* 
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

 
*/