package com.the703.di1; 
public class Cat  implements Animal{ 
	@Override public String eat() {   return "Cat-eat"; }
	@Override public String sleep() { return "Cat-sleep"; }
	@Override public String poo() {   return "Cat-poo"; } 
}
