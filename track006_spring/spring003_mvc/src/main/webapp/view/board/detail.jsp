<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%@include file="../inc/header.jsp"  %>

<script>
window.addEventListener("load" , function(){
	let  result = '${result}';   // el
	console.log(result);
	
	if( result == "비밀번호 확인!"){  alert(result);  history.go(-1);  }  // 알림창, 뒤로 가기
	else if(result.length != 0){  alert(result);                   }  
}); 
</script>

<!-- 	header		 -->
<!-- 	header		 -->
   <div class="container my-5">
      <h3>글 상세보기</h3>
      <form  action ="#"  method="post">
      	<div  class="my-3">
      		<label for="bname"   class="form-label">이름</label>
      		<input type="text"   class="form-control"  value="${dto.bname}"
      			  id="bname"  name="bname"   readonly    />
      	</div> 
      	<div  class="my-3">
      		<label for="btitle"  class="form-label">제목</label>
      		<input type="text"   class="form-control"    value="${dto.btitle}"
      			 id="btitle"  name="btitle"   readonly />
      	</div>
      	<div  class="my-3">
      		<label for="bcontent"  class="form-label">내용</label>
      		<textarea  class="form-control"    id="bcontent" 
      			 name="bcontent"  readonly >${dto.bcontent}</textarea>
      	</div>
      	<div  class="my-3">
      		<img src="${pageContext.request.contextPath}/upload/${dto.bfile}"  
      			 alt="${dto.btitle}"  class="w-50" />
      	</div>
		<div class="my-3  text-end">
			<a href="${pageContext.request.contextPath}/board/edit.do?bno=${dto.bno}"
				class="btn btn-outline-primary" title="글수정">수정</a> 
			<a href="${pageContext.request.contextPath}/board/delete.do?bno=${dto.bno}"
				class="btn btn-outline-success" title="글삭제">삭제</a> 
			<a href="${pageContext.request.contextPath}/board/list.do"
				class="btn btn-primary" title="목록보러가기">목록</a>
		</div>
	</form> 
		 
   </div>
<!-- 	footer		 -->
<!-- 	footer		 -->
<%@include file="../inc/footer.jsp"  %>












