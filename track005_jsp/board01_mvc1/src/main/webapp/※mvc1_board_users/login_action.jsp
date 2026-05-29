<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
    request.setCharacterEncoding("UTF-8");  
    String email = request.getParameter("email");
    String bpass = request.getParameter("bpass");

    try{ 
        Connection conn = null;  
        PreparedStatement pstmt = null;   
        ResultSet rs = null;

        String sql="SELECT * FROM users WHERE email=? AND bpass=?";
        String url="jdbc:mysql://localhost:3306/mbasic";   
        String user ="root", pass="1234"; 

        Class.forName("com.mysql.cj.jdbc.Driver");          
        conn  = DriverManager.getConnection(url, user, pass);
        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, email);
        pstmt.setString(2, bpass);

        rs = pstmt.executeQuery();

        if(rs.next()){
            // 로그인 성공 → 세션에 저장
            session.setAttribute("email", rs.getString("email"));
            session.setAttribute("nickname", rs.getString("nickname"));
            out.println("<script>alert('로그인 성공!'); location.href='mypage.jsp';</script>");
        }else{
            out.println("<script>alert('로그인 실패!'); history.back();</script>");
        }

        if(rs != null) rs.close();
        if(pstmt != null) pstmt.close();
        if(conn != null) conn.close();
    }catch(Exception e){
        e.printStackTrace();
    } 
%>
