<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>

<div class="container my-5">
  <h3>로그인</h3>
  <!-- 2. Login
	> 로그인폼  -  Get
	> 로그인처리 - Post
	1) 처리서블릿   : LoginAction
	2) 데이터 노출  : x
	3) 보관데이터   : bpass , email  
	4) 처리경로     : 처리후 마이페이지로   (MyAction - Get) 
   -->
  <form action="" method="post" onsubmit="return checkForm()">
    <div class="my-3">
      <label for="email" class="form-label">이메일</label>
      <input type="email" class="form-control" id="email" name="email" />
    </div>
    <div class="my-3">
      <label for="bpass" class="form-label">비밀번호</label>
      <input type="password" class="form-control" id="bpass" name="bpass" />
    </div>
    <div class="text-end">
      <button type="reset" class="btn btn-outline-primary">취소</button>
      <button type="submit" class="btn btn-primary">로그인</button>
    </div>
  </form>
</div> 

<script>
function checkForm(){
  let email = document.getElementById("email");
  let bpass = document.getElementById("bpass");

  if(email.value.trim()==""){ alert("이메일을 입력하세요"); email.focus(); return false; }
  if(bpass.value.trim()==""){ alert("비밀번호를 입력하세요"); bpass.focus(); return false; }
  return true;
}
</script>

<%@include file="../inc/footer.jsp" %>
