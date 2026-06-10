package com.the703.service; 
import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.dto.UserDto; 

public interface UserService { 
	public int insert(UserDto dto);//1. 회원가입  + 권한추가
	public int findLogin(UserDto dto);//2. 로그인 
	public UserDto  findByUno(int  uno);//3. 마이페이지 
	public String   findByEmail( String email);//4. 아이디중복검사
	 
	/* security login */
	public    AuthListDto   readAuth(AuthDto  dto);
	public        UserDto   findByEmailUserInfo( String email);
}
