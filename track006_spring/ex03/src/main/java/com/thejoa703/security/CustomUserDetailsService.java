package com.thejoa703.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.service.UserService;

public class CustomUserDetailsService   implements UserDetailsService{

	@Autowired  UserService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthDto     adto = new AuthDto();    adto.setEmail(username); // 이메일셋팅
		AuthListDto  dto = service.readAuth(adto);  // 이메일,비밀번호, 권한(들) 가져오기
		
		return dto == null?  null : new CustomUser(dto);
	}

}
