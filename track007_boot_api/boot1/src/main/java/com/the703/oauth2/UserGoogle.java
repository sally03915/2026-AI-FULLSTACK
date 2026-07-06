package com.the703.oauth2;

import java.util.Map;
import lombok.AllArgsConstructor;

@AllArgsConstructor // 모든필드를 생성자로부터 받기 - 컴파일시점에서 자동생성
public class UserGoogle  implements UserInfoOAuth2 {
	private final  Map<String, Object>  attributes;   // @Autowired- 생성자찾아서 di
	
	@Override public String getProvider() { return "google"; } 
	@Override public String getProviderId() {
		Object sub  =  attributes.get("sub");
		return sub != null ?  sub.toString() : null;
	}
	@Override public String getEmail() { 
		Object email  =  attributes.get("email");
		return email != null ?  email.toString() : null;
	}
	@Override public String getNickname() {  
		Object name  =  attributes.get("name");
		return name != null ?  name.toString() : null;
	}
	@Override public String getImage() { 
		Object picture  =  attributes.get("picture");
		return picture != null ?  picture.toString() : "the703.png";
	}
}
 
/*
<google>
{
   sub=103058387739722400130, 
   name=안효정, 
   given_name=효정, 
   family_name=안, 
   picture=https://lh3.googleusercontent.com/a/AEdFTp5SiCyTaOLog9sDPN6QhWwsUj7xPbfj4HQF0fdC=s96-c, 
   email=sally03915@gmail.com, 
   email_verified=true, 
   locale=ko
}

*/