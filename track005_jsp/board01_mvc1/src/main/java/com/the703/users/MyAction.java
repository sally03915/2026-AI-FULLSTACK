package com.the703.users;

import java.io.IOException;
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

 
@WebServlet("/MyAction")
public class MyAction extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    public MyAction() { super();  }

    protected void doGet(HttpServletRequest request, 
    		HttpServletResponse response) throws ServletException, IOException {
    	// 1. 로그인한정보확인 -  session.getAttribute("email")
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	HttpSession  session = request.getSession();    //## 서버에 저장되어 있는 유저정보확인
    	String 		email    = (String)session.getAttribute("email");
    	
    	// 2. sql- 내정보가져오기
    	Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
    	String url = "jdbc:mysql://localhost:3306/mbasic";
    	String sql = "select * from users  where email=?";
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		conn  = DriverManager.getConnection(url,"root","1234");
    		pstmt = conn.prepareStatement(sql);   pstmt.setString(1, email);
    		rset  = pstmt.executeQuery();
    		if(rset.next()) {
    			request.setAttribute("nickname", rset.getString("nickname"));
    			request.setAttribute("email"   , rset.getString("email"));
    			request.setAttribute("mobile"  , rset.getString("mobile"));
    			request.setAttribute("udate"   , rset.getString("udate"));
    			request.setAttribute("bip"     , rset.getString("bip"));
    		}
	    	// 3. mypage.jsp 로 경로 넘기기
	    	request.getRequestDispatcher("mypage.jsp").forward(request, response);
    	}catch(Exception e) {e.printStackTrace();}
    }

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	}
}
