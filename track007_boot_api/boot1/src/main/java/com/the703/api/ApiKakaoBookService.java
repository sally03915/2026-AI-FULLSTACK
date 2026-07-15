package com.the703.api;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ApiKakaoBookService {

    private final String kakaoRestApiKey;
    private final RestClient restClient;
    private final String kakaoBookUrl = "https://dapi.kakao.com/v3/search/book";

    // properties의 kakaoRestApi 값을 주입받도록 수정했습니다.
    public ApiKakaoBookService(@Value("${kakaoRestApi}") String kakaoRestApiKey) {
        this.kakaoRestApiKey = kakaoRestApiKey;
        this.restClient = RestClient.builder().build();
    }

    /**
     * 카카오 도서 검색 API 호출 서비스
     * @param search 검색 키워드
     * @return List<KakaoBookDto> 카카오 규격 책 정보 리스트
     */
    public List<KakaoBookDto> getBooks(String search) {
        try {
            // 1. 검색 파라미터 및 URI 빌드
            URI targetUrl = UriComponentsBuilder.fromHttpUrl(kakaoBookUrl)
                    .queryParam("query", search)
                    .queryParam("size", 10) // 가져올 데이터 개수 (기본 10, 최대 50)
                    .build()
                    .toUri();

            // 2. RestClient를 이용한 API 호출
            KakaoBookResponse response = restClient.get()
                    .uri(targetUrl)
                    .header(HttpHeaders.AUTHORIZATION, "KakaoAK " + kakaoRestApiKey)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(KakaoBookResponse.class);

            // 3. 응답 결과 반환
            if (response != null && response.getDocuments() != null) {
                return response.getDocuments();
            }

        } catch (Exception e) {
            // 외부 API 장애가 전체 시스템 다운으로 이어지지 않도록 예외 처리 후 빈 리스트 반환
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}


// https://developers.kakao.com/docs/ko/daum-search/dev-guide

/*
 curl -v -G GET "https://dapi.kakao.com/v3/search/book?target=title" \
  --data-urlencode "query=미움받을 용기" \
  -H "Authorization: KakaoAK ${REST_API_KEY}" 
 */
