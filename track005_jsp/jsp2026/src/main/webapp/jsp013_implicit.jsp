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
   <!-- jsp013_implicit.jsp -->
   <div class="container card my-5">
      <h3 class="card-header">001. 내장객체</h3>
	  <pre  class="alert alert-info">
	  1. jsp 페이지가 웹컨테이너에 의해 
	  2. 고정된이름의 객체 컨테이너를 자동으로 구현
	  3. request(요청) , response(응답) , session(정보저장) , out(출력
	  </pre>       
       
      <h4>002. request - getParameter</h4>
      <pre  class="alert alert-success">
      1. 처리해주는 해결사 : action="jsp013_1.jsp"
      2. 요청방식        : 주소표시창 노출
      3. 보관용기이름     : query
      = getParameter("name")
      4. 출력내용 :  
      검색어 : 입력한값
      </pre>
	  <form action="jsp013_1.jsp" method="get" onsubmit="return check()">
		<div class="my-2">
			<label for="query">검색어</label> 
			<input type="text" class="form-control" placeholder="" id="query" name="query" />
			<button type="submit" class="btn btn-success mt-3 d-block">검색</button>
		</div>
	 </form>
	 
	 <br/> <!-- 줄바꿈 -->
	 <br/> <!-- 줄바꿈 -->	
	   
	 <!-- 				 -->
	 <!-- 				 -->
	 <!-- 				 --> 
      <pre  class="alert alert-success">
      1. 처리해주는 해결사 : action="jsp013_2.jsp"
      2. 요청방식        : 주소표시창 노출
      3. 보관용기이름     :  username / checkbox: option1
      = getParameterValues("name") 
      </pre> 
      <form    action="jsp013_2.jsp"  method="get"  onsubmit="return checkbox()"  >
        <div class="mb-3 mt-3">
          <label for="username" class="form-label">NAME:</label> 
          <input  type="text" class="form-control" id="username"  placeholder="Enter email" name="username">
         </div><!-- user name -->
         <div class="form-check">
           <input class="form-check-input" type="checkbox"   id="check1" name="option1" value="dog" >
           <label class="form-check-label" for="check1">DOG</label>
         </div>
         <div class="form-check">
           <input class="form-check-input" type="checkbox"   id="check2" name="option1" value="cat" >
           <label class="form-check-label"  for="check2" >CAT</label>
         </div>   
         <div class="form-check">
           <input class="form-check-input" type="checkbox"   id="check3" name="option1" value="pig"   >
           <label class="form-check-label"  for="check3">PIG</label>
         </div>
         <div class="my-3">
              <button  type="submit"  class="btn btn-primary" >전송</button>
         </div>                  
      </form>
       
      <hr/> 
      <h4>003. response</h4>
      <pre  class="alert alert-info">
      1. http요청에 대한 응답저장하는 객체
      2. jsp에서 다른페이지로 이동
      		(1) sendRedirect      - 브라우저 url을 변경o, request/response객체가 유지안됨.
      		(2) RequestDispatcher - 위임(요청전달)            
      								브라우저 url을 변경x, request/response객체가 유지 됨.
      </pre>
      <%
      //ver-1 알림창 처리안됨.
      //out.println("<script>alert('안녕?');</script>");  // 알림창 x
      //response.sendRedirect("http://www.naver.com");
      %>
      <%
      //ver-2. 
      // jsp13_3.jsp   
      // request.getRequestDispatcher("jsp012_milks.jsp")이용해서 여기서 처리해주세요!    
      // response.sendRedirect("jsp013_3.jsp");
      %>
      
      <pre  class="alert alert-success">
      jsp013_implicit.jsp (1)
      :나이입력받는폼 
      						→  jsp013_4.jsp  처리 (2)
                             
                             19세 미만이라면 -   jsp013_child.jsp
                             19세 이상이라면 -   보여주는 주소표시창줄은   jsp013_4.jsp  
                                              보이는화면은   jsp013_adult.jsp      
      </pre>
	  <form action="jsp013_4.jsp" method="get" onsubmit="return check()">
		<div class="my-2">
			<label for="userage">나이입력</label> 
			<input type="text" class="form-control" placeholder="" 
			       id="userage" name="userage" />
			<button type="submit" class="btn btn-success mt-3 d-block">성인여부</button>
		</div>
	 </form>
	 
      <hr/>
      <h4>004. scope</h4>
      
      
      <hr/>
      <h4>005. error</h4>
      
   </div>
</body>
</html>




