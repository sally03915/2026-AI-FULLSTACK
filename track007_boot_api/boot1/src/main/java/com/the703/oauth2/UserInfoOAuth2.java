package com.the703.oauth2;

public interface UserInfoOAuth2 {
	public String getProvider();
	public String getProviderId();
	public String getEmail();
	public String getNickname();
	public String getImage();
}


/**
1)  pom.xml
2)  UserInfoOAuth2
3)  UserKakao / UserGoogle  / UserNaver
4)  Oauth2UserService   ==
5)  SecurityConfig - 설정
6)  Controller + view


1. provider   = "local" (the703)  / "google" , "kakao" , "naver"
2. providerId =                         google → sub , kakao/facebook   → id, naver  → response

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

<kakao>
{
    id=2632890179, 
    connected_at=2023-01-22T08:17:54Z, 
    properties = {nickname=효정}, 
    kakao_account = {
        profile_nickname_needs_agreement=false, 
        profile={nickname=효정}, 
        has_email=true, 
        email_needs_agreement=false, 
        is_email_valid=true, 
        is_email_verified=true, 
        email=sally03915@naver.com
    }
}

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




 

1) naver    ( 네아로 - 연습용 )   → id/비번
2)  kakao   
3)  google  ( 도메인 , https )

https://developers.naver.com/main/
https://developers.kakao.com/
https://console.cloud.google.com/

*/
