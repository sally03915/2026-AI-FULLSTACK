package com.thejoa703.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.LoginRequest;
import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Tag( name="User Api" , description="회원 인증 및 관리 관련 API (Session & Swagger  지원)"  )   //swagger
@RestController       // @Controller + @ResponseBody
@RequestMapping("/auth")     //     /api/users
@RequiredArgsConstructor 
public class UserController { 
	
	private final UserService  userService;   //@Autowired
	
	// 사용자 등록 (회원가입)
	// 회원가입
	@Operation( summary="회원가입" , description = "새로운 사용자를 등록합니다.")
	@PostMapping(  value="/signup" , consumes= MediaType.MULTIPART_FORM_DATA_VALUE)   
	public    ResponseEntity<UserResponseDto>  createUser(
			@ModelAttribute UserRequestDto  request , // multipart/form-data
			@Parameter(description="프로필 이미지 파일")  // swagger
			@RequestPart(name="ufile" , required=false)  MultipartFile  ufile
	){  //return  ResponseEntity.status(HttpStatus.CREATED).body(response);   // HttpStatus.CREATED 201
		return   ResponseEntity.ok(   userService.createUser(request , ufile)    );
	}
	
	// 이메일중복확인 
	@Operation( summary="이메일 중복 확인" , description = "사용 중인 이메일인지 중복 여부를 확인합니다.")
	@GetMapping("/check-email") 
	public   ResponseEntity<Boolean>   checkEmail(
			@Parameter(description="확인할 이메일")  @RequestParam("email")  String email 
	){	
		return  ResponseEntity.ok(  userService.existsByEmail(email));
	}
	
	// 닉네임중복확인 
	@Operation( summary="닉네임 중복 확인" , description = "사용 중인 닉네임인지 중복 여부를 확인합니다.")
	@GetMapping("/check-nickname") 
	public   ResponseEntity<Boolean>   checkNickname(
			@Parameter(description="확인할 닉네임")  @RequestParam("nickname")  String nickname 
	){	
		return  ResponseEntity.ok(  userService.existsByNickname(nickname));
	}
	
	// 로그인
	@Operation( summary="로그인" , description = "이메일과 비밀번호로 로그인하여 세션을 생성합니다.")
	@PostMapping(value="/login"  , consumes = MediaType.APPLICATION_JSON_VALUE) 
	public   ResponseEntity<UserResponseDto>   login(
			@RequestBody LoginRequest request,
			HttpSession session   // jakarta.servlet.http.HttpSession
	){	
		//Long userId = (Long)session.getAttribute("LOGIN_USER_ID");
		//if( userId == null ) {  return  ResponseEntity.status(401).build();  }   // 권한없음.
		//return  ResponseEntity.ok(  userService.getUser(userId));  
		UserResponseDto  user	 =	userService.login(request);
		session.setAttribute("LOGIN_USER_ID", user.getId());  //세션셋팅
		return  ResponseEntity.ok(  user );
	}
	
	// 로그아웃 
	@Operation( summary="로그아웃" , description = "현재 세션을 만료시켜 로그아웃합니다.")
	@PostMapping("/logout")
	public    ResponseEntity<Void> logout(HttpSession session){
		session.invalidate();
		return ResponseEntity.noContent().build();
	}
	
	// 마이페이지       
	@Operation( summary="현재 로그인한 사용자 정보조회" , description = "세션기반으로 현재 로그인된 사용자의 정보를 조회")
	@GetMapping("/me") 
	public    ResponseEntity<UserResponseDto>  getUser( HttpSession session ){
		
		Long userId = (Long)session.getAttribute("LOGIN_USER_ID");
		if( userId == null ) {  return  ResponseEntity.status(401).build();  }   // 권한없음.
		return  ResponseEntity.ok(  userService.getUser(userId));  
	} 
	// 닉네임수정
	@Operation( summary="닉네임 변경" , description = "특정 사용자의 닉네임을 변경합니다.")
	@PatchMapping("/{userId}/nickname")
	public    ResponseEntity<UserResponseDto>  updateNickname(
			@Parameter(description = "사용자 ID")    @PathVariable("userId") Long userId ,
			@Parameter(description = "변경할 닉네임")  @RequestParam("nickname") String nickname
	){
		return ResponseEntity.ok(   userService.updateNickname(userId, nickname) );
	}
	
	// 이미지프로필수정
	@Operation( summary="프로필 이미지 업로드/교체" , description = "특정 사용자의 프로필이미지를 변경합니다.")
	@PatchMapping(value="/{userId}/profile-image" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public    ResponseEntity<UserResponseDto>  updateProfileImage(
			@Parameter(description = "사용자 ID")    @PathVariable("userId") Long userId ,
			@Parameter(description = "변경할 닉네임")  @RequestParam("ufile") MultipartFile ufile
	){
		return ResponseEntity.ok(   userService.updateProfileImage(userId, ufile) );
	}
	
	
	// 탈퇴
	@Operation( summary="회원 탈퇴" , description = "로그인된 사용자 계정을 삭제하고 세션을 만료시킵니다.")
	@DeleteMapping("/me")
	public    ResponseEntity<Void>  deleteMe(HttpSession session){
		Long userId = (Long)session.getAttribute("LOGIN_USER_ID");
		if( userId == null ) {  return  ResponseEntity.status(401).build();  }   // 권한없음.
		
		userService.deleteById(userId);
		session.invalidate();
		return  ResponseEntity.noContent().build();
	}

	
}
//
//1. User Api    - 사용자 관련 API
//- POST	/api/users		    회원가입       ※ 기능 : createUser
//- GET		/api/users/{id}		사용자 단건조회  ※ 기능 :  getUser