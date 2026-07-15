package com.the703.api;

import java.util.List;

import lombok.Data;

@Data
public class KakaoBookResponse {
    private List<KakaoBookDto> documents;
}