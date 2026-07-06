package com.the703.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.the703.dto.Sboard2Dto;

@Mapper
public interface Sboard2Dao {
	public  int   		      insert(Sboard2Dto   dto);
	public  List<Sboard2Dto>  selectAll();
	public  List<Sboard2Dto>  selectPaging(HashMap<String, Object> para);
	public  int               selectCnt();
	public  Sboard2Dto        selectById(Sboard2Dto  dto);
	public  int               updateHit( Sboard2Dto  dto);
	public  int               update(    Sboard2Dto  dto);
	public  int               delete(    Sboard2Dto  dto);
} 
