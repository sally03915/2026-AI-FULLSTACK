package com.the703.basic017;

public class StringStringBuffer {
	public static void main(String[] args) {
		//#1. String
		String str = "ABC";
		System.out.println("1. str 주소 > " + str + " " + System.identityHashCode(str));
		//									1. str 주소 > ABC 1521118594
		str += "D";
		System.out.println("2. str 주소 > " + str + " " + System.identityHashCode(str));
		//									2. str 주소 > ABCD 1156060786
		//#2. StringBuffer
		StringBuffer sb = new StringBuffer();
		sb.append("ABC");
		System.out.println("3. sb 주소 > " + sb + " " + System.identityHashCode(sb));
		//								    3. sb 주소 > ABC 1709537756	
		sb.append("D");
		System.out.println("4. sb 주소 > " + sb + " " + System.identityHashCode(sb));
		//								    4. sb 주소 > ABCD 1709537756
	}
}
