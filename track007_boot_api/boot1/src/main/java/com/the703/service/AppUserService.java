package com.the703.service;

import org.springframework.web.multipart.MultipartFile;
import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;

public interface AppUserService {
	//1. 회원가입 - 유저정보등록(이미지) + 권한 + 비밀번호 암호화
	public  int insert(MultipartFile file, AppUserDto dto);
	
	//2. 회원정보수정 - local (내회사)
	public  int update(MultipartFile file, AppUserDto dto);
	
	//3. 회원정보삭제 - local true / social false
	public  int delete(AppUserDto dto, boolean local);
	
	//4. 로그인
	public  AppUserAuthDto readAuthByEmail( String email, String provider);
	
	//5. 마이페이지
	public  AppUserDto selectEmail( String email, String provider);
	
	//6. 아이디중복체크
	public  int  iddouble( String email, String provider);
	
	//7. 비밀번호 맞는지 확인
	public boolean  matchesPassword( String email, String provider , String rawPassword);
}
