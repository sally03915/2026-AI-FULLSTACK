<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<% //1. 데이터 넘겨받기  - bname, bpass, btitle, bcontent / bip - InetAddress .getLocalHost().getHostAddress()
	request.setCharacterEncoding("UTF-8");  
	String bname    = request.getParameter("bname");
	String bpass    = request.getParameter("bpass");
	String btitle   = request.getParameter("btitle");
	String bcontent = request.getParameter("bcontent");  //out.println(bname + "/" + bpass + "/" + btitle + "/" + bcontent); 
    //2. sql처리 
	 try{ 
		Connection conn = null;  PreparedStatement pstmt = null;   //ResultSet rset = null;
		String sql="insert into  mvcboard1 (bname , bpass , btitle ,bcontent , bip)  values  (?,?,?,?,?)";
		String url="jdbc:mysql://localhost:3306/mbasic";   
		String user ="root" , pass="1234"; 
		Class.forName("com.mysql.cj.jdbc.Driver");          //1. 드라이버로딩
		conn  = DriverManager.getConnection(url, user, pass);//2. jdbc연동
		pstmt = conn.prepareStatement(sql); //3. sql 구문처리 - select: executeQuery /insert,update,delete:executeUpdate
		pstmt.setString(1, bname);
		pstmt.setString(2, bpass);
		pstmt.setString(3, btitle);
		pstmt.setString(4, bcontent);
		pstmt.setString(5, InetAddress .getLocalHost().getHostAddress());
		
		if(pstmt.executeUpdate() > 0){//4. 처리후 성공알림창 후 list.jsp로
		 	out.println("<script> alert('글쓰기 성공!'); location.href='list.jsp'; </script>");
		}else{ out.println("<script> alert('글쓰기 실패!'); location.href='list.jsp'; </script>"); }
		
		//5. jdbc끊기 if(rset != null) {  rset.close();  }
		if(pstmt != null){  pstmt.close();  }
		if(conn != null) {  conn.close();  }
	  }catch(Exception e){e.printStackTrace();} 
%>
