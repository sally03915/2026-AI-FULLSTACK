package com.the703.basic014;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//1. 콜렉션 프레임워크 : [배열]의 단점을 개선한 [객체]만 저장가능 [동적배열]
//2. List, Set, Map
// List(기차)  - 순서o , 중복o / add, get, size,remove, contains
// Set(주머니)  - 순서x , 중복x / add,  향상된 for/ Iterator, size,remove, contains

public class Set001 { 
	public static void main(String[] args) {
		Integer i1 = 1; // 부품객체    = 기본값 
		int     i2 = i1;// 기본값      = 부품객체
		float   f  = i1.floatValue();
		//float   f2 = i2.floatValue();
		//Wrapper - Integer, Float, Double,,,
		System.out.println(i1 + " : \t" + i2 +  " : \t" + f  );
		
		Set<Integer>  set1 = new HashSet<>();
		// The constructor Integer(int) is deprecated since version 9
		set1.add( new Integer(1));   // Integer e = new Integer(1)   부품객체
		set1.add(1);  //  Integer e = 1     (기본값)
		set1.add(1);  //  부품객체    = 기본값 (Integer - wrapper클래스)
		set1.add(1);  //  기본값을 자동으로 - 객체화 - 부품객체( wrapper 클래스)
		set1.add(2);
		set1.add(3);

		System.out.println(set1);
		// add, get(x), size , remove, contains
		Set<Candy>  set2 = new HashSet<>();
		set2.add(  new Candy("츕파춥스" , 200));
		set2.add(  new Candy("츕파춥스" , 200));
		set2.add(  new Candy("츕파춥스" , 200)); 
		set2.add(  new Candy("청포도알사탕" , 4500)); 
		set2.add(  new Candy("아이셔"  , 1500)); 
		
		System.out.println(set2.size());
		System.out.println(set2.remove(new Candy("츕파춥스" , 200))? "냠냠~!" : "못먹었어!");
		System.out.println(set2.contains(new Candy("아이셔"  , 1500))? "겸둥꺼~" : "없어~!");
		System.out.println(set2);
		
		//set2.get
		for(Candy c :  set2) { System.out.println( c.name + "-" + c.price ); }
	} // end main
}// end class

class Candy{
	String name;
	int    price;
	
	public Candy() { super();  }
	public Candy(String name, int price) { super(); this.name = name; this.price = price; }
	@Override public String toString() { return "Candy [name=" + name + ", price=" + price + "]"; }
	
	@Override public int hashCode() { return Objects.hash(name, price); }
	@Override public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candy other = (Candy) obj;
		return Objects.equals(name, other.name) && price == other.price;
	}
	
	
}


