package com.thejoa703.oauth2;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import lombok.Getter;

/**
 * jwt/oauth2 사용자 통합 클래스
 * - jwt/oauth2 사용자 모두 UserDetails 기반으로 관리
 * - SecurityConftext에서 principal 타입으로 일관되게 유지
 */
@Getter
public class CustomOAuth2User implements OAuth2User, UserDetails { //소셜 사용자정보,  시큐리티
 
    private static final long serialVersionUID = 1L;
	
    private final Long id;           // jwt subject 유저     
    private final String provider;   // google, kakao, naver  + local  
    private final String email;
    private final String nickname;
    private final String role;
    private final Map<String, Object> attributes;
 
    // JWT 사용자 
    public CustomOAuth2User(Long id, String role) {
        this.id = id;
        this.role = role;
        this.provider = null;
        this.email = null;
        this.nickname = null;
        this.attributes = null;
    }
    // OAuth2 사용자생성용
    public CustomOAuth2User(String provider, String email, String nickname,
                               String role, Map<String, Object> attributes) {
        this.id = null;
        this.provider = provider;
        this.email = email;
        this.nickname = nickname;
        this.role = role;
        this.attributes = attributes;
    }
    // OAUTH2구현
    @Override
    public Map<String, Object> getAttributes() { return attributes; }

    @Override
    public String getName() { return email != null ? email : String.valueOf(id); }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() { return "N/A"; }    // PASSWORD 설정 X

    @Override
    public String getUsername() { return email != null ? email : String.valueOf(id); }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
 
    public Long getId() { return id; }
    public String getProvider() { return provider; }
    public String getNickname() { return nickname; }
    public String getRole() { return role; }
}
