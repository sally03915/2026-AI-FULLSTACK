<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MVC1-BOARD</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
    <link href="./css/board.css" rel="stylesheet">
</head>
<body>
<div class="container my-3">
	<form  action="${pageContext.request.contextPath}/upload"  
		   method="post"
		   enctype="multipart/form-data"
	>	   
		<div class="my-3">
			<label for="name"  class="form-label">작성자</label>
			<input type="text"  id="name"  name="name"  class="form-control"/>
		</div>	
		<div class="my-3">
			<label for="file"   class="form-label">파일업로드</label>
			<input type="file"  id="file"  name="file"   class="form-control"/>
		</div>	
		<div class="my-3 text-end"> 
			<input type="submit"     class="btn btn-danger" value="업로드"/>
		</div>	
	</form>
</div>	
</body>
</html>