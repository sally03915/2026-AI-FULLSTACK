- Todo1:  MYSQL
- Todo2:  JSP 



---
### ■1.  MYSQL 
1) WEB BASIC - HTML + CSS + JS ( 화면단 )
2) JAVA ( 프로그래밍 )
3) MYSQL/ORACLE (DB)
4) JSP (Html+Java)

##### TABLE
##### ALTER


 
---
### ■2.  JSP

1. project
2. ws vs  was


---
### ■3.  복습문제

1.  데이터베이스 언어
-- DDL(  정의어   )  CREATE, ALTER, DROP 
-- DML(   )    ________, ________, ________ , ________ 
-- DCL(   )     ________, ________


2. 다음과 같이 테이블준비
-- DB명     : mbasic    
-- 테이블명: userinfo
-- 필드1 -  필수입력 no    ,  숫자자동증가, 기본키      정수형
-- 필드2 -  필수입력  name  가변형문자열(100)
-- 필드3 -  필수입력  age      정수형
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| no    | int          | NO   | PRI | NULL    | auto_increment |
| name  | varchar(100) | NO   |     | NULL    |                |
| age   | int          | NO   |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)


3. 다음을 수정  
-- 1. 이메일 필드 추가(add)       email varchar(100)
-- 2. 이메일 필드 수정(change)   email을 email2로  자료형은 varchar(50) 으로 
-- 3. 이메일 필드 수정(modify)   email을 email2로  자료형은 varchar(50) 으로 
-- 4. 이메일 필드 삭제(drop)   
