package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MapEx001 {
	public static void main(String[] args) {
		// put, get, size, remove, contain
		Scanner scanner = new Scanner(System.in);
		Map<String, String> map = new HashMap<>();
		map.put("피구왕", "통키");
		map.put("제빵왕", "김탁구");
		map.put("요리왕", "비룡");
		
		System.out.println("==============================\r\n"
				+ "KING   NAME\r\n"
				+ "==============================");
		for( Entry<String, String> m  :  map.entrySet()) {
			System.out.printf("%s    %s\n" , m.getKey() , m.getValue());
			System.out.println("-----------------------------");
		}
		
		System.out.println("KING의 정보를 제공중입니다\n이름을 입력하세요>");
		String king = scanner.next(); 
		
		System.out.println( map.containsKey(king) ? 
				"ㅁ" + king+":"+ map.get(king) : "찾으시는 왕이 없어요~!");
		//		※ 만약 key가 있다면.... key를 주면 value값을 줄께......
		//      ※ if( map.containsKey(사용자가 입력한값) ){  map.get(key값)  } 
	}
}

/*
연습문제1)  Collection  Framework
패키지명 : com.the703.basic014_ex
클래스명 : MapEx001
1. MAP 만들기
KEY   VALUE
피구왕   통키
---------------------
제빵왕   김탁구
---------------------
요리왕   비룡

Map<String, String> map = new HashMap<>();

2 다음과 같이 문제풀기
2-1. 다음과 같이 출력
2-2. 사용자에게 KING의 이름을 입력받아 해당하는 값 출력
==============================
KING   NAME
==============================
피구왕   통키
---------------------
제빵왕   김탁구
---------------------
요리왕   비룡
---------------------
KING의 정보를 제공중입니다
이름을 입력하세요> 제빵왕

ㅁ제빵왕 : 김탁구

*/