<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>   
<%
//1. bno, bpass 넘겨받기
request.setCharacterEncoding("UTF-8");
int bno = Integer.parseInt(request.getParameter("bno"));
String bpass = request.getParameter("bpass");

//2. delete from mvcboard1  where  bno=?   and bpass=?   
// (select:  executeQuery / insert, update,delete:executeUpdate) 
Connection conn = null;  PreparedStatement pstmt = null;	
String url  = "jdbc:mysql://localhost:3306/mbasic";
String user = "root" , pass="1234";
String sql  = "delete from mvcboard1  where  bno=?   and bpass=? ";
		
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url,user, pass);
	pstmt = conn.prepareStatement(sql);     
	pstmt.setInt(   1, bno);    	pstmt.setString(2, bpass);

	if(pstmt.executeUpdate()>0)
	{ out.println("<script>alert('삭제성공!');     location.href='list.jsp';</script>"); }
	else{ out.println("<script>alert('삭제실패!'); history.go(-1);</script>"); } 
	//3. 삭제시 list.jsp / 삭제실패 비번입력폼으로 history.go(-1)
	if(pstmt != null){  pstmt.close(); }
	if(conn != null ){  conn.close(); }
}catch(Exception e){e.printStackTrace();}  
%>