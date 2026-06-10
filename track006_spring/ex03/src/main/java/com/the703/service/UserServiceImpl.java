package com.the703.service;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service; 
import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.dto.UserDto;

@Service
public   class UserServiceImpl  implements UserService{
	@Autowired  UserMapper dao;
	@Autowired  @Qualifier("passwordEncoder") PasswordEncoder  pwencoder;
	//import org.springframework.security.crypto.password.PasswordEncoder;
	
	@Override public int insert(UserDto dto) { 
		/////
		AuthDto adto = new AuthDto();   adto.setEmail(dto.getEmail());   adto.setAuth("ROLE_MEMBER");
		dao.insertAuth(adto);   // 권한추가 
		///// 3셋팅        2암호화				  1사용자가 입력한값가져오기
		dto.setBpass(     pwencoder.encode(  dto.getBpass()   )  );
		try { dto.setBip(InetAddress.getLocalHost().getHostAddress()); }
		catch (UnknownHostException e) { e.printStackTrace(); }
		return dao.insert(dto); 
	}
	
	@Override public int findLogin(UserDto dto) { return dao.findLogin(dto); }
	@Override public UserDto findByUno(int uno) { return dao.findByUno(uno); }
	@Override public String findByEmail(String email) { return dao.findByEmail(email); }
	@Override public AuthListDto readAuth(AuthDto dto) { return dao.readAuth(dto); }
	
	@Override public        UserDto   findByEmailUserInfo( String email) {
		return dao.findByEmailUserInfo(email);
	}

}



