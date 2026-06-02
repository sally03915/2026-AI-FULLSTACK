package spring001_di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.di2.AnimalFarm; 


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(  locations = "classpath:config/beans2.xml" )
public class BeanTest2 {
	//  import org.springframework.context.ApplicationContext;
	@Autowired  ApplicationContext  context;
	
	@Test
	public void test() {  // Bean - 스프링이 관리하는 부품객체  
		AnimalFarm  animalFarm = (AnimalFarm)context.getBean("animalFarm");
		animalFarm.print();  //## 사용하기
		

//		AnimalFarm  animalFarm2 = (AnimalFarm)context.getBean("animalFarm2");
//		animalFarm2.print();  //## 사용하기
	} 
}
