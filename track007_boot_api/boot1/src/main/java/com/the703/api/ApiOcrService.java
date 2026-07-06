package com.the703.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ByteArrayResource;

import java.util.*;

@Service
public class ApiOcrService {

    @Value("${naver.ocr.secret}")
    private String secretKey;

    @Value("${naver.ocr.invoke-url}")
    private String invokeUrl;

    private final RestClient restClient;

    public ApiOcrService(RestClient.Builder restClientBuilder) {
        // RestClient Builder를 주입받아 초기화 (Spring 권장 방식)
        this.restClient = restClientBuilder.build();
    }

    public String executeOcr(MultipartFile file) throws Exception {
        // 1. DTO 객체 생성 (요청 메타데이터)
        ApiOcrRequestDto requestDto = new ApiOcrRequestDto();
        requestDto.setRequestId(UUID.randomUUID().toString());
        requestDto.setTimestamp(System.currentTimeMillis());

        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        
        ApiOcrRequestDto.ImageDto imageDto = new ApiOcrRequestDto.ImageDto();
        imageDto.setFormat(extension);
        imageDto.setName("ocr_target");
        // 파일 데이터 설정 (RestClient는 ByteArrayResource를 활용해 multipart 파일 전송 가능)
        imageDto.setData(Base64.getEncoder().encodeToString(file.getBytes())); 
        requestDto.setImages(Collections.singletonList(imageDto));

        // 2. multipart/form-data 요청 구성
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        // NCP OCR API 명세에 따라 JSON 메시지 파트 추가 (필요시 Jackson 등으로 문자열 직렬화)
        body.add("message", requestDto); 
        // 파일 파트 추가
        body.add("file", new ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }
        });

        // 3. RestClient API 호출
        ResponseEntity<String> response = restClient.post()
                .uri(invokeUrl)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .header("X-OCR-SECRET", secretKey)
                .body(body)
                .retrieve()
                .toEntity(String.class);

        return response.getBody(); // JSON 형태의 결과 텍스트
    }
}
