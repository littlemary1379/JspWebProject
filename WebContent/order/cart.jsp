<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">
	<h4>장바구니</h4>
	<table class="table">
		<thead>
			<tr>
				<th>상품명</th>
				<th>이미지</th>
				<th>가격</th>
				<th>수량</th>
				<th>선택</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${orderlist }" var="orderlist" varStatus="status">
				<c:set var="totalPrice" value="${totalPrice+(orderlist.orderProPrice*orderlist. count)}" />
				<tr>
					<td>${orderlist. orderProName}</td>
					<td><img class="col-sm-12"src="${orderlist.orderPhoto }" style="width:150px"></td>
					<td>${orderlist. orderProPrice}</td>
					<td class="d-flex">
						<form name="form-${status.index }">
							<input type="text" id="count-${status.index }" name="count" value=${orderlist. count}>
						</form>
						<div>
							<button onClick="add(${status.index },${orderlist. orderProPrice});">+</button>
							<button onclick="del(${status.index },${orderlist. orderProPrice});">-</button>
						</div>
					</td>
					<td>
						<div>
							<button>주문하기</button>
							<button>삭제</button>
						</div>
					</td>
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
		<button onclick="location.href='/DailyT/order?cmd=userCheck'">주문하기</button>
	</div>
</div>
<script src="/DailyT/js/addDel.js"></script>