package com.the703.dto;

import java.util.List;

import lombok.Data;

@Data
public class AuthListDto {
	private  String email;
	private  String bpass;
	private  List<AuthDto> authList;  
}
