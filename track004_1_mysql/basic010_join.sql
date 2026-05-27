-- 1. CRUD (SELECT JOIN)
-- 2. CRUD (SELECT JOIN 연습문제)
-- ________________________________________________________________
-- ________________________________________________________________


-- select (1) - 기본문법
-- select (2) - 집계함수
-- select (3) - 함수 ( Number, String, Date , if, case )
-- select (4) - join  #
-- select (5) - subquery


-- DDL :  CREATE, ALTER, DROP
-- DML : insert, select #, update, delete
-- DCL  : grant, revoke

--  basic010_join.sql


-- ■진행1. CRUD (SELECT JOIN)
-- >> JOIN
-- 1. join
--    - 두개 이상의 테이블들을 연결 또는 결합하여 데이터를 출력
--    - 테이블간의 연결고리( pk, fk )로 관계를 맺고 데이터를 출력

-- 2. 종류
--    - inner join : 양쪽테이블 모두 일치하는 데이터
--    - outer join : 특정테이블을 기준으로 데이터를 검색


-- STEP0) 준비테이블
-- mysql> desc join_userinfo;
-- +-------+--------------+------+-----+---------+-------+
-- | Field | Type         | Null | Key | Default | Extra |
-- +-------+--------------+------+-----+---------+-------+
-- | no    | int(11)      | NO   |     | 0       |       |
-- | name  | varchar(100) | NO   |     | NULL    |       |
-- | age   | int(11)      | NO   |     | NULL    |       |
-- +-------+--------------+------+-----+---------+-------+
-- 3 rows in set (0.00 sec)

-- mysql>

-- mysql> select * from join_userinfo;
-- +----+------+-----+
-- | no | name | age |
-- +----+------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 |
-- +----+------+-----+
-- 4 rows in set (0.00 sec)
-- mysql>

-- ---------------------------------
-- mysql> desc join_userban;
-- +-------+-------------+------+-----+---------+----------------+
-- | Field | Type        | Null | Key | Default | Extra          |
-- +-------+-------------+------+-----+---------+----------------+
-- | no    | int(11)     | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(20) | NO   |     | NULL    |                |
-- | ban   | char(2)     | YES  |     | NULL    |                |
-- +-------+-------------+------+-----+---------+----------------+

-- mysql> select * from join_userban;
-- +----+--------+------+
-- | no | name   | ban  |
-- +----+--------+------+
-- |  1 | first  | A    |
-- |  2 | second | B    |
-- |  3 | third  | A    |
-- |  4 | fourth | C    |
-- |  5 | fifth  | B    |
-- |  6 | sixth  | C    |
-- +----+--------+------+

use mbasic;
CREATE TABLE join_userinfo
( no  int not null  auto_increment primary key ,
  name varchar(20)  not null ,
  age  int not null
 ) default charset utf8;
insert into  join_userinfo (name, age)  values  ('first'  , 11 );
insert into  join_userinfo (name, age)  values  ('second' , 22 );
insert into  join_userinfo (name, age)  values  ('third'  , 33 );
insert into  join_userinfo (name, age)  values  ('fourth' , 44);


CREATE TABLE join_userban
( no  int not null  auto_increment primary key ,
  name varchar(20)  not null ,
  ban  char(2)
) default charset utf8;

insert into  join_userban  (name,  ban)  values  ('first'     ,  'A');
insert into  join_userban  (name,  ban)  values  ('second' ,   'B');
insert into  join_userban  (name,  ban)  values  ('third'    ,  'A');
insert into  join_userban  (name,  ban)  values  ('fourth'  ,   'C');
insert into  join_userban  (name,  ban)  values  ('fifth'     ,  'B');
insert into  join_userban  (name,  ban)  values  ('sixth'    ,  'C');

select * from join_userinfo;
select * from join_userban;
 

-- question1) join을 이용하여 join_userinfo
--   학생의 번호, 이름, 나이, 반을 출력하시오.
-- +----+--------+-----+------+
-- | no | name   | age | ban  |
-- +----+--------+-----+------+
-- |  1 | first  |  11 | A    |
-- |  2 | second |  22 | B    |
-- |  3 | third  |  33 | A    |
-- |  4 | fourth |  44 | C    |
-- +----+--------+-----+------+

-- >>> (1) = join
-- select  no , name  ,age , ban 
-- from    join_userinfo ,   join_userban 
-- where   join_userinfo.no=join_userban.no;
-- Error Code: 1052. Column 'no' in field list is ambiguous	0.000 sec

select  a.no , a.name  , a.age , b.ban 
from    join_userinfo  a,   join_userban  b
where   a.no=b.no;

-- >>> (2) join  on
select  a.no , a.name  , a.age , b.ban 
from    join_userinfo  a  join   join_userban  b
on      a.no=b.no;

-- >>> (3) join  using
select  a.no , a.name  , a.age , b.ban 
from    join_userinfo  a  join   join_userban  b
using(no);

-- >>> (4) natural join
select no, name, age, ban
from   join_userinfo  natural join  join_userban;


-- question2)  inner join을 이용하여 join_userinfo
--   테이블의 20세이상 40세 이하 학생의 번호, 이름, 나이, 반을 출력하시오.   번호.이름
--    >> 세가지방법으로
-- +----+--------+-----+------+
-- | no | name   | age | ban  |
-- +----+--------+-----+------+
-- |  2 | second |  22 | B    |
-- |  3 | third  |  33 | A    |
-- +----+--------+-----+------+
-- >>> (1) = join
select     a.no ,  a.name , a.age , b.ban
from       join_userinfo  a,     join_userban  b
where      a.no = b.no  and  a.age >= 20  and  a.age <=40;   

-- >>> (2) join  on
select     a.no ,  a.name , a.age , b.ban
from       join_userinfo  a   join    join_userban  b
on	       a.no = b.no  
where  a.age >= 20  and  a.age <=40;   

-- >>> (3) join  using
select     a.no ,  a.name , a.age , b.ban
from       join_userinfo  a   join    join_userban  b
using(no)
where  a.age >= 20  and  a.age <=40;   

select     no ,name ,age ,ban
from       join_userinfo     natural  join    join_userban    
where      age >= 20  and   age <=40;   



-- question3)  outer join
-- +------+--------+------+------+
-- | no   | name   | ban  | age  |
-- +------+--------+------+------+
-- |    1 | first  | A    |   11 |
-- |    2 | second | B    |   22 |
-- |    3 | third  | A    |   33 |
-- |    4 | fourth | C    |   44 |
-- | NULL | NULL   | B    | NULL |
-- | NULL | NULL   | C    | NULL |
-- +------+--------+------+------+
-- 6 rows in set (0.00 sec)

select  a.no   , a.name   , b.ban  , a.age 
from    join_userinfo a  right join    join_userban  b
on      a.no = b.no;

select  a.no   , a.name   , b.ban  , a.age 
from    join_userban  b left join  join_userinfo a 
on      a.no = b.no;




