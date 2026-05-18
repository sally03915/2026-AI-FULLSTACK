-- STEP1) 
-- 1.  데이터베이스 언어 - 다음과 같은형식으로 빈칸 채우기
-- DDL( 정의어  )   CREATE, ALTER , DROP  → CAD
-- DML( 조작어  )   INSERT, SELECT, UPDATE, DELETE  → CRUD
-- DCL( 제어어  )   GRANT , REVOKE


-- STEP2) 
-- Q1. userinfo 테이블을 복사해서 userinfo_ex 테이블을 만드시오.
use mbasic;   -- database 선택
CREATE TABLE userinfo_ex  select * from userinfo;  -- 테이블만들기 (구조 + 데이터)
show tables;  -- 테이블들 확인
desc  userinfo_ex;  -- 테이블구조확인
alter table userinfo_ex  modify  no  int not null  auto_increment primary key;   -- 숫자자동증가 + 기본키
select * from userinfo_ex; -- 전체 데이터검색

-- mysql> desc userinfo_ex;
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(100) | NO   |     | NULL    |                |
-- | age   | int          | NO   |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 3 rows in set (0.00 sec)

-- mysql> select * from userinfo_ex;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 |
-- +----+--------+-----+



-- Q2. userinfo_ex 에  다음과 같이 데이터 추가 
-- mysql> select * from userinfo_ex;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 |
-- |  5 | fifth    |  50 |
-- |  6 | six   |  66 |
-- +----+--------+-----+

insert into  userinfo_ex                  values  (  5, 'fifth' , 50);
insert into  userinfo_ex  (no, name, age) values  (  6, 'six'   , 66);

select * from userinfo_ex;

-- Q3. userinfo_ex 에 데이터 수정
-- mysql> select * from userinfo_ex;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 |
-- |  5 | fifth    |  55 |   ← age 55로 수정
-- |  6 | six   |  66 |       ← name sixth로 수정
-- +----+--------+-----+

update    userinfo_ex  set   age =55  where  no=5;
update    userinfo_ex  set   age =55  where  name='fifth';
update    userinfo_ex  set   age =55  where  no=5 and name='fifth';


update    userinfo_ex  set   name='sixth'  where  no=6;
update    userinfo_ex  set   name='sixth'  where  name='six';
update    userinfo_ex  set   name='sixth'  where  no=6 and name='six';

select * from userinfo_ex;

-- Q4. userinfo_ex 에 데이터 삭제
-- mysql> select * from userinfo_ex;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 | 
-- +----+--------+-----+
delete from userinfo_ex where no=5;
delete from userinfo_ex where no=6;
delete from userinfo_ex where no>=5;
