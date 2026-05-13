package com.the703.basic018;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress001 { 
	public static void main(String[] args) {
		try {
			InetAddress local= InetAddress.getLocalHost();
			System.out.println("1. IP HostName : "   + local.getHostName());
			System.out.println("2. IP HostAdress : " + local.getHostAddress());
			
			local = InetAddress.getByName("www.naver.com");
			System.out.println("3. IP HostAdress : " + local);
			
		} catch (UnknownHostException e) { e.printStackTrace(); }
	} 
}
/*
1. Network
- 통신기술들이 그물망처럼 연결된 통신을 이용해서 컴퓨터 자원을 공유

2. Client  vs  Server
- Client ( 서비스 사용 )
- Server ( 서비스 제공 )

3. Ip주소 (컴퓨터주소)
예) 192.168.0.1 (건물)
80( http웹 ), 443( https 웹자물쇠 ) ,22( ssh 보안원격호스트 ) ,25( smtp 메일)

127.0.0.1:8080
localhost:8080

4. InetAddress 
- ip 주소를 다루는 클래스

*/



