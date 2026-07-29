package com.thejoa703.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag( name="User Api" , description="사용자 관련 API"  )   //swagger
@RestController       // @Controller + @ResponseBody
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins="*") 
public class UserController { 
	private final UserService  userService;
	
	// 사용자 등록 (회원가입)
	// ResponseEntity - 상태코드 전달  - /api/users
	@Operation( summary="회원가입" , description = "새로운 사용자를 등록합니다.")
	@PostMapping 
	public    ResponseEntity<UserResponseDto>  createUser(@RequestBody UserRequestDto  requestDto){
		UserResponseDto  response	 = userService.createUser(requestDto);
		return  ResponseEntity.status(HttpStatus.CREATED).body(response);   // HttpStatus.CREATED 201
	}
	
	// 사용자 단건조회                 -  /api/users/1    해당번호
	@Operation( summary="사용자 단건조회" , description = "사용자 ID로 특정회원정보를 조회합니다.")
	@GetMapping("/{id}") 
	public    ResponseEntity<UserResponseDto>  getUser( @PathVariable("id")  Long id ){
		UserResponseDto  response	 = userService.getUser(id);
		   return  ResponseEntity.ok(response);   // ok  200
		// return  ResponseEntity.status(HttpStatus.OK).body(response); 
	} 
}
//
//1. User Api    - 사용자 관련 API
//- POST	/api/users		    회원가입       ※ 기능 : createUser
//- GET		/api/users/{id}		사용자 단건조회  ※ 기능 :  getUser