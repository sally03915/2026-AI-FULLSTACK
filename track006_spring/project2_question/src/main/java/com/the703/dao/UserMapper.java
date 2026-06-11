package com.the703.dao;
import com.the703.dto.AuthDto;
import com.the703.dto.AuthUserDto;
import com.the703.dto.UserDto;


public interface UserMapper { 

	public     AuthUserDto    readAuth(String email);
	
	public  int          insertAuth(AuthDto  dto); 
	public int      	 insert(UserDto dto);  

	public String   findByEmail( String email);
	public UserDto  findByEmailUserInfo(   String email);
	public UserDto  findByNickname(   String nickname);
}
