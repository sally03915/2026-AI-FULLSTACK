<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="../inc/header.jsp"  %>
<!-- 	header		 -->
<!-- 	header		 -->

   <div class="container  my-5">
      <h3 >글 삭제</h3>
      <form  action ="${pageContext.request.contextPath}/board/delete.do?bno=${param.bno}"  
      			method="post"   onsubmit="return checkForm()"> 
      	<div  class="my-3">
      		<label for="bpass"   class="form-label">비밀번호</label>
      		<input type="password"   class="form-control"    id="bpass"  name="bpass"  />
      	</div> 
      	<div  class="my-3  text-end"> 
      		<button type="reset"   class="btn btn-outline-primary"  title="글취소">취소</button>
      		<a href=""             class="btn btn-outline-success"  title="목록보러가기">목록</a>
      		<button type="submit"  class="btn btn-primary"  title="글삭제">글삭제</button>
      	</div>
      </form> 
		<script>
		function   checkForm(){ 
			let bpass = document.getElementById("bpass"); 
			if(bpass.value.trim() ==""){ alert("빈칸입니다. \n확인해주세요");  bpass.focus();  return false; } 
			return true;
		}
		</script>
   </div>
   
<!-- 	footer		 -->
<!-- 	footer		 -->
<%@include file="../inc/footer.jsp"  %>