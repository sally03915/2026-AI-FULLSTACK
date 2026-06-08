#1. spring003_mvc 안전한 복사해서 ex03 번만들기
#2. 테이블 users
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

■ model
1) Dto
2) Dao - join / login / mypage  / 아이디 중복검사 (해당 sql 찾기)
3) Service  테스트

■ controller
1) UserController

■ view
1) 회원가입  join 
2) 로그인    login 
3) 마이페이지 mypage
4) 아이디중복검사  (ajax)
5) board 검색    (ajax)

