package com.the703.dto;

import java.util.List;

import lombok.Data;

@Data
public class AppUserAuthDto {
	private String   		email;
	private String   		password;
	private List<AuthDto>   authList;
}
