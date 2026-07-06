package com.the703.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.the703.dto.Sboard2Dto;

public interface Sboard2Service {
	//1. 전체페이징 ( 페이징 )
	public List<Sboard2Dto>  list10(int pageNo);
	//2. 갯수카운드
	public int               selectCnt();
	//3. 상세조회 ( 조회수올리기)
	public Sboard2Dto        detail(Sboard2Dto dto);
	//4. 입력기능 ( 이미지 올리기 )
	public int insert( MultipartFile file, Sboard2Dto dto);
	//5. 수정폼
	public Sboard2Dto        updateForm(Sboard2Dto dto);
	//6. 수정기능 ( 이미지 올리기 )
	public int update( MultipartFile file, Sboard2Dto dto);
	//7. 삭제기능
	public int               delete(Sboard2Dto dto);
}
