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
<!-- 		header				 -->
<!-- 		header				 -->
<!-- https://www.w3schools.com/bootstrap5/bootstrap_jumbotron.php -->
<!-- bg-primary(파랑)  bg-danger(빨강)  warning(노랑) -->
<div class="p-5 bg-primary text-white">
  <h1>Milk Order Project</h1>
  <p>MVC1 - PreparedStatement Ex</p>
</div>

<!-- 		메뉴판테이블			-->
<!-- 		메뉴판테이블			-->
<!-- https://www.w3schools.com/bootstrap5/bootstrap_tables.php -->
   <div class="container card my-5  bg-primary  text-white ">
      <h2 class="card-header">Milk Menu</h2>  
      <table  class="table table-bordered table-striped table-hover">
      	<caption>우유메뉴</caption>
      	<thead>
			<tr>
				<th scope="col">NO</th>
				<th scope="col">NAME</th>
				<th scope="col">PRICE</th>
			</tr>
		</thead>
      	<tbody>
      	<%@page import="java.sql.*"%>
    	<%
    	try{//1. 드라이버연동 - Class.forName
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection conn=null;  PreparedStatement pstmt = null;  ResultSet rset = null;
    		
    		//2. JDBC 연동 - DriverManager.getConnection
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
    		//3. PreparedStatement pstmt 이용해서 milk 테이블의 데이터가져오기 - 가격이 낮은순으로 
    		pstmt = conn.prepareStatement("select * from milk order by mprice asc");
    		
    		rset = pstmt.executeQuery(); //표
    		while(rset.next()){ //줄
    			out.println("<tr><td>"+rset.getInt("mno")+"</td><td>"
    								  +rset.getString("mname")+"</td><td>"
    								  +rset.getInt("mprice")+"</td></tr>");
    		} 
    		//4. JDBC 끊기 
    		if(rset  != null){ rset.close();       }
    		if(pstmt != null){ pstmt.close();      }
    		if(conn  != null){ conn.close();       }
    		
    	}catch(Exception e){ e.printStackTrace();                } 
			/*  
			> mysql
			alter table milk  modify  mnum   int null;
			alter table milk  modify  mtotal int null;
			
			insert into milk (mno, mname, mprice)  values (1 , 'white' , 1500);
			insert into milk (mno, mname, mprice)  values (2 , 'choco' , 1800);
			insert into milk (mno, mname, mprice)  values (3 , 'banana' , 1800);
			
						1	white	1500
			    		2	choco	1800
			    		3	banana	1800 
			 */ 
    	%>
      	</tbody>
      </table> 
   </div>


<!-- 		주문현황표				 -->
<!-- 		주문현황표				 -->

   <div class="container card my-5  bg-warning  text-white ">
      <h2 class="card-header">Milk 주문현황표</h2>  
      <table  class="table table-striped table-bordered table-hover">
      	<caption>주문현황표</caption>
      	<thead>
			<tr>
				<th scope="col">NO</th>
				<th scope="col">NAME</th>
				<th scope="col">NUM</th>
				<th scope="col">DATE</th>
			</tr>
		</thead>
		<tbody>
		<%
		try{
			//1. 드라이버연동 Class.forName
			Class.forName("com.mysql.cj.jdbc.Driver");
			 
			Connection conn = null; PreparedStatement pstmt = null;  ResultSet rset = null;
			String url = "jdbc:mysql://localhost:3306/mbasic";
			String sql = "select * from milk_order  order by ono desc";
			
			//2. jdbc 연동 DriverManager.getConnection
			conn = DriverManager.getConnection(url , "root","1234");
			//3. pstmt 사용sql-처리   pstmt.executeQuery()   
			pstmt = conn.prepareStatement(sql);
			rset  = pstmt.executeQuery(); //표  executeQuery(select)   
										  //   executeUpdate(insert,update,delete)
			while(rset.next()){ //줄
				out.println("<tr><td>"+rset.getInt("ono")  //칸
						+"</td><td>"+rset.getString("oname")
						+"</td><td>"+rset.getInt("onum")
						+"</td><td>"+rset.getString("odate")+"</td></tr>");
			}
			//4. jdbc close
			if( rset != null ){ rset.close(); }
			if( pstmt != null){ pstmt.close();}
			if( conn != null ){ conn.close(); }
		}catch(Exception e){e.printStackTrace();   }
		%>
		</tbody>
      </table>
   </div>   



