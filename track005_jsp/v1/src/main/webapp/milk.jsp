<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html  lang="ko">
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<!-- header -->
<!-- header -->
<!-- https://validator.w3.org/nu/#textarea 여기서 에러체크하면서 해야--> 
<!-- https://www.w3schools.com/bootstrap5/bootstrap_jumbotron.php -->
<!-- bg-primary 파랑  bg-danger 빨강  bg-warning 노랑 -->

<div class="p-5 bg-primary text-white">
  <h1>Milk Order Project</h1>
  <p>MVC1 - PreparedStatement Ex</p>
</div>


<!-- 메뉴판 테이블 -->
<!-- 메뉴판 테이블 -->
<!-- https://www.w3schools.com/bootstrap5/bootstrap_tables.php -->
   <div class="container card my-5 bg-primary text-white">
      <h2 class="card-header">Milk Menu</h2>
      
       <table class="table table-bordered table-striped table-hover">
       	<caption>우유메뉴</caption>
       	<thead>
       		<tr>
       			<th scope="col">NO</th>
       			<th scope="col">NAME</th>
       			<th scope="col">PRICE</th>
       		</tr>
       	
       	</thead>
       	
       	<tbody>
       	<% 
       	try{
       	//1. 드라이버 연동
       	Class.forName("com.mysql.cj.jdbc.Driver");
       	Connection conn = null;
       	PreparedStatement pstmt = null;
       	ResultSet rset = null;
       	
       	//2. JDBC 연동
		conn = DriverManager.getConnection(
       			                    "jdbc:mysql://localhost:3306/mbasic",   // url
       			                    "root",   // user
       			                    "1234");  // pass
       	       	
       	//3. PreparedStatement pstmt 이용해서 milk 테이블의 데이터가져오기
       	//   가격이 낮은 순으로
       	pstmt = conn.prepareStatement("select * from milk order by mprice asc");
      	
        rset = pstmt.executeQuery(); // 표
        while(rset.next()){ //줄
        	out.println("<tr><td>"   + rset.getInt("mno")+"</td><td>"
        			                 + rset.getString("mname")+"</td><td>"
        			                 + rset.getInt("mprice")+"</td></tr>"  );
        }
       	  
       			                    
       			                    
       			                    
       	//4. JDBC 끊기
      	if(rset != null){rset.close();}
    	if(pstmt != null){pstmt.close();}
    	if(conn != null){conn.close();}
    		
       		
       	}catch( Exception e){ e.printStackTrace(); }
       	/*
       	alter table milk modify mnum int null;
       	alter table milk modify mtotal int null;
       	
       	insert into milk (mno, mname, mpirce) values (1, 'white', 1500);
       	insert into milk (mno, mname, mpirce) values (2, 'choco', 1800);
       	insert into milk (mno, mname, mpirce) values (3, 'banana', 1800);
       	*/
       	
       	
       	//1. white  1500
       	//2. choco  1800
       	//3. banana 1800
       	 
       	
       	%>
       	
       	
       	
       	
       	
       	</tbody>
       	
       </table>
   </div>




<!-- 주문현황표 -->
<!-- 주문현황표 -->





<!-- 주문삽입, 수정, 삭제 -->
<!-- 주문삽입, 수정, 삭제 -->





</body>
</html>