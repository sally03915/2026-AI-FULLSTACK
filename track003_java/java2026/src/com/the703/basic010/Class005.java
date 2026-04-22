package com.the703.basic010;

//1. 클래스는 부품객체
//2. 클래스는 상태(멤버변수)와 행위(멤버함수)
class Farm{
	//상태(멤버변수)
	String name;  //인스턴스변수- heap area - new O - 생성자
	int age;
	static String FarmName="(주) 동물농장";  //클래스변수 - 클래스명.변수명 
	static int    FarmNum;   // 클래스변수 - method area - new X - 생성자 X
	static String FarmBoss;  
	static {  FarmNum=2;  FarmBoss="신동엽"; }   // 초기화블록
	//행위(멤버함수)
	static void numPlus() {   FarmNum++; /*this.age++; */ }  // 클래스.메서드 - method area - static
	
	void show() { //인스턴스 메서드 - heap area - new O - 생성자
		System.out.println("\n\n::::::::::::::::");
		System.out.println("::이름 : " + this.name);
		System.out.println("::나이 : " + this.age);
		System.out.println("::동물농장 인원 : " + Farm.FarmNum);
	}
}
public class Class005 {
	public static void main(String[] args) {
		System.out.println("\n\n0. 동물농장");
		System.out.println("::회사이름 > " + Farm.FarmName);
		System.out.println("::회사사장 > " + Farm.FarmBoss);
		System.out.println("::회사인원 > " + Farm.FarmNum);

		System.out.println("\n\n1. 동물식구 - this- 각각");
		Farm cat = new Farm();  //1) new 객체만들기  2) Farm() 초기화  3) cat번지
		cat.name = "kitty";  cat.age = 3;   Farm.numPlus();   cat.show(); 
		 
		Farm dog = new Farm();  //1) new 객체만들기  2) Farm() 초기화  3) cat번지
		dog.name = "뽀비";    dog.age = 7;    /*dog.numPlus(); */  Farm.numPlus();   
		dog.show(); 
	}
}
//////////////////////////////////////////////////////
/*
초기화			기본값	명시적초기화		초기화블록			생성자
    FarmName  	null	(주) 동물농장		(주) 동물농장		x
    FarmNum		0		0				2				x
	FarmBoss	null	null			신동엽			x
-----------------------------------------------------
    cat	    name=null,   →				→				→
    		age=0
    dog     name=null,	 →				→				→		
    		age=0
*/
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
--------------------------------------------------------------------
[METHOD:정보, static, final]  Farm.class  , Class005.class
   Farm.FarmName="(주) 동물농장";   Farm.FarmNum=2;  Farm.FarmBoss="신동엽";   Farm.numPlus()
--------------------------------------------------------------------
[HEAP:동적]           		 |  [STACK:지역] 
2번지{name="뽀비"  , age=7}       ←  cat[2번지]
1번지{name="kitty", age=3}       ←  cat[1번지]
--------------------------------------------------------------------
*/
//////////////////////////////////////////////////////

