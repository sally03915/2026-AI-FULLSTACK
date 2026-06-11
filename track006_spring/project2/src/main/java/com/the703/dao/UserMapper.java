package com.the703.dao;
import com.the703.dto.AuthUserDto;

@Mapper
public interface UserMapper {
	public     AuthUserDto    readAuth(String email);
}
