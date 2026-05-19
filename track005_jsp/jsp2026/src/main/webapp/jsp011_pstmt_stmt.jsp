<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card my-5">
      <h3 class="card-header">	PSTMT/ STMT </h3>
      <pre  class="alert alert-info">
      1. jdbc  - Java Database Connectivity
      - java 와 db연결해 sql 실행해주는 표준 api
      2. mysql, oracle,,, 다양한 dbms와 연결
      3. 사용방법
      https://dev.mysql.com/downloads/
      
      [src]-[main]-[webapp]-[WEB-INF]-[lib] -  mysql-connector-j-8.4.0.jar
      
      4. JDBC 사용방법
      1) Class.forName() 드라이버 로딩
      2) DriverManager Connection 활성화
      3) Connection DB연동
      4) Statemenet, PreparedStatement sql 구문실행
	      	PreparedStatement pstmt = 
	      		conn.prepareStatement("insert into userinfo (name, age) values(?,?)");
	      		
	      	pstmt.setString(1 , "길동");  //? 순서, 값
	    	pstmt.setInt(   2 , 11   );  //? 순서, 값 
	    	int result = pstmt.executeUpdate();  // INSERT, UPDATE, DELETE , 실행한 줄수	 
      		/////////////////////////////////////////////////////////////////////////////
      		
      5) jdbc 연동끊기 
      </pre>
      <%@page import="java.sql.*"%>
      <%
      try{
    	//1. 드라이버로딩  필요한 코드? Class.forName()
        //   com.mysql.cj.jdbc.Driver
      	Class.forName("com.mysql.cj.jdbc.Driver");
      	//2. JDBC 연동   필요한 코드? DriverManager.getConnection()
      	//  jdbc:mysql://localhost:3306/mbasic
      	Connection conn = DriverManager.getConnection(
      			"jdbc:mysql://localhost:3306/mbasic",
      			"root","1234");
      	///////////////////////////////////////////////////////
      	PreparedStatement pstmt = 
      		conn.prepareStatement("insert into userinfo (name, age) values(?,?)");
      	pstmt.setString(1 , "길동");  //? 순서, 값
    	pstmt.setInt(   2 , 11   );  //? 순서, 값 
    	int result = pstmt.executeUpdate();		
    	if(result>0){ out.println("길동이 insert 성공!"); }		
      	///////////////////////////////////////////////////////
      	//3. JDBC 끊기   필요한 코드? conn.close()
      	if(pstmt != null){  pstmt.close();    }	
      	if(conn  != null){  conn.close();     }		
      }catch(Exception e){e.printStackTrace();}			
      %>
      
      <%
      	try{
			//1. 드라이버로딩   Class.forName   -  com.mysql.cj.jdbc.Driver
      		Class.forName("com.mysql.cj.jdbc.Driver");
    		//2. JDBC 연동    DriverManager.getConnection   
    		Connection conn = DriverManager.getConnection(
    				"jdbc:mysql://localhost:3306/mbasic", "root", "1234");
    		/////////////////////////////////////////////////////////////////////
    		PreparedStatement pstmt = null;   ResultSet rset = null;
    		pstmt = conn.prepareStatement("select * from userinfo"); 
    		rset = pstmt.executeQuery(); //표: executeQuery- select 
    									 //   executeUpdate- insert, update, delete
    		while( rset.next() ){  //  줄 |  1 | first  |   11 |
    			out.println("<p>"+ rset.getInt("no")  + " / "    
    		                + rset.getString("name")  + " / " 
    		                + rset.getInt("age")      +"</p>" );  //칸 rset.getInt("필드명")
    		} 
    		/////////////////////////////////////////////////////////////////////
    		//3. JDBC 연동끊기  conn.close
    		if(rset  != null){rset.close(); }
    		if(pstmt != null){pstmt.close();}
    		if(conn  != null){conn.close(); }
    		
      	}catch(Exception e){e.printStackTrace();    }
		/*     		mysql> select * from userinfo;
		+----+--------+------+
		| no | name   | age  |
		+----+--------+------+
		|  1 | first  |   11 |
		|  2 | second |   22 |
		|  3 | third  |   33 |
		|  4 | fourth |   44 |
		+----+--------+------+ */
      %>
      
   </div>
</body>
</html>