-- question4)  left, right join 이용
-- +----+--------+------+------+
-- | no | name   | ban  | age  |
-- +----+--------+------+------+
-- |  1 | first  | A    |   11 |
-- |  2 | second | B    |   22 |
-- |  3 | third  | A    |   33 |
-- |  4 | fourth | C    |   44 |
-- |  5 | fifth  | B    | NULL |
-- |  6 | sixth  | C    | NULL |
-- +----+--------+------+------+
-- 6 rows in set (0.00 sec)
select    b.no , b.name   , b.ban , a.age
from      join_userinfo  a  right join  join_userban b
on        a.no = b.no;

select    b.no , b.name   , b.ban , a.age
from      join_userban b   left join   join_userinfo  a  
on        a.no = b.no;


-- ■진행2. CRUD (SELECT JOIN 연습문제)   >>연습문제 1~20번
-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 1
-- -- emp ,DEPT 테이블을 이용하여 다음과 같이  사원데이터를  조회하시오.
SELECT * FROM EMP, DEPT ORDER BY EMPNO;   
--  >> 조인조건이 없으면 두테이블 모두 조회 
--  >> emp 14줄, dept 4줄  카다시안곱 - 모든조합

-- -- 이코드가 의미하는바는?
-- mysql> SELECT * FROM EMP, DEPT ORDER BY EMPNO;
-- +-------+--------+-----------+------+------------+------+------+--------+--------+------------+----------+
-- | empno | ename  | job       | mgr  | hiredate   | sal  | comm | deptno | deptno | dname      | loc      |
-- +-------+--------+-----------+------+------------+------+------+--------+--------+------------+----------+
-- |  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800 | NULL |     20 |     30 | SALES      | CHICAGO  |
-- |  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800 | NULL |     20 |     40 | OPERATIONS | BOSTON   |
-- |  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800 | NULL |     20 |     10 | ACCOUNTING | NEW YORK |
-- |  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800 | NULL |     20 |     20 | RESEARCH   | DALLAS   |
-- |  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600 |  300 |     30 |     10 | ACCOUNTING | NEW YORK |
-- |  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600 |  300 |     30 |     20 | RESEARCH   | DALLAS   |
-- |  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600 |  300 |     30 |     30 | SALES      | CHICAGO  |
-- |  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600 |  300 |     30 |     40 | OPERATIONS | BOSTON   |
-- |  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250 |  500 |     30 |     10 | ACCOUNTING | NEW YORK |
-- |  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250 |  500 |     30 |     20 | RESEARCH   | DALLAS   |
-- |  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250 |  500 |     30 |     30 | SALES      | CHICAGO  |
-- |  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250 |  500 |     30 |     40 | OPERATIONS | BOSTON   |
-- |  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975 | NULL |     20 |     10 | ACCOUNTING | NEW YORK |
-- |  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975 | NULL |     20 |     20 | RESEARCH   | DALLAS   |
-- |  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975 | NULL |     20 |     30 | SALES      | CHICAGO  |
-- |  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975 | NULL |     20 |     40 | OPERATIONS | BOSTON   |
-- |  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250 | 1400 |     30 |     10 | ACCOUNTING | NEW YORK |
-- |  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250 | 1400 |     30 |     20 | RESEARCH   | DALLAS   |
-- |  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250 | 1400 |     30 |     30 | SALES      | CHICAGO  |
-- |  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250 | 1400 |     30 |     40 | OPERATIONS | BOSTON   |
-- |  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850 | NULL |     30 |     40 | OPERATIONS | BOSTON   |
-- |  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850 | NULL |     30 |     10 | ACCOUNTING | NEW YORK |
-- |  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850 | NULL |     30 |     20 | RESEARCH   | DALLAS   |
-- |  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850 | NULL |     30 |     30 | SALES      | CHICAGO  |
-- |  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |     10 | ACCOUNTING | NEW YORK |
-- |  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |     20 | RESEARCH   | DALLAS   |
-- |  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |     30 | SALES      | CHICAGO  |
-- |  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |     40 | OPERATIONS | BOSTON   |
-- |  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000 | NULL |     20 |     10 | ACCOUNTING | NEW YORK |
-- |  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000 | NULL |     20 |     20 | RESEARCH   | DALLAS   |
-- |  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000 | NULL |     20 |     30 | SALES      | CHICAGO  |
-- |  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000 | NULL |     20 |     40 | OPERATIONS | BOSTON   |
-- |  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |     30 | SALES      | CHICAGO  |
-- |  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |     40 | OPERATIONS | BOSTON   |
-- |  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |     10 | ACCOUNTING | NEW YORK |
-- |  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |     20 | RESEARCH   | DALLAS   |
-- |  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500 |    0 |     30 |     10 | ACCOUNTING | NEW YORK |
-- |  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500 |    0 |     30 |     20 | RESEARCH   | DALLAS   |
-- |  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500 |    0 |     30 |     30 | SALES      | CHICAGO  |
-- |  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500 |    0 |     30 |     40 | OPERATIONS | BOSTON   |
-- |  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100 | NULL |     20 |     10 | ACCOUNTING | NEW YORK |
-- |  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100 | NULL |     20 |     20 | RESEARCH   | DALLAS   |
-- |  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100 | NULL |     20 |     30 | SALES      | CHICAGO  |
-- |  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100 | NULL |     20 |     40 | OPERATIONS | BOSTON   |
-- |  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950 | NULL |     30 |     10 | ACCOUNTING | NEW YORK |
-- |  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950 | NULL |     30 |     20 | RESEARCH   | DALLAS   |
-- |  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950 | NULL |     30 |     30 | SALES      | CHICAGO  |
-- |  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950 | NULL |     30 |     40 | OPERATIONS | BOSTON   |
-- |  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000 | NULL |     20 |     10 | ACCOUNTING | NEW YORK |
-- |  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000 | NULL |     20 |     20 | RESEARCH   | DALLAS   |
-- |  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000 | NULL |     20 |     30 | SALES      | CHICAGO  |
-- |  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000 | NULL |     20 |     40 | OPERATIONS | BOSTON   |
-- |  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |     40 | OPERATIONS | BOSTON   |
-- |  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |     10 | ACCOUNTING | NEW YORK |
-- |  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |     20 | RESEARCH   | DALLAS   |
-- |  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |     30 | SALES      | CHICAGO  |
-- +-------+--------+-----------+------+------------+------+------+--------+--------+------------+----------+
-- 56 rows in set (0.00 sec)

-- mysql>




-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 2
-- -- emp ,DEPT 테이블에서
-- -- EMP테이블의 DEPTNO 와 DEPT테이블의 DEPTNO가 같은 사원의 데이터를  조회하시오.
select  *
from    emp , dept 
where   emp.deptno = dept.deptno
order   by empno;

