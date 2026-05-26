<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@include file="inc/header.jsp" %>

<%
  // 세션에서 로그인된 사용자 정보 가져오기
  String email = (String)session.getAttribute("email");
  if(email == null){
    response.sendRedirect("login.jsp");
    return;
  }

  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
    String sql = "SELECT * FROM users WHERE email=?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, email);
    rs = pstmt.executeQuery();

    if(rs.next()){
%>
<div class="container my-5">
  <h3>마이페이지</h3>
  <table class="table table-bordered table-striped">
    <tbody>
      <tr>
        <th scope="row">닉네임</th>
        <td><%= rs.getString("nickname") %></td>
      </tr>
      <tr>
        <th scope="row">이메일</th>
        <td><%= rs.getString("email") %></td>
      </tr>
      <tr>
        <th scope="row">휴대폰</th>
        <td><%= rs.getString("mobile") %></td>
      </tr>
      <tr>
        <th scope="row">가입일</th>
        <td><%= rs.getTimestamp("udate") %></td>
      </tr>
      <tr>
        <th scope="row">가입IP</th>
        <td><%= rs.getString("bip") %></td>
      </tr>
    </tbody>
  </table>
</div>
<%
    }
  }catch(Exception e){
    e.printStackTrace();
  }finally{
    if(rs!=null) rs.close();
    if(pstmt!=null) pstmt.close();
    if(conn!=null) conn.close();
  }
%>

<%@include file="inc/footer.jsp" %>
