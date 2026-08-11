package com.thejoa703.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.thejoa703.oauth2.CustomOAuth2User;

//import com.thejoa703.oauth2.CustomOAuth2User;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 보안게이트
/**
 * JWT 인증필터
 * - Authorization 헤더에서  Bearer 토큰추출
 * - JwtProvider로  Claims 파싱
 * - CustomOAuth2User  기반 Principal 생성 후 SecurityContext 에 저장
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    // JWT 토큰 발급/검증
    private final JwtProvider jwtProvider;
    // 생성자 
    public JwtAuthenticationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }
    // ###  /uploads/  로 시작하는 요청은 JWT 필터 타지 않게 통과
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return path.startsWith("/uploads/");
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
    	
    	// Step1:  주소와 헤더가 백엔드 필터까지 전송되고 있는지 확인
        String header = request.getHeader("Authorization");
  

        if (StringUtils.hasText(header) && header.startsWith("Bearer ")) {
            String token = header.substring(7);  // 7자 빼고
            try { 
                System.out.println("====== [Filter] 추출된 토큰: " + token);
                
            	// Step2:  토큰추출
                Claims claims = jwtProvider.parse(token).getBody();  
                Long userId = Long.parseLong(claims.getSubject());
                String role = claims.get("role", String.class);
                 
                System.out.println("====== [Filter] 파싱 성공 -> userId: " + userId + ", role: " + role);
                
                // Step3: 시큐리티에 저장 
                 CustomOAuth2User userPrincipal = new CustomOAuth2User(userId, role);

                 UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(
                                userPrincipal, null, userPrincipal.getAuthorities()
                 );

                 SecurityContextHolder.getContext().setAuthentication(auth);
                  
                 System.out.println("====== [Filter] SecurityContext에 인증 정보 저장 완료! ======");
 
            } catch (Exception e) { 
            	// Step4. 토큰파싱, 검증시 에러나는지 확인
                System.out.println("에러 원인: " + e.getMessage());
                e.printStackTrace(); 
                
                SecurityContextHolder.clearContext();
            }
        } else { 
            System.out.println("  [Filter] Authorization 헤더가 누락되었거나 Bearer 형식이 아닙니다.");
        }

        chain.doFilter(request, response);
    }
}
