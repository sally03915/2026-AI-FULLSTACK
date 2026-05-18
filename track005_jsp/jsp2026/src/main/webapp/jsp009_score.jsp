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
		<h3 class="card-header"> Score </h3>
		<pre class="my-3">
		 처리할 경로 : jsp009_result.jsp
		 주소표시창줄에 노출 X
		 보관용기이름 :  kor   / eng /  math 
		 Q1. 빈칸검사
		 Q2. 성적처리 정보  jsp008_result.jsp  (테이블형식)
		 KOR    ENG    MATH   TOTAL    AVG
		 100    100     99    299      99.67   
		</pre>
		<form  action="jsp009_result.jsp"  method="post">
			<div class="my-3">
				<label for="kor"   class="form-label">KOR : </label>
				<input type="number"  class="form-control"  id="kor"  name="kor"   min="0"   max="100"  value="0" />      
			</div><!-- end kor -->
			<div class="my-3">
				<label for="eng"   class="form-label">ENG : </label>
				<input type="number"  class="form-control"  id="eng"  name="eng"  min="0"   max="100" />      
			</div><!-- end kor -->
			<div class="my-3">
				<label for="math"   class="form-label">MATH : </label>
				<input type="number"  class="form-control"  id="math"  name="math" 
					   min="0"   max="100"/>      
			</div><!-- end kor -->
			<div class="my-3"  style="text-align:right" > 
				<button type="submit"    class="btn btn-success" 
					  title="성적처리하러가기"       >성적처리</button>
			</div><!-- end kor    text-end-->			
		</form>
		
	</div>
</body>
</html> 



<!-- 

 -->







