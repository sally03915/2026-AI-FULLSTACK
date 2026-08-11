package com.thejoa703.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//암호화
@Configuration
public class PasswordConfig {

	@Bean
	public PasswordEncoder   passwordEncoder() {
		return  new BCryptPasswordEncoder();
	}
}
