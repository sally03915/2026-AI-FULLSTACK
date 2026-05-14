
-- #### 3. 테이블 

-- 1. RDBMS (Relational Data Management System)
-- - 관계형 데이터베이스
-- - 테이블의 관계 
-- - 속성(필드) 연결

-- 2. 테이블 만들기 (집안의 방, 가방 안의 분류표)
-- DDL(정의:create, alter, drop) , DML(조작:) , DCL(제어:)
-- -----------------------------------
-- CREATE TABLE table명 (
--     필드1 자료형 옵션,
--     필드2 자료형 옵션
-- );
-- -----------------------------------
-- 자료형 : 
--     1. 숫자 : int( 정수, 1,2,3,) ,  double(실수,1.23)
--     2. 문자 : char(고정, 남/여)   ,  varchar(가변, abc, abcd,abcde)
--     3. 날짜 : date, datetime
-- 옵션 : 
--     필수입력 - not null
--     숫자자동증가 - auto_increment
--     기본키 - primary key    

-- [실습1]
-- create table t1(   
--     name varchar(100)  not null,
--     age  int
-- );    
-- show  tables;    -- 테이블목록확인
-- desc  t1;        -- 구조확인

-- create table t11(
--     no    int         not null,
--     name  varchar(30) not null
-- );

-- create table t12(
--     bookid  int            not null,    -- not(안돼) null(빈거)
--     title   varchar(100)   not null     -- 필수입력
-- );

-- show tables;
-- desc t12;


-- ※ ERROR 1046 (3D000): No database selected
-- use db명

-- mysql> show databases;
-- mysql> use mbasic
-- mysql> status           -- 상태확인

-- ※ 참고사항) not null 필수입력
-- mysql> insert into t1 (age) values (1);
-- ERROR 1364 (HY000): Field 'name' doesn't have a default value (값넣어!)

-- mysql> insert into t1 (name, age) values ('aaa', 1);
-- Query OK, 1 row affected (0.00 sec)

-- mysql> insert into t1 (name) values ('bbb');
-- Query OK, 1 row affected (0.00 sec)

-- mysql> select * from t1;
-- +------+------+
-- | name | age  |
-- +------+------+
-- | aaa  |    1 |
-- | bbb  | NULL |
-- +------+------+
-- 2 rows in set (0.00 sec)

-- mysql>


-- [실습2]  auto_increment (숫자 자동증가) , primary key (기본키)
-- create table t2(
--     jumin int          not null  auto_increment  primary key,
--     name  varchar(100) not null,
--     age   int          
-- );

-- ※ 참고사항)
-- insert into  t2 (name, age)  values ('aaa' , 1);
-- insert into  t2 (name)  values ('bbb');
-- insert into  t2 (jumin, name, age)  values (1 , 'ccc' , 1);

-- mysql> select * from t2;
-- +-------+------+------+
-- | jumin | name | age  |
-- +-------+------+------+
-- |     1 | aaa  |    1 |
-- |     2 | bbb  | NULL |
-- |     3 | aaa  |    1 |
-- +-------+------+------+
-- 2 rows in set (0.00 sec)


-- ------------------------------------------------------------
-- ------------------------------------------------------------ [연습문제]
-- [001]  다음과 같이 DB와 테이블을 만드시오  	   >> coffee
-- 커피번호 : cno    int           필수입력     primary key
-- 커피이름 : cname  varchar(50)   필수입력
-- 커피가격 : cprice   int          필수입력
-- +--------+-------------+------+-----+---------+----------------+
-- | Field  | Type        | Null | Key | Default | Extra          |
-- +--------+-------------+------+-----+---------+----------------+
-- | cno    | int(11)     | NO   | PRI | NULL    | auto_increment |	 
-- | cname  | varchar(50) | NO   |     | NULL    |                |
-- | cprice | int(11)     | NO   |     | NULL    |                |
-- +--------+-------------+------+-----+---------+----------------+


create table coffee(
   cno    int             not null  primary key   auto_increment  , 
   cname  varchar(50)     not null , 
   cprice int             not null
);


