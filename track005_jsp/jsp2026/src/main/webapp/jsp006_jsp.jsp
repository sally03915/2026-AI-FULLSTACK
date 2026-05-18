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
   <div class="container card my-5">
      <h3 class="card-header">JSP 기본속성 001. 주석 </h3>
      <div class="alert  alert-warning"> 코드 설명글</div>
      <!-- html 주석  ctrl + shift + /  -->
      <%--  jsp 주석      --%>
      <%    //java 주석     %> 
   </div> 
   
   <div class="container card my-5">
   	   <h3>002. 페이지 지시자</h3>
   	   <%@page import="java.util.ArrayList"%>
   	   	
   	   <h3>003. 스크립트립</h3>
       <div class="alert  alert-warning"> 자바코드 - ctrl + space bar </div>
   	   <%
   	   		ArrayList<String>  list = new ArrayList<>();
   	   		list.add("one");      list.add("two");      list.add("three");   
   	   		out.println(list);
   	   %>
   	   
   	   <h3>004. 표현식</h3>
   	   <%=list%>
   	   
   	   <h3>005. 선언</h3>	   
   	   <%!  public String company(){ return "the703"; } %>
   	   <p> copyright &copy;  <%=company()%> all rights reserved. </p>
   	   
   </div>	   
   
   
   
   
</body>
</html>



