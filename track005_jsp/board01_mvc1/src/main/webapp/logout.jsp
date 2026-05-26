<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>

<%
    // 세션 종료 처리
    session.invalidate();
%>

<div class="container my-5">
  <h3>로그아웃</h3>
  <p>정상적으로 로그아웃 되었습니다.</p>
  <a href="login.jsp" class="btn btn-primary">로그인 페이지로</a>
  <a href="list.jsp" class="btn btn-outline-success">게시판으로</a>
</div>

<%@include file="inc/footer.jsp" %>
