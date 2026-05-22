<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
// 1. 데이터 넘겨받기

/* -4) edit.jsp   (글수정 폼)     edit_action.jsp (글수정 처리) */
 try{
     //-1) list.jsp   전체 리스트 출력   select * from   mvcboard1 order bno desc
  Connection conn = null;  PreparedStatement pstmt = null;   ResultSet rset = null;
  String sql="update  mvcboard1   set  btitle=? ,bcontent=?  where  bno=?  and bpass=?";
  String url="jdbc:mysql://localhost:3306/mbasic";   
  String user ="root" , pass="1234";
  
     //1. 드라이버로딩
     //2. jdbc연동
     //3. sql 구문처리
     //4. 성공알림창 - 성공시 detail.jsp / 실패시 수정폼으로
     //5. jdbc끊기
     if(rset != null) {  rset.close();  }
     if(pstmt != null){  pstmt.close();  }
     if(conn != null) {  conn.close();  }
  }catch(Exception e){e.printStackTrace();}	

%>