#### 1. Mysql?
> 1. mysql why?
1. DBMS
-  Database Management System
-  데이터베이스를 관리해주는 시스템

2. Database?
- Data + Base
- Data  1.데이터(수집된 사실, 값)   2. 정보(의미 부여)
- Data(의미를 제공하는 데이터) + Base( 체계와 규격을 가진 집합)

Q1. 다음 빈칸을 채우시오
      1.     (#1 데이터 )는  수집된 사실이나 값을 의미하고
      2.     (#2 정보   )는  데이터들 중에서 의미를 제공하는 데이터를 의미

3. Database 종류
- Oracle , Mysql , MSSql,,,,,,


> 2. mysql Setting
1. MYSQL 다운로드
       https://dev.mysql.com/
       -Download
       - MySQL Community Server

2. MYSQL 설치
3. MYSQL 환경설정 (1) path
4. MYSQL 환경설정 (2) utf-8


#### 2. RDBMS

> 1. RDBMS (Relational Datase Management System)
- 관계형 데이터베이스  관리 시스템
- 테이블들의 관계

> 2. RDBMS 구성요소
- 개체 (Entity : Table)
- 관계 (Relationship)
- 속성 (Attribute : 필드)

  ※ 스키마 - 데이터베이스 구조와 제약조건을 명세정의
     외부스키마 = 사용자뷰
     개념스키마 = 전체적인뷰
     내부스키마 = 저장스키마

  ※ 데이터베이스 설계단계
   #1. 개념적설계 - 요구사항분석 후 개념적 설계 ERD  
       (집을어떻게? 방몇개, 주방어디,,, 거실은 얼마나크게)
   #2. 논리적설계 - ERD를 이용하여 데이터베이스 스키마를 설계
       (방 = 테이블 , 사람 = 엔티티 , 관계 = 외래키)
   #3. 물리적설계 - 테이블 저장구조 설계 ( mysql,oracle,,,,)
       (실제건축자재로 만들기 - mysql, oracle)

> 3. 데이터베이스 언어
1. 정의어 (DDL) DDL = Data Definition Language
    CREATE, ALTER, DROP     → CAD
2. 조작어 (DML) DML = Data Manipulation Language
    INSERT, SELECT, UPDATE, DELETE     → CRUD
3. 제어어 (DCL) DCL = Data Control Language      
    GRANT ,  REVOKE

> 4. [실습] Database 만들기

1. 만들기      :  create database db명
2. 확인       :  show   databases
3. 삭제(복구x) :  drop   database  db명
4. DB사용      : use    db명
 
1) 접속 
mysql -uroot -p
1234

2) mysql 
show  databases;
create database  db1;      --  데이터베이스 만들기
drop database  db1;    -- 데이터베이스 삭제 (복구 안됨)


> 5. [연습] 
1. db명 : test , mbasic , db703 3개 db만들기
2. db만들어진것 확인
3. db703 삭제
```mysql
create database  test;
create database  mbasic;
create dadtabase db703;

show databases;

drop database db703;
```