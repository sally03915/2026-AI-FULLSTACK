-- 1.  데이터베이스 언어
-- DDL(  정의어   )  CREATE, ALTER, DROP   → cad
-- DML(  조작어   )  INSERT, SELECT, UPDATE , DELETE 
-- DCL(  제어어   )  GRANT , REVOKE


-- 2. 다음과 같이 테이블준비
-- DB명     : test
-- 테이블명: userinfo
-- 필드1 -  필수입력 no    ,  숫자자동증가, 기본키      정수형
-- 필드2 -  필수입력  name  가변형문자열(100)
-- 필드3 -  필수입력  age      정수형
use test;                -- 드래그해서 선택  ctrl + enter
drop   table userinfo;   -- 테이블있다면 삭제시  
create table userinfo(
	no    int          not null auto_increment   primary key,
    name  varchar(100) not null,
    age   int          not null
);
show tables;
desc userinfo;

-- alter table   usesrinfo  rename  userinfo;

-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(100) | NO   |     | NULL    |                |
-- | age   | int          | NO   |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 3 rows in set (0.00 sec)

-- 3. 다음을 수정  
-- alter table  ( add , drop , change/modify , rename)
-- 1. 이메일 필드 추가(add)       email varchar(100)
alter table userinfo  add  email  varchar(100); 
-- 2. 이메일 필드 수정(change)   email을 email2로  자료형은 varchar(50) 으로 
alter table userinfo  change  email  email2  varchar(50);

-- 3. 이메일 필드 수정(modify)   email을 email2로  자료형은 varchar(50) 으로   (★이상한점!  - modify는 필드명 수정안됨)
-- 3. 이메일 필드 수정(modify)  ★변경)     email2로  자료형은 varchar(100) 으로    
alter table userinfo  modify  email2 varchar(100);

-- 4. 이메일 필드 삭제(drop)
alter table userinfo drop email2;

desc  userinfo;





