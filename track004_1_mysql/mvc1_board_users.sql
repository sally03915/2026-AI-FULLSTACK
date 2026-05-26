
######################################################################################
-- mysql> desc mvcboard1;
-- +----------+---------------+------+-----+-------------------+-------------------+
-- | Field    | Type          | Null | Key | Default           | Extra             |
-- +----------+---------------+------+-----+-------------------+-------------------+
-- | bno      | int           | NO   | PRI | NULL              | auto_increment    |
-- | bname    | varchar(20)   | NO   |     | NULL              |                   |
-- | bpass    | varchar(50)   | NO   |     | NULL              |                   |
-- | btitle   | varchar(1000) | NO   |     | NULL              |                   |
-- | bcontent | text          | NO   |     | NULL              |                   |
-- | bdate    | timestamp     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
-- | bhit     | int           | NO   |     | 0                 |                   |
-- | bip      | varchar(50)   | NO   |     | NULL              |                   |
-- +----------+---------------+------+-----+-------------------+-------------------+
-- 8 rows in set (0.00 sec)

-- create table mvcboard1(
--   bno int not null  auto_increment primary key, 
--   bname varchar(20) not null,
--   bpass  varchar(50) not null,
--   btitle   varchar(1000) not null,
--   bcontent text   not null,
--   bdate timestamp  not null  default current_timestamp  ,
--   bhit    int not null  default 0,
--   bip     varchar(50) not null 
-- );

-- C  글쓰기  
--     insert into  mvcboard1 (bname , bpass , btitle ,bcontent , bip)  values  (?,?,?,?,?)
-- R  전체파일 / 상세보기
--     select * from   mvcboard1 order bno desc
--     select * from   mvcboard1  where  bno=?

-- U  수정     / 조회수올리기
--     update  mvcboard1   set  bhit=bhit+1    where  bno=?
--     update  mvcboard1   set  btitle=? ,bcontent=?  where  bno=?  and bpass=?

-- D  글삭제
--     delete from mvcboard1  where  bno=?   and bpass=?


######################################################################################
-- mysql>
-- mysql> desc users;
-- +----------+--------------+------+-----+-------------------+-------------------+
-- | Field    | Type         | Null | Key | Default           | Extra             |
-- +----------+--------------+------+-----+-------------------+-------------------+
-- | uno      | int          | NO   | PRI | NULL              | auto_increment    |
-- | nickname | varchar(20)  | NO   |     | NULL              |                   |
-- | bpass    | varchar(50)  | NO   |     | NULL              |                   |
-- | email    | varchar(100) | NO   |     | NULL              |                   |
-- | mobile   | varchar(50)  | NO   |     | NULL              |                   |
-- | udate    | timestamp    | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
-- | bip      | varchar(50)  | NO   |     | NULL              |                   |
-- +----------+--------------+------+-----+-------------------+-------------------+
-- 7 rows in set (0.00 sec)

-- (1) users 라는 테이블 만들기   
-- (2) sql  -  회원가입 sql,  로그인 sql 찾기~!
use mbasic;

-- insert
insert into  users  (nickname , bpass , email , mobile  , bip)  
values              ('aaa' , '1111' , 'aaa@gmail.com', '010-111-1111' , '127.0.0.1');

-- select (login, ,,,,)
select  count(*)  from users  where  bpass='1111' and email='aaa@gmail.com';





create table users(
  uno int not null  auto_increment primary key, 
  nickname varchar(20) not null,
  bpass    varchar(50) not null,
  email    varchar(100) not null,
  mobile   varchar(50) not null, 
  udate timestamp  not null  default current_timestamp  , 
  bip     varchar(50) not null 
);