select  empno , ename , job , mgr , hiredate, sal, comm, emp.deptno, dept.deptno, dname, loc
from    emp , dept 
where   emp.deptno = dept.deptno
order   by empno;
-- 겹치는 필드 소속채우기 Column 'deptno' in field list is ambiguous	0.000 sec 

desc emp;    -- empno , ename , job , mgr , hiredate, sal, comm, deptno, deptno 
desc dept;   -- deptno, dname, loc

-- +-------+--------+-----------+------+------------+------+------+--------+--------+------------+----------+
-- | empno | ename  | job       | mgr  | hiredate   | sal  | comm | deptno | deptno | dname      | loc      |
-- +-------+--------+-----------+------+------------+------+------+--------+--------+------------+----------+
-- |  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800 | NULL |     20 |     20 | RESEARCH   | DALLAS   |
-- |  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600 |  300 |     30 |     30 | SALES      | CHICAGO  |
-- |  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250 |  500 |     30 |     30 | SALES      | CHICAGO  |
-- |  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975 | NULL |     20 |     20 | RESEARCH   | DALLAS   |
-- |  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250 | 1400 |     30 |     30 | SALES      | CHICAGO  |
-- |  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850 | NULL |     30 |     30 | SALES      | CHICAGO  |
-- |  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |     10 | ACCOUNTING | NEW YORK |
-- |  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000 | NULL |     20 |     20 | RESEARCH   | DALLAS   |
-- |  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |     10 | ACCOUNTING | NEW YORK |
-- |  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500 |    0 |     30 |     30 | SALES      | CHICAGO  |
-- |  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100 | NULL |     20 |     20 | RESEARCH   | DALLAS   |
-- |  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950 | NULL |     30 |     30 | SALES      | CHICAGO  |
-- |  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000 | NULL |     20 |     20 | RESEARCH   | DALLAS   |
-- |  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |     10 | ACCOUNTING | NEW YORK |
-- +-------+--------+-----------+------+------------+------+------+--------+--------+------------+----------+
-- 14 rows in set (0.00 sec)

-- >>>>>


-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 3
-- -- emp 테이블의 별칭을 E로 ,DEPT  테이블의 별칭을 D로 하여
-- -- 별칭을 이용하여 EMP테이블의 DEPTNO 와 DEPT테이블의 DEPTNO가 같은 사원의 데이터를  조회하시오.
select  *
from    emp e, dept d
where   e.deptno = d.deptno
order   by  empno;

select  empno ,ename , job   , mgr  , hiredate , sal, comm, e.deptno, d.deptno,dname    , loc  
from    emp e, dept d
where   e.deptno = d.deptno
order   by  empno;

-- +-------+--------+-----------+------+------------+------+------+--------+--------+------------+----------+
-- | empno | ename  | job       | mgr  | hiredate   | sal  | comm | deptno | deptno | dname      | loc      |
-- +-------+--------+-----------+------+------------+------+------+--------+--------+------------+----------+
-- |  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800 | NULL |     20 |     20 | RESEARCH   | DALLAS   |
-- |  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600 |  300 |     30 |     30 | SALES      | CHICAGO  |
-- |  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250 |  500 |     30 |     30 | SALES      | CHICAGO  |
-- |  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975 | NULL |     20 |     20 | RESEARCH   | DALLAS   |
-- |  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250 | 1400 |     30 |     30 | SALES      | CHICAGO  |
-- |  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850 | NULL |     30 |     30 | SALES      | CHICAGO  |
-- |  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |     10 | ACCOUNTING | NEW YORK |
-- |  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000 | NULL |     20 |     20 | RESEARCH   | DALLAS   |
-- |  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |     10 | ACCOUNTING | NEW YORK |
-- |  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500 |    0 |     30 |     30 | SALES      | CHICAGO  |
-- |  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100 | NULL |     20 |     20 | RESEARCH   | DALLAS   |
-- |  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950 | NULL |     30 |     30 | SALES      | CHICAGO  |
-- |  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000 | NULL |     20 |     20 | RESEARCH   | DALLAS   |
-- |  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |     10 | ACCOUNTING | NEW YORK |
-- +-------+--------+-----------+------+------------+------+------+--------+--------+------------+----------+
-- 14 rows in set (0.00 sec)


-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 4
-- -- EMP, DEPT테이블에서 다음과 같이 조회해보고 어떤오류가 나는지 적으시오.
--   Error Code: 1052. Column 'DEPTNO' in field list is ambiguous	0.000 sec
--   depno 필드가 emp, dept 둘다 있어서,,,,, 겹치는 필드 소속채우기

SELECT EMPNO, ENAME, DEPTNO, DNAME, LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;





-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 5
-- -- 위의 코드를  오류안나게 수정해
-- -- 다음과 같은 결과가 나오게 만드시오.
SELECT EMPNO, ENAME, e.DEPTNO, DNAME, LOC
FROM   EMP E, DEPT D
WHERE  E.DEPTNO = D.DEPTNO;

-- +-------+--------+--------+------------+----------+
-- | EMPNO | ENAME  | DEPTNO | DNAME      | LOC      |
-- +-------+--------+--------+------------+----------+
-- |  7369 | SMITH  |     20 | RESEARCH   | DALLAS   |
-- |  7499 | ALLEN  |     30 | SALES      | CHICAGO  |
-- |  7521 | WARD   |     30 | SALES      | CHICAGO  |
-- |  7566 | JONES  |     20 | RESEARCH   | DALLAS   |
-- |  7654 | MARTIN |     30 | SALES      | CHICAGO  |
-- |  7698 | BLAKE  |     30 | SALES      | CHICAGO  |
-- |  7782 | CLARK  |     10 | ACCOUNTING | NEW YORK |
-- |  7788 | SCOTT  |     20 | RESEARCH   | DALLAS   |
-- |  7839 | KING   |     10 | ACCOUNTING | NEW YORK |
-- |  7844 | TURNER |     30 | SALES      | CHICAGO  |
-- |  7876 | ADAMS  |     20 | RESEARCH   | DALLAS   |
-- |  7900 | JAMES  |     30 | SALES      | CHICAGO  |
-- |  7902 | FORD   |     20 | RESEARCH   | DALLAS   |
-- |  7934 | MILLER |     10 | ACCOUNTING | NEW YORK |
-- +-------+--------+--------+------------+----------+
-- 14 rows in set (0.00 sec)

-- mysql>



-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 6
-- -- emp 테이블의 별칭을 E로 ,DEPT  테이블의 별칭을 D로 하여
-- -- 별칭을 이용하여  EMP테이블의 DEPTNO 와 DEPT테이블의 DEPTNO가 같은 사원 중
-- -- 급여가 3000이상인 사원을 조회하시오.
-- +-------+-------+------+--------+------------+----------+
-- | EMPNO | ENAME | sal  | DEPTNO | DNAME      | LOC      |
-- +-------+-------+------+--------+------------+----------+
-- |  7788 | SCOTT | 3000 |     20 | RESEARCH   | DALLAS   |
-- |  7839 | KING  | 5000 |     10 | ACCOUNTING | NEW YORK |
-- |  7902 | FORD  | 3000 |     20 | RESEARCH   | DALLAS   |
-- +-------+-------+------+--------+------------+----------+
-- 3 rows in set (0.00 sec)

