package ex02;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.BoardMapper;
import com.the703.dao.TestMapper;
import com.the703.dto.BoardDto;

@RunWith(SpringJUnit4ClassRunner.class)  //1. spring 구동테스트
@ContextConfiguration(locations = "classpath:config/root-context.xml")  //2. 설정
public class ModelTest { 
	@Autowired  ApplicationContext context;  //3. Bean ( 스프링이 관리하는 객체) 생성~소멸
	@Autowired  DataSource  dataSource;
	@Autowired  SqlSession  sqlSession; 
	@Autowired  TestMapper  testMapper;  
	
	@Autowired  BoardMapper  boardMapper;  
	
	@Test
	public void test4() throws UnknownHostException {
//		//삭제
//		System.out.println(boardMapper.delete(1));
//		//수정
//		BoardDto dto2 = new BoardDto();
//		dto2.setBname("first");        dto2.setBno(2);
//		dto2.setBtitle("첫번째 글쓰기-new");  dto2.setBcontent("내용-new"); 
//		System.out.println(boardMapper.update(dto2)); //실행한 줄수1
//		
//		//검색
//		System.out.println(boardMapper.select(1));
//		//삽입
//		BoardDto dto = new BoardDto();
//		dto.setBname("first");        dto.setBpass("1111");
//		dto.setBtitle("첫번째 글쓰기");  dto.setBcontent("내용");
//		dto.setBip(InetAddress.getLocalHost().getHostAddress()); //#1
//		System.out.println(boardMapper.insert(dto)); //실행한 줄수1
		//전체검색
		System.out.println(boardMapper.selectAll());
	}
	
	
	
	@Ignore @Test public void  test3() { System.out.println(testMapper.now());    }         
	@Ignore @Test public void  test1() { System.out.println(context);    } 
	@Ignore @Test public void  test2() { System.out.println(sqlSession); } 
}