<!-- 		주문삽입, 수정, 삭제	-->
<!-- 		주문삽입, 수정, 삭제	-->
<!-- https://www.w3schools.com/bootstrap5/bootstrap_collapse.php -->
	<div class="container card  bg-secondary my-5 p-3">
		<h3	class="card-header text-white my-3"> MILK 주문, 수정, 삭제</h3>
				
		<div id="accordion" >
		
		  <div class="card ">
		    <div class="card-header   bg-warning">
		      <a class="btn" data-bs-toggle="collapse" href="#collapseOne">
		        주문하기
		      </a>
		    </div>
		    <div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
		      <div class="card-body">
		        	<form action="jsp012_insert.jsp"  method="post"   onsubmit = "return  order()">
		        		<div class="my-3">
		        			<label for="oname"  class="form-label">주문할 우유 이름</label>
		        			<input type="text" class="form-control"  id="oname"   name="oname" />
		        		</div>
		        		<div class="my-3">
		        			<label for="onum"  class="form-label">주문할 우유 갯수</label>
		        			<input type="text" class="form-control"  id="onum"   name="onum" />
		        		</div>
		        		<div class="my-3"> 
		        			<button  type="submit"  class="btn btn-warning" >  주문하기 </button>
		        		</div>
		        	</form> 
		        	<!--  
						1)  form 만들기 2) 빈칸검사 
						3)  처리해결사 jsp012_insert.jsp 데이터 노출x 보관용기 oname, onum
		        	 -->
		      </div>
		    </div>
		  </div>
		
		  <div class="card">
		    <div class="card-header  bg-primary">
		      <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseTwo">
		         주문수정
		      </a>
		    </div>
		    <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
		      <div class="card-body">
		        	<form action="jsp012_update.jsp"  method="post"   onsubmit = "return  order1()">
		        		<div class="my-3">
		        			<label for="ono1"  class="form-label">수정할 우유번호</label>
		        			<input type="text" class="form-control"  id="ono1"   name="ono" />
		        		</div>
		        		<div class="my-3">
		        			<label for="oname1"  class="form-label">주문할 우유 이름</label>
		        			<input type="text" class="form-control"  id="oname1"   name="oname" />
		        		</div>
		        		<div class="my-3">
		        			<label for="onum1"  class="form-label">주문할 우유 갯수</label>
		        			<input type="text" class="form-control"  id="onum1"   name="onum" />
		        		</div>
		        		<div class="my-3"> 
		        			<button  type="submit"  class="btn btn-warning" >  주문하기 </button>
		        		</div>
		        	</form> 	 
		        	<!--  
						1)  form 만들기 2) 빈칸검사 
						3)  처리해결사 jsp012_update.jsp 데이터 노출x 보관용기 oname, onum , ono
		        	 -->
		      </div>
		    </div>
		  </div>
		
		  <div class="card">
		    <div class="card-header   bg-primary">
		      <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseThree">
		        주문삭제
		      </a>
		    </div>
		    <div id="collapseThree" class="collapse" data-bs-parent="#accordion">
		      <div class="card-body">
					<form action="jsp012_milk_delete.jsp"    method="get">
					  <div class="mb-3">
					    <label for="ono_delete" class="form-label"> 취소 주문번호</label>
					    <input type="number" class="form-control" id="ono_delete" 
					    		placeholder="취소할 주문번호를 적어주세요!" name="ono">
					  </div>
					  <button type="submit" class="btn btn-danger">주문하기</button>
					</form> 		      
		      
		       		 <!--  
						1)  form 만들기 2) 빈칸검사 
						3)  처리해결사 jsp012_delete.jsp 데이터 노출o 보관용기  ono
		        	 -->
		      </div>
		    </div>
		  </div>
		
		</div>
		
	</div>


<!-- 
2. milk 주문하러가기
1)  form 만들기
2) 빈칸검사
3)  처리해결사
   jsp012_insert.jsp
   데이터 노출x
   보관용기 mname, mprice 
 --> 

</body>
</html>


<!-- 
= MODEL
★ 다음과 같이 테이블을 준비해주세요!
mysql> desc milk_order;
+-------+--------------+------+-----+-------------------+-------------------+
| Field | Type         | Null | Key | Default           | Extra             |
+-------+--------------+------+-----+-------------------+-------------------+
| ono   | int          | NO   | PRI | NULL              | auto_increment    |
| oname | varchar(20)  | NO   |     | NULL              |                   |
| onum  | int          | NO   |     | NULL              |                   |
| odate | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| oip   | varchar(100) | NO   |     | NULL              |                   |
+-------+--------------+------+-----+-------------------+-------------------+
5 rows in set (0.00 sec)

create table milk_order(
	ono      int           not null  auto_increment   PRIMARY KEY,   -- 필드명 자료형 옵션
	oname    varchar(20)   not null,
	onum     int           not null,
	odate    datetime      default   CURRENT_TIMESTAMP,
	oip      varchar(100)  not null
);
 
-- Q1.  milk_order 값삽입.  insert 구문 완성    
	insert into milk_order (oname, onum, oip) values ('banana',1,  '198.160.0.1'  );
	
-- Q2.  milk_order ono가 1인데이터 조회 
    select    *     from      milk_order    where     ono=1; 
    
-- Q3.  milk_order 전체데이터조회
    select    *    from   milk_order;

-- Q4.  milk_order 해당번호의 이름과 갯수 수정   
	update milk_order  set  oname='choco' , onum=3  where ono=1;

-- Q5.  milk_order 해당번호의 데이터 삭제
    delete from milk_order  where ono=1;
 -->
