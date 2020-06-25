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
        <th>판매 종료 날짜</th>
        <th>  </th>
        <th>  </th>
                         
      </tr>
    </thead>
    
    <tbody>
    <c:forEach var="subproducts" items="${subproducts }" >
      <tr>
        <td>${subproducts.subId }</td>
        <td>${subproducts.subName }</td>
        <td>${subproducts.subPrice }</td>
        <td>${subproducts.subSale }</td>
        <td>${subproducts.subDate }</td>
        <td><a href="/DailyT/admin?cmd=subUpdate&subId=${subproducts.subId }"><button>수정</button></a></td>
        <td><button>삭제</button></td>                  
      </tr>
    </c:forEach> 

    </tbody>
  </table>
</div>

</body>
</html>
