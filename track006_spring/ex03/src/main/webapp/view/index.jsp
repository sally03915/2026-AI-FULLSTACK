<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MVC1-BOARD</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
    <link href="./css/board.css" rel="stylesheet">
</head>
<body>
	<div class="container my-3 bg-info  text-white p-3 rounded  text-center">
		<h3>security</h3>
		<a href="${pageContext.request.contextPath}/security/all"  
		  class="btn btn-warning">ALL- 모든사람들 접근가능</a>
		<a href="${pageContext.request.contextPath}/security/member"
		  class="btn btn-success">MEMBER - 멤버만 접근가능</a> 
	</div>
</body>
</html>