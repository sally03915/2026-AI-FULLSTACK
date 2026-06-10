------------------------------
#6. Security  
------------------------------   
▶ 1. Security?
 - 애플리케이션의 보안(인증, 인가)을 담당
 - Filter의 흐름에 따라 처리

▶ 2. 인증  VS  인가
 - 인증  Authentication - [본인]이 맞는지 확인       : 여권갖고 비행기탑승, 로그인
 - 인가  Authorization  - 인증된사용자가 [접근가능]   : 승객은 조종실에 못들어감.

▶ 3. Security 아키텍쳐

=====================
		 ② [UsernamePasswordAuthentication Token]
 			↓
① Http Request  →     [AuthenticationFilter] ③ ...  →  [Authentication  Manager]
			↓⑩               ⑨	  ←
		    [SecurityContextHolder]
=====================

-1. 사용자가 로그인 폼태그 시도 (username + password 전달)
-2. UsernamePasswordAuthentication 요청정보  Authentication 를 생성
-3. Authentication 인증처리
★UsernamePasswordAuthentication

-10. 인증 완료가 [사용자정보]   SecurityContextHolder 담기
    - AuthenticationSuccessHandler   를 실행( 성공 )
    - AuthenticationFailureHandler   를 실행( 실패 )

=====================
 [AuthenticationFilter] ③   → [Authentication  Manager] → ④[AuthenticationProvider(s)]
			  		         						← ⑨       ↑	↓⑤	
							↑		   						 [ UserDetailsService ]	 
			  				 ProviderManager		          ↑	↓⑥
						      								 [ UserDetails ]	

=====================
-4. Authentication  Manager  인증담당
★UsernamePasswordAuthentication  Token은 Provider를 찾는데 사용
 
AuthenticationProvider
★ 로그인정보 DB정보와 비교

UserDetailsService
★ DB에 있는 [사용자정보]가져오기


■ver-1) 시큐리티 구조
1. pom.xml 
2. web.xml
3. serucity-context.xml  
4. SecurityController

■ver-2) 시큐리티 DB 연동

