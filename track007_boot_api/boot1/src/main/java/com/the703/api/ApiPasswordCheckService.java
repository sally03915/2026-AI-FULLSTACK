package com.the703.api;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class ApiPasswordCheckService {
 
	
    private final RestClient restClient;
 
    public ApiPasswordCheckService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("https://api.pwnedpasswords.com/range/").build();
    }
 

    /**
     * 비밀번호 유출 횟수를 반환합니다.
     * @param password 검사할 비밀번호 (평문)
     * @return 유출 횟수 (유출되지 않았다면 0)
     */
    public int checkPasswordLeakCount(String password) {
        try {
            // 1. SHA-1 해시값 생성 및 대문자 변환
            String sha1Hash = convertToSha1Hex(password);
            
            // 2. 앞 5자리(prefix)와 나머지 35자리(suffix) 분리
            String prefix = sha1Hash.substring(0, 5);
            String suffix = sha1Hash.substring(5);

            // 3. RestClient를 사용한 동기 HTTP GET 요청
            String response = restClient.get()
                    .uri("/{prefix}", prefix)
                    .retrieve()
                    .body(String.class);

            if (response == null || response.isEmpty()) {
                return 0;
            }

            // 4. 결과 분석 (나머지 35자리가 목록에 있는지 대소문자 구분 없이 비교)
            String[] lines = response.split("\r?\n");
            for (String line : lines) {
                String[] parts = line.split(":");
                if (parts[0].equalsIgnoreCase(suffix)) {
                    return Integer.parseInt(parts[1]); // 유출 횟수 반환
                }
            }

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-1 알고리즘을 찾을 수 없습니다.", e);
        } catch (Exception e) {
            throw new RuntimeException("비밀번호 유출 확인 중 오류가 발생했습니다.", e);
        }

        return 0;
    }

    // SHA-1 해싱 헬퍼 메소드
    private String convertToSha1Hex(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] messageDigest = md.digest(input.getBytes());
        
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString().toUpperCase();
    }
}