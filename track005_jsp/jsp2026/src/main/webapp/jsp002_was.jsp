<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  <!-- 자바 --> <!--  주석 ctrl + shift + / -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WAS (Web ApplicationServer) | 동적페이지</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container card my-5 bg-primary text-white">
		<h3 class="card-header"> WAS : 동적페이지</h3>
		<p> 
		<%@page import="java.util.Calendar"%>
		<%
		// ctrl + space
		Calendar today = Calendar.getInstance();
		String     now = today.get( Calendar.HOUR_OF_DAY ) + ":" + today.get( Calendar.MINUTE );
		out.println( now );
		%>	
		</p>
	</div>
</body>
</html>