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
public class Sboard2ServiceImpl implements Sboard2Service { 
	@Autowired Sboard2Dao  dao;
	@Autowired UtilUpload  upload;

	@Override public int insert(MultipartFile file, Sboard2Dto dto) { 
		if(!file.isEmpty()) {
			try { dto.setBfile(  upload.fileUpload(file)  ); }
			catch (IOException e) { e.printStackTrace(); }
		}
		try { dto.setBip( InetAddress.getLocalHost().getHostAddress() ); }
		catch (UnknownHostException e) { e.printStackTrace(); }
		return dao.insert(dto); 
	}
	
	@Override public int update(MultipartFile file, Sboard2Dto dto) {
		if(!file.isEmpty()) {
			try { dto.setBfile(  upload.fileUpload(file)  ); }
			catch (IOException e) { e.printStackTrace(); }
		}
		return dao.update(dto); 
	}
	
	@Override public int delete(Sboard2Dto dto) { return dao.delete(dto); }
	
	@Override public List<Sboard2Dto> selectAll() { return dao.selectAll(); }
	@Transactional
	@Override public Sboard2Dto select(int id) { dao.updateHit(id);  return dao.select(id); }
	@Override public Sboard2Dto selectUpdateForm(int id) { return dao.select(id); }

	/* paging */
	@Override
	public List<Sboard2Dto> select10(int pageNo) {  //(1)1,10 , (2) 11,20 (3) 21,30
		HashMap<String,Integer>   para = new HashMap<>();
		int start = (pageNo-1)*10 + 1;  //(1)1    (2)11  (2)21
		int end   = start + 9;
		
		para.put("start", start);
		para.put("end"  , end);
		return dao.select10(para);
	}

	@Override public int selectTotalCnt() { return dao.selectTotalCnt(); }
	
	/* Paging + Search */
	@Override
	public List<Sboard2Dto> select3(String keyword, int pageNo) {
		HashMap<String, Object> para = new HashMap<>();
		//  11-1 (10/10 = 1) 20-1(19/10 = 1)
		int pageSize=3; //3개씩의 페이지
		// 1: start→1, end→3   2: start→4, end→6   3: start→7, end→9 
		para.put("search", keyword);
		int start = (pageNo-1)*pageSize+1;
		para.put("start", start);   // 1→1    2→4 (2-1)*3+1   3→7 (3-1)*3+1
		para.put("end"  , start + pageSize-1);   //4→6 (4+3-1)   , 7→9  (7+3-1)
		return dao.select3(para);
	}

	@Override 
	public int selectSearchTotalCnt(String keyword) { return dao.selectSearchTotalCnt(keyword); }

}







