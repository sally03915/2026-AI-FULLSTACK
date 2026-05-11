package com.the703.days;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

//1. DTO
class Player {
	private String name;
	private int score;
	
	public Player() { super(); }
	public Player(String name, int score) { super(); this.name = name; this.score = score; }
	@Override public String toString() { return "Player [name=" + name + ", score=" + score + "]"; }
	
	@Override public int hashCode() { return Objects.hash(name, score); }
	@Override public boolean equals(Object obj) { if (this == obj) return true; if (obj == null) return false; if (getClass() != obj.getClass()) return false; Player other = (Player) obj; return Objects.equals(name, other.name) && score == other.score; }
	
	public String getName() { return name; } 
	public void setName(String name) { this.name = name; } 
	public int getScore() { return score; } 
	public void setScore(int score) { this.score = score; }  
}

public class Day029 {
	public static void main(String[] args) {  
		//List : 기차  (순서o, 중복o) add, get, size, remove, contains
		//Q3. 순서o, 중복o
		List<Player> players = new ArrayList<>();
		players.add(new Player("Mario", 1200)); 
		players.add(new Player("Luigi", 1500));
		players.add(new Player("Peach", 1800));
		players.add(new Player("Bowser", 900));
		players.add(new Player("Bowser", 900));
		
		for(int i=0; i<players.size(); i++) {
			Player p = players.get(i); System.out.printf("%d    %s    %d  \n" , i+1 , p.getName(), p.getScore() );
		}
		
		System.out.println();		System.out.println();
		//Set  : 주머니 (순서x, 중복x) add, put, size, remove, contains
		Set<Player> setPlayers = new HashSet<>();
		setPlayers.add(new Player("Mario", 1200)); 
		setPlayers.add(new Player("Luigi", 1500));
		setPlayers.add(new Player("Peach", 1800));
		setPlayers.add(new Player("Bowser", 900));
		setPlayers.add(new Player("Bowser", 900));
		
		Iterator<Player> iter = setPlayers.iterator(); //1. 줄을 서시오.
		int i=0;
		while(  iter.hasNext() ) { //2. 처리대상의 유무
			Player p = iter.next(); //3. 한개씩 꺼내오기
			System.out.printf("%d    %s    %d  \n" , ++i , p.getName(), p.getScore() );
		}
		System.out.println();		System.out.println();
		
		//Map  : 기차  (key:value-쌍-엔트리) put, get(key), size, remove, contains
		HashMap<String, Player> mapPlayers = new HashMap<>();
		mapPlayers.put("mario", new Player("Mario", 1200));
		mapPlayers.put("luigi", new Player("Luigi", 1500));
		mapPlayers.put("peach", new Player("Peach", 1800));
		mapPlayers.put("bowser", new Player("Bowser", 900));
		
		for( Entry<String, Player> e:    mapPlayers.entrySet()) {
			System.out.println(e.getKey() + "\t" + e.getValue().getName() + "\t" + e.getValue().getScore());
		}
				
		//		Q6. 정렬 문제
		//		6-1. List코드에서 익명 클래스로 점수 오름차순 정렬
		players.sort(new Comparator<Player>() {
			@Override public int compare(Player o1, Player o2) 
				  { return Integer.compare(o1.getScore(), o2.getScore()); }  //오름차순
			 	  //{ return Integer.compare(o2.getScore(), o1.getScore()); }  //내림차순
		});  // Comparator<? super Player> c
		
		
		for(int i1=0; i1<players.size(); i1++) {
			Player p = players.get(i1); System.out.printf("%d    %s    %d  \n" , i1+1 , p.getName(), p.getScore() );
		}
		
		//		6-2. 람다식으로 점수 오름 정렬
		players.sort(( o1,  o2)-> Integer.compare(o1.getScore(), o2.getScore())   );   //## 람다
		
		for(int i1=0; i1<players.size(); i1++) {
			Player p = players.get(i1); System.out.printf("%d    %s    %d  \n" , i1+1 , p.getName(), p.getScore() );
		}
 
		//		6-3. 메서드 참조로 점수 오름차순 정렬	
		players.sort( Comparator.comparingInt( Player::getScore ) );     //## 참조
		
		for(int i1=0; i1<players.size(); i1++) {
			Player p = players.get(i1); System.out.printf("%d    %s    %d  \n" , i1+1 , p.getName(), p.getScore() );
		}
		 
	}
}

////////////////////////////////////
//// 1. 신의 손~~! (5분)  → now~! 개인카톡 보내주세요~~! 
///   ( 수정:44 , 보라, 주엽,욱진, 윤정 : 46 )
//// 2. 해결사 도전~!   내 친구 코드 버그 해결 횟수 ( 디버깅 마스터 )
//// 3. 블로그왕 도전~!  작성한 학습 블로그 글 수   (   블로그왕   )
//// 4. 개발마스터? 엔젤?
/*
Q1. Player DTO 클래스 만들기
속성:
private String name;
private int score;

Q2. List (ArrayList) 출력
2-1. players 이름으로 ArrayList 만들기
2-2. 데이터 추가:
new Player("Mario", 1200),
new Player("Luigi", 1500),
new Player("Peach", 1800),
new Player("Bowser", 900)
new Player("Bowser", 900)

2-3. for + size 이용해서 출력

출력 예시
1   Mario    1200
2   Luigi    1500
3   Peach    1800
4   Bowser   900
5   Bowser   900

Q3. List에서 출력을 보면 Bowser   900  라는 같은데이터를 넣었는데 2개가 나옴. 이유는?
4   Bowser   900
5   Bowser   900


Q4. Set (HashSet) 출력
4-1. setPlayers 이름으로 HashSet 만들기
4-2. 동일한 데이터 넣기 (중복 허용 안됨)
4-3. Iterator 이용해서 출력
출력 예시
1   Mario    1200
2   Luigi    1500
3   Peach    1800
4   Bowser   900

Q5. Map (HashMap) 출력
5-1. mapPlayers 이름으로 HashMap 만들기
5-2.  데이터 넣기 (Key-Value 구조)
mapPlayers.put("mario", new Player("Mario", 1200));
mapPlayers.put("luigi", new Player("Luigi", 1500));
mapPlayers.put("peach", new Player("Peach", 1800));
mapPlayers.put("bowser", new Player("Bowser", 900));
5-3. for-each + entrySet 이용해서 출력
출력 예시
mario   Mario    1200
luigi   Luigi    1500
peach   Peach    1800
bowser  Bowser   900

Q6. 정렬 문제
6-1. List코드에서 익명 클래스로 점수 오름차순 정렬
6-2. 람다식으로 점수 오름차순 정렬
6-3. 메서드 참조로 점수 오름차순 정렬

출력 예시 (오름차순)
코드
Bowser   900
Bowser   900
Mario    1200
Luigi    1500
Peach    1800
*/