select    EMPNO , ENAME , sal  , e.DEPTNO ,DNAME   , LOC  
from      emp e , dept d
where     e.deptno = d.deptno  and  sal >= 3000;



-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 7
-- -- emp 테이블의 별칭을 E로 ,SALGRADE  테이블의 별칭을 S로 하여
-- -- 별칭을 이용하여  EMP테이블의 사원의 급여가  SALGRADE의 최소급여와 최대급여사이이 있는
-- -- 사원을 데이터를 다음과 같이 조회하시오.
desc emp;         --  empno | ename  | job       | mgr  | hiredate   | sal  | comm | deptno 
desc salgrade;    --  grade | losal | hisal 
select * from salgrade;

select     *
from       emp e , SALGRADE  s
where      sal between   s.losal   and  s.hisal
order      by  grade asc  , sal asc  ;


-- +-------+--------+-----------+------+------------+------+------+--------+-------+-------+-------+
-- | empno | ename  | job       | mgr  | hiredate   | sal  | comm | deptno | grade | losal | hisal |
-- +-------+--------+-----------+------+------------+------+------+--------+-------+-------+-------+
-- |  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800 | NULL |     20 |     1 |   700 |  1200 |
-- |  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950 | NULL |     30 |     1 |   700 |  1200 |
-- |  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100 | NULL |     20 |     1 |   700 |  1200 |
-- |  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250 |  500 |     30 |     2 |  1201 |  1400 |
-- |  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250 | 1400 |     30 |     2 |  1201 |  1400 |
-- |  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 |     2 |  1201 |  1400 |
-- |  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500 |    0 |     30 |     3 |  1401 |  2000 |
-- |  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600 |  300 |     30 |     3 |  1401 |  2000 |
-- |  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 |     4 |  2001 |  3000 |
-- |  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850 | NULL |     30 |     4 |  2001 |  3000 |
-- |  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975 | NULL |     20 |     4 |  2001 |  3000 |
-- |  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000 | NULL |     20 |     4 |  2001 |  3000 |
-- |  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000 | NULL |     20 |     4 |  2001 |  3000 |
-- |  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 |     5 |  3001 |  9999 |
-- +-------+--------+-----------+------+------------+------+------+--------+-------+-------+-------+
-- 14 rows in set (0.00 sec)


-- >>>>>

-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 8
-- -- emp 테이블을 두번 이용하여
-- -- 별칭을 이용하여  EMP테이블의 사원의 급여가  SALGRADE의 최소급여와 최대급여사이이 있는
-- -- 사원의 직속상관(MGR)의 정보를 다음과 같이 조회하시오.
select  empno, ename, mgr `직속상관`  from emp;

-- select    사원.empno , 사원.ename , 사원.mgr  , 직속상관.empno `MGR_EMPNO`  , 직속상관.ename `MGR_ENAME`
-- from      emp sawon  , emp mgr , salgrade s
-- where     사원.mgr  = 직속상관.empno(연결조건)  and    사원.sal   between  SALGRADE의 최소급여   and  최대급여사이이 있는  
-- order by  직속상관의 번호를 오름차순으로

select    sawon.empno , sawon.ename , sawon.mgr  , mgr.empno `MGR_EMPNO`  , mgr.ename `MGR_ENAME`
from      emp sawon  , emp mgr , salgrade s
where     sawon.mgr  = mgr.empno   and    sawon.sal   between s.losal  and  s.hisal
order by  mgr.empno  asc;

-- +-------+--------+------+-----------+-----------+
-- | empno | ename  | mgr  | MGR_EMPNO | MGR_ENAME |
-- +-------+--------+------+-----------+-----------+
-- |  7788 | SCOTT  | 7566 |      7566 | JONES     |
-- |  7902 | FORD   | 7566 |      7566 | JONES     |
-- |  7521 | WARD   | 7698 |      7698 | BLAKE     |
-- |  7654 | MARTIN | 7698 |      7698 | BLAKE     |
-- |  7844 | TURNER | 7698 |      7698 | BLAKE     |
-- |  7900 | JAMES  | 7698 |      7698 | BLAKE     |
-- |  7499 | ALLEN  | 7698 |      7698 | BLAKE     |
-- |  7934 | MILLER | 7782 |      7782 | CLARK     |
-- |  7876 | ADAMS  | 7788 |      7788 | SCOTT     |
-- |  7782 | CLARK  | 7839 |      7839 | KING      |
-- |  7566 | JONES  | 7839 |      7839 | KING      |
-- |  7698 | BLAKE  | 7839 |      7839 | KING      |
-- |  7369 | SMITH  | 7902 |      7902 | FORD      |
-- +-------+--------+------+-----------+-----------+
-- 13 rows in set (0.00 sec)







-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 8
-- -- emp 테이블을 두번 이용하여
-- -- 사원의 직속상관(MGR)의 정보를 다음과 같이 조회하시오.

--      EMPNO ENAME             MGR  MGR_EMPNO MGR_ENAME
-- ---------- ---------- ---------- ---------- ----------
--       7902 FORD             7566       7566 JONES
--       7788 SCOTT            7566       7566 JONES
--       7900 JAMES            7698       7698 BLAKE
--       7844 TURNER           7698       7698 BLAKE
--       7654 MARTIN           7698       7698 BLAKE
--       7521 WARD             7698       7698 BLAKE
--       7499 ALLEN            7698       7698 BLAKE
--       7934 MILLER           7782       7782 CLARK
--       7876 ADAMS            7788       7788 SCOTT
--       7782 CLARK            7839       7839 KING
--       7698 BLAKE            7839       7839 KING

--      EMPNO ENAME             MGR  MGR_EMPNO MGR_ENAME
-- ---------- ---------- ---------- ---------- ----------
--       7566 JONES            7839       7839 KING
--       7369 SMITH            7902       7902 FORD

-- 13개 행이 선택되었습니다.





--  --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 9
-- -- emp 테이블을 두번 이용하여
-- -- 사원의 직속상관(MGR)의 정보를 다음과 같이 조회하시오.
-- -- 앞의 예제와 비교 (앞의 예제는 13줄) -->> KING은 최고직급인 PRESIDENT이므로
-- -- 직속상관이 존재하지않으므로 NULL이나와 데이터에서 빠짐.
-- -- 데이터가 NULL이더라도 데이터가 나오게 처리하시오.
select   sawon.EMPNO , sawon.ENAME  , sawon.MGR , mgr.empno  `MGR_EMPNO`  , mgr.ename  `MGR_ENAME` 
from     emp  sawon  left join  emp  mgr
on       sawon.mgr = mgr.empno 
order   by   sawon.empno  asc;  


