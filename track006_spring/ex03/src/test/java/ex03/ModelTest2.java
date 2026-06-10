package ex03;

import java.net.UnknownHostException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.UserDto;
import com.the703.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  //1. spring 구동테스트
//@ContextConfiguration(locations = "classpath:config/*-context.xml")  //2. 설정
@ContextConfiguration(
	locations = {"classpath:config/root-context.xml" , "classpath:config/security-context.xml"})
public class ModelTest2 {
	@Autowired  UserMapper user;
	@Autowired  UserService service;
	@Autowired  @Qualifier("passwordEncoder") PasswordEncoder  pwencoder;
	// import  org.springframework.security.crypto.password.PasswordEncoder;
	
	/*  security		*/
	@Test  public void test4() { 
		//		AuthDto dto2 = new AuthDto();    dto2.setEmail("a@a");
		//		System.out.println(  service.readAuth(dto2));
		
		System.out.println(service.findByEmailUserInfo("a@a"));
	}
	
	@Ignore @Test  public void test3() { 
		/* 로그인시 인가 */
		AuthDto dto2 = new AuthDto();    dto2.setEmail("a@a");
		System.out.println(  user.readAuth(dto2));
		
		/* 권한2개 줬으면 주석달고 위에 해당유저정보가져오기 */
		/* 권한2개 - 회원, ADMIN */
		AuthDto dto1 = new AuthDto();    dto1.setEmail("a@a");  dto1.setAuth("ROLE_MEMBER");
		//AuthDto dto1 = new AuthDto();    dto1.setEmail("a@a");  dto1.setAuth("ROLE_ADMIN");
		System.out.println( user.insertAuth(dto1));    // ROLE_MEMBER  ,  ROLE_ADMIN
		
		/*  회원가입시 암호화 성공했으면 주석달고 위에 권한실행 */
		/*  회원가입  (암호화)  pwencoder.encode("a") */
		UserDto dto = new UserDto();
		dto.setNickname("a");   	dto.setBpass(  pwencoder.encode("a") );    
		dto.setEmail("a@a");   		dto.setMobile("0101111111"); 
		System.out.println(service.insert(dto)); 
	}    // 
	
	
	@Ignore @Test public void test2() throws UnknownHostException {
		//이메일중복 : findByEmail  - email
			System.out.println(user.findByEmail("first@gmail.com"));  
 	
	    //마이페이지 : findByUno    - uno
			System.out.println(service.findByUno(9));  //갖고있는 유저번호
    		
		//로그인    : findLogin     email=#{email}  and  bpass=#{bpass}
			UserDto dto2 = new UserDto();
			dto2.setBpass("1111");   dto2.setEmail("first@gmail.com");
			System.out.println(  service.findLogin(dto2));
		
		
		//회원가입   :  insert    - UserDto : nickname ,bpass, email , mobile, bip 
			UserDto dto = new UserDto();
			dto.setNickname("first");   			dto.setBpass("1111");    
			dto.setEmail("first@gmail.com");   		dto.setMobile("0101111111"); 
			System.out.println(service.insert(dto));
	}	
	
	
	@Ignore @Test public void test1() throws UnknownHostException {
		//이메일중복 : findByEmail  - email
		System.out.println(user.findByEmail("first@gmail.com"));  
		
		//마이페이지 : findByUno    - uno
		System.out.println(user.findByUno(8));  //갖고있는 유저번호
		
		//로그인    : findLogin     email=#{email}  and  bpass=#{bpass}
		UserDto dto2 = new UserDto();
		dto2.setBpass("1111");   dto2.setEmail("first@gmail.com");
		System.out.println(  user.findLogin(dto2));
		
		
		//회원가입   :  insert    - UserDto : nickname ,bpass, email , mobile, bip 
		//		UserDto dto = new UserDto();
		//		dto.setNickname("first");   			dto.setBpass("1111");    
		//		dto.setEmail("first@gmail.com");   		dto.setMobile("0101111111");
		//		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		//		System.out.println(user.insert(dto));
	}
}

