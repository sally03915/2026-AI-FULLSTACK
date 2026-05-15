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
      <h3 class="card-header">REQUEST-요청</h3>
	  <p  class="alert alert-success my-2">
			https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=apple  <br/>
			1. 처리컨테이너(action) :  https://search.naver.com/search.naver  <br/>
			2. 처리방식   (method) :  get
			3. 보관용기   (name  ) :  query 
	  </p>
		<form action="https://search.naver.com/search.naver" method="get"
			onsubmit="return check()">
			<div class="my-2">
				<label for="query">검색어</label> <input type="text"
					class="form-control" placeholder="네이버에게 물어봐!" id="query"
					name="query" />
				<button type="submit" class="btn btn-success mt-3 d-block">검색</button>
			</div>
		</form>
		<script>
	  	function check(){
	  		let query = document.getElementById("query");   //1. 아이디값 이용해서  query 대상찾아오기
	  		if(query.value.trim() == ""){//2. query.value 문자열찾아와서   trim() 앞뒤 공백빼고
	  		 	alert("검색어를 입력하세요.");
	  		 	query.focus();  //커서
	  			return  false;//3. 전송여부
	  		}
	  		return true;
	  	}
	  </script> 
   </div>
   
   
</body>
</html>

