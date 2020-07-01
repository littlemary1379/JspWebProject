<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/adminNav.jsp"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<div class="container">
  <h2>단품 관리</h2>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>상품 번호</th>
        <th>이름</th>
        <th>가격</th>
        <th>할인율</th>
        <th>종류</th> 
        <th>재고</th> 
        <th>판매 종료 날짜</th>
        <th>  </th>
        <th>  </th>
                         
      </tr>
    </thead>
    
    <tbody>
    <c:forEach var="products" items="${products }" >
      <tr id="product-${products.proId }">
        <td>${products.proId }</td>
        <td>${products.proName }</td>
        <td>${products.proPrice }</td>
        <td>${products.proSale }</td>
        <td>${products.prokind }</td>
        <td>${products.proStock }</td>
        <td>${products.proDate }</td>
        <td><a href="/DailyT/admin?cmd=proUpdate&proId=${products.proId }"><button>수정</button></a></td>
        <td><button onClick="proDelete(${products.proId})">삭제</button></td>                  
      </tr>
    </c:forEach> 

    </tbody>
  </table>

</div>
<hr/>
<script>
	function proDelete(proId) {
		console.log(proId);
		$.ajax({
			type:"post",
			url:"/DailyT/admin?cmd=prodelete",
			data:"proId="+proId,
			contentType:"application/x-www-form-urlencoded; charset=utf-8",
			dataType:"text"
			
		}).done(function (result) {
			if(result==1){
				var deleteCheck=confirm("정말 삭제하시겠습니까?");
					if(deleteCheck){
						var product=$("#product-"+proId);
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
