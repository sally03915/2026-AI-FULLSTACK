<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%@include file="../inc/header.jsp"  %>
<!-- 	header		 -->
<!-- 	header		 -->
   <div class="container my-5">
      <h3>글 상세보기</h3>
      <form  action ="#"  method="post">
      	<div  class="my-3">
      		<label for="bname"   class="form-label">이름</label>
      		<input type="text"   class="form-control"    id="bname"  name="bname"   readonly />
      	</div>  
      	<div  class="my-3">
      		<label for="bpass"   class="form-label">비밀번호</label>
      		<input type="password"   class="form-control"    id="bpass"  name="bpass"  />
      	</div> 
      	<div  class="my-3">
      		<label for="btitle"  class="form-label">제목</label>
      		<input type="text"   class="form-control"    id="btitle"  name="btitle"   readonly />
      	</div>
      	<div  class="my-3">
      		<label for="bcontent"  class="form-label">내용</label>
      		<textarea  class="form-control"    id="bcontent"  name="bcontent"  readonly ></textarea>
      	</div>
      	<div  class="my-3  text-end"> 
      		<a href=""             class="btn btn-outline-primary"  title="글수정">수정</a>
      		<a href=""             class="btn btn-outline-success"  title="글삭제">삭제</a>
      		<a href=""             class="btn btn-primary"          title="목록보러가기">목록</a>
      	</div>
      </form> 
		 
   </div>
<!-- 	footer		 -->
<!-- 	footer		 -->
<%@include file="../inc/footer.jsp"  %>
