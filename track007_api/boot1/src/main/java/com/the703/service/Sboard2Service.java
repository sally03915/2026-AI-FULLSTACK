package com.the703.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.the703.dto.Sboard2Dto;
 
public interface Sboard2Service {
	public int insert(MultipartFile file , Sboard2Dto dto);
	public int update(MultipartFile file , Sboard2Dto dto);
	public int delete(Sboard2Dto dto);
	public List<Sboard2Dto>  selectAll();
	public Sboard2Dto        select(int id);  //조회수올리기 + 상세보기
	public Sboard2Dto        selectUpdateForm(int id);  //수정하기폼
	
	/* Paging */
	public List<Sboard2Dto> select10(int pageNo);
	public int  selectTotalCnt();
	
	/* Paging + Search */
	public List<Sboard2Dto>  select3( String keyword ,int pageNo);
	public int  selectSearchTotalCnt( String keyword );
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