package com.the703.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Service
public class ApiNaverBookXml {
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Channel {
        @JacksonXmlProperty(localName="item")
        @JacksonXmlElementWrapper(useWrapping = false)
        private List<BookDto> items;

        public List<BookDto> getItems() { return items; }
        public void setItems(List<BookDto> items) { this.items = items; }
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Rss {
        @JacksonXmlProperty(localName="channel")
        private Channel channel;
        public Channel getChannel() { return channel; }
        public void setChannel(Channel channel) { this.channel = channel; }
    }
    
    private final RestClient restClient;
    private final XmlMapper xmlMapper = new XmlMapper();

    // Spring Boot 3 생성자 주입 방식으로 RestClient 초기화
    public ApiNaverBookXml(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }
    
    public List<BookDto> getBooks(String query) {
        String clientId = "reu63fdeQl8IXmwLVsRM";  
        String clientSecret = "AvEnm8FcX2";        
        
        // 1. UriComponentsBuilder로 안전하게 URI 조립 (URLEncoder 제거 가능)
        java.net.URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com/v1/search/book.xml")
                .queryParam("query", query)
                .build()
                .toUri();
        
        try {
            // 2. RestClient를 이용한 세련된 GET 호출
            String responseBody = restClient.get()
                    .uri(uri)
                    .header("X-Naver-Client-Id", clientId)
                    .header("X-Naver-Client-Secret", clientSecret)
                    .accept(MediaType.APPLICATION_XML) // Accept: application/xml 설정
                    .retrieve()
                    .body(String.class);
            
            // 3. XML 파싱 (기존 로직 유지)
            Rss rss = xmlMapper.readValue(responseBody, Rss.class);
            return rss.getChannel().getItems();
            
        } catch (Exception e) { 
            throw new RuntimeException("네이버 북 API 호출 또는 XML 파싱 오류", e);
        }
    } 
}

//curl "https://openapi.naver.com/v1/search/book.xml?query=%EC%A3%BC%EC%8B%9D&display=10&start=1" \
//-H "X-Naver-Client-Id: {애플리케이션 등록 시 발급받은 클라이언트 아이디 값}" \
//-H "X-Naver-Client-Secret: {애플리케이션 등록 시 발급받은 클라이언트 시크릿 값}" -v