package com.the703.oauth2;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.the703.dao.AppUserDao;
import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;
import com.the703.dto.AuthDto;
import com.the703.security.CustomUserDetails;

@Service
public class Oauth2UserService extends DefaultOAuth2UserService{

	@Autowired  AppUserDao dao;
	@Autowired  PasswordEncoder   passwordEncoder;
	
	//alt + shift + s (override)
	@Override public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		/////1. 회사 - 유저정보
		System.out.println(".....................................1 : " + userRequest);
		
		OAuth2User  oAuth2User  = super.loadUser(userRequest);  //Attributes- Map{ "key" :"value"}
		String provider   = userRequest.getClientRegistration().getRegistrationId();//kakao, naver, google
		
		UserInfoOAuth2  info = null;   
		     if( "google".equals(provider) ){   info = new UserGoogle( oAuth2User.getAttributes()); }
		else if( "naver".equals(provider) ) {   info = new UserNaver( oAuth2User.getAttributes());  }
		else if( "kakao".equals(provider) ) {   info = new UserKakao( oAuth2User.getAttributes());  }
		else {    
			throw new OAuth2AuthenticationException("지원하지 않은 소셜입니다. " + provider);
		}
		
		/////2. 유저정보 -  email, nickname, providerId
		String email      = info.getEmail();
		String nickname   = info.getNickname();
		String providerId = info.getProviderId(); 
		String img        = info.getImage();  //## 
		
		AppUserDto  param = new AppUserDto();  
		param.setEmail(email);  param.setProvider(provider);  param.setProviderId(providerId); 
		AppUserDto  userinfo = 	dao.findByEmail(param);  // 마이페이지
		     
		/////3. 1) db회원가입   2) 회원정보입력받는창 / 마이페이지   
		if(userinfo == null) {  //회원가입
			param.setNickname(   nickname != null ? nickname :   provider  + UUID.randomUUID().toString() );
			param.setPassword(   passwordEncoder.encode(  UUID.randomUUID().toString())  );
			param.setMbtiTypeId(1);   
			param.setUfile(      img != null?  img :   "the703.png");   
			param.setMobile("");
			dao.insertAppUser(param);   //1. 회원가입
			
			AuthDto auth = new AuthDto();
			auth.setEmail(email);   auth.setAuth("ROLE_MEMBER");  dao.insertAuth(auth);
			System.out.println("........ 신규 소셜 사용자가입  : " + email);
		}else { // 마이페이지 - 업데이트  sq
			param.setAppUserId(userinfo.getAppUserId());
			param.setNickname(nickname  );   param.setUfile("the703.png"); dao.updateAppUser(param);  
			System.out.println("........ 기존 소셜 사용자수정  : " + email);
		}
		 
		AppUserAuthDto authDto = dao.readAuthByEmail(param);  // 시큐리티
		CustomUserDetails  customUserDetails = new CustomUserDetails( param ,authDto);
		
		Map<String, Object>  attrs = new HashMap<>(oAuth2User.getAttributes());
		attrs.put("provider", provider);
		attrs.put("email"   , email);
		attrs.put("nickname", nickname);
		customUserDetails.setAttributes(attrs);
		return customUserDetails;
	}
}
//1) kakao로그인 → kakao 이유저 나알아~! 보장해줄께 유저정보를 넘겨줌.
//2) 시큐리티에서 유저정보를 가져와서 UserDetails 객체만들어서 정보들어감.  password null값 오류
//3) 쇼셜사용자의 password가 null이면 - 누군가가 비밀번호를 알아서 입력, 공백쳐서 로그인 방지











