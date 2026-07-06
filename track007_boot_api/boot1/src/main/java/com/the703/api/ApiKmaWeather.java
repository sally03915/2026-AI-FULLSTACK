package com.the703.api;

import java.net.URI;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ApiKmaWeather {
	@Value("${kma.api}")  private String apiKey;
	
	private final RestClient  restClient;

	public ApiKmaWeather(RestClient.Builder restClientBuilder) {
		super();
		this.restClient = restClientBuilder.build();
	}
	
	public  String getWeatherResponse() {
		String date = new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis());
		// https  시작하지 않아도 ok  / 인코딩문제관련 문제 처리
		URI uri = UriComponentsBuilder
				.fromUriString("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst")     
				.queryParam("serviceKey", apiKey)
				.queryParam("numOfRows", 10)
				.queryParam("pageNo", 1)
				.queryParam("base_date", date)
				.queryParam("base_time", "0600")
				.queryParam("nx", 55)
				.queryParam("ny", 125)
				.build(true)
				.toUri();
		
		try {
			return restClient.get()
							.uri(uri)
							.retrieve()
							.body(String.class);
		}catch(Exception e) {  throw new RuntimeException("기상청 API 호출 중 오류 발생 " , e);}
	} 
}
 
/*
http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst
?serviceKey=인증키&numOfRows=10&pageNo=1
&base_date=20210628&base_time=0600&nx=55&ny=125
*/