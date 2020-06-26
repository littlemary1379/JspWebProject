<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/adminNav.jsp"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<div class="container">
  <h2>회원 관리</h2>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>회원 번호</th>
        <th>실명</th>
        <th>아이디</th>
        <th>닉네임</th>
        <th>E-mail</th> 
        <th>주소</th> 
        <th>휴대폰 번호</th>
        <th>  </th>
        <th>  </th>
                         
      </tr>
    </thead>
    
    <tbody>
    <c:forEach var="customers" items="${customers }" >
      <tr id="product-${customers.custid }">
        <td>${customers.custid }</td>      	
        <td>${customers.userId }</td>
        <td>${customers.username }</td>
        <td>${customers.nickname }</td>
        <td>${customers.email }</td>
        <td>${customers.address }</td>
        <td>${customers.cellphone }</td>
      </tr>
    </c:forEach> 

    </tbody>
  </table>
</div>

</body>
</html>
