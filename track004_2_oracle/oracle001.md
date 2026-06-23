□1. oracle
- 데이터베이스언어
1) 데이터 정의어 (DDL) :  create, alter, drop (cad)
2) 데이터 조작어 (DML) : insert, select, update, delete (crud)
3) 데이터 제어어 (DCL) : grant , revoke

- 1. oracle 설치
- 2. sql developer 설치 ( sql 편집)
- 3. 사용
<실습1>
```sql (cmd)
sqlplus
conn  system/1234

-- 유저만들기 ( 오라클 12 이상에서 기존방식으로 사용자 생성 허용 )
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
create user scott  identified by tiger;

-- 권한부여
grant  connect , resource  to scott;

ALTER USER scott DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;    -- 물리적공간이용
grant  create table to scott;
```

<실습2>
```sql(sqldeveloper)

--1. 테이블만들기
-- 테이블명  자료형  옵션
create table dept(
   deptno  number    primary key,
   dname   varchar2(14),
   loc     varchar2(13)
);

-- 2. insert + commit (crud)

-- 3. crud

```


□2. boot
