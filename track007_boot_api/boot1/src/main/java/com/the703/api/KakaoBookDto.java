package com.the703.api;

import java.util.List;
import lombok.Data;

@Data
public class KakaoBookDto {
    private String title;          // 도서 제목
    private List<String> authors;  // 저자 리스트 (카카오는 배열로 줍니다)
    private String publisher;      // 출판사
    private int price;             // 도서 정가
    private int sale_price;        // 도서 판매가
    private String thumbnail;      // 도서 썸네일 이미지 URL
    private String contents;       // 도서 소개 요약 (네이버의 description 역할)
    private String isbn;           // ISBN 번호 (10자리 또는 13자리, 공백으로 구분됨)
    private List<String> translators; // 번역가 리스트
    private String datetime;       // 출판일 (ISO 8601 형식)
    private String status;         // 판매 상태 (정상판매, 품절 등)
}