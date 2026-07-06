package com.the703.dto;

import lombok.Data;

@Data
public class AppUserDto {
	private Integer  appUserId;
	private String   email;
	private String   password;
	private Integer  mbtiTypeId;
	private String   createdAt;
	private String   ufile;
	private String   mobile;
	private String   nickname;
	private String   provider;
	private String   providerId;
}


/*

SQL> desc appuser;
 이름                                      널?      유형
 ----------------------------------------- -------- ----------------------------
 APP_USER_ID                               NOT NULL NUMBER(5)
 EMAIL                                     NOT NULL VARCHAR2(100)
 PASSWORD                                           VARCHAR2(100)
 MBTI_TYPE_ID                                       NUMBER(3)
 CREATED_AT                                         DATE
 UFILE                                              VARCHAR2(255)
 MOBILE                                             VARCHAR2(50)
 NICKNAME                                           VARCHAR2(50)
 PROVIDER                                  NOT NULL VARCHAR2(50)
 PROVIDER_ID                                        VARCHAR2(100)


SQL> desc authorities;
 이름                                      널?      유형
 ----------------------------------------- -------- ----------------------------
 AUTH_ID                                   NOT NULL NUMBER(5)
 EMAIL                                              VARCHAR2(255)
 AUTH                                      NOT NULL VARCHAR2(255)
 APP_USER_ID                                        NUMBER(5)
*/