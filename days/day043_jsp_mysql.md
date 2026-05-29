※  users 테이블만들기
1. 회원가입
2. 로그인

mysql>
mysql> desc users;
+----------+--------------+------+-----+-------------------+-------------------+
| Field    | Type         | Null | Key | Default           | Extra             |
+----------+--------------+------+-----+-------------------+-------------------+
| uno      | int          | NO   | PRI | NULL              | auto_increment    |
| nickname | varchar(20)  | NO   |     | NULL              |                   |
| bpass    | varchar(50)  | NO   |     | NULL              |                   |
| email    | varchar(100) | NO   |     | NULL              |                   |
| mobile   | varchar(50)  | NO   |     | NULL              |                   |
| udate    | timestamp    | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| bip      | varchar(50)  | NO   |     | NULL              |                   |
+----------+--------------+------+-----+-------------------+-------------------+
7 rows in set (0.00 sec)

mysql>
mysql>


create table users(
  uno int not null  auto_increment primary key, 
  nickname varchar(20) not null,
  bpass    varchar(50) not null,
  email    varchar(100) not null,
  mobile   varchar(50) not null, 
  udate timestamp  not null  default current_timestamp  , 
  bip     varchar(50) not null 
);


insert into users (nickname, bpass, email, mobile, bip ) 
values            ('first' , '1111' , 'first@gmail.com' , '010-111-1111' , '127.0.0.1');


.................................................................................................
1.  Join
> 회원가입폼   - Get
> 회원가입처리 - Post
1) 처리서블릿   : JoinAction
2) 데이터 노출  : x
3) 보관데이터   : nickname , bpass , email , mobile
4) 처리경로     : 처리후 로그인 폼으로 (LoginAction - Get)

2. Login
> 로그인폼    -  Get
> 로그인처리 - Post
1) 처리서블릿   : LoginAction
2) 데이터 노출  : x
3) 보관데이터   : bpass , email  
4) 처리경로     : 처리후 마이페이지로   (MyAction - Get)


3. Mypage
> 마이페이지 - Get 
1) 처리서블릿   : MyAction
2) 로그인한정보로 서버에서 해당이메일의 정보가져오기
3) 처리후  mypage.jsp로 사용자 정보 넘겨주기


4. Logout
> 로그아웃 - Get

5. Users
>  사용자목록 확인
1) 처리서블릿  : Users
2) 사용자들의 목록을 확인  - users.jsp 로 전체사용자의 정보확인



.................................................................................................