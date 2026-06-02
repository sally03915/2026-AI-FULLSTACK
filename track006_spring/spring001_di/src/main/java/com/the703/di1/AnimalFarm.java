package com.the703.di1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class AnimalFarm {
	private String name;
	private Animal ani; 
	
	public String aniSleep() {  return name + ">" + ani.sleep(); }
	public String aniEat()   {  return name + ">" + ani.eat();   }
	public String aniPoo()   {  return name + ">" + ani.poo();   }
	
	public void print() {
		System.out.println( aniSleep() );
		System.out.println( aniEat()   );
		System.out.println( aniPoo()   );
	}
}