--  +-------+--------+------+-----------+-----------+
-- | EMPNO | ENAME  | MGR  | MGR_EMPNO | MGR_ENAME |
-- +-------+--------+------+-----------+-----------+
-- |  7369 | SMITH  | 7902 |      7902 | FORD      |
-- |  7499 | ALLEN  | 7698 |      7698 | BLAKE     |
-- |  7521 | WARD   | 7698 |      7698 | BLAKE     |
-- |  7566 | JONES  | 7839 |      7839 | KING      |
-- |  7654 | MARTIN | 7698 |      7698 | BLAKE     |
-- |  7698 | BLAKE  | 7839 |      7839 | KING      |
-- |  7782 | CLARK  | 7839 |      7839 | KING      |
-- |  7788 | SCOTT  | 7566 |      7566 | JONES     |
-- |  7839 | KING   | NULL |      NULL | NULL      |
-- |  7844 | TURNER | 7698 |      7698 | BLAKE     |
-- |  7876 | ADAMS  | 7788 |      7788 | SCOTT     |
-- |  7900 | JAMES  | 7698 |      7698 | BLAKE     |
-- |  7902 | FORD   | 7566 |      7566 | JONES     |
-- |  7934 | MILLER | 7782 |      7782 | CLARK     |
-- +-------+--------+------+-----------+-----------+
-- 14 rows in set (0.00 sec)

-- mysql>





-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 10
-- -- 다음과 같이 코드를 작성해보고  오른쪽 외부조인이 의미하는 바를 적으시오.
select   sawon.EMPNO , sawon.ENAME  , sawon.MGR , mgr.empno  `MGR_EMPNO`  , mgr.ename  `MGR_ENAME` 
from     emp  sawon  right join  emp  mgr
on       sawon.mgr = mgr.empno 
order   by  sawon.MGR;  

-- +-------+--------+------+-----------+-----------+
-- | EMPNO | ENAME  | MGR  | MGR_EMPNO | MGR_ENAME |
-- +-------+--------+------+-----------+-----------+
-- |  NULL | NULL   | NULL |      7499 | ALLEN     |
-- |  NULL | NULL   | NULL |      7654 | MARTIN    |
-- |  NULL | NULL   | NULL |      7876 | ADAMS     |
-- |  NULL | NULL   | NULL |      7934 | MILLER    |
-- |  NULL | NULL   | NULL |      7369 | SMITH     |
-- |  NULL | NULL   | NULL |      7521 | WARD      |
-- |  NULL | NULL   | NULL |      7844 | TURNER    |
-- |  NULL | NULL   | NULL |      7900 | JAMES     |
-- |  7369 | SMITH  | 7902 |      7902 | FORD      |
-- |  7499 | ALLEN  | 7698 |      7698 | BLAKE     |
-- |  7521 | WARD   | 7698 |      7698 | BLAKE     |
-- |  7566 | JONES  | 7839 |      7839 | KING      |
-- |  7654 | MARTIN | 7698 |      7698 | BLAKE     |
-- |  7698 | BLAKE  | 7839 |      7839 | KING      |
-- |  7782 | CLARK  | 7839 |      7839 | KING      |
-- |  7788 | SCOTT  | 7566 |      7566 | JONES     |
-- |  7844 | TURNER | 7698 |      7698 | BLAKE     |
-- |  7876 | ADAMS  | 7788 |      7788 | SCOTT     |
-- |  7900 | JAMES  | 7698 |      7698 | BLAKE     |
-- |  7902 | FORD   | 7566 |      7566 | JONES     |
-- |  7934 | MILLER | 7782 |      7782 | CLARK     |
-- +-------+--------+------+-----------+-----------+
-- 21 rows in set (0.00 sec)




-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 11
-- -- SQL-99 표준문법을 지원하고 있습니다.
-- -- 이문법을 사용하면 다른 DBMS에서도 사용할수 있습니다.
-- -- emp,dept 테이블을 이용하여 다음과 같이 코드작성을 해보고 의미하는바를 적으시오.
-- ---------------------------------------------
-- ---------------------------------------------  NATURAL JOIN
-- -- 반드시 두 테이블 간의 같은 이름, 타입을 가진 컬럼이 필요하다.
-- -- 조인에 이용되는 컬럼은 명시하지 않아도 자동으로 조인에 사용된다.
-- -- 동일한 이름을 갖는 컬럼이 있지만 데이터 타입이 다르면 에러가 발생한다.
select  *  
from    emp e natural join  dept d
order by deptno, empno;    -- deptno 필드 겹침 부분이 1번만나옴   (중간테스트)

select  EMPNO , ENAME  , JOB    , MGR  , HIREDATE   , SAL  , COMM , DEPTNO , DNAME     , LOC   
from    emp e natural join  dept d
order by deptno, empno;   


-- +-------+--------+-----------+------+------------+------+------+--------+------------+----------+
-- | EMPNO | ENAME  | JOB       | MGR  | HIREDATE   | SAL  | COMM | DEPTNO | DNAME      | LOC      |
-- +-------+--------+-----------+------+------------+------+------+--------+------------+----------+
-- |  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450 | NULL |     10 | ACCOUNTING | NEW YORK |
-- |  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 | ACCOUNTING | NEW YORK |
-- |  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300 | NULL |     10 | ACCOUNTING | NEW YORK |
-- |  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800 | NULL |     20 | RESEARCH   | DALLAS   |
-- |  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975 | NULL |     20 | RESEARCH   | DALLAS   |
-- |  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000 | NULL |     20 | RESEARCH   | DALLAS   |
-- |  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100 | NULL |     20 | RESEARCH   | DALLAS   |
-- |  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000 | NULL |     20 | RESEARCH   | DALLAS   |
-- |  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600 |  300 |     30 | SALES      | CHICAGO  |
-- |  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250 |  500 |     30 | SALES      | CHICAGO  |
-- |  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250 | 1400 |     30 | SALES      | CHICAGO  |
-- |  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850 | NULL |     30 | SALES      | CHICAGO  |
-- |  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500 |    0 |     30 | SALES      | CHICAGO  |
-- |  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950 | NULL |     30 | SALES      | CHICAGO  |
-- +-------+--------+-----------+------+------------+------+------+--------+------------+----------+
-- 14 rows in set (0.00 sec)

-- mysql>




