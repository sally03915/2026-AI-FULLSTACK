#################################################################################
-- 1. 데이터베이스 언어
-- - DDL :  CREATE,   ALTER(#)    , DROP   → CAD

-- 1) alter 문법
-- https://dev.mysql.com/doc/refman/8.0/en/table.html

-- help alter
-- help alter table;

-- 2) 문법
-- ALTER TABLE 테이블명 
--     ADD        추가컬렁명  자료형 옵션  [FIRST | AFTER col_name]
--     DROP       삭제필드명
--     CHANGE     이전필드명  새로운필드명  자료형 옵션
--     MODIFY     수정필드명  자료형  옵션
--     RENAME     새로운테이블이름


-- -- 1. 테이블준비 
-- -- mysql> desc userinfo;
-- -- +-------+--------------+------+-----+---------+----------------+
-- -- | Field | Type         | Null | Key | Default | Extra          |
-- -- +-------+--------------+------+-----+---------+----------------+
-- -- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- -- | name  | varchar(100) | NO   |     | NULL    |                |
-- -- | age   | int          | NO   |     | NULL    |                |
-- -- +-------+--------------+------+-----+---------+----------------+
-- -- 3 rows in set (0.00 sec)



-- -- 2. 코드확인
-- #1) 필드추가
--   alter table userinfo  add   uno   int;
--   alter table userinfo  add   uno2  int  first;  -- 맨앞에
--   alter table userinfo  add   email varchar(100)  after name;  -- name 뒤에 

-- #2) 필드삭제
--   alter table userinfo  drop uno;
--   alter table userinfo  drop uno2;         ※  uno2  삭제

-- #3) 필드수정(CHANGE)  - 필드명 , 자료형 옵션  수정
--  > alter table userinfo  change oldname newname 자료형 옵션
--  alter table userinfo    change email   email2   varchar(50);
--  alter table userinfo    change email2  email    varchar(50); ※ email2를 email로 바꾸기

-- #4) 필드수정(modify)  - 자료형 옵션 수정   (  add, drop , change | modify )
--  alter  table  userinfo  modify  email  varchar(20) not null; 
--  
--  alter table userinfo  drop  email;

-- #5) 테이블명 수정      (  add, drop , change | modify , rename )
-- alter table userinfo  rename users;



#################################################################################
-- >>>> 연습문제1)
-- [001]  다음과 같이 테이블을 준비하시오    >> alter_coffee
-- mysql> desc alter_coffee;
-- +--------+-------------+------+-----+---------+-------+
-- | Field  | Type        | Null | Key | Default | Extra |
-- +--------+-------------+------+-----+---------+-------+
-- | cno    | int(11)     | YES  |     | NULL    |       |
-- | cname  | varchar(20) | YES  |     | NULL    |       |
-- | cprice | int(11)     | YES  |     | NULL    |       |
-- +--------+-------------+------+-----+---------+-------+
-- 3 rows in set (0.00 sec)

-- create table alter_coffee (
--     cno     int , 
--     cname   varchar(20) , 
--     cprice  int
-- );


-- > DDL :  CREATE , DROP , ALTER
-- > ALTER TABLE 테이블명
--     (추가 : ADD, 삭제 : DROP , 수정 CHANGE:MODIFY,RENAME)

-- [002] 다음과 같이 DB와 테이블을 수정하시오  [TABLE명 : alter_coffee] -  ALTER TABLE
-- 연습문제1) cno, cname,cprice필드를 ( not null )으로 수정    (modify / change)
--    ALTER TABLE alter_coffee  change  cno  cno  int     not null;
--    ALTER TABLE alter_coffee  modify cname varchar(20)  not null;
--    ALTER TABLE alter_coffee  modify cprice int         not null;

-- 연습문제2) 쿠폰필드  cgift    문자열고정(10)  미필수로 추가    (add)
--    ALTER TABLE alter_coffee  add  cgift   char(10) ;

-- 연습문제3) 쿠폰필드  cgift를  ccoupon으로 바꾸기    (change)
--    ALTER TABLE alter_coffee   change   cgift   ccoupon  char(10);

-- 연습문제4) 쿠폰필드 ccoupon삭제   (drop)
--    ALTER TABLE alter_coffee   drop      ccoupon;
--  
-- 연습문제5) cno를 cprice뒤로이동   (modify / change)
--    ALTER TABLE alter_coffee  modify cno         int not null  after cprice;
--    ALTER TABLE alter_coffee  change cno   cno   int not null  after cprice;

