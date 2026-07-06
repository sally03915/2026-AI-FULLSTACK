package com.the703;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.the703.dao.Sboard2Dao;
import com.the703.dao.TestDao;
import com.the703.dto.Sboard2Dto;
import com.the703.service.Sboard2Service;

@SpringBootTest
class Boot1ApplicationTests {
	
	@Autowired  TestDao  dao;  // ctrl + shift + o
	@Autowired  Sboard2Dao  	sboard2Dao;
	@Autowired  Sboard2Service  sboard2Service;
	
	@Disabled @Test  public void test010_delete() {   
		Sboard2Dto  dto = new Sboard2Dto();
		dto.setId(41); // 있는 id
		assertEquals(1, sboard2Service.delete(dto));     
	} 
	// 41
	@Disabled  @Test  public void test09_update() {   
		Sboard2Dto  dto = new Sboard2Dto();
		dto.setAppUserId(1);   dto.setBtitle("title-new");  dto.setBcontent("content-new");
		dto.setBpass("1111");  dto.setId(41);
	
		MockMultipartFile file = new   MockMultipartFile("file" , "test.txt" , "text/plain" , "data".getBytes());
		// import org.springframework.mock.web.MockMultipartFile;
		int result = sboard2Service.update(file, dto); 
		assertEquals(1, result);    
	} 
	 
	@Disabled  @Test  public void test08_detail() {   
		Sboard2Dto  dto = new Sboard2Dto();
		dto.setId(41);
		assertEquals(41, sboard2Service.detail(dto).getId());     
	} 
	
	
	
	@Disabled  @Test  public void test07_service_paging() {   
		 assertEquals(7, sboard2Service.list10(1).size());  
		 
		 assertEquals(7, sboard2Service.selectCnt());    
	} 
	
	@Disabled @Test  public void test06_service_insert() {  
		Sboard2Dto  dto = new Sboard2Dto();
		dto.setAppUserId(1);   dto.setBtitle("title");  dto.setBcontent("content");
		dto.setBpass("1111");   
	
		MockMultipartFile file = new   MockMultipartFile("file" , "test.txt" , "text/plain" , "data".getBytes());
		// import org.springframework.mock.web.MockMultipartFile;
		
		int result = sboard2Service.insert(file, dto); 
		assertEquals(1, result);    
	} 
	 
	
	/*									*/
	/*									*/
	/*									*/
	@Disabled @Test  public void test05_delete() { //삭제
		Sboard2Dto  dto = new Sboard2Dto();
		dto.setId(27);
		int result = sboard2Dao.delete(dto);
		assertEquals(1, result); 
	} 
	
	@Disabled @Test  public void test04_update() {//수정
		Sboard2Dto  dto = new Sboard2Dto(); 
		dto.setBtitle("title-new");  dto.setBcontent("content-new");
		dto.setBfile("1.png");       dto.setId(27); 
	
		int result = sboard2Dao.update(dto); 
		assertEquals(1, result);                   // 자동확인 :  결과물이 1인지 junit 체크
	}  
	
	@Disabled @Test  public void test03_byId()   {//id, 조회수올리기
		Sboard2Dto  dto = new Sboard2Dto();
		dto.setId(27);
		Sboard2Dto result = sboard2Dao.selectById(dto);
		assertEquals(27,  result.getId()); 
	}  
	
	@Disabled @Test  public void test02_paging() { //페이징, 갯수
		HashMap<String,Object>  para = new HashMap<>();
		para.put("start", 0);
		para.put("end", 10);
		List<Sboard2Dto> list10 = sboard2Dao.selectPaging(para);
		assertEquals(6,  list10.size());    // 6숫자는 지금 있는 list 의 갯수로  ( 예상되는 결과 , 해당코드 )
		assertNotNull(list10); 
		assertEquals(6,  sboard2Dao.selectCnt());  //  전체갯수 6개
	} 
	
	@Disabled @Test  public void  test01_Insert() throws UnknownHostException { //insert
		Sboard2Dto  dto = new Sboard2Dto();
		dto.setAppUserId(1);   dto.setBtitle("title");  dto.setBcontent("content");
		dto.setBpass("1111");  dto.setBfile("1.png");   dto.setBip(InetAddress.getLocalHost().getHostAddress());
	
		int result = sboard2Dao.insert(dto);
		System.out.println(".....1 > " + result);  // 기존방식 - 수동으로 값확인 :  콘솔에 1
		assertEquals(1, result);                   // 자동확인 :  결과물이 1인지 junit 체크
	}
	 
	// @Ignore - JUnit4
	@Test 
	void contextLoads() {
		System.out.println("..........................");
		System.out.println( dao.readTime());
		System.out.println("..........................");
	}

}


