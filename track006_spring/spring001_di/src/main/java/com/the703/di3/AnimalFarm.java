package com.the703.di3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 
import javax.annotation.Resource;


@Component("animalFarm")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class AnimalFarm {
	@Value("${name}")
	private String name;
	
	@Resource(name="${ani}")
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
