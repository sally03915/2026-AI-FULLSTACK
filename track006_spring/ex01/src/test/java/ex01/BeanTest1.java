package ex01;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.company.ioc1.IceCreamShop;

@RunWith(SpringJUnit4ClassRunner.class)   //spring 구동
@ContextConfiguration(locations = "classpath:config/test1.xml")  // 위치설정
public class BeanTest1 {
	
	@Autowired  ApplicationContext  context;  //1. bean (스프링이 관리하는 객체들)
	//2. ApplicationContext - bean 생성부터 소멸까지 관리
	//3. @Autowired   생성자, 프로퍼티가 있는지 테스트하고 자동연결, 적용
	@Test 
	public void test1() {
	    IceCreamShop shop = (IceCreamShop) context.getBean("shop");
	    shop.print();
	}
}
