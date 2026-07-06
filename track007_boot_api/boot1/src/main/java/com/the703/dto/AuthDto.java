package com.the703.dto;

import lombok.Data;

@Data
public class AuthDto {
	private Integer  authId;
	private String   email;
	private String   auth;
	private Integer  appUserId;
}


/*
SQL> desc authorities;
 이름                                      널?      유형
 ----------------------------------------- -------- ----------------------------
 AUTH_ID                                   NOT NULL NUMBER(5)
 EMAIL                                              VARCHAR2(255)
 AUTH                                      NOT NULL VARCHAR2(255)
 APP_USER_ID                                        NUMBER(5)
 
*/