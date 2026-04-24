package com.the703.basic011_ex;

/******
-newShow() 메서드는 각 클래스에서 오버라이딩되어 고유한 출력 형식을 가짐
*/
class   MobileNote                      {                              void show() {}     }

class MobileNote7 extends MobileNote {
	private String iris, face;
	void newShow() { 
		System.out.println("NOTE7 객체 기능(Overriding)\n" + "iris = "+this.iris+"\n" + "face = "+this.face);
	}
	//// 생성자 오버로딩 (이름이 같음 - 파라미터의 자료형과 갯수)
	public MobileNote7() { super(); }
	public MobileNote7(String iris, String face) { super(); this.iris = iris; this.face = face; }

	public String getIris() { return iris; } public void setIris(String iris) { this.iris = iris; }
	public String getFace() { return face; } public void setFace(String face) { this.face = face; }
}

class MobileNote8 extends MobileNote7 {  // 상속시 
	private String face;
	///// 오버라이딩 ( 상속시 부모의 메서드를 수정해서 자식 클래스에 맞게 수정 ) 
	@Override void newShow() { 
		super.newShow();
		System.out.println("NOTE8 객체 기능(Overriding) 추가\n" + "face = "+this.face); 
	}
	public String getFace() { return face; } public void setFace(String face) { this.face = face; }
}

class MobileNote9 extends MobileNote8 {
	private int battery;
	public MobileNote9(String iris, String face,int battery) {
		this.setIris(iris); this.setFace(face); this.battery = battery;
	}
	@Override void newShow() { 
	   super.newShow();  //super(부모주소) 
	   System.out.println("NOTE9 객체 기능(Overriding) 추가\n" + "battery 예쁘게 사용하기!\n" + "battery = "
			   				+ this.battery);
	}
	public int getBattery() { return battery; } public void setBattery(int battery) { this.battery = battery; }
}

public class ExtendsEx002 {
	public static void main(String[] args) {
//        MobileNote7 my7 = new MobileNote7();
//        my7.setIris("brown"); my7.setFace("pretty"); my7.newShow();
//
//        MobileNote8 my8 = new MobileNote8();
//        my8.setFace("pretty"); my8.newShow();
//
//        MobileNote9 my9 = new MobileNote9();
//        my9.setBattery(24); my9.newShow();
		
		 MobileNote9 my9 = new MobileNote9("brown" , "pretty" , 24*7);
		 my9.newShow();
	}
}


/*

>>요구사항
-MobileNote 클래스를 기반으로 상속 구조를 설계할 것 
  (MobileNote7, MobileNote8, MobileNote9 모두 상속)
-각 클래스에서 setter 메서드를 통해 멤버변수 값을 설정할 수 있도록 구현할 것
-newShow() 메서드를 오버라이딩하여 출력 형식을 문제에서 제시한 형태로 맞출 것
-출력 순서와 내용이 정확히 일치하도록 main() 메서드를 구성할 것


연습문제2)     클래스 상속과 메서드 오버라이딩
패키지명 : com.company.java011_ex 
클래스명 : ExtendsEx002.java

1. 아래 조건에 맞게 ExtendsEx002.java 파일을 작성하고,
   main() 메서드를 수정하여 다음과 같은 출력 결과가 나오도록 하시오.
2. 주어진 코드 (수정 전)
```java
public class ExtendsEx002{
    public static void main(String[] args) {
        MobileNote7 my7 = new MobileNote7();
        my7.setIris("brown");
        my7.setFace("pretty");
        my7.newShow();

        MobileNote8 my8 = new MobileNote8();
        my8.setFace("pretty");
        my8.newShow();

        MobileNote9 my9 = new MobileNote9();
        my9.setBattery(24);
        my9.newShow();
    }
}
```
3. 출력 결과 

NOTE7 객체 기능(Overriding)
iris = brown
face = pretty

NOTE8 객체 기능(Overriding) 추가
face = pretty

NOTE9 객체 기능(Overriding) 추가
battery 예쁘게 사용하기!
battery = 24

4. 클래스 구조 설명
클래스명		멤버변수		  멤버메서드
MobileNote	없음		                  void show()
 ↑
MobileNote7	String iris, String face  void newShow()
 ↑
MobileNote8	String face	              void newShow()
 ↑
MobileNote9	int battery	              void newShow()
모든 멤버변수는 private으로 선언

-각 클래스는 MobileNote 클래스를 상속받음
-newShow() 메서드는 각 클래스에서 오버라이딩되어 고유한 출력 형식을 가짐

5. 요구사항
-MobileNote 클래스를 기반으로 상속 구조를 설계할 것 
  (MobileNote7, MobileNote8, MobileNote9 모두 상속)
-각 클래스에서 setter 메서드를 통해 멤버변수 값을 설정할 수 있도록 구현할 것
-newShow() 메서드를 오버라이딩하여 출력 형식을 문제에서 제시한 형태로 맞출 것
-출력 순서와 내용이 정확히 일치하도록 main() 메서드를 구성할 것


*/