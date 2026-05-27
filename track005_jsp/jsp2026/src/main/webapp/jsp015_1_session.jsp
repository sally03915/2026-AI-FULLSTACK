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
	<div class="container card  my-5  p-3">
		<h3 class="card-header"> 세션 - 서버측에 저장되는 정보</h3>
		<pre class="alert alert-success">
		1. 로그인에 성공시 - session.setAttribute()  서버측에 사용자 정보 저장
		2. 로그인에 성공시 - session.getAttribute()  서버측의 정보를 header
		3. 로그아웃 시    - session.invalidator()   서버측의 정보를 삭제 
		</pre>
		
		<table class="table  table-striped table-bordered table-hover  text-center my-3">
			<caption>SESSION</caption>
			<tbody>
			<%
			String username	 = (String) session.getAttribute("username");  //object
			String userage	 = (String) session.getAttribute("userage");   //object
			out.println("<tr><td>"+username+"</td><td>"+userage+"</td></tr>");
			%>
			</tbody>
		</table>

		<div  class="text-center">
			<a href="jsp015_session2.jsp" class="btn btn-danger">세션값 저장</a>
			<a href="jsp015_session3.jsp" class="btn btn-danger">세션값 삭제</a>
			<a href="jsp015_session4.jsp" class="btn btn-danger">세션값 초기화</a>
		</div>
	</div>
	
</body>
</html>