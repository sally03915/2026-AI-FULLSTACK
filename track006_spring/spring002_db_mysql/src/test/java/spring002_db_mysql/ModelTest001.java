package spring002_db_mysql;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.TestMapper;
import com.the703.dao.UserInfoMapper;
import com.the703.dto.UserInfoDto;

@RunWith(SpringJUnit4ClassRunner.class)  //1. spring 구동
@ContextConfiguration(locations = "classpath:config/root-context.xml")  //2. 설정파일

public class ModelTest001 {
	@Autowired ApplicationContext  context;  //3.  Bean (스프링이 관리하는 객체) 생성~소멸
	@Autowired DataSource       dataSource; 
	@Autowired SqlSession       sqlSession;
	@Autowired TestMapper       test;	
	
	@Autowired UserInfoMapper   userinfo;
	
	@Test
	public void test6(){
		//5. 삭제
		System.out.println(  userinfo.delete(46)  );
		
		//4. 수정
		UserInfoDto dto = new UserInfoDto();  dto.setEmail("hello@gmail.com"); dto.setAge(100); dto.setNo(46);
		System.out.println(userinfo.update(dto));		
		
		//3. 한명검색
		System.out.println(  userinfo.select(46)   );
		//2. 삽입
		//UserInfoDto dto = new UserInfoDto();  dto.setEmail("hi@gmail.com");  dto.setAge(10);
		//System.out.println(userinfo.insert(dto));
		//1. 전체검색
		//System.out.println( userinfo.selectAll() );
	}
	 
	
	@Ignore   //@Test
	public void test1() { System.out.println(context);  }
	
	@Ignore   //@Test
	public void test2() { System.out.println(dataSource);  }
	
	@Ignore   //@Test
	public void test3() { System.out.println(sqlSession);  }
	
	@Ignore   //@Test
	public void test4() { System.out.println(test.now());  }
}
