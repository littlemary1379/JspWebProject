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
      <tr>
        <td>${products.proId }</td>
        <td>${products.proName }</td>
        <td>${products.proPrice }</td>
        <td>${products.proSale }</td>
        <td>${products.prokind }</td>
        <td>${products.proStock }</td>
        <td>${products.proDate }</td>
        <td><a href="/DailyT/admin?cmd=proUpdate&proId=${products.proId }"><button>수정</button></a></td>
        <td><button>삭제</button></td>                  
      </tr>
    </c:forEach> 

    </tbody>
  </table>
</div>

</body>
</html>
