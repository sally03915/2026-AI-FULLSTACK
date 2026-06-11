package com.the703.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.the703.dto.BoardDto;

public interface BoardService { 
	public List<BoardDto>  selectAll(); 
	public int             insert(BoardDto  dto , MultipartFile file); 
	public BoardDto        detail(int bno); 
	public BoardDto        editView(int bno); 
	public int             edit(BoardDto  dto , MultipartFile file); 
	public int             delete(BoardDto  dto); 
	/* paging */
	/* paging */
	public List<BoardDto>  select10(int  pstartno);
	public int             selectCnt();
}




