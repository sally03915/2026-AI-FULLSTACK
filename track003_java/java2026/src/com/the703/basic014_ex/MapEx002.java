package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;

// 생성자(기본,필드) , toString,   hashCode + equals ,  setters+getters
class BookDto{
	private String title;  
	private String author;
	
	public BookDto() { super(); } 
	public BookDto(String title, String author) { super(); this.title = title; this.author = author; }
	@Override public String toString() { return "BookDto [title=" + title + ", author=" + author + "]"; }
	
	@Override public int hashCode() { return Objects.hash(author, title); }
	@Override public boolean equals(Object obj) { if (this == obj) return true; if (obj == null) return false; if (getClass() != obj.getClass()) return false; BookDto other = (BookDto) obj; return Objects.equals(author, other.author) && Objects.equals(title, other.title); }
	
	public String getTitle() { return title; } 
	public void setTitle(String title) { this.title = title; }
	public String getAuthor() { return author; } 
	public void setAuthor(String author) { this.author = author; }
	
}
public class MapEx002 { 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, BookDto> map = new HashMap<>();
		map.put("978-11111",  new BookDto("자바의 완성" , "가길동"));
		map.put("978-22222",  new BookDto("파이썬 기초" , "홍길동"));
		map.put("978-33333",  new BookDto("자료구조와 알고리즘" , "이순신"));
		 
		System.out.println("==============================\r\n" + "ISBN        TITLE        AUTHOR\r\n" + "==============================");
		for(String key :  map.keySet() ) {  //키들의 묶음
			System.out.printf("%s    %s    %s\n" , key , map.get(key).getTitle() , map.get(key).getAuthor());
			System.out.println("------------------------------");
		}

		for(Entry<String, BookDto> e :  map.entrySet() ) {  // 쌍(key:value)의 묶음
			System.out.printf("%s    %s    %s\n" , e.getKey() , e.getValue().getTitle() , e.getValue().getAuthor());
			System.out.println("------------------------------");
		}
		
		Iterator<Entry<String, BookDto>> iter =    map.entrySet().iterator();  // 반복자
	    while(iter.hasNext()) {
	    	Entry<String, BookDto> e  = iter.next();
			System.out.printf("%s    %s    %s\n" , e.getKey() , e.getValue().getTitle() , e.getValue().getAuthor());
			System.out.println("------------------------------");
	    }
	    System.out.print("도서 정보를 제공중입니다\r\n" + "ISBN을 입력하세요>");  String isbn = scanner.next();
	    System.out.println( map.containsKey(isbn)? 
	      "📖 선택한 도서 정보: "  + map.get(isbn).getTitle()+" / 저자: "  + map.get(isbn).getAuthor()  : "ISBN 확인바람"); 
	} 
}
/*
연습문제2)  Collection  Framework
패키지명 : com.the703.basic014_ex
클래스명 : MapEx002
1. MAP 만들기
KEY         VALUE
978-11111   new BookDto("자바의 완성" , "가길동")
---------------------
978-22222   new BookDto("파이썬 기초" , "홍길동")
---------------------
978-33333   new BookDto("자료구조와 알고리즘" , "이순신")

Map<String, BookDto> map = new HashMap<>();


2 다음과 같이 문제풀기
2-1. BookDto 만들기   {    private String title;  private String author;}
2-2. 다음과 같이 출력
2-3. 사용자에게 KING의 이름을 입력받아 해당하는 값 출력
==============================
ISBN        TITLE        AUTHOR
==============================
978-11111 | 자바의 완성 | 가길동
------------------------------
978-22222 | 파이썬 기초 | 홍길동 
------------------------------
978-33333 | 자료구조와 알고리즘 | 이순신 
------------------------------
도서 정보를 제공중입니다
ISBN을 입력하세요> 978-22222

📖 선택한 도서 정보: 파이썬 기초 / 저자: 홍길동

*/