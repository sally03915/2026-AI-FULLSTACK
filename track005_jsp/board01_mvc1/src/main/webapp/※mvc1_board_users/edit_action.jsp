<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
// 1. 데이터 넘겨받기 (수정할 글번호 넘겨받기 )
request.setCharacterEncoding("UTF-8");
int bno         = Integer.parseInt(request.getParameter("bno"));
String bpass    = request.getParameter("bpass");
String btitle   = request.getParameter("btitle");
String bcontent = request.getParameter("bcontent");

// 2. update mvcboard1   set  btitle=? , bcontent=?  where  bno=? and bpass=?
Connection conn = null;  PreparedStatement pstmt = null;		
String url  = "jdbc:mysql://localhost:3306/mbasic";
String user = "root" , pass="1234";
String sql  = "update mvcboard1   set  btitle=? , bcontent=?  where  bno=? and bpass=?";	

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url, user, pass);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, btitle);  pstmt.setString(2, bcontent);
	pstmt.setInt(   3, bno);     pstmt.setString(4, bpass);

	if(pstmt.executeUpdate() >0 ){
		out.println("<script>  alert('수정완료'); location.href='detail.jsp?bno="+bno+"';  </script>");
	}else{
		out.println("<script>  alert('비밀번호확인'); history.go(-1);  </script>");
	}
	// 3. 수정시 detail.jsp 가서 수정이 되었는지 확인 / 수정폼으로 넘기기
	if(pstmt != null){ pstmt.close();}
	if(conn  != null){ conn.close();}
}catch(Exception e){ e.printStackTrace();}		
		  
%>


