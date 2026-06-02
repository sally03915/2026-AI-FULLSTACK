package com.the703.di2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 

@Component("animalFarm")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class AnimalFarm {
	@Value("poppi")
	private String name;
	
	@Autowired  @Qualifier("dog")
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
