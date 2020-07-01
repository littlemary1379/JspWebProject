<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>


<div class="container h-100 col-md-6">
	<h4 id="subscribe-title">정기 배송 주문</h4>
	<!-- 정기구독 입력 폼 -->
	<form class="form col-md-12 was-validated" action="/DailyT/order?cmd=subscribeProc" method="post">
		
		<div class="form-group">
			<label class="ID-label">구독 종류 :</label> 
			<input type="text" class="form-control" name="kind" id="kind" value="${subscribeKind }" readonly>
		</div>
		<div class="form-group">
			<label class="ID-label">배송 기간 :</label> 
			<input type="text" class="form-control" name="term" id="term" value="${buyTerm }" readonly>
		</div>
		<div class="form-group">
			<label class="ID-label">시작 날짜 :</label> 
			<input type="text" class="form-control" name="startDate" id="startDate" readonly>
		</div>
		<div class="delivery">
			<button type="button" onclick="sameOrder(${custid })">주문자와 동일</button>
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
			<button class="btn btn-primary" type="submit">신청하기</button>
		</div>
	</form>

</div>

<script src="/DailyT/js/juso.js"></script>
<script src="/DailyT/js/today.js"></script>
<script src="/DailyT/js/sameOrder.js"></script>
</body>
</html>