<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<!-- jsp018_servlet.jsp -->
   <div class="container card my-5">
      <h3 class="card-header">Java + Servlet</h3>
      <pre  class="alert alert-success">
      1. mvc
      - model( db )
      - view (view)
      - controller(처리)
      
      2. mvc1 vs  mvc2
      - mvc1 : 컨트롤러의 역할을 jsp     ( 화면중심 )
      - mvc2 : 컨트롤러의 역할을 servlet ( 데이터처리, 제어흐름 )
      
      3. Servlet
      - 1) 요청처리- 요청받아서 분석
      - 2) 비즈니스 로직 수행 - db연동, 계산처리, 다른시스템 통신
      - 3) 처리결과 응답 ( dispatcher, sendRedirect / xml, json )
      - 4) 상태관리 - 세션, 쿠키 
      </pre>
      
      <h4>001. java class 부품객체 사용</h4> 
      <%@page import="com.the703.servlet.Java001"%>
      <%
      Java001  basic = new Java001(10,20);    // ctrl + space
      out.println(basic);
      %>
       
      <h4>002. Servlet   get/post</h4> 
      <p  class="my-3"> <a href="Hi"  class="btn btn-danger"> Servlet001 - Get </a> </p>
      
	  <form action="Hi"   method="post">
	    <button type="submit" class="btn btn-primary"> Servlet001 - Post </button>
	  </form>
   </div>
   
</body>
</html>