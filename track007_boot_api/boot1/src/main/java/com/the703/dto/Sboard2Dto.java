package com.the703.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter @Setter @ToString  
@NoArgsConstructor
@AllArgsConstructor
public class Sboard2Dto {
	private int id;
	private int appUserId;
	private String btitle;
	private String bcontent;
	private String bpass;
	private String bfile;
	private int    bhit;
	private String bip;
	private String createdAt;
}


/*
SQL> desc  sboard2;
 이름                                      	널?      유형
 ----------------------------------------- -------- ----------------------------
 ID                                        NOT NULL NUMBER
 APP_USER_ID                          NOT NULL NUMBER
 BTITLE                                   NOT NULL VARCHAR2(1000)
 BCONTENT                             NOT NULL CLOB
 BPASS                                   NOT NULL VARCHAR2(255)
 BFILE                                                   VARCHAR2(255)
 BHIT                                                    NUMBER
 BIP                                       NOT NULL VARCHAR2(255)
 CREATED_AT                                          DATE

*/