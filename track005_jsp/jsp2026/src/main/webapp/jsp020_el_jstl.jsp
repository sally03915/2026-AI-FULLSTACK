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
   <!--   jsp020_el_jstl.jsp     -->
   <div class="container card my-5">
      <h3 class="card-header">001. el</h3>
      <pre class="alert alert-success">
      1. 출력  EL(Expression Language, 표현식 언어)
      2. 자바코드없이 출력  , jstl와 같이 사용   
      </pre>
      
      <p> <%    out.println("Hello");   %>  </p>
      <p> <%=   "Hello"                 %>  </p>
      <p> ${"hello"}   ${1}  ${3.14}  ${'A'}  ${"sally"}</p>
      
      <p> <a href="jsp020_result.jsp?name=sally"  class="btn btn-danger">PARAM - 데이터 넘기기</a></p>
      
      <%@page import="com.the703.servlet.Java001"%>
      
      <%  ///////////////////////////////// 서블릿 - 비지니스로직 
      Java001 data = new  Java001(10,3);
      request.setAttribute("d" , data);
          /////////////////////////////////%>
      <p><%=request.getAttribute("d")%></p>
      <p>${d}</p>
      <p>${d.a}</p> <!--  객체명.변수명 - getter()  -->
      
      
      <hr/>
      <h3 class="card-header  my-5">002. jstl</h3> 
      <pre class="alert alert-success">
      1. JavaServer Pages Standard Tag Library
      2. 제어문이나 반복문을 태그로 표현
      3. jar 파일 다운로드 - [WEB-INF]-[lib]
         https://mvnrepository.com/artifact/javax.servlet/jstl/1.2 
      </pre>
      
      <%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
      <h4  class="card-header">1) if</h4>
      <c:if test="${10>3}">  10은 3보다 크다</c:if>
      
      <h4  class="card-header">2) choose</h4>
      <c:set  var="num"  value="2"/>
      <c:choose>
      	<c:when test="${num==1}">  1이다. </c:when>
      	<c:when test="${num==2}">  2이다. </c:when>
      	<c:when test="${num==3}">  3이다. </c:when>
      	<c:otherwise>1,2,3이 아니다</c:otherwise>
      </c:choose>
      
      <h4  class="card-header">3) forEach</h4>  
      <c:set  var="numbers"  value="1,2,3"/>
   	  <c:forEach    var="i"  items="${numbers}">
   	  	  ${i}  <br/>
   	  </c:forEach>	  
   	  
   	  <%  //서버에서 list형식으로 셋팅
   	  	String [] numbers2 = {"one" , "two" ,"three" };	
   	    request.setAttribute("numbers2", numbers2);
   	  %>
   	  <c:forEach  var="i"  items="${numbers2}"  varStatus="status" >
   	     ${status.first}  -    ${status.index}    -	${i}  <br/>
   	  </c:forEach> 
   </div>
   <!--  -->
	<div class="container card my-5   bg-success  text-white">
		<h4 class="card-header">1) if</h4>
		<pre>
		문제 설명:
		jstl if를 사용하여
		"20은 30보다 작거나 같다" 라는 문장을 출력해보세요.
		</pre>
		<p  class="bg-warning p-3"><c:if test="${20<=30}">20은 30보다 작거나 같다</c:if></p>
		

		<h4 class="card-header">2) choose</h4>
		<pre>
		문제 설명:
		변수 level을 3으로 설정하고,
		jstl choose문을 이용하여
		level이 1이면 "초급", 2이면 "중급",
		3이면 "고급", 그 외에는 "알 수 없음"을 출력해보세요.
		</pre>
		<p  class="bg-warning p-3">
			<c:set  var="level"  value="3" />
			<c:choose>
				<c:when test="${level == 1}">초급</c:when>
				<c:when test="${level == 2}">중급</c:when>
				<c:when test="${level == 3}">고급</c:when>
				<c:otherwise>알 수 없음</c:otherwise>
			</c:choose>
		</p>
		<%
		//서버에서 list형식으로 셋팅
		String[] season = { "봄", "여름", "가을", "겨울" };
		request.setAttribute("season", season);
		%>
		<h4 class="card-header">3) forEach</h4> 
		<pre>
		문제 설명:
		forEach를 사용하여 배열 ["봄","여름","가을","겨울"] 을 반복문으로 출력하여
		각 요소 뒤에 "입니다"라는 문장을 붙여보세요.
		</pre>
		<p class="bg-warning p-3">
			<c:forEach  var="s"  items="${season}">  ${s}입니다.<br/> </c:forEach>
		</p>
	</div>


</body>
</html>