-- 연습문제6) cno를 맨위로           (modify / change) 
--    ALTER TABLE alter_coffee  modify cno     int not null  first;
--    ALTER TABLE alter_coffee  change cno cno int not null  first;

-- 연습문제7) cno를 primary key 추가   (add)
--    ALTER TABLE alter_coffee  modify cno     int not null  primary key;
--    ALTER TABLE alter_coffee  change cno cno int not null  primary key;
--    ALTER TABLE alter_coffee  add   primary key(cno);

--    ALTER TABLE alter_coffee  drop  primary key;

-- 연습문제8) alter_coffee테이블의 이름을 alter_coffee2로 바꾸기   (rename)
--    ALTER TABLE alter_coffee  rename  alter_coffee2;

-- 연습문제9) 다음과 같이 최종본으로 테이블만들기
--    ALTER TABLE alter_coffee2  modify cno int not null  auto_increment primary key  first;

-- mysql> desc alter_coffee2;
-- +--------+-------------+------+-----+---------+----------------+
-- | Field  | Type        | Null | Key | Default | Extra          |
-- +--------+-------------+------+-----+---------+----------------+
-- | cno    | int(11)     | NO   | PRI | NULL    | auto_increment |
-- | cname  | varchar(20) | NO   |     | NULL    |                |
-- | cprice | int(11)     | NO   |     | NULL    |                |
-- +--------+-------------+------+-----+---------+----------------+
-- 3 rows in set (0.00 sec)





-- <!-- [milk 테이블]
-- 1. milk 테이블의 mprice 필드를 NULL 허용으로 변경하시오.
-- 2. milk 테이블에 mdate 필드를 DATE 타입으로 추가하시오.
-- 3. milk 테이블의 mdate 필드 이름을 mexpire로 변경하시오.
-- 4. milk 테이블의 mexpire 필드를 삭제하시오.
-- 5. milk 테이블의 mno 필드를 mprice 뒤로 이동하시오.
-- 6. milk 테이블의 mno 필드를 맨 위로 이동하시오.
-- 7. milk 테이블의 이름을 milk2로 변경하시오.


-- [milk 테이블]

-- 8. milk 테이블의 mprice 필드에 기본값(Default) 1000을 설정하시오.
-- 9. milk 테이블의 mnum 필드에 0 이상만 입력되도록 CHECK 제약조건을 추가하시오.
-- 10. milk 테이블의 mname 필드에 UNIQUE 제약조건을 추가하시오.
-- 11. milk 테이블의 mtotal 필드를 삭제한 후, mprice * mnum을 자동 계산하는 생성 칼럼으로 다시 추가하시오.
-- 12. milk_category 테이블을 새로 만들고, milk 테이블에 외래키(FK)를 추가하여 연결하시오. 
-- -->



-- <!-- [기본 ALTER TABLE 문제 - score 테이블]

-- 1. score 테이블의 semail 필드를 NOT NULL로 변경하시오.
-- 2. score 테이블에 sphone 필드를 varchar(20) 타입으로 추가하시오.
-- 3. score 테이블의 sphone 필드 이름을 stel로 변경하시오.
-- 4. score 테이블의 stel 필드를 삭제하시오.
-- 5. score 테이블의 sno 필드를 sproject 뒤로 이동하시오.
-- 6. score 테이블의 sno 필드를 맨 위로 이동하시오.
-- 7. score 테이블의 이름을 score2로 변경하시오.


-- [심화 ALTER TABLE 문제 - score 테이블]

-- 8. score 테이블의 ssavg 필드에 기본값(Default) 0을 설정하시오.
-- 9. score 테이블의 sjava 필드에 0 이상만 입력되도록 CHECK 제약조건을 추가하시오.
-- 10. score 테이블의 sname 필드에 UNIQUE 제약조건을 추가하시오.
-- 11. score 테이블의 sstotal 필드를 삭제한 후, sjava + sjsp + sspring + sproject를 자동 계산하는 생성 칼럼으로 다시 추가하시오.
-- 12. score_class 테이블을 새로 만들고, score 테이블에 외래키(FK)를 추가하여 연결하시오. -->




#################################################################################