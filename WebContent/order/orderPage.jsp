<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>


<div class="container">
	<h4 id="subscribe-title">주문 페이지</h4>
	<!-- 주문상품 확인 폼 -->
		<table class="table" id="cart">
		<thead>
			<tr>
				<th>상품명</th>
				<th>이미지</th>
				<th>가격</th>
				<th>수량</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${orderlist }" var="orderlist" varStatus="status">
				<c:set var="totalPrice" value="${totalPrice+(orderlist.orderProPrice*orderlist. count)}" />
		
				<tr id="cartlist-${status.index }">
					<td id="itemname-${status.index }">${orderlist. orderProName}</td>
					<td><img id="itemimage-${status.index }" class="col-sm-12"src="${orderlist.orderPhoto }" style="width:150px"></td>
					<td id="itemprice-${status.index }">${orderlist. orderProPrice}</td>
					<td class="d-flex">
						<form name="form-${status.index }">
							<input type="text" id="count-${status.index }" name="count" value=${orderlist. count} readonly>
						</form>
	
					</td>
					<td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr />
	<div class="d-flex justify-content-between">
		<div class="d-flex">
			<label>total: </label>
			<p id="totalPrice">${totalPrice }</p>
			
		</div>
	</div>
</div>
<div class="container h-100 col-md-6">
	
	<form class="form col-md-12 was-validated" action="/DailyT/order?cmd=subscribeProc" method="post">
		

		<div class="delivery">
			<c:if test="${custid ne 0} ">
			<button type="button" onclick="sameOrder(${custid })">주문자와 동일</button>
			</c:if>
			<div class="form-group">
				<label for="nickname">이름 :</label> 
				<input type="text" class="form-control" name="deliveryName" id="deliveryName" required="required">
				<div class="invalid-feedback">빈 칸을 채워주세요.</div>
			</div>
			<div class="form-group">
				<label for="address">address :</label> 
				<input type="button" onClick="goPopup();" value="주소 검색" /> 
				<input type="text" class="form-control" id="deliveryAddr" name="deliveryAddr" readonly required="required">
				<div class="invalid-feedback">빈 칸을 채워주세요..</div>
			</div>
			<div class="form-group">
				<label for="cellphone">휴대폰(- 빼고 입력하세요) :</label> 
				<input type="text" class="form-control" name="deliveryPhone" id="deliveryPhone" required="required">
				<div class="invalid-feedback">빈 칸을 채워주세요.</div>
			</div>
		</div>
		<div class="form-group d-flex justify-content-end">
			<button class="btn btn-primary" type="submit">주문하기</button>
		</div>
	</form>

</div>

<script src="/DailyT/js/juso.js"></script>
<script src="/DailyT/js/sameOrder.js"></script>
</body>
</html>