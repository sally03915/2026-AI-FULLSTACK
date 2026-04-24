package com.the703.basic011_ex;

/*   Object  #3 Object(){                        }#4
       ↑
     Color   #2 Color(){         name=null, num=0}#5
       ↑
     Green   #1 Green(){                  show() }#6
    
    ---------------------------------------------
    Green mygreen = new Green();
    ---------------------------------------------
    1. Green은  Object(부품객체이다)  Color은  Object(부품객체이다)
    2. 생성자호출 : Green() →  Color()  → Object()    1 2 3 
    3. 객체생성  : Object → Color → Green  4 5 6
*/
class Color extends Object{
	public String name;
	private int num;
	
	public int getNum() { return num; }
	public void setNum(int num) { this.num = num; }
	
	public Color() { super(); }
	public Color(String name, int num) { super(); this.name = name; this.num = num; }
}
class Green extends Color{
	public Green() { super(); }
	public Green(String name, int num) { super(name, num); }

	void show() {
		System.out.println("GREEN");
		System.out.println("NAME : " + super.name); 
		System.out.println("NUM : "  + super.getNum());	 
	}
} 
public class ExtendsEx001 {
	public static void main(String[] args) {
        Green mygreen = new Green();
        mygreen.name = "LIGHT_GREEN";
        //mygreen.num = 5;
        mygreen.setNum(5);
        mygreen.show();
	}
}
/*
 


패키지명 : com.the703.basic011_ex
클래스명 :   ExtendsEx001.java
1. 아래 조건에 맞게 ExtendsEx001.java 파일을 작성하고, 
main() 메서드를 수정하여 다음과 같은 출력 결과가 나오도록 하시오.

2. 주어진 코드 (수정 전)
```java
public class ExtendsEx001 {
    public static void main(String[] args){
        Green mygreen = new Green();
        mygreen.name = "LIGHT_GREEN";
        mygreen.num = 5;
        mygreen.show();
    }
}
```
3.출력 결과 
GREEN
NAME : LIGHT_GREEN
NUM : 5

4. 클래스 구조 설명
 Color 클래스 : 멤버 변수:  name (String, public)  / num (int, private)
  ↑
Green 클래스  : 멤버 변수:  name (String, public), num (int, private)
 

5 요구사항
1) Color와 Green 클래스의 상속 관계를 활용할 것
2) main() 메서드에서 직접 name과 num에 값을 할당할 수 있도록 접근 제어자를 고려할 것
3) show() 메서드를 통해 출력 형식을 맞출 것

*/