-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 12
-- -- emp,dept 테이블을 JOIN + USING을 이용하여
-- -- 급여가 3000이상인 직원의 데이터를 다음과 같이 작성하시오.
-- +-------+-------+-----------+------+------------+------+------+--------+------------+----------+
-- | EMPNO | ENAME | JOB       | MGR  | HIREDATE   | SAL  | COMM | DEPTNO | DNAME      | LOC      |
-- +-------+-------+-----------+------+------------+------+------+--------+------------+----------+
-- |  7839 | KING  | PRESIDENT | NULL | 1981-11-17 | 5000 | NULL |     10 | ACCOUNTING | NEW YORK |
-- |  7788 | SCOTT | ANALYST   | 7566 | 1987-04-19 | 3000 | NULL |     20 | RESEARCH   | DALLAS   |
-- |  7902 | FORD  | ANALYST   | 7566 | 1981-12-03 | 3000 | NULL |     20 | RESEARCH   | DALLAS   |
-- +-------+-------+-----------+------+------------+------+------+--------+------------+----------+
-- 3 rows in set (0.00 sec)
select    EMPNO , ENAME , JOB , MGR , HIREDATE , SAL , COMM , d.DEPTNO , DNAME  , LOC   
from      emp e  join dept d   using(deptno)
where     sal  >= 3000
order     by  deptno;

select    EMPNO , ENAME , JOB , MGR , HIREDATE , SAL , COMM , d.DEPTNO , DNAME  , LOC   
from      emp e  join dept d   on  e.deptno = d.deptno
where     sal  >= 3000
order     by  deptno;

select    EMPNO , ENAME , JOB , MGR , HIREDATE , SAL , COMM , d.DEPTNO , DNAME  , LOC   
from      emp e  , dept d     
where     e.deptno = d.deptno  and sal  >= 3000
order     by  deptno;

select    EMPNO , ENAME , JOB , MGR , HIREDATE , SAL , COMM , DEPTNO , DNAME  , LOC   
from      emp e  natural join dept d     
where     sal  >= 3000
order     by  deptno;

-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 13
-- -- emp,dept 테이블을 JOIN + ON을 이용하여
-- -- 급여가 3000이하인 직원의 데이터를 다음과 같이 작성하시오.
select   EMPNO , ENAME , JOB , MGR , HIREDATE , SAL , COMM , d.DEPTNO , DNAME  , LOC   
from     emp e  join   dept d    on  e.deptno  = d.deptno
where    sal < 3000
order by deptno asc;

select   EMPNO , ENAME , JOB , MGR , HIREDATE , SAL , COMM , d.DEPTNO , DNAME  , LOC   
from     emp e  join   dept d     using( deptno)
where    sal < 3000
order by deptno asc;

select   EMPNO , ENAME , JOB , MGR , HIREDATE , SAL , COMM , d.DEPTNO , DNAME  , LOC   
from     emp e  ,   dept d     
where     e.deptno  = d.deptno  and  sal < 3000
order by deptno asc;

select   EMPNO , ENAME , JOB , MGR , HIREDATE , SAL , COMM ,  DEPTNO , DNAME  , LOC   
from     emp e  natural join  dept d     
where    sal < 3000
order by deptno asc;

-- +-------+--------+----------+------+------------+------+------+--------+------------+----------+
-- | EMPNO | ENAME  | JOB      | MGR  | HIREDATE   | SAL  | COMM | DEPTNO | DNAME      | LOC      |
-- +-------+--------+----------+------+------------+------+------+--------+------------+----------+
-- |  7782 | CLARK  | MANAGER  | 7839 | 1981-06-09 | 2450 | NULL |     10 | ACCOUNTING | NEW YORK |
-- |  7934 | MILLER | CLERK    | 7782 | 1982-01-23 | 1300 | NULL |     10 | ACCOUNTING | NEW YORK |
-- |  7369 | SMITH  | CLERK    | 7902 | 1980-12-17 |  800 | NULL |     20 | RESEARCH   | DALLAS   |
-- |  7566 | JONES  | MANAGER  | 7839 | 1981-04-02 | 2975 | NULL |     20 | RESEARCH   | DALLAS   |
-- |  7788 | SCOTT  | ANALYST  | 7566 | 1987-04-19 | 3000 | NULL |     20 | RESEARCH   | DALLAS   |
-- |  7876 | ADAMS  | CLERK    | 7788 | 1987-05-23 | 1100 | NULL |     20 | RESEARCH   | DALLAS   |
-- |  7902 | FORD   | ANALYST  | 7566 | 1981-12-03 | 3000 | NULL |     20 | RESEARCH   | DALLAS   |
-- |  7499 | ALLEN  | SALESMAN | 7698 | 1981-02-20 | 1600 |  300 |     30 | SALES      | CHICAGO  |
-- |  7521 | WARD   | SALESMAN | 7698 | 1981-02-22 | 1250 |  500 |     30 | SALES      | CHICAGO  |
-- |  7654 | MARTIN | SALESMAN | 7698 | 1981-09-28 | 1250 | 1400 |     30 | SALES      | CHICAGO  |
-- |  7698 | BLAKE  | MANAGER  | 7839 | 1981-05-01 | 2850 | NULL |     30 | SALES      | CHICAGO  |
-- |  7844 | TURNER | SALESMAN | 7698 | 1981-09-08 | 1500 |    0 |     30 | SALES      | CHICAGO  |
-- |  7900 | JAMES  | CLERK    | 7698 | 1981-12-03 |  950 | NULL |     30 | SALES      | CHICAGO  |
-- +-------+--------+----------+------+------------+------+------+--------+------------+----------+
-- 13 rows in set (0.00 sec)

-- mysql>



-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 14
-- -- emp ,DEPT 테이블에서  급여가 2000  초과인 사원들의 부서 정보, 사원정보를 다음과 같이   조회하시오.
-- -- 등가조인 =  을 이용하시오.
-- +--------+------------+-------+-------+------+
-- | DEPTNO | DNAME      | EMPNO | ENAME | SAL  |
-- +--------+------------+-------+-------+------+
-- |     20 | RESEARCH   |  7566 | JONES | 2975 |
-- |     30 | SALES      |  7698 | BLAKE | 2850 |
-- |     10 | ACCOUNTING |  7782 | CLARK | 2450 |
-- |     20 | RESEARCH   |  7788 | SCOTT | 3000 |
-- |     10 | ACCOUNTING |  7839 | KING  | 5000 |
-- |     20 | RESEARCH   |  7902 | FORD  | 3000 |
-- +--------+------------+-------+-------+------+
-- 6 rows in set (0.00 sec)

select  d.DEPTNO , DNAME  , EMPNO, ENAME, SAL
from    emp e, dept d
where   d.deptno = e.deptno   and  sal > 2000;

select  d.DEPTNO , DNAME  , EMPNO, ENAME, SAL
from    emp e  join  dept d  on d.deptno = e.deptno   
where   sal > 2000;

select  d.DEPTNO , DNAME  , EMPNO, ENAME, SAL
from    emp e  join  dept d   using(deptno)   
where   sal > 2000;

select  DEPTNO , DNAME  , EMPNO, ENAME, SAL
from    emp e  natural join  dept d  
where   sal > 2000;



