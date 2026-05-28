package com.the703.servlet;

public class Java001 {
	private int a;
	private int b;
	
	public Java001() { super(); }
	public Java001(int a, int b) { super(); this.a = a; this.b = b; }
	@Override public String toString() { return "Java001 [a=" + a + ", b=" + b + "]"; }
	
	public int getA() { return a; } 
	public void setA(int a) { this.a = a; }
	public int getB() { return b; } 
	public void setB(int b) { this.b = b; }
}
