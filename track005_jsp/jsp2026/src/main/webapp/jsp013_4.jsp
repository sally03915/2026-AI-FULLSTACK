<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>   
<%
//1. utf-8   userage 나이 넘어오는데이터 확인  (getParameter)
	int userage = Integer.parseInt(	request.getParameter("userage"));
	//out.println(userage);
//2. 만약 19세 미만이라면 jsp013_child.jsp 파일 넘기기 (sendRedirect)
//   아니라면           jsp013_adult.jsp (경로 안보이게 숨기기 - dispatch 이용)W
//											쿼리스트링   주소?name1=value1&name2=value2
	if( userage < 19 ){ response.sendRedirect("jsp013_child.jsp?userage=" + userage); }  //나이 null
	else{   request.getRequestDispatcher("jsp013_adult.jsp").forward(request, response);  }
%>