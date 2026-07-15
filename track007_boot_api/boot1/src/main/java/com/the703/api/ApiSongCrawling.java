package com.the703.api;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class ApiSongCrawling {

	public List<SongDto>  crawling(){
		List<SongDto>  list = new ArrayList<>();	
		// https://www.melon.com/chart/index.htm
		// Mozilla/5.0 (Windows NT 10.0; Win64; x64)

		try {
			
			String url = "https://www.melon.com/chart/index.htm";  //##
			Connection  conn = Jsoup.connect(url)
									.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")  //브라우저처럼 위장
									.referrer("https://www.melon.com/")  // 출처 ##
									.timeout(10_000);  // 연결시도후 응답을 기다리는데 최대시간 (밀리초)  10초
			Document doc = conn.get();
			
			Elements  titleEle = doc.select(".ellipsis.rank01  a");   // 태그의 css표현  ##
			Elements  artistEle = doc.select(".ellipsis.rank02 a");  // ##
			
			int cnt = Math.min( titleEle.size() , artistEle.size() );
			for(int i=0; i<cnt; i++) {
				String title  = titleEle.get(i).text();
				//String titleHref = titleEle.get(i).attr("href");
				String artist = artistEle.get(i).text();
				list.add(new SongDto(title, artist));
			}
			
		} catch (Exception e) { 
			e.printStackTrace(); 
			list.add(new SongDto("크롤링 중 오류발생", e.getMessage()));
		}
		return list;
	}
}

// 크롤링 -  웹페이지를 발견하고 수집하는 과정
// 스크랩핑 - 수집된페이지에서 원하는 데이터만 추출하는 과정 