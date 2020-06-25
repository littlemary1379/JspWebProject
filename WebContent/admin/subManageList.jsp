<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/adminNav.jsp"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<div class="container">
  <h2>정기구독 관리</h2>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>상품 번호</th>
        <th>이름</th>
        <th>가격</th>
        <th>할인율</th>
        <th>판매 종료 날짜</th>
        <th>  </th>
        <th>  </th>
                         
      </tr>
    </thead>
    
    <tbody>
    <c:forEach var="subproducts" items="${subproducts }" >
      <tr id="subproduct-${subproducts.subId }">
        <td>${subproducts.subId }</td>
        <td>${subproducts.subName }</td>
        <td>${subproducts.subPrice }</td>
        <td>${subproducts.subSale }</td>
        <td>${subproducts.subDate }</td>
        <td><a href="/DailyT/admin?cmd=subUpdate&subId=${subproducts.subId }"><button>수정</button></a></td>
        <td><button onClick="subDelete(${subproducts.subId})">삭제</button></td>                  
      </tr>
    </c:forEach> 

    </tbody>
  </table>
</div>
<script>
	function subDelete(subId) {
		console.log(subId);
		$.ajax({
			type:"post",
			url:"/DailyT/admin?cmd=subdelete",
			data:"subId="+subId,
			contentType:"application/x-www-form-urlencoded; charset=utf-8",
			dataType:"text"
			
		}).done(function (result) {
			if(result==1){
				var deleteCheck=confirm("정말 삭제하시겠습니까?");
					if(deleteCheck){
						var product=$("#subproduct-"+subId);
						product.remove();
						alert("상품이 목록에서 삭제되었습니다.");
					}else{
						alert("상품 삭제 취소");
					}

			}else{
				console.log("삭제 실패");
			}
			
			
		}).fail(function (error) {
			console.log("오류 발생");
		});
	}


</script>
</body>
</html>
