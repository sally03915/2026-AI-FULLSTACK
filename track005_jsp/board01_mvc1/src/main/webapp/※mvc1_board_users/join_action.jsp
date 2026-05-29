<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
    request.setCharacterEncoding("UTF-8");  
    String nickname = request.getParameter("nickname");
    String bpass    = request.getParameter("bpass");
    String email    = request.getParameter("email");
    String mobile   = request.getParameter("mobile");

    try{ 
        Connection conn = null;  
        PreparedStatement pstmt = null;   
        String sql="INSERT INTO users (nickname, bpass, email, mobile, bip) VALUES (?,?,?,?,?)";
        String url="jdbc:mysql://localhost:3306/mbasic";   
        String user ="root", pass="1234"; 

        Class.forName("com.mysql.cj.jdbc.Driver");          
        conn  = DriverManager.getConnection(url, user, pass);
        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, nickname);
        pstmt.setString(2, bpass);
        pstmt.setString(3, email);
        pstmt.setString(4, mobile);
        pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());

        if(pstmt.executeUpdate() > 0){
            out.println("<script>alert('회원가입 성공!'); location.href='login.jsp';</script>");
        }else{
            out.println("<script>alert('회원가입 실패!'); history.back();</script>");
        }

        if(pstmt != null) pstmt.close();
        if(conn != null) conn.close();
    }catch(Exception e){
        e.printStackTrace();
    } 
%>
