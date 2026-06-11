<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>

<div class="container my-5">
<script>
window.addEventListener("load" , function(){
	let  result = '${result}';   // el
	console.log(result);
	
	if( result == "회원가입실패" ){  alert(result);  history.go(-1);  }  // 알림창, 뒤로 가기
	else if(result.length != 0){  alert(result);                   }  
}); 
</script>
  <h3>로그인</h3> 
  <form action="${pageContext.request.contextPath}/login" method="post" onsubmit="return checkForm()">
    <input  type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
    <div class="my-3">
      <label for="email" class="form-label">이메일</label>
      <input type="email" class="form-control" id="email" name="username" />
    </div>
    <div class="my-3">
      <label for="bpass" class="form-label">비밀번호</label>
      <input type="password" class="form-control" id="bpass" name="password" />
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
