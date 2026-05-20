<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%  // jsp012_insert.jsp
	//1. utf-8 설정
	request.setCharacterEncoding("UTF-8");
	//2. request.getParameter() 이용해서 데이터 받기
	String oname = request.getParameter("oname");
	int     onum = Integer.parseInt(request.getParameter("onum")); //out.println(oname + " / " + onum);
	//3. insert 구문처리
	try{
		Connection conn = null;	PreparedStatement pstmt = null; 
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url  = "jdbc:mysql://localhost:3306/mbasic";
		String sql  = "insert into milk_order (oname, onum , oip)  values  (?,?,?)";
		conn = DriverManager.getConnection(url , "root" , "1234");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString( 1   , oname);
		pstmt.setInt(    2   , onum);
		pstmt.setString( 3   , InetAddress.getLocalHost().getHostAddress());  //Ip 주소가져오기
		
		int result = pstmt.executeUpdate();   // insert, update, delete 실행한 줄 수
		//4. jsp012_milks.jsp 로 돌아가기      - 알림창            주소표시창줄 
		if(result > 0){  
			out.println("<script> alert('우유주문 성공했습니다.');  location.href='jsp012_milks.jsp';  </script>");  
		}else{ 	
			out.println("<script> alert('관리자에게 문의해주세요!');  location.href='jsp012_milks.jsp';  </script>");  
		} 
		
		if(pstmt != null){ pstmt.close();   }
		if(conn != null ){ conn.close();    }
	}catch(Exception e){e.printStackTrace();}
%>

<!-- 
//1. utf-8 설정
//2. request.getParameter() 이용해서 데이터 받기
//3. insert 구문처리
//4. jsp012_milks.jsp 로 돌아가기  

//3-1. Class.forName
//3-2. jdb연동 DriverManager.getConneciton
//3-3. insert  executeUpdate
//3-4. close
-->