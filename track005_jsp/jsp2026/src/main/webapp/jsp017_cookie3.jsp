<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%  // jsp017_cookie3.jsp
	//1. 쿠키값 있는지 확인
	String cookie = request.getHeader("Cookie");
	//2. null 이 아니면 
	if( cookie  != null){
		Cookie[] cookies = request.getCookies();
		for(Cookie c :  cookies ){
			c.setMaxAge(0);  response.addCookie(c);  // 유효시간 0
		}
	}
	response.sendRedirect("jsp017_1_cookie.jsp");
%>