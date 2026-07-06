package com.the703.oauth2;

import java.util.Map;
import lombok.AllArgsConstructor;

@AllArgsConstructor // 모든필드를 생성자로부터 받기 - 컴파일시점에서 자동생성
public class UserNaver  implements UserInfoOAuth2 {
	private final  Map<String, Object>  attributes;   // @Autowired- 생성자찾아서 di

	@SuppressWarnings("unchecked")
	private  Map<String, Object>  getResponse(){
		Object response = attributes.get("response");
		return response instanceof Map?   (Map<String, Object>)response : null;
	}
	@Override public String getProvider() { return "naver"; }
	@Override public String getProviderId() { 
		Map<String, Object>  response =  getResponse();
		return response != null?  String.valueOf(   response.get("id")) : null; 
	}
	@Override public String getEmail() { 
		Map<String, Object>  response =  getResponse();
		return response != null?  String.valueOf(   response.get("email")) : null;  
	}
	@Override public String getNickname() { 
		Map<String, Object>  response =  getResponse();
		return response != null?  String.valueOf(   response.get("name")) : null;   
	}
	@Override public String getImage() { 
		Map<String, Object>  response =  getResponse();
		return response != null?  String.valueOf(   response.get("profile_image")) : "the703.png";   
	}
}
 
/*
<naver>
{
    resultcode=00, 
    message=success, 
    response = {
        id=pvdq1FSG3VZlD7Cp3JuWfAFi-3xir6A-WPlP5f8kXIo, 
        email=sally03915@naver.com, 
        name=안효정
    }
} 

*/