<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card  my-5">
      <h3 class="card-header  text-white  bg-danger"> 반갑습니다! 고객님!(어른)</h3>
      <p><%=request.getParameter("userage")%> 살 고객님! 상품추천이요!</p>
      <p><a href="javascript:history.go(-1)" class="btn btn-danger">BACK</a></p>
   </div>  
</body>
</html> 
