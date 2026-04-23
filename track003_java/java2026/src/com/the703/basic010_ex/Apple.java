package com.the703.basic010_ex;

// private ( Apple 클래스내부 ) < default(package) 폴더 < protected 상속자식 < public 아무데서나
public class Apple {
	private String name;
	private int price;
	// 생성자- 기본생성자, 필드생성자, toString, getters+setters
	public Apple() { super();  }
	public Apple(String name, int price) { super(); this.name = name; this.price = price; }
	@Override public String toString() { return "Apple [name=" + name + ", price=" + price + "]"; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
}
