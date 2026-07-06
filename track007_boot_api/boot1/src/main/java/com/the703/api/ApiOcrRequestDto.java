package com.the703.api;
import lombok.Data;
import java.util.List;

@Data
public class ApiOcrRequestDto {
    private String version = "V2";
    private String requestId;
    private long timestamp;
    private List<ImageDto> images;

    @Data
    public static class ImageDto {
        private String format; // jpg, png 등
        private String name;   // 이미지 명
        private String data;   // Base64 인코딩된 이미지 문자열
    }
}