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
		<h3 class="card-header"> LOGIN </h3>
		<pre class="my-3 alert alert-info">
		 처리할 경로 : jsp008_result.jsp
		 주소표시창줄에 노출
		 보관용기이름 :  email   / pass / remember

		 Q1. 빈칸검사
		 Q2. 로그인한 정보  jsp008_result.jsp
		  email : 사용자가 입력한 값
		  pass  : 사용자가 입력한 값 
		</pre>
		<!-- Q 이미지를 중앙으로 
		<p><img src="images/login.png" alt="login"/></p>  -->
		<form action="jsp008_result.jsp"  method="get"  onsubmit="return checkLogin()">
			<div class="my-3">
				<label for="email"   class="form-label">Email : </label>
				<input type="email"  class="form-control"  id="email"  name="email" />      
			</div>
			<div class="my-3">
				<label for="pass"       class="form-label">Password : </label>
				<input type="password"  class="form-control"  id="pass"  name="pass" />      
			</div>		
			<div class="my-3">
				<label for="check"       class="form-label">Remember : </label>
				<input type="checkbox"   id="check"  name="remember" />      
			</div>	
			<div class="my-3  text-end"> 
				<button type="submit"    title="login 하러가기"
				       class="btn btn-primary"  id="check"  name="remember"  > 로그인 </button> 
			</div>								
		</form>
		<script>
		function  checkLogin(){
			let email = document.getElementById("email");
			let pass = document.getElementById("pass");
			if(email.value.trim() == ""){  alert("이메일  칸을 확인해주세요"); email.focus(); return false; }
			if(pass.value.trim()  == ""){  alert("비밀번호 칸을 확인해주세요"); pass.focus(); return false; }
			return true;
		}
		</script>
	</div>
</body>
</html> 
 

