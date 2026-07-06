drop table sboard2;
create table sboard2(
 	ID                   NUMBER          	  NOT NULL ,
 	APP_USER_ID     NUMBER          	  NOT NULL ,
 	BTITLE             VARCHAR2(1000)         NOT NULL, 
 	BCONTENT       CLOB                 	  NOT NULL ,
 	BPASS              VARCHAR2(255)          NOT NULL ,
 	BFILE               VARCHAR2(255)     default  'the703.png',
 	BHIT                NUMBER    	         default 0 , 
	BIP                  VARCHAR2(255)     NOT NULL  ,
 	CREATED_AT      DATE   	          default  sysdate
);
desc sboard2;
create sequence  sboard2_seq;   


-- step2
--1) crud
--* insert 
insert into  sboard2 ( ID                          ,  APP_USER_ID ,  BTITLE  ,  BCONTENT  ,  BPASS  ,  BFILE  ,  BIP  )
values               ( sboard2_seq.nextval   ,  1001    ,  'title'   , 'bcontent'  ,   '1111' ,   '1.png' ,   '127.0.0.1'   );
commit;
--* 전체select  ( 페이징 )
select *  from  sboard2  order by id   desc;

SELECT * FROM sboard2 
ORDER BY id DESC
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;

--  OFFSET 0 ROWS: 건너뛸 행의 개수 (0부터 시작)
--  FETCH NEXT 10 ROWS ONLY: 가져올 행의 개수
--  최신글부터 10개   0, 10   /  10,10  / 20, 10

select  count(*)  from sboard2;
-- 11g 이하
select * from(
	 select row_number() over(order by id desc)  as rnum, 
     id, app_user_id, btitle, bcontent, bpass, bfile, bip, bhit, created_at
	 from  sboard2
) A  
where  A.rnum  between  0  and 10;

-- mysql ( oracle에서는 동작안함)
select *  from  sboard2  order by id   desc   limit  0, 10 ;     


--* 해당번호의 select
select *  from  sboard2    where  id=21;
  
--* 해당번호 조회수 올리기
update  sboard2   set   bhit = bhit + 1  where  id=21;

--* 해당번호 업데이트
update  sboard2  set  btitle='new' , bcontent='new' , bfile='2.png'  where  id=21;
  
--* 해당번호 삭제
delete  from  sboard2   where  id=21;







