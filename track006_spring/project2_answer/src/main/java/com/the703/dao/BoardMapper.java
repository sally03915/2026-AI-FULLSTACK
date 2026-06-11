package com.the703.dao;

import java.util.HashMap;
import java.util.List;

import com.the703.dto.BoardDto;

@Mapper
public interface BoardMapper {  
	public  int  insert(BoardDto dto);
	public  int  update(BoardDto dto);
	public  int  delete(int bno);
	
	public  List<BoardDto>  selectAll();
	public        BoardDto  select(int bno);
	public  int  updateHit(int bno);
	
	/*	 paging		*/
	/*	 paging		*/
	public   List<BoardDto>   select10(HashMap<String,Integer> map); 
	public   int              selectCnt(); 
}

/*

> 실습
1. project 만들기
    1. dynamic web project - ex02
    2. configure  - [Convert to Maven Project]
    3. spring      - add Spring project Nature
    4. java se-11 / project facts, build path
    5. build path - add Libraries - JUnit 4
    
2. pom.xml 에  jar 파일 다운로드 받기
3. root-context 에   내용설정
   1) DataSource
   2) Mybatis
   3) Mapper
4. 각종 설정파일들설정
    com.the703.dao   - @Mapper 
    com.the703.dto    
    config       
      ㄴ db.properties
      ㄴ mybatis-config.xml
      ㄴ test-mapper.xml
      ㄴ board-mapper.xml
5. 테스트파일설정
  
6. test-mapper.xml
select now()   
    
7. mvcboard
mysql> desc mvcboard2;
+----------+---------------+------+-----+-------------------+-------------------+
| Field    | Type          | Null | Key | Default           | Extra             |
+----------+---------------+------+-----+-------------------+-------------------+
| bno      | int           | NO   | PRI | NULL              | auto_increment    |
| bname    | varchar(20)   | NO   |     | NULL              |                   |
| bpass    | varchar(50)   | NO   |     | NULL              |                   |
| btitle   | varchar(1000) | NO   |     | NULL              |                   |
| bcontent | text          | NO   |     | NULL              |                   |
| bdate    | timestamp     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| bhit     | int           | NO   |     | 0                 |                   |
| bip      | varchar(50)   | NO   |     | NULL              |                   |
+----------+---------------+------+-----+-------------------+-------------------+
8 rows in set (0.00 sec)
(해당번호의 글읽기, 글수정, 삭제)
create : insert into  mvcboard2 (bname , bpass , btitle , bcontent , bip)  
         values  (   #{bname} , #{bpass} , #{btitle} , #{bcontent} , #{bip} )
read   : select * from mvcobard2  order by bno desc
         select * from mvcobard2  where  bno= #{bno}
update : update  mvcboard2  set  btitle=#{btitle}  , bcontent=#{bcontent}  where bno= #{bno}
delete : delete  from mvcboard2  where bno= #{bno} 





CREATE TABLE mvcboard2 (
    bno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    bname VARCHAR(20) NOT NULL,
    bpass VARCHAR(50) NOT NULL,
    btitle VARCHAR(1000) NOT NULL,
    bcontent TEXT NOT NULL,
    bdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    bhit INT NOT NULL DEFAULT 0,
    bip VARCHAR(50) NOT NULL
);

*/

