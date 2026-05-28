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
      <h3 class="card-header"> Milk Servlet</h3> 
      <pre  class="alert alert-warning">
      1. 처리해결사 : MilkInsert
      2. 데이터노출 x
      3. 서버에 데이터 넘겨줄때 : oname, onum
      </pre>
      	<form action="MilkInsert"  method="post"   onsubmit = "return  order()">
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
   </div>
</body>
</html>