<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>


<div class="container h-100 col-md-6">
	<h3 class="customer-title">회원정보 수정</h3>
	<!-- 회원정보 입력 폼 -->	
	<form class="customer-form col-md-12 was-validated" action="/DailyT/cust?cmd=custUpdateProc" method="post">
		<!-- ID 입력은 수정할 수 없도록 readonly 처리 -->
		<div class="form-group">
			<label class="ID-label">ID :</label>
			<input type="text" class="form-control" name="userID" id="userID" value="${sessionScope.principal.userId }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="nickname">이름 :</label> 
			<input type="text" class="form-control" name="username" id="username" value="${sessionScope.principal.username }" readonly="readonly">
			<div class="invalid-feedback">빈 칸을 채워주세요.</div>
		</div>		
		<div class="form-group">
			<label for="nickname">nickname :</label> 
			<input type="text" class="form-control" name="nickname" id="nickname" value="${sessionScope.principal.nickname }" required="required">
			<div class="invalid-feedback">빈 칸을 채워주세요.</div>
		</div>
		<div class="form-group">
			<label for="pwd">email :</label> 
			<input type="email" class="form-control" name="email" id="email" value="${sessionScope.principal.email }" required="required">
			<div class="invalid-feedback">빈 칸을 채워주세요.</div>
		</div>
		<div class="form-group">
			<div class="d-flex justify-content-between">
				<label for="address">address :</label> 
				<button class="join-button" type="button" onClick="goPopup();">주소 검색</button>
			</div>
			<input type="text" class="form-control" id="address" name="address" value="${sessionScope.principal.address }" readonly required="required">
			<div class="invalid-feedback">빈 칸을 채워주세요..</div>
		</div>	
		<div class="form-group">
			<label for="cellphone">휴대폰(- 빼고 입력하세요) :</label> 
			<input type="text" class="form-control" name="cellphone" id="cellphone" value="${sessionScope.principal.cellphone }" required="required">
			<div class="invalid-feedback">빈 칸을 채워주세요.</div>
		</div>		
		<div class="form-group d-flex justify-content-end">
			<button class="btn btn-default" type="submit">Update</button>
		</div>
	</form>

</div>

<script src="/DailyT/js/juso.js"></script>

<%@ include file="../include/footer.jsp"%>