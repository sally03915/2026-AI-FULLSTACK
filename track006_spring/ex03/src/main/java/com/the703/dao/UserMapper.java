package com.the703.dao; 
import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.dto.UserDto;

@Mapper
public interface UserMapper {
	public int      insert(UserDto dto);
	public int      findLogin(UserDto dto);
	public UserDto  findByUno(   int  uno);
	public String   findByEmail( String email);
	
	/*  security */
	public  int          insertAuth(AuthDto  dto);
	public  AuthListDto  readAuth(AuthDto  dto);
}

/*
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

2) Dao - UserMapper   user-mapper.xml
         join / login / mypage  / 아이디 중복검사 (해당 sql 찾기)

create  : 
    insert into users  (nickname ,bpass, email , mobile, bip )  
    values             ( #{nickname} ,#{bpass}, #{email} , #{mobile}, #{bip} ) 

read    : 
    select count(*) from users  where  email=#{email}  and  bpass=#{bpass}
    select       *  from users  where  uno=#{uno} 
    select    email from users  where  email=#{email}
*/

/*
mysql> desc authorities;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| email | varchar(50) | NO   |     | NULL    |       |
| auth  | varchar(50) | NO   |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
2 rows in set (0.01 sec)

mysql> 
1)  insert 구문찾기    first@gmail.com  /  ROLE_MEMBER
     insert into  authorities (email, auth) values ( #{email} , #{auth} ) 

2)  JOIN 이용해서    first@gmail.com의   email, bpass, auth 필드값찾기 
  select     u.email,  u.bpass,  a.auth
  from      users u    left   join authorities a    on u.email   = a.email  
  where     u.email =#{email} 

*/