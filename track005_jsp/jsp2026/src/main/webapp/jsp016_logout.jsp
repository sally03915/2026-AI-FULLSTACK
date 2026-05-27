<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>   
<%  /*  jsp016_logout.jsp  session.invalidator()  */
	// jsp016_login.jsp  페이지로 넘어가기
	session.invalidate(); 
	out.println("<script> alert('로그아웃 성공!'); location.href='jsp016_login.jsp';</script>");
%>