package com.the703.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.the703.dto.AuthUserDto;

public class UserServiceImpl  implements UserService{

	@Autowired  UserService service;
	@Override public AuthUserDto readAuth(String email) { return service.readAuth(email); }

}
