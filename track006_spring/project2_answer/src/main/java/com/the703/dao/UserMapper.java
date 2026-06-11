package com.the703.dao;
import com.the703.dto.AuthDto;
import com.the703.dto.AuthUserDto;
import com.the703.dto.UserDto;

@Mapper
public interface UserMapper { 
	
	public  int          insertAuth(AuthDto  dto); 
	public int      	 insert(UserDto dto);  

	public     AuthUserDto    readAuth(String email);
	

	public String   findByEmail( String email);
	public UserDto  findByEmailUserInfo(   String email);
	public UserDto  findByNickname(   String nickname);
}
