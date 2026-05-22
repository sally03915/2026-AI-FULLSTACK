<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
    <link href="./css/board.css" rel="stylesheet">
</head>
<body>
    <!--  header  -->
    <header> 
        <div class="p-5 bg-primary text-white text-center myvisual">
            <h1>THEJOA703</h1>
            <p>MVC1 JSP PROJECT</p>
        </div> 
        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <h2  class="myhidden">주메뉴</h2>
            <div class="container-fluid">
                <a class="navbar-brand" href="javascript:void(0)">Logo</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="mynavbar">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">Link</a>
                    </li>
                    <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">Link</a>
                    </li>
                    <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">Link</a>
                    </li>
                </ul> 
                </div>
            </div>
        </nav>
    </header>
    <!--  header -->
    <!--  header -->
    <!--  header -->
    <!--  header -->



    <!--  content -->
    <section class="container  my-5">
        <h3> MultiBoard </h3>
        <table  class="table  table-striped  table-bordered table-hover">
            <caption> BOARD 목록 </caption>
            <thead>
                <tr>
                    <th scope="col">NO</th>
                    <th scope="col">TITLE</th>
                    <th scope="col">WRITER</th>
                    <th scope="col">DATE</th>
                    <th scope="col">HIT</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>첫번째 글쓰기</td>
                    <td>FIRST</td>
                    <td>2026.05</td>
                    <td><span class="badge rounded-pill bg-dark">1</span></td>
                </tr>
            </tbody>
        </table>

        <div  class="text-end">
           <a href="#"  title="글쓰기 폼"  class="btn btn-primary" >글쓰기</a>
        </div>

    </section>

    <!--  footer -->
    <!--  footer -->
    <!--  footer -->
    <!--  footer -->
        
    <!--            배경       글자색       글자중앙정렬   안쪽여백   -->
    <footer  class="bg-dark   text-white  text-center   p-5">
        copyrights &copy;  THEJOA703 2026 all rights reserved.
    </footer>
</body>
</html>