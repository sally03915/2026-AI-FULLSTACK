<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>   
<%
//1. 데이터넘겨받기
	request.setCharacterEncoding("UTF-8");
	int ono = Integer.parseInt(request.getParameter("ono"));
	//out.println(ono); 
//2. sql - delete from milk_order	where  ono=?
	try{
		PreparedStatement pstmt = null;  Connection  conn = null;
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "delete from milk_order	where  ono=?";
		//2-1. 드라이버연동
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2-2. jdbc연동
		conn = DriverManager.getConnection(url ,"root" , "1234");
		//2-3. sql 처리
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ono);
		if(pstmt.executeUpdate() > 0){
			out.println("<script> alert('삭제성공!'); location.href='jsp012_milks.jsp'; </script>");
		}else{
			out.println("<script> alert('삭제실패!'); location.href='jsp012_milks.jsp'; </script>");
		}
		//2-4. jdbc끊기
		if( pstmt!= null  ){  pstmt.close(); }
		if( conn!= null   ){  conn.close();  }
	}catch(Exception e){e.printStackTrace();                  }

%>