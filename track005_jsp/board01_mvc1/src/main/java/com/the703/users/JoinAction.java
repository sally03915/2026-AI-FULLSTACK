package com.the703.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinAction")
public class JoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    public JoinAction() { super(); }
    
    // 회원가입폼으로 
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("join.jsp").forward(request, response); 
	}

	// 회원가입기능
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//1. 데이터 넘겨받기 - nickname , bpass , email , mobile
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();   // java.io.PrintWriter
		
		String nickname = request.getParameter("nickname");
		String bpass    = request.getParameter("bpass");
		String email    = request.getParameter("email");
		String mobile   = request.getParameter("mobile");
		
		//2. sql (드커프리) 처리
		Connection conn = null; PreparedStatement pstmt = null;
		String url      = "jdbc:mysql://localhost:3306/mbasic";
		String sql      = "insert into users (nickname , bpass , email , mobile , bip)  values (?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  //[드]라이버 로딩
			conn = DriverManager.getConnection(url , "root" , "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);		 pstmt.setString(2, bpass);
			pstmt.setString(3, email); 			 pstmt.setString(4, mobile);
			
			pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
			
			if(pstmt.executeUpdate() > 0) {  
				out.println("<script>  alert('회원가입에 성공했습니다.');  location.href='LoginAction';  </script>");
			}else { out.println("<script>  alert('회원가입에 실패했습니다');   history.go(-1);  </script>"); }
			
			if(pstmt != null) {   pstmt.close(); }
			if(conn  != null) {   conn.close(); }
			
		}catch(Exception e) {e.printStackTrace();}  
	}// end doPost
	
}// end class



