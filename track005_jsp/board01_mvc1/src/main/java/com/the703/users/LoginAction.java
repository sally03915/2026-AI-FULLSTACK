package com.the703.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginAction() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response); //로그인폼으로
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
																throws ServletException, IOException {
		//1. 데이터 넘겨받기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String email = request.getParameter("email"); 
		String bpass = request.getParameter("bpass"); 
		HttpSession session = request.getSession();   // HttpSession - 서버에 저장  ##
		PrintWriter     out = response.getWriter();   // 출력구문     ##
		//2. sql처리 (드 커 프 리)
		Connection conn = null;  PreparedStatement pstmt = null;  ResultSet rset = null;
		String     sql  = "select count(*)  cnt  from users  where email=?  and bpass=?"; 
		String     url  = "jdbc:mysql://localhost:3306/mbasic";
		int        find = -1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn  = DriverManager.getConnection(url , "root" , "1234");
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, email); 		 pstmt.setString(2, bpass);
			
			rset  = pstmt.executeQuery(); // 표
			if(rset.next()) {     find = rset.getInt("cnt"); }   // 아이디와 비번이 같은유저는 1명
			//3. 해당화면으로 넘기기
			if(find == 1) {  session.setAttribute("email" , email); 
				     out.println("<script> alert('로그인성공!'); location.href='MyAction'; </script>");			
			}else {  out.println("<script> alert('정보확인!'); history.go(-1); </script>");} 
		}catch(Exception e) { e.printStackTrace();}
	}
}
