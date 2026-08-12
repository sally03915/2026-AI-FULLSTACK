package com.thejoa703.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.LoginRequest;
import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.entity.AppUser;
import com.thejoa703.exception.ResourceNotFoundException;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.util.FileStorageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)  //데이터 저장(insert)시 rollback  / readOnly=true  읽기전용,낭비
public class UserService { 
	private final AppUserRepository   appUserRepository;    
	private final FileStorageService  fileStorageService; 
	private final PasswordEncoder     passwordEncoder;// 보안 : 비밀번호 암호화   ##
	//Create : 회원가입  
	@Transactional
	public  UserResponseDto createUser(UserRequestDto request , MultipartFile  profileImage) {
		String provider = request.getProvider() != null ? request.getProvider() : "local";
		
		if( appUserRepository.findByEmailAndProvider(request.getEmail() , provider).isPresent() ) {   
			throw new IllegalArgumentException("이미 존재하는 사용자입니다.");  
		} 
		if( appUserRepository.existsByNickname( request.getNickname()) ) {   
			throw new IllegalArgumentException("이미 사용중인 닉네임입니다.");  
		} 
        AppUser user = new AppUser();
        user.setEmail(request.getEmail());
        user.setPassword(  passwordEncoder.encode(   request.getPassword()  )  ); //##  암호화
        user.setNickname(request.getNickname());
        user.setProvider(provider);
        user.setRole("ROLE_USER");	 
        user.setUfile( profileImage != null &&  !profileImage.isEmpty()
        			  ?   fileStorageService.upload(profileImage) 
        		      :   "uploads/thejoa703.png"); 
		return    UserResponseDto.fromEntity(   appUserRepository.save(user)   ) ;   // 유저생성
	}

	//Read : 이메일중복검사
	public boolean  existsByEmail(String email) {  return   appUserRepository.existsByEmail(email); }
	
	//Read : 닉네임중복검사
	public boolean  existsByNickname(String nickname) {  return   appUserRepository.existsByNickname(nickname); }
	
	//Read : 로그인   
	public  UserResponseDto  login(LoginRequest request) {
		AppUser  user = appUserRepository
		 .findByEmailAndProvider( request.getEmail(),request.getProvider() != null?  request.getProvider() : "local")
		 .orElseThrow( ()->  new ResourceNotFoundException("사용자를 찾을수 없습니다.") );
		
		//######
		//								사용자가 입력한 값 		/ db의 비밀번호
		if(  !passwordEncoder.matches(request.getPassword(), user.getPassword()) ) {
			throw new IllegalArgumentException("비밀번호 불일치");
		}
		 
		return  UserResponseDto.fromEntity(user);
	} 
	//	userService.findByEmailAndProvider(userInfo.getEmail(), userInfo.getProvider())
	//    .orElseGet(() -> userService.saveSocialUser(
	
	//#### 사용자조회 - findByEmailAndProvider
	public  Optional<AppUser>   findByEmailAndProvider(String email, String provider){
		return   appUserRepository.findByEmailAndProvider(email, provider);
	}
	//#### saveSocialUser 
	@Transactional	  //######  social - insert
	public AppUser saveSocialUser( String email, String provider, String providerId, String nickname, String image) {
		AppUser user  = AppUser.builder()
						   .email(email)
						   .provider(provider)
						   .providerId(providerId)
						   .nickname(nickname)
						   .ufile(image)
						   .password( passwordEncoder.encode("thejoa703")  )   //## social + security
						   .role("ROLE_USER") 
						   .build();
		return appUserRepository.save(user);  
	}
	
	//##### 권한조회
	public String findRoleByUserId(Long userId) {
		return   appUserRepository.findById(userId)       
								  .map(AppUser::getRole)   
								  .orElse("ROLE_USER");    
	}
	
	//Read : 사용자 단건조회
	public   UserResponseDto  getUser(Long userId) {  // Optional - 값 1개, null
		AppUser user =     appUserRepository.findById(userId)
				.orElseThrow( () -> new ResourceNotFoundException("존재하지 않는 사용자입니다.id : " + userId));
		return UserResponseDto.fromEntity(user);
	} 
	//Read : 전체사용자 수
	public long  countUsers() {   return   appUserRepository.count(); }
	
	// Update :  닉네임변경
	@Transactional
	public  UserResponseDto   updateNickname( Long userId,  String newNickanme) { 
		if( appUserRepository.existsByNickname( newNickanme ) ) { throw new IllegalArgumentException("이미 사용중인 닉네임입니다.");  } 
		// 해당유저번호 받아서 유저찾기
		AppUser user   =   appUserRepository.findById(userId)
							.orElseThrow( ()-> new ResourceNotFoundException("사용자를 찾을 수 없습니다. ID: " +userId) );
		// 수정
		user.setNickname(newNickanme);  // 값변경  → 트랜잭션 종료시 자동 update   ( save 한 효과 )
		return   UserResponseDto.fromEntity(user);
	}
	// Update :  프로필이미지변경
	@Transactional
	public  UserResponseDto   updateProfileImage( Long userId, MultipartFile  profileImage) {
		// 해당유저번호 받아서 유저찾기
		AppUser user   =   appUserRepository.findById(userId)
							.orElseThrow( ()-> new ResourceNotFoundException("사용자를 찾을 수 없습니다. ID: " +userId) );
		// 수정
        user.setUfile( profileImage != null &&  !profileImage.isEmpty()
  			  ?   fileStorageService.upload(profileImage) 
  		      :   "uploads/thejoa703.png"); 
        return    UserResponseDto.fromEntity(  user  ) ;  
	}
	
	// Delete :  회원탈퇴
	@Transactional
	public void deleteById(Long userId) {
		//선택1) 소프트딜리트 - 프로필이미지번경한 예시처럼 수정
		if(  !appUserRepository.existsById(userId)  ) {
			throw  new IllegalArgumentException("삭제할 사용자가 존재하지 않습니다. ID: " +userId);
		}
		appUserRepository.deleteById(userId);  //선택2) 실제 db에서 삭제  ( 하드딜리트 )
	}
	
}



//회원가입    ( 이메일중복검사, 닉네임중복검사 )
//↓
//로그인       
//↓
//마이페이지  (닉네임변경, 프로필이미지변경 , 회원탈퇴 , 로그아웃) 




