<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%@include file="../inc/header.jsp"  %>
<!-- 	header		 -->
<!-- 	header		 -->
<script>
window.addEventListener("load" , function(){
	let  result = '${result}';   // el
	console.log(result);
	
	if( result == "글쓰기 실패" || result == "비밀번호 확인!"){  alert(result);  history.go(-1);  }  // 알림창, 뒤로 가기
	else if(result.length != 0){  alert(result);                   }  
}); 
</script>


    <!--  content -->
    <section class="container  my-5">
        <h3> MultiBoard </h3>
<%--         <pre>
        페이징 :  ${paging}
        전체리스트 : ${list}
        </pre> --%>
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
              
				<c:forEach   var="dto"   items="${list}"   varStatus="status">
					<tr> <!-- 1) 256(전체갯수)-1   한개씩 빼기 
					          2) 전체갯수-0  256~247  / 전체갯수-10  246~237 / 전체갯수-30   246~237
					    -->
						<td>${paging.listtotal - paging.pstartno - status.index}</td>
						<td><a href="${pageContext.request.contextPath}/board/detail.do?bno=${dto.bno}">   
							${dto.btitle}
						</a></td>
						<td>${dto.bname}</td>
						<td>${dto.bdate}</td>
						<td>${dto.bhit}</td>
					</tr>
				</c:forEach>
			
            </tbody>
            <tfoot><tr><td colspan="5">
            	<ul class="pagination  justify-content-center"> 
            	<!-- 이전 -->
            	<c:if test="${paging.start > paging.bottomlist}">
            		<li  class="page-item">
            			<a href="?pstartno=${paging.start-1}"  class="page-link">이전</a>
            		</li>
            	</c:if>
            	
            	<!-- 1,2,3,4,5,6,7,8,,10 -->
            	<c:forEach  var="i"  begin="${paging.start}"  end="${paging.end}">
            		<li   class="page-item   <c:if test="${i==paging.current}">  active </c:if> ">
            			<a href="?pstartno=${i}"  class="page-link">${i}</a>
            		</li>
            	</c:forEach>
            	
            	<!-- 다음 -  다음글이 있다면  -  하단의전체 >  end  -->
            	<c:if test="${paging.pagetotal > paging.end}">
            		<li  class="page-item">
            			<a href="?pstartno=${paging.end+1}"  class="page-link">다음</a>
            		</li>
            	</c:if> 
            </ul></td></tr>
            </tfoot>
        </table>

        <div  class="text-end">
           <a href="${pageContext.request.contextPath}/board/write.do"  
           	  title="글쓰기 폼"  class="btn btn-primary" >글쓰기</a>
        </div>

    </section>

 
<!-- 	footer		 -->
<!-- 	footer		 -->
<%@include file="../inc/footer.jsp"  %>

  