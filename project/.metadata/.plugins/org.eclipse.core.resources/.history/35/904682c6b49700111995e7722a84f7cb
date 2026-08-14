package com.thejoa703.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.thejoa703.oauth2.OAuth2SuccessHandler;
import com.thejoa703.security.JwtAuthenticationFilter;
import com.thejoa703.security.JwtProvider;

import lombok.RequiredArgsConstructor;

/**  
 * Spring Security 설정
 * - csrf / formLogin / httpBasic  비활성화
 * - Cors 설정 ( react 에서 접속가능여부 )
 */

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtProvider jwtProvider;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;

 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http 
        	// 기본보안기능 비활성화
            .csrf(csrf -> csrf.disable())
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())
            // Cors 설정
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            // 세션설정 - STATELESS
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            // 권한 설정
            .authorizeHttpRequests(auth -> auth
                // Swagger, 인증관련경로 권한 설정	
                .requestMatchers(
                    "/auth/**", "/login/**", "/oauth2/**",
                    "/swagger-ui/**", "/v3/api-docs/**",
                    "/swagger-resources/**", "/webjars/**", 
                    "/configuration/**", "/uploads/**"  , "/api/deptusers/**" , "/api/likes/**"
                ).permitAll() 
                // 해쉬태그
                .requestMatchers(HttpMethod.GET, "/api/posts/search/hashtag").permitAll()   
                // 전제조회용
                .requestMatchers(HttpMethod.GET, "/api/posts").permitAll()    
                // 단건조회용
                .requestMatchers(HttpMethod.GET, "/api/posts/**").permitAll()  
                .requestMatchers("/api/posts/paged").permitAll() 
                // /api/ 요청은 jwt 인증필요
                .requestMatchers("/api/**").authenticated()
                // 나머지는 모두허용
                .anyRequest().permitAll()
            )
            // Oauth2 로그인은 소셜로그인전용
            .oauth2Login(oauth2 -> oauth2.successHandler(oAuth2SuccessHandler))
            // 시큐리티 체인안에서 동작
            .addFilterBefore(new JwtAuthenticationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
            throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
 
        //configuration.setAllowedOrigins(List.of("http://localhost:3000"));  //★ Front 포트번호
        // ★ React 및 Flutter 웹/앱에서 접근할 수 있도록 허용 주소 추가
        configuration.setAllowedOriginPatterns(List.of(
            "http://localhost:3000",       // React 개발 서버
            "http://localhost:*",          // 로컬에서 뜨는 다른 포트들 (Flutter Web 등)
            "https://*.yourdomain.com"     // 배포된 도메인 (필요시 추가)
        ));

        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
