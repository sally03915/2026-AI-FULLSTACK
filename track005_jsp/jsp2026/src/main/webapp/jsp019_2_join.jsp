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
      <h3 class="card-header">Servlet - Join</h3>
      <pre  class="alert alert-warning">
      1. 처리해결사 : JoinAction
      2. 데이터노출 x
      3. 서버에 데이터 넘겨줄때 :nickname , bpass , email , mobile
      4. JoinAction -  닉네임과 이메일, 휴대폰 출력해주는 결과페이지  ( jsp019_result.jsp)
      </pre>
	  <h3>회원가입</h3>
	  <form action="JoinAction" method="post" onsubmit="return checkForm()">
	    <div class="my-3">
	      <label for="nickname" class="form-label">닉네임</label>
	      <input type="text" class="form-control" id="nickname" name="nickname" />
	    </div>
	    <div class="my-3">
	      <label for="bpass" class="form-label">비밀번호</label>
	      <input type="password" class="form-control" id="bpass" name="bpass" />
	    </div>
	    <div class="my-3">
	      <label for="email" class="form-label">이메일</label>
	      <input type="email" class="form-control" id="email" name="email" />
	    </div>
	    <div class="my-3">
	      <label for="mobile" class="form-label">휴대폰</label>
	      <input type="text" class="form-control" id="mobile" name="mobile" />
	    </div>
	    <div class="text-end">
	      <button type="reset" class="btn btn-outline-primary">취소</button>
	      <button type="submit" class="btn btn-primary">가입하기</button>
	    </div>
	  </form>
	  <script>
		function checkForm(){
		  let nickname = document.getElementById("nickname");
		  let bpass = document.getElementById("bpass");
		  let email = document.getElementById("email");
		  let mobile = document.getElementById("mobile");
		
		  if(nickname.value.trim()==""){ alert("닉네임을 입력하세요"); nickname.focus(); return false; }
		  if(bpass.value.trim()==""){ alert("비밀번호를 입력하세요"); bpass.focus(); return false; }
		  if(email.value.trim()==""){ alert("이메일을 입력하세요"); email.focus(); return false; }
		  if(mobile.value.trim()==""){ alert("휴대폰 번호를 입력하세요"); mobile.focus(); return false; }
		  return true;
		}
		</script>
	  
   </div>
</body>
</html>