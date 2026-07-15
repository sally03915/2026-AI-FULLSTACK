package com.the703.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiReportService {

    private final RestClient restClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${google.report.client-id}")
    private String clientId;

    @Value("${google.report.client-secret}")
    private String clientSecret;

    @Value("${google.report.refresh-token}")
    private String refreshToken;

    public ApiReportService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    // OpenAI 활용 가상 요약 메서드
    public String getAiSummary(String rawTaskData) {
        return "★이번 주 주간 보고 요약★\n- 완료 태스크: 12건\n- 지연 태스크: 3건\n- 리스크: 백엔드 API 인코딩 이슈 해결 완료.";
    }

    /**
     * 💡 [추가됨] 고정된 Refresh Token을 사용해 실시간으로 유효한 Access Token을 발급받는 메서드
     */
    public String getNewAccessToken() {
        try {
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("client_id", clientId);
            formData.add("client_secret", clientSecret);
            formData.add("refresh_token", refreshToken);
            formData.add("grant_type", "refresh_token");

            String response = restClient.post()
                    .uri("https://oauth2.googleapis.com/token")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(formData)
                    .retrieve()
                    .body(String.class);

            JsonNode root = objectMapper.readTree(response);
            return root.path("access_token").asText();
        } catch (Exception e) {
            throw new RuntimeException("구글 Access Token 갱신 실패: " + e.getMessage(), e);
        }
    }

    // Google Docs API 호출 및 문서 생성
    public String createGoogleDoc(String title, String content) { // 💡 파라미터에서 외부 accessToken을 제거했습니다.
        try {
            // 💡 문서를 만들기 직전에 실시간으로 구글 서버에서 가장 싱싱한 토큰을 받아옵니다!
            String accessToken = getNewAccessToken().trim();

            // STEP 1: 빈 구글 문서 생성
            Map<String, Object> createBody = Map.of("title", title);
            
            String createResponse = restClient.post()
                    .uri("https://docs.googleapis.com/v1/documents")
                    // 💡 "Bearer " 문자열 결합 시 오차가 없도록 깔끔하게 매칭
                    .header("Authorization", "Bearer " + accessToken)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(createBody)
                    .retrieve()
                    .body(String.class);

            JsonNode root = objectMapper.readTree(createResponse);
            String documentId = root.path("documentId").asText(); 

            // STEP 2: 본문 텍스트 채우기
            Map<String, Object> updateBody = Map.of(
                "requests", List.of(
                    Map.of("insertText", Map.of("text", content, "location", Map.of("index", 1)))
                )
            );

            restClient.post()
                    .uri("https://docs.googleapis.com/v1/documents/{documentId}:batchUpdate", documentId)
                    .header("Authorization", "Bearer " + accessToken)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(updateBody)
                    .retrieve()
                    .toBodilessEntity();

            // STEP 3: 최종 URL 생성 및 반환
            return "https://docs.google.com/document/d/" + documentId + "/edit";

        } catch (Exception e) {
            throw new RuntimeException("구글 API 호출 중 에러: " + e.getMessage(), e);
        }
    }
}