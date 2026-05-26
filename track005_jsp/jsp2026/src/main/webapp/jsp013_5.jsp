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
     <h4>004. scope (내장객체 유효범위)</h4>
      <pre  class="alert alert-success">
		1. application(웹애플리케이션이 실행되고 있는동안 , 서버가 꺼질때까지 유지) 
				> session (특정브라우저와 연결된 세션, 브라우저 종료시 소멸)
					> request(요청: form, a 요청) 
						> page (해당jsp 페이지에서만)     
		2.  page는 새 페이지이므로 다시 설정하지 않으면 null
		    request는 범위는 새 요청이므로 값이 사라짐
		    session, application 유지
      </pre>
      
	  <table class="table table-striped">
		<caption>SCOPE- 내장객체 유효범위</caption>
		<tbody>
			<tr><th scope="row">page</th>       <td><%=pageContext.getAttribute("name")%></td></tr>
			<tr><th scope="row">request</th>    <td><%=request.getAttribute("name")%></td></tr>
			<tr><th scope="row">session</th>    <td><%=session.getAttribute("name")%></td></tr>
			<tr><th scope="row">application</th><td><%=application.getAttribute("name")%></td></tr>			
		</tbody>
	  </table>
	  <p><a href="javascript:history.go(-1)" class="btn btn-danger">BACK</a></p> 
      
   </div>
</body>
</html>