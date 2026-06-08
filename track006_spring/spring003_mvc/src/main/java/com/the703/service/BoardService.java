package com.the703.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.the703.dto.BoardDto;

public interface BoardService {
	//■1. 전체리스트   
	public List<BoardDto>  selectAll();
	//■2. 글쓰기 기능  
	public int             insert(BoardDto  dto , MultipartFile file);
	//■3. 글상세보기    - 조회수올리기 / 해당글 
	public BoardDto        detail(int bno);
	//■4. 글수정폼 경로  - 해당글
	public BoardDto        editView(int bno);
	//■4. 글수정 기능    - 비밀번호가 맞는지 확인 후 글수정
	public int             edit(BoardDto  dto , MultipartFile file);
	//■5. 글삭제 기능    - 비밀번호가 맞는지 확인 후 글삭제 
	public int             delete(BoardDto  dto);
	
	/* paging */
	/* paging */
	public List<BoardDto>  select10(int  pstartno);
	public int             selectCnt();
}




