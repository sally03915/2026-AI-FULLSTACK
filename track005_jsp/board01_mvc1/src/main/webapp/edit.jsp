<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>   
<%@include file="inc/header.jsp"  %>
<!-- 	header		 -->
<!-- 	header		 -->
<%@page import="java.sql.*"%>
<%
//1. 해당번호 넘겨받기
request.setCharacterEncoding("UTF-8");
int bno = Integer.parseInt(  request.getParameter("bno") );

//2. sql구문처리 - 해당번호의 데이터 가져오기
//    select * from   mvcboard1  where  bno=?
String bname = "", btitle="", bcontent="";
Connection conn = null;  PreparedStatement pstmt = null;  ResultSet rset = null;
String url  = "jdbc:mysql://localhost:3306/mbasic"; 
String user = "root" , pass="1234";
String sql  = "select * from   mvcboard1  where  bno=?"; 

try{
	Class.forName("com.mysql.cj.jdbc.Driver");   // Class.forName
	conn = DriverManager.getConnection(url, user, pass); // DriverManager.getConnection
	pstmt = conn.prepareStatement(sql);    pstmt.setInt(1, bno);
	rset  = pstmt.executeQuery(); //표
	if(rset.next()){ //줄   
		bname = rset.getString("bname");   btitle = rset.getString("btitle");  bcontent = rset.getString("bcontent");
	}   //      칸							
	
	if(rset  != null){ rset.close();}
	if(pstmt != null){ pstmt.close();}
	if(conn  != null){ conn.close();}
}catch(Exception e){e.printStackTrace();}

//3. view 받아오데이터 넣기
%>

   <div class="container  my-5">
      <h3>글 수정</h3>
      <form  action ="edit_action.jsp?bno=<%=bno%>"  method="post"   onsubmit="return checkForm()">
      	<div  class="my-3">
      		<label for="bname"   class="form-label">이름</label>
      		<input type="text"   class="form-control"    id="bname"  name="bname"  value="<%=bname%>"  readonly />
      	</div> 
      	<div  class="my-3">
      		<label for="bpass"   class="form-label">비밀번호</label>
      		<input type="password"   class="form-control"    id="bpass"  name="bpass"  />
      	</div>
      	<div  class="my-3">
      		<label for="btitle"  class="form-label">제목</label>
      		<input type="text"   class="form-control"    id="btitle"  name="btitle"   value="<%=btitle%>"  />
      	</div>
      	<div  class="my-3">
      		<label for="bcontent"  class="form-label">내용</label>
      		<textarea  class="form-control"    id="bcontent"  name="bcontent"  ><%=bcontent%></textarea>
      	</div>
      	<div  class="my-3  text-end"> 
      		<button type="reset"   class="btn btn-outline-primary"  title="글수정취소">취소</button>
      		<a href="list.jsp"             class="btn btn-outline-success"  title="목록보러가기">목록</a>
      		<button type="submit"  class="btn btn-primary"  title="글수정">글수정</button>
      	</div>
      </form> 
      
		<script>
		function   checkForm(){
			let bname = document.getElementById("bname");
			let bpass = document.getElementById("bpass");
			let btitle = document.getElementById("btitle");
			let bcontent = document.getElementById("bcontent");
			
			if(bname.value.trim() ==""){ alert("빈칸입니다. \n확인해주세요");  bname.focus();  return false; }
			if(bpass.value.trim() ==""){ alert("빈칸입니다. \n확인해주세요");  bpass.focus();  return false; }
			if(btitle.value.trim() ==""){ alert("빈칸입니다. \n확인해주세요"); btitle.focus();  return false; }
			if(bcontent.value.trim() ==""){ alert("빈칸입니다. \n확인해주세요");bcontent.focus();  return false;}
			return true;
		}
		</script>
   </div>
<!-- 	footer		 -->
<!-- 	footer		 -->
<%@include file="inc/footer.jsp"  %>