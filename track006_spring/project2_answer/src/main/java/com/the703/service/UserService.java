package com.the703.service;

import com.the703.dto.AuthUserDto;
import com.the703.dto.UserDto;

public interface UserService {

	public int insert(UserDto dto);//1. 회원가입  + 권한추가
	public     AuthUserDto    readAuth( String email );
	
	public String   findByEmail( String email );
	public UserDto  findByEmailUserInfo( String email );
	public UserDto  findByNickname( String nickname );
}

