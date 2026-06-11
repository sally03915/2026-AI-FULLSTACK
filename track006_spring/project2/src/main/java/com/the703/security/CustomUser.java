package com.the703.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.the703.dto.AuthUserDto;
import lombok.Getter;

@Getter 
public class CustomUser extends User{  
	private static final long serialVersionUID = 1L; 
 
	AuthUserDto  dto;
	
	//1.유저아이디와 비밀번호를 받아서 권한이 있는지 체크
	public CustomUser(String username, 
				      String password, 
				      Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities); 
	}

	//2. username, password에 맞게 셋팅
    public CustomUser(AuthUserDto  dto) {
    	super(  dto.getEmail() , dto.getBpass() 
    						   , dto.getAuthList()
    						        .stream()
    						        .map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
    						        .collect(Collectors.toList()));
    	this.dto = dto;
    } 
    
}




