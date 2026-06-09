package com.the703.service;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import com.the703.dao.UserMapper;
import com.the703.dto.UserDto;

@Service
public class UserServiceImpl  implements UserService{
	@Autowired  UserMapper dao;
	@Override public int insert(UserDto dto) { 
		try { dto.setBip(InetAddress.getLocalHost().getHostAddress()); }
		catch (UnknownHostException e) { e.printStackTrace(); }
		return dao.insert(dto); 
	}
	@Override public int findLogin(UserDto dto) { return dao.findLogin(dto); }
	@Override public UserDto findByUno(int uno) { return dao.findByUno(uno); }
	@Override public String findByEmail(String email) { return dao.findByEmail(email); } 
}