-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 15
-- -- emp ,DEPT 테이블에서  급여가 2000  초과인 사원들의 부서 정보, 사원정보를 다음과 같이   조회하시오.
-- -- NATURAL JOIN을 이용하시오. 
select  DEPTNO , DNAME  , EMPNO, ENAME, SAL
from    emp e  natural join  dept d  
where   sal > 2000; 
-- +--------+------------+-------+-------+------+
-- | DEPTNO | DNAME      | EMPNO | ENAME | SAL  |
-- +--------+------------+-------+-------+------+
-- |     20 | RESEARCH   |  7566 | JONES | 2975 |
-- |     30 | SALES      |  7698 | BLAKE | 2850 |
-- |     10 | ACCOUNTING |  7782 | CLARK | 2450 |
-- |     20 | RESEARCH   |  7788 | SCOTT | 3000 |
-- |     10 | ACCOUNTING |  7839 | KING  | 5000 |
-- |     20 | RESEARCH   |  7902 | FORD  | 3000 |
-- +--------+------------+-------+-------+------+
-- 6 rows in set (0.00 sec)





-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 16
-- -- emp ,DEPT 테이블에서  각 부서별 평균급여, 최대급여, 최소급여, 사원수를  다음과 같이   조회하시오.
-- -- = 등가조인을 이용하시오.
-- +--------+------------+-----------+---------+---------+-----+
-- | DEPTNO | DNAME      | AVG_SAL   | MAX_SAL | MIN_SAL | CNT |
-- +--------+------------+-----------+---------+---------+-----+
-- |     10 | ACCOUNTING | 2916.6667 |    5000 |    1300 |   3 |
-- |     20 | RESEARCH   | 2175.0000 |    3000 |     800 |   5 |
-- |     30 | SALES      | 1566.6667 |    2850 |     950 |   6 |
-- +--------+------------+-----------+---------+---------+-----+
-- 3 rows in set (0.00 sec)
select    d.DEPTNO , DNAME   , avg(sal) `AVG_SAL`, max(sal) `MAX_SAL` , min(sal) `MIN_SAL` , count(*) `CNT`
from      emp  e , DEPT  d
where     e.deptno = d.deptno
group by  d.DEPTNO , DNAME
order by  d.deptno asc;
 
select    d.DEPTNO , DNAME   , avg(sal) `AVG_SAL`, max(sal) `MAX_SAL` , min(sal) `MIN_SAL` , count(*) `CNT`
from      emp  e join DEPT  d   on  e.deptno = d.deptno
group by  d.DEPTNO , DNAME
order by  d.deptno asc;
 
select    d.DEPTNO , DNAME   , avg(sal) `AVG_SAL`, max(sal) `MAX_SAL` , min(sal) `MIN_SAL` , count(*) `CNT`
from      emp  e join DEPT  d   using(deptno)
group by  d.DEPTNO , DNAME
order by  d.deptno asc; 

select    DEPTNO , DNAME   , avg(sal) `AVG_SAL`, max(sal) `MAX_SAL` , min(sal) `MIN_SAL` , count(*) `CNT`
from      emp  e  natural join DEPT  d  
group by  DEPTNO , DNAME
order by  deptno asc; 



-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 17
-- -- emp ,DEPT 테이블에서  각 부서별 평균급여, 최대급여, 최소급여, 사원수를  다음과 같이   조회하시오.
-- -- JOIN + USING을 이용하시오.

-- +--------+------------+-----------+---------+---------+-----+
-- | DEPTNO | DNAME      | AVG_SAL   | MAX_SAL | MIN_SAL | CNT |
-- +--------+------------+-----------+---------+---------+-----+
-- |     10 | ACCOUNTING | 2916.6667 |    5000 |    1300 |   3 |
-- |     20 | RESEARCH   | 2175.0000 |    3000 |     800 |   5 |
-- |     30 | SALES      | 1566.6667 |    2850 |     950 |   6 |
-- +--------+------------+-----------+---------+---------+-----+
-- 3 rows in set (0.00 sec)

select    d.DEPTNO , DNAME   , avg(sal) `AVG_SAL`, max(sal) `MAX_SAL` , min(sal) `MIN_SAL` , count(*) `CNT`
from      emp  e join DEPT  d   using(deptno)
group by  d.DEPTNO , DNAME
order by  d.deptno asc; 

-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 18
-- -- emp ,DEPT 테이블에서 모든부서정보와 사원정보를 다음과 같이 부서번호, 사원이름 순으로    조회하시오.
-- -- left join을 이용하시오.
select    d.DEPTNO , DNAME    , EMPNO , ENAME ,JOB  , SAL  
from      dept d  left join emp  e    on   d.deptno = e.deptno
order  by  d.deptno, ename;

select    d.DEPTNO , DNAME    , EMPNO , ENAME ,JOB  , SAL  
from      emp  e     right join  dept d    on   d.deptno = e.deptno
order  by  d.deptno, ename;


-- +--------+------------+-------+--------+-----------+------+
-- | DEPTNO | DNAME      | EMPNO | ENAME  | JOB       | SAL  |
-- +--------+------------+-------+--------+-----------+------+
-- |     10 | ACCOUNTING |  7782 | CLARK  | MANAGER   | 2450 |
-- |     10 | ACCOUNTING |  7839 | KING   | PRESIDENT | 5000 |
-- |     10 | ACCOUNTING |  7934 | MILLER | CLERK     | 1300 |
-- |     20 | RESEARCH   |  7876 | ADAMS  | CLERK     | 1100 |
-- |     20 | RESEARCH   |  7902 | FORD   | ANALYST   | 3000 |
-- |     20 | RESEARCH   |  7566 | JONES  | MANAGER   | 2975 |
-- |     20 | RESEARCH   |  7788 | SCOTT  | ANALYST   | 3000 |
-- |     20 | RESEARCH   |  7369 | SMITH  | CLERK     |  800 |
-- |     30 | SALES      |  7499 | ALLEN  | SALESMAN  | 1600 |
-- |     30 | SALES      |  7698 | BLAKE  | MANAGER   | 2850 |
-- |     30 | SALES      |  7900 | JAMES  | CLERK     |  950 |
-- |     30 | SALES      |  7654 | MARTIN | SALESMAN  | 1250 |
-- |     30 | SALES      |  7844 | TURNER | SALESMAN  | 1500 |
-- |     30 | SALES      |  7521 | WARD   | SALESMAN  | 1250 |
-- |     40 | OPERATIONS |  NULL | NULL   | NULL      | NULL |
-- +--------+------------+-------+--------+-----------+------+
-- 15 rows in set (0.00 sec)




