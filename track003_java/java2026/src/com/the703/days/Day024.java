package com.the703.days;

class A11 {
    int a; // (1)   인스턴스변수 - heap area - new - this 각각

    A11() { }

    A11(int a) { this.a            = a;           } // (2) 생성자
    //           this.a 인스턴스변수 = a 지역변수 

    //(3) void show()    인스턴스메서드 -hea area - new 생성자 - this 각각
    void show() { 
        this.a = 11; 
        System.out.println(this.a); 
    }

    //(4) static void classMethod()  클래스 메서드 - method area - new x - 공용
    static void classMethod() { /*this.a = 12;*/ }  //# static은 this.a  인스턴스사용불가

    //(5) int showZ()  인스턴스메서드
    int showZ() { 
        int a = 0;   //# 지역변수   지역변수는 수동으로 초기화
        return a; 
    }
}

public class Day024 {

	public static void main(String[] args) {
		int a = 0; 
		System.out.println(a);

	}

}
