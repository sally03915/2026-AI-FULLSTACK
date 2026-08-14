package com.thejoa703.security;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate; // 🔍 템플릿 변경
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class TokenStore {
 
    private final StringRedisTemplate stringRedisTemplate; 
 
    // RefreshToken 저장
    public void saveRefreshToken(String userId, String token, long ttlSeconds) {
        String key = buildKey(userId); 
        stringRedisTemplate.opsForValue().set(key, token, ttlSeconds, TimeUnit.SECONDS);
    }

    // RefreshToken 조회
    public String getRefreshToken(String userId) {
        String key = buildKey(userId);
        return stringRedisTemplate.opsForValue().get(key);
    }

    // RefreshToken 삭제 ( 로그아웃 시)
    public void deleteRefreshToken(String userId) {
        String key = buildKey(userId);
        stringRedisTemplate.delete(key);
    }
    // REDIS 키 생성 규칙 ##
    private String buildKey(String userId) {
        return "refresh:" + userId;
    }
}