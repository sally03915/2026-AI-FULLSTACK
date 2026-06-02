package com.the703.dto;

import lombok.Data;

@Data
public class UserInfoDto {
	private int no;
	private String email;
	private int age;
}
/*
mysql> desc userinfo_e;
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| no    | int          | NO   | PRI | NULL    | auto_increment |
| email | varchar(100) | NO   |     | NULL    |                |
| age   | int          | YES  |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
3 rows in set (0.01 sec)

*/