-- [002] 다음과 같이 DB와 테이블을 만드시오  			>> milk
-- 우유번호 : mno      int           필수입력     primary key
-- 우유이름 : mname    varchar(50)  필수입력
-- 우유가격 : mprice   int          필수입력
-- 우유갯수 : mnum     int         필수입력
-- 우유총액 : mtotal   int         필수입력


-- +--------+-------------+------+-----+---------+----------------+
-- | Field  | Type        | Null | Key | Default | Extra          |
-- +--------+-------------+------+-----+---------+----------------+
-- | mno    | int(11)     | NO   | PRI | NULL    | auto_increment |
-- | mname  | varchar(50) | NO   |     | NULL    |                |
-- | mprice | int(11)     | NO   |     | NULL    |                |
-- | mnum   | int(11)     | NO   |     | NULL    |                |
-- | mtotal | int(11)     | NO   |     | NULL    |                |
-- +--------+-------------+------+-----+---------+----------------+
create table milk(
       mno     int          not null      primary key,
       mname   varchar(50)  not null  ,
       mprice  int          not null  , 
       mnum    int          not null  , 
       mtotal  int          not null  
);



-- [003] 다음과 같이 DB와 테이블을 만드시오    >> score
-- +----------+-------------+------+-----+---------+----------------+
-- | Field    | Type        | Null | Key | Default | Extra          |
-- +----------+-------------+------+-----+---------+----------------+
-- | sno      | int(11)     | NO   | PRI | NULL    | auto_increment |
-- | sname    | varchar(20) | NO   |     | NULL    |                |
-- | sjava    | int(11)     | NO   |     | NULL    |                |
-- | sjsp     | int(11)     | NO   |     | NULL    |                |
-- | sspring  | int(11)     | NO   |     | NULL    |                |
-- | sproject | int(11)     | NO   |     | NULL    |                |
-- | sstotal  | int(11)     | YES  |     | NULL    |                |
-- | ssavg    | int(11)     | YES  |     | NULL    |                |
-- | semail   | varchar(50) | YES   |     | NULL    |                |
-- +----------+-------------+------+-----+---------+----------------+

-- [004]  다음과 같이 DB와 테이블을 만드시오      >> emp
-- mysql> desc emp;
-- +----------+-------------+------+-----+---------+----------------+
-- | Field    | Type        | Null | Key | Default | Extra          |
-- +----------+-------------+------+-----+---------+----------------+
-- | empno    | int(11)     | NO   | PRI | NULL    | auto_increment |
-- | ename    | varchar(20) | YES  |     | NULL    |                |
-- | job      | varchar(20) | YES  |     | NULL    |                |
-- | mgr      | int(11)     | YES  |     | NULL    |                |
-- | hiredate | date        | YES  |     | NULL    |                |
-- | sal      | int(11)     | YES  |     | NULL    |                |
-- | comm     | int(11)     | YES  |     | NULL    |                |
-- | deptno   | int(11)     | YES  |     | NULL    |                |
-- +----------+-------------+------+-----+---------+----------------+
-- 8 rows in set (0.01 sec)

-- mysql>





-- [005]  다음과 같이 DB와 테이블을 만드시오     >> dept
-- mysql> desc dept;
-- +--------+-------------+------+-----+---------+----------------+
-- | Field  | Type        | Null | Key | Default | Extra          |
-- +--------+-------------+------+-----+---------+----------------+
-- | deptno | int(11)     | NO   | PRI | NULL    | auto_increment |
-- | dname  | varchar(20) | NO   |     | NULL    |                |
-- | loc    | varchar(20) | NO   |     | NULL    |                |
-- +--------+-------------+------+-----+---------+----------------+
-- 3 rows in set (0.00 sec)




-- [006]  다음과 같이 DB와 테이블을 만드시오    >> salagrade
-- mysql> desc salgrade;
-- +-------+---------+------+-----+---------+----------------+
-- | Field | Type    | Null | Key | Default | Extra          |
-- +-------+---------+------+-----+---------+----------------+
-- | grade | int(11) | NO   | PRI | NULL    | auto_increment |
-- | losal | int(11) | YES  |     | NULL    |                |
-- | hisal | int(11) | YES  |     | NULL    |                |
-- +-------+---------+------+-----+---------+----------------+
-- 3 rows in set (0.02 sec)

-- mysql> 

