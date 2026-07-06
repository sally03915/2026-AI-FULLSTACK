package com.the703.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.the703.dao.Sboard2Dao;
import com.the703.dto.Sboard2Dto;
import com.the703.util.UtilUpload;

@Service
public class Sboard2SeriveImpl  implements Sboard2Service{
	@Autowired  Sboard2Dao  dao;
	@Autowired  UtilUpload  upload;
	
	//1. 전체페이징 ( 페이징 )
	@Override public List<Sboard2Dto> list10(int pageNo) { // (1) 0,10   (2) 10,10
		//ver-1  oracle 11이전  (    (1) 1,10   (2) 11,10    )
		//ver-2  oracle 12이후  (    (1) 0,10   (2) 10,10    ) 
		HashMap<String, Object> para = new HashMap<>();
		para.put("start",   (pageNo-1)*10);
		para.put("end"  ,   10           );
		return dao.selectPaging(para);
	}
	//2. 갯수카운드
	@Override public int selectCnt() { return dao.selectCnt(); }
	
	//3. 상세조회 ( 조회수올리기)
	@Transactional     
	@Override public Sboard2Dto detail(Sboard2Dto dto) { 
		dao.updateHit(dto);
		return dao.selectById(dto);
	}
	
	//4. 입력기능 ( 이미지 올리기 )
	@Override public int insert(MultipartFile file, Sboard2Dto dto) {
		// 이미지 업로드기능
		
		
		if(!file.isEmpty()) {
			try { dto.setBfile( upload.fileUpload(file)  ); } 
			catch (IOException e) { e.printStackTrace(); }
		}
		// ip셋팅
		try { dto.setBip(InetAddress.getLocalHost().getHostAddress()); } 
		catch (UnknownHostException e) { e.printStackTrace(); }
		
		return dao.insert(dto); 
	}
	//5. 수정폼
	@Override public Sboard2Dto updateForm(Sboard2Dto dto) { return dao.selectById(dto); }
	
	//6. 수정기능 ( 이미지 올리기 )
	@Override public int update(MultipartFile file, Sboard2Dto dto) {
		// 이미지 업로드기능
		if(!file.isEmpty()) {
			try { dto.setBfile( upload.fileUpload(file)  ); } 
			catch (IOException e) { e.printStackTrace(); }
		}
		return dao.update(dto);
	}
	//7. 삭제기능
	@Override public int delete(Sboard2Dto dto) { return dao.delete(dto); }

}




