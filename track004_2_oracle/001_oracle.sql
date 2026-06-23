--□1. oracle
--- 데이터베이스언어
--1) 데이터 정의어 (DDL) :  create, alter, drop (cad)
--2) 데이터 조작어 (DML) : insert, select, update, delete (crud)
--3) 데이터 제어어 (DCL) : grant , revoke

--- 1. oracle 설치
--- 2. sql developer 설치 ( sql 편집)
--- 3. 사용

--<실습1>
--```sql (cmd)
--sqlplus;
--conn  system/1234

-- 유저만들기 ( 오라클 12 이상에서 기존방식으로 사용자 생성 허용 )
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
create user scott  identified by tiger;

-- 권한부여
grant  connect , resource  to scott;

ALTER USER scott DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;    -- 물리적공간이용
grant  create table to scott;

--```
---------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------
--<실습2>  테이블만들기 ,  dml
-- 드래그 ctrl + enter
conn  scott/tiger;

-- 1) 테이블만들기
create table dept(
   deptno  number    primary key,
   dname   varchar2(14),
   loc     varchar2(13)
);

-- 2) insert
--    DEPTNO DNAME                        LOC
------------ ---------------------------- --------------------------
--        10 ACCOUNTING                   NEW YORK
--        20 RESEARCH                     DALLAS
--        30 SALES                        CHICAGO
--        40 OPERATIONS                   BOSTON

-- insert into 이용해서 값 넣기
insert into dept  (DEPTNO , DNAME , LOC)  values (10 , 'ACCOUNTING' , 'NEW YORK');
insert into dept  (DEPTNO , DNAME , LOC)  values (20 , 'RESEARCH'   , 'DALLAS');
insert into dept  (DEPTNO , DNAME , LOC)  values (30 , 'SALES'      , 'CHICAGO');
insert into dept  (DEPTNO , DNAME , LOC)  values (40 , 'OPERATIONS' , 'BOSTON');

commit;

select * from dept;

-- 3. crud
-- 3-1) 데이터 넣기 -   50  AIDEV   SEOUL
insert into dept  (DEPTNO , DNAME , LOC)  values (50 , 'AIDEV' , 'SEOUL');

-- 3-2) 데이터 수정 -   50  AIDEV   INCHEON
update  dept  set  LOC='INCHEON'  where deptno=50;

-- 3-3) 데이터 삭제 -   50번
delete from dept  where deptno=50;



-- 4. sequence  ( 숫자 자동증가 )
create sequence  dept_seq;
insert into dept  (DEPTNO , DNAME , LOC)  values ( dept_seq.nextval , 'AIDEV' , 'SEOUL');

select * from dept;

drop   sequence  dept_seq;

-- 참고)
CREATE SEQUENCE dept_seq
       START WITH      50     --  시작할 번호  ( 기존데이터와 겹치지 않게) 
       INCREMENT BY    10     --  증가할 값    ( 10개씩 증가)  
       NOCACHE                --  캐시사용안함  ( 번호 건너뛰기 방지) 
       NOCYCLE;               --  값이 처음으로 안돌아감.



-- 5. 외래키
--  부모삭제시 자식도 같이 삭제
CREATE TABLE emp1 (
  empno    number   not null   primary key   ,
  ename    varchar2(10) not null   ,
  job      VARCHAR2(9),
  mgr      NUMBER(4),
  hiredate DATE,
  sal      NUMBER(7,2),
  comm     NUMBER(7,2),
  deptno   number(2)   references  dept(deptno)  on delete cascade
);
-- 날짜 입력
INSERT INTO emp1 VALUES (7369, 'SMITH', 'CLERK', 7902, '1980-12-17' , 800, NULL, 1);
delete from dept  where  deptno=1;
select * from emp1;
drop table emp1;

-- 부모삭제시 자식의 deptno를 null로 변경
CREATE TABLE emp2 (
  empno    number   not null   primary key   ,
  ename    varchar2(10) not null   ,
  job      VARCHAR2(9),
  mgr      NUMBER(4),
  hiredate DATE,
  sal      NUMBER(7,2),
  comm     NUMBER(7,2),
  deptno   number(2)   references  dept(deptno)  on delete   set null
);
INSERT INTO emp2 VALUES (7369, 'SMITH', 'CLERK', 7902, '1980-12-17' , 800, NULL, 50);
delete from dept  where  deptno=50;
select * from emp2;


-- 6 정리
CREATE TABLE emp (
  empno    NUMBER(4) PRIMARY KEY,
  ename    VARCHAR2(10),
  job      VARCHAR2(9),
  mgr      NUMBER(4),
  hiredate DATE,
  sal      NUMBER(7,2),
  comm     NUMBER(7,2),
  deptno   NUMBER(2) REFERENCES dept(deptno) ON DELETE CASCADE
);
INSERT INTO emp VALUES (7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800, NULL, 20);
INSERT INTO emp VALUES (7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600, 300, 30);
INSERT INTO emp VALUES (7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1250, 500, 30);
INSERT INTO emp VALUES (7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975, NULL, 20);
INSERT INTO emp VALUES (7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850, NULL, 30);
INSERT INTO emp VALUES (7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450, NULL, 10);
INSERT INTO emp VALUES (7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000, NULL, 10);
INSERT INTO emp VALUES (7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500, 0, 30);
INSERT INTO emp VALUES (7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950, NULL, 30);
INSERT INTO emp VALUES (7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000, NULL, 20);
INSERT INTO emp VALUES (7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300, NULL, 10);
INSERT INTO emp VALUES (7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250, 1400, 30);
INSERT INTO emp VALUES (7876, 'ADAMS', 'CLERK', 7788, '1983-01-12', 1100, NULL, 20);
INSERT INTO emp VALUES (7788, 'SCOTT', 'ANALYST', 7566, '1982-12-09', 3000, NULL, 20);
commit;






