package com.the703.basic014_ex;

import java.util.ArrayList;
import java.util.List;

//1. 동적배열 : 콜렉션프레임워크
//   List, Set, Map
//   List(기차) : 순서(index) o, 중복 o
//   add, get, size, remove, contains
public class ListEx001 {
	public static void main(String[] args) {
	   List<String> colors = new ArrayList<>();
	   colors.add("red");  colors.add("green");  colors.add("blue");  //colors.add("blue");

	   System.out.println(colors.get(0));
	   System.out.println(colors.get(1));
	   System.out.println(colors.get(2));
	   
	   System.out.println();
	   for(int i=0; i<colors.size(); i++)
	   { System.out.println(colors.get(i)); }

	   System.out.println();
	   for( String c : colors ){  System.out.println(c);  }
	}
}
/*
연습문제1)  Collection  Framework
패키지명 : com.the703.basic014_ex
클래스명 : ListEx001
다음과 같이 코드를 작성하시오.
 1. ArrayList이용해서 colors 만들기
 2. red, green, blue 데이터 추가
 3. 출력

red
green
blue

*/