-- ```
--  APPUSER
--  ┌───────────────────────────────────────────────┐
--  │ APP_USER_ID (PK)                              │
--  │ EMAIL (NOT NULL, UNIQUE with PROVIDER)        │
--  │ PASSWORD                                      │
--  │ MBTI_TYPE_ID                                  │
--  │ CREATED_AT                                    │
--  │ UFILE                                         │
--  │ MOBILE                                        │
--  │ NICKNAME                                      │
--  │ PROVIDER (NOT NULL)                           │
--  │ PROVIDER_ID                                   │
--  └───────────────────────────────────────────────┘
--                 ▲
--                 │  (FK: APP_USER_ID)
--                 │
--  AUTHORITIES
--  ┌───────────────────────────────────────────────┐
--  │ AUTH_ID (PK)                                  │
--  │ EMAIL                                         │
--  │ AUTH (NOT NULL, UNIQUE with APP_USER_ID)      │
--  │ APP_USER_ID (FK → APPUSER.APP_USER_ID)        │
--  └───────────────────────────────────────────────┘
-- ````

-- SQL> desc appuser;
-- Name                                      Null?    Type
-- ----------------------------------------- -------- ----------------------------
-- APP_USER_ID                               NOT NULL NUMBER(5)
-- EMAIL                                     NOT NULL VARCHAR2(100)
-- PASSWORD                                           VARCHAR2(100)
-- MBTI_TYPE_ID                                       NUMBER(3)
-- CREATED_AT                                         DATE
-- UFILE                                              VARCHAR2(255)
-- MOBILE                                             VARCHAR2(50)
-- NICKNAME                                           VARCHAR2(50)
-- PROVIDER                                  NOT NULL VARCHAR2(50)
-- PROVIDER_ID                                        VARCHAR2(100)

-- SQL> desc authorities;
--  Name                                      Null?    Type
--  ----------------------------------------- -------- ----------------------------
--  AUTH_ID                                   NOT NULL NUMBER(5)
--  EMAIL                                              VARCHAR2(255)
--  AUTH                                      NOT NULL VARCHAR2(255)
--  APP_USER_ID                                        NUMBER(5)

-- SQL>




-- ## ✅ APPUSER 테이블 생성

 

CREATE TABLE APPUSER (
    APP_USER_ID   NUMBER(5)       CONSTRAINT PK_APPUSER PRIMARY KEY,
    EMAIL         VARCHAR2(100)   CONSTRAINT NN_APPUSER_EMAIL NOT NULL,
    PASSWORD      VARCHAR2(100),
    MBTI_TYPE_ID  NUMBER(3),
    CREATED_AT    DATE,
    UFILE         VARCHAR2(255),
    MOBILE        VARCHAR2(50),
    NICKNAME      VARCHAR2(50),
    PROVIDER      VARCHAR2(50)    CONSTRAINT NN_APPUSER_PROVIDER NOT NULL,
    PROVIDER_ID   VARCHAR2(100)
);
create sequence appuser_seq;

  
CREATE TABLE AUTHORITIES (
    AUTH_ID      NUMBER(5)        CONSTRAINT PK_AUTHORITIES PRIMARY KEY,
    EMAIL        VARCHAR2(255),
    AUTH         VARCHAR2(255)    CONSTRAINT NN_AUTHORITIES_AUTH NOT NULL,
    APP_USER_ID  NUMBER(5)
);
create sequence authorities_seq;


--1) 회원가입
insert into  appuser 
(APP_USER_ID ,EMAIL , PASSWORD , MBTI_TYPE_ID , CREATED_AT , UFILE  , MOBILE, NICKNAME , PROVIDER , PROVIDER_ID)
values   
(  appuser_seq.nextval, 'first@gmail.com' , '111', 1,sysdate , '1.png' , '0101111111'  , 'first' , 'the703', 't7-1');

--2) 로그인 - 이메일로 이메일, 비밀번호, 권한
select   u.email ,  u.password, a.auth
from     appuser u  left join  authorities a  on   u.email = a.email
where    u.email = 'first@gmail.com'; 

--3) 이메일로 유저찾기
select * from   appuser  where  email='first@gmail.com'; 

--4) 이메일로 중복검사
select count(*) from   appuser  where  email='first@gmail.com'; 

--5) 회원수정
update  appuser
set     password='2222',  
mbti_type_id=2 ,
ufile  = '2.png' ,
nickname='second',
mobile='0102222222',
provider='naver',
provider_id='n-1'
where  app_user_id=21;    -- 있는번호

--6) 회원삭제
delete from appuser  where   app_user_id=21; 

--7) 권한삽입
insert into authorities ( AUTH_ID , EMAIL,  AUTH)
values                  ( authorities_seq.nextval , 'first@gmail.com' , 'ROLE_MEMBER');
--8) 권한삭제 
delete from   authorities  where email = 'first@gmail.com';



```
-- 이메일 + PROVIDER 조합 유니크 제약
ALTER TABLE APPUSER
ADD CONSTRAINT UK_APPUSER_EMAIL_PROVIDER UNIQUE (EMAIL, PROVIDER);
 
-- 동일 사용자에게 같은 권한 중복 방지 (APP_USER_ID + AUTH 유니크)
ALTER TABLE AUTHORITIES
ADD CONSTRAINT UK_AUTHORITIES_USER_AUTH UNIQUE (APP_USER_ID, AUTH);

-- 외래키 설정: AUTHORITIES.APP_USER_ID → APPUSER.APP_USER_ID
ALTER TABLE AUTHORITIES
ADD CONSTRAINT FK_AUTHORITIES_APPUSER FOREIGN KEY (APP_USER_ID)
REFERENCES APPUSER (APP_USER_ID);
```