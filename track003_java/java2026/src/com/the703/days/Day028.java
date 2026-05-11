package com.the703.days;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
// 생성자 , toString, hashCode/equals, getters/setters
class Milk{
	private String mname; 
	private int    mprice;
	
	public Milk() { super(); }
	public Milk(String mname, int mprice) { super(); this.mname = mname; this.mprice = mprice; }
	@Override public String toString() { return "Milk [mname=" + mname + ", mprice=" + mprice + "]"; }
	
	// 클래스 확인
	@Override public int hashCode() { return Objects.hash(mname, mprice); }
	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Milk other = (Milk) obj;
		return Objects.equals(mname, other.mname) && mprice == other.mprice;
	}
	public String getMname() { return mname; } 
	public void setMname(String mname) { this.mname = mname; }
	public int getMprice() { return mprice; } 
	public void setMprice(int mprice) { this.mprice = mprice; } 
	
}
public class Day028 {
	public static void main(String[] args) { 
		//List( 기차 ) 순서o, 중복o  add, get, size, remove, contains  
		List<Milk>  milks = new ArrayList<>();
		milks.add(new Milk("바나나우유", 1300)); 
		milks.add(new Milk("메론맛우유", 1800)); 
		milks.add(new Milk("커피우유", 1500)); 
		milks.add(new Milk("커피우유", 1500));  
		
		for(int i=0; i<milks.size(); i++) {
			System.out.printf("%d     %s    %d\n" , i+1, milks.get(i).getMname(),  milks.get(i).getMprice());
		}
		System.out.println(); System.out.println();
		
		int i=0;
		for(Milk m :   milks) { System.out.printf("%d     %s    %d\n" , ++i, m.getMname(),  m.getMprice()); }

		// 오름차순 
		System.out.println("\n\n가격순으로 오름차순");
		
		
		//1. 익명적객체
		//		milks.sort(  new  Comparator<Milk>() {
		//			@Override public int compare(Milk o1, Milk o2) { 
		//				return Integer.compare(o1.getMprice(), o2.getMprice()); 
		//			}
		//		});
		
		//2. 람다식
		// milks.sort( (o1, o2)-> Integer.compare(o1.getMprice(), o2.getMprice())        );
		// @FunctionalInterface	   public interface Comparator<T> { int compare(T o1, T o2);  }
		 
		//3. 참조형   Integer 부품객체에 compare라는 기능박스
		// error :  milks.sort(  Integer::compare      );  Milk 객체에서 가격 꺼내야함.
		milks.sort(  Comparator.comparingInt(Milk::getMprice)  );
		
		i=0;
		for(Milk m :   milks) { System.out.printf("%d     %s    %d\n" , ++i, m.getMname(),  m.getMprice()); }
		//  void java.util.List.sort( Comparator<? super Milk> c )
		//  리턴값 void (안에서 알아서처리)
		//  Comparator<? super Milk> c   -  Comparator 비교 부품객체  <? super Milk> Milk 포함한 부모객체

		
		

		System.out.println(); System.out.println();
		
		//Set( 주머니 ) 순서x, 중복x  add, for , size, remove, contains  
		Set<Milk>  sets = new HashSet<>(); 
		sets.add(new Milk("바나나우유", 1300)); 
		sets.add(new Milk("메론맛우유", 1800)); 
		sets.add(new Milk("커피우유", 1500)); 
		sets.add(new Milk("커피우유", 1500));   
		i=0;
		Iterator<Milk>  iter = sets.iterator();  //줄을서시오
		while(iter.hasNext()) { // 처리대상확인
			Milk  m = iter.next();
			System.out.printf("%d     %s    %d\n" , ++i, m.getMname(),  m.getMprice()); 
		} 
		System.out.println(); System.out.println();
		
		i=0;
		for(Milk m :   sets) { 
			System.out.printf("%d     %s    %d\n" , ++i, m.getMname(),  m.getMprice()); 
		}
 		 
		System.out.println();  System.out.println();
		
		// Key (사전 :  key:value(쌍))  put , get(key) ,  size, remove, containsKey , containsValue , entrySet, keySet
		Map<String, Milk>  maps = new HashMap<>(); 
	    maps.put("banana" , new Milk("바나나우유", 1300));  
	    maps.put("melon"  , new Milk("메론맛우유", 1800));  
	    maps.put("coffee" , new Milk("커피우유", 1500));  
	    maps.put("coffee2", new Milk("커피우유", 1500));  
 
	    for(String key : maps.keySet()) { 
			System.out.printf("%s     %s    %s\n" ,key, maps.get(key).getMname(),  maps.get(key).getMprice()); 
	    } 
	    for(Entry<String, Milk>  e : maps.entrySet()) {  //  e.getKey(), e.getValue()
			System.out.printf("%s     %s    %s\n" , 
							  e.getKey(), e.getValue().getMname(),  e.getValue().getMprice()); 
	    }
	    
	    
	    
	}
}


/*

Q1. 빈칸 채우기
1. List는 순서가 [  있는  O ] 구조로 데이터를 관리하며, 중복을 [허용 O]
    - 주요 메서드: add, get, size, remove, contains  → 기차
2. Set은 순서가 [ 없는X ] 구조로 데이터를 관리하며,  중복을 [허용안함X]
    - 주요 메서드: add, get(X) 향상된 for /iterator , size, remove, contains  → 주머니
3. Map은 [key]와 [value]의 쌍으로 데이터를 관리한다. 
    - 주요 메서드: put, get(key) , size, remove, containsKey , containsValue , entrySet, keySet



Q2. ArrayList, HashSet, HashMap을 작성하시오.  
1. Milk Dto 클래스 만들기  
   - 속성 : private String mname; private int mprice  

2. milks 이름으로 ArrayList 만들기  
3. 다음의 데이터 넣기  
   new Milk("바나나우유", 1300),  
   new Milk("메론맛우유", 1800),  
   new Milk("커피우유", 1500),  
   new Milk("커피우유", 1500)  
4. for + size 이용해서 데이터 출력  
```
1     바나나우유       1300
2     메론맛우유       1800
3     커피우유         1500
4     커피우유         1500
```
 
5. sets 이름으로 HashSet 만들기  
6. 다음의 데이터 넣기  
   new Milk("바나나우유", 1300),  
   new Milk("메론맛우유", 1800),  
   new Milk("커피우유", 1500),  
   new Milk("커피우유", 1500)  
7. Iterator 이용해서 데이터 출력   
```
1     바나나우유       1300
2     메론맛우유       1800
3     커피우유         1500
```
 
8. maps 이름으로 HashMap 만들기  
9. 다음의 데이터 넣기 (Key-Value 구조)  
   maps.put("banana", new Milk("바나나우유", 1300));  
   maps.put("melon", new Milk("메론맛우유", 1800));  
   maps.put("coffee", new Milk("커피우유", 1500));  
   maps.put("coffee2", new Milk("커피우유", 1500));  

10. for-each + keySet 이용해서 데이터 출력  
```
banana    바나나우유       1300
melon     메론맛우유       1800
coffee    커피우유         1500
coffee2   커피우유         1500
``` 

*/