-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 19
-- -- emp ,DEPT 테이블에서 모든부서정보와 사원정보를 다음과 같이 부서번호, 사원이름 순으로    조회하시오.
-- -- right JOIN을 이용하시오.
-- +--------+------------+-------+--------+-----------+------+
-- | DEPTNO | DNAME      | EMPNO | ENAME  | JOB       | SAL  |
-- +--------+------------+-------+--------+-----------+------+
-- |     10 | ACCOUNTING |  7782 | CLARK  | MANAGER   | 2450 |
-- |     10 | ACCOUNTING |  7839 | KING   | PRESIDENT | 5000 |
-- |     10 | ACCOUNTING |  7934 | MILLER | CLERK     | 1300 |
-- |     20 | RESEARCH   |  7876 | ADAMS  | CLERK     | 1100 |
-- |     20 | RESEARCH   |  7902 | FORD   | ANALYST   | 3000 |
-- |     20 | RESEARCH   |  7566 | JONES  | MANAGER   | 2975 |
-- |     20 | RESEARCH   |  7788 | SCOTT  | ANALYST   | 3000 |
-- |     20 | RESEARCH   |  7369 | SMITH  | CLERK     |  800 |
-- |     30 | SALES      |  7499 | ALLEN  | SALESMAN  | 1600 |
-- |     30 | SALES      |  7698 | BLAKE  | MANAGER   | 2850 |
-- |     30 | SALES      |  7900 | JAMES  | CLERK     |  950 |
-- |     30 | SALES      |  7654 | MARTIN | SALESMAN  | 1250 |
-- |     30 | SALES      |  7844 | TURNER | SALESMAN  | 1500 |
-- |     30 | SALES      |  7521 | WARD   | SALESMAN  | 1250 |
-- |     40 | OPERATIONS |  NULL | NULL   | NULL      | NULL |
-- +--------+------------+-------+--------+-----------+------+
-- 15 rows in set (0.00 sec)


-- --------------------------------------------------------
-- --------------------------------------------------------
-- -- 실습 20
-- -- emp ,DEPT 테이블에서 모든부서정보와 사원정보, 급여등급정보, 각사원의 직속상관의 정보를
-- -- 다음과 같이 부서번호, 사원이름 순으로  정렬하여  조회하시오.
select    d.DEPTNO , d.DNAME  , e.EMPNO , e.ENAME, e.MGR  , e.SAL ,e.DEPTNO, 
          s.LOSAL , s.HISAL ,s.GRADE ,
          mgr.empno `MGR_EMPNO` , mgr.ename `MGR_ENAME` 
from      emp e   right join  DEPT d      on (e.deptno = d.deptno)  
                  left  join  salgrade s  on (e.sal  between  s.losal  and  s.hisal)
                  left  join  emp mgr     on (e.mgr = mgr.empno)
order by  d.deptno , e.empno ;    -- d.deptno  , e.ename   /    d.deptno , e.empno

--
select    d.DEPTNO , d.DNAME  , e.EMPNO , e.ENAME, e.MGR  , e.SAL ,e.DEPTNO, 
          s.LOSAL , s.HISAL ,s.GRADE ,
          mgr.empno `MGR_EMPNO` , mgr.ename `MGR_ENAME` 
from     DEPT d   left join   emp e       on (e.deptno = d.deptno)  
                  left  join  salgrade s  on (e.sal  between  s.losal  and  s.hisal)
                  left  join  emp mgr     on (e.mgr = mgr.empno)
order by  d.deptno , e.empno ; 

--  using
select    d.DEPTNO , d.DNAME  , e.EMPNO , e.ENAME, e.MGR  , e.SAL ,e.DEPTNO, 
          s.LOSAL , s.HISAL ,s.GRADE ,
          mgr.empno `MGR_EMPNO` , mgr.ename `MGR_ENAME` 
from     DEPT d   left join   emp e       using(deptno)  
                  left  join  salgrade s  on (e.sal  between  s.losal  and  s.hisal)
                  left  join  emp mgr     on (e.mgr = mgr.empno)
order by  d.deptno , e.empno ; 

--  natural join
select    d.DEPTNO , DNAME  , e.EMPNO , e.ENAME, e.MGR  , e.SAL , 
          s.LOSAL , s.HISAL ,s.GRADE ,
          mgr.empno `MGR_EMPNO` , mgr.ename `MGR_ENAME` 
from     DEPT d   natural join   emp e       
                  left  join  salgrade s  on (e.sal  between  s.losal  and  s.hisal)
                  left  join  emp mgr     on (e.mgr = mgr.empno)
order by   deptno ,  e.empno ; 


-- +--------+------------+-------+--------+------+------+--------+-------+-------+-------+-----------+-----------+
-- | DEPTNO | DNAME      | EMPNO | ENAME  | MGR  | SAL  | DEPTNO | LOSAL | HISAL | GRADE | MGR_EMPNO | MGR_ENAME |
-- +--------+------------+-------+--------+------+------+--------+-------+-------+-------+-----------+-----------+
-- |     10 | ACCOUNTING |  7782 | CLARK  | 7839 | 2450 |     10 |  2001 |  3000 |     4 |      7839 | KING      |
-- |     10 | ACCOUNTING |  7839 | KING   | NULL | 5000 |     10 |  3001 |  9999 |     5 |      NULL | NULL      |
-- |     10 | ACCOUNTING |  7934 | MILLER | 7782 | 1300 |     10 |  1201 |  1400 |     2 |      7782 | CLARK     |
-- |     20 | RESEARCH   |  7369 | SMITH  | 7902 |  800 |     20 |   700 |  1200 |     1 |      7902 | FORD      |
-- |     20 | RESEARCH   |  7566 | JONES  | 7839 | 2975 |     20 |  2001 |  3000 |     4 |      7839 | KING      |
-- |     20 | RESEARCH   |  7788 | SCOTT  | 7566 | 3000 |     20 |  2001 |  3000 |     4 |      7566 | JONES     |
-- |     20 | RESEARCH   |  7876 | ADAMS  | 7788 | 1100 |     20 |   700 |  1200 |     1 |      7788 | SCOTT     |
-- |     20 | RESEARCH   |  7902 | FORD   | 7566 | 3000 |     20 |  2001 |  3000 |     4 |      7566 | JONES     |
-- |     30 | SALES      |  7499 | ALLEN  | 7698 | 1600 |     30 |  1401 |  2000 |     3 |      7698 | BLAKE     |
-- |     30 | SALES      |  7521 | WARD   | 7698 | 1250 |     30 |  1201 |  1400 |     2 |      7698 | BLAKE     |
-- |     30 | SALES      |  7654 | MARTIN | 7698 | 1250 |     30 |  1201 |  1400 |     2 |      7698 | BLAKE     |
-- |     30 | SALES      |  7698 | BLAKE  | 7839 | 2850 |     30 |  2001 |  3000 |     4 |      7839 | KING      |
-- |     30 | SALES      |  7844 | TURNER | 7698 | 1500 |     30 |  1401 |  2000 |     3 |      7698 | BLAKE     |
-- |     30 | SALES      |  7900 | JAMES  | 7698 |  950 |     30 |   700 |  1200 |     1 |      7698 | BLAKE     |
-- |     40 | OPERATIONS |  NULL | NULL   | NULL | NULL |   NULL |  NULL |  NULL |  NULL |      NULL | NULL      |
-- +--------+------------+-------+--------+------+------+--------+-------+-------+-------+-----------+-----------+
-- 15 rows in set (0.00 sec)

-- mysql>

