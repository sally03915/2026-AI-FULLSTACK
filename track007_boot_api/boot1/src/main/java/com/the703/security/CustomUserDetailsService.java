package com.the703.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.the703.dao.AppUserDao;
import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;

@Service   //## 
public class CustomUserDetailsService   implements UserDetailsService{
	@Autowired  AppUserDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//1. username   1@1:local   2@2:kakao
		String [] parts = username.split(":");    // {1@1 , local} =  1@1:local
		String email    = parts[0];
		String provider = parts.length > 1? parts[1] : "the703";  // local - 회원가입한사람.
		
		AppUserDto dto = new AppUserDto();   dto.setEmail(email);  dto.setProvider(provider);
		AppUserAuthDto authDto = dao.readAuthByEmail(dto);  //  username, password, List<AuthDto>
		
		
		AppUserDto     appUserDto  = dao.findByEmail(dto);  // 사용자정보들
		
		
		return new CustomUserDetails(appUserDto, authDto);  // 사용자정보, 사용자 로그인정보
	}
}





