package com.the703.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinAction
 */
@WebServlet("/JoinAction")
public class JoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public JoinAction() { super();  }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//1. 데이터 넘겨받기
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	
    	String nickname = request.getParameter("nickname");
    	String bpass    = request.getParameter("bpass");
    	String email    = request.getParameter("email");
    	String mobile   = request.getParameter("mobile");
    	
    	//2. sql
    	//3. 경로넘기기
    	request.setAttribute("nickname", nickname);
    	request.setAttribute("bpass"   , bpass);
    	request.setAttribute("email"   , email);
    	request.setAttribute("mobile"  , mobile);
    	request.getRequestDispatcher("jsp019_result.jsp").forward(request, response);
	} 
}
