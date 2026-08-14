package com.thejoa703.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Value("${spring.data.redis.host}")   //application.yml   
    private String host;

    @Value("${spring.data.redis.port}")   // 6379
    private int port;
    // Redis 연결 생성 관리 ( JWT 저장소)
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {  //Lettuce  비동기/반응형 지원
        return new LettuceConnectionFactory(host, port);
    }
    // StringRedisTemplate - Redis 문자열기반 데이터를 저장/조회할수 있도록 해주는 템플릿
    @Bean
    public StringRedisTemplate stringRedisTemplate(LettuceConnectionFactory factory) {
        return new StringRedisTemplate(factory);
    } // 관리

    // 검색 기능 확장을 위한 객체/JSON 직렬화 템플릿
    // 최근 검색목록 ,  해시태그 검색 결과를 REDISD 캐싱할때 사용
     @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        // Key 직렬화 : KEY깨지지 않게 문자열로 
        template.setKeySerializer(new StringRedisSerializer());
        
        // Value 직렬화
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // hash 구조 직렬화 설정
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        return template;
    }    
}