package com.the703.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.the703.dto.Sboard2Dto;

@Mapper
public interface Sboard2Dao {
	public int insert(Sboard2Dto dto);
	public int update(Sboard2Dto dto);
	public int updateHit(int id);
	public int delete(Sboard2Dto dto);
	public List<Sboard2Dto>  selectAll();
	public Sboard2Dto        select(int id);
	public List<Sboard2Dto>  select10(HashMap<String,Integer> para);
	public int               selectTotalCnt();
	public List<Sboard2Dto>  select3(  HashMap<String,Object> para);  //##
	public int               selectSearchTotalCnt(String search);//##
}


/*
Q3.  Dao 
    SQL>
    SQL> desc sboard2;
    Name                                      Null?    Type
    ----------------------------------------- -------- ----------------------------
    ID                                        NOT NULL NUMBER
    APP_USER_ID                               NOT NULL NUMBER
    BTITLE                                    NOT NULL VARCHAR2(1000)
    BCONTENT                                  NOT NULL CLOB
    BPASS                                     NOT NULL VARCHAR2(255)
    BFILE                                              VARCHAR2(255)
    BHIT                                               NUMBER
    BIP                                       NOT NULL VARCHAR2(255)
    CREATED_AT                                         DATE
    
    1. 테이블
    CREATE TABLE sboard2 (
	  id NUMBER PRIMARY KEY,
	  app_user_id NUMBER NOT NULL,
	  btitle VARCHAR2(1000) NOT NULL,
	  bcontent CLOB NOT NULL,
	  bpass VARCHAR2(255) NOT NULL,
	  bfile VARCHAR2(255) DEFAULT '0.png',
	  bhit NUMBER DEFAULT 0,
	  bip VARCHAR2(255) NOT NULL,
	  created_at DATE  default sysdate
	); 
	create sequence sboard2_seq;
    
    2. dto
    3. dao / mapper작성
    4. 테스트
*/