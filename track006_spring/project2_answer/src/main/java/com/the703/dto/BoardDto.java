package com.the703.dto;
import lombok.Data;
@Data
public class BoardDto {
	private int bno;
	private String bname;
	private String bpass;
	private String btitle;
	private String bcontent;
	private String bdate;
	private int bhit;
	private String bip;
	private String bfile;
}

/* mysql> desc mvcboard2;
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
| bfile    | varchar(500)  | YES  |     | the703.png        |                   |
+----------+---------------+------+-----+-------------------+-------------------+
9 rows in set (0.00 sec)
*/