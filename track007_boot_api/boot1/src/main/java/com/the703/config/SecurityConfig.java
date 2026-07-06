package com.the703.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.the703.oauth2.Oauth2UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig { 
	
	private final Oauth2UserService  oauth2UserService;
	
	// http 경로설정
	@Bean public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http//1. 허용경로
			.authorizeHttpRequests(  auth ->  auth
					.requestMatchers("/users/join"   , "/users/login"  , "/users/iddouble", "/api/**").permitAll()
					.requestMatchers("/users/mypage" , "/users/update", "/users/delete"  ).authenticated()
					.anyRequest().permitAll()
			)
			//2. 로그인처리
			.formLogin(form-> form
					.loginPage("/users/login")
					.loginProcessingUrl("/users/loginProc")
					.defaultSuccessUrl("/users/mypage" , true)
					.failureUrl("/users/fail")
					.permitAll()
			)
			//3. 로그아웃
			.logout( logout -> logout
					.logoutUrl("/users/logout")
					.logoutSuccessUrl("/users/login")
					.invalidateHttpSession(true)
					.clearAuthentication(true)
					.permitAll()
			)
			// oauth2 - social
			.oauth2Login(  oauth2 -> oauth2
					.loginPage("/users/login")
					.defaultSuccessUrl("/users/mypage" , true)
					.userInfoEndpoint( userinfo ->  userinfo.userService(oauth2UserService)  )
			)
			//4. csrf 예외처리
			.csrf(  csrf -> csrf
					.ignoringRequestMatchers("/users/join" , "/users/update" ,  "/users/delete" ));
		return  http.build();
	} 
	
	// AuthenticationManager 설정
	@Bean
	public AuthenticationManager  authenticationManager(AuthenticationConfiguration  config) throws Exception {
		return   config.getAuthenticationManager();
	} 
	
}





