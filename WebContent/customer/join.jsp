<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>


<div class="container h-100 col-md-6">
	<h3 id="join-title">Join</h3>
	<!-- 회원가입 입력 폼 -->	
	<form class="join-form col-md-12 was-validated" action="/DailyT/cust?cmd=joinProc" method="post" onsubmit="return validate();">
		<!-- ID 입력, 중복확인 폼 -->
		<div class="form-group">
			<div class="d-flex justify-content-between">
				<label class="ID-label">ID :</label>
				<button class="join-button" onclick="usernamecheck();" type="button"> ID 중복 확인</button>
			</div>
			<input type="text" class="form-control" name="userID" id="userID" required="required">
			<div class="invalid-feedback">빈 칸을 채워주세요.</div>
		</div>
		<div class="form-group">
			<label for="pwd">PW :</label>
			<input type="password" class="form-control" name="password" id="password" required="required">
			<div class="invalid-feedback">빈 칸을 채워주세요.</div>
		</div>
		<div class="form-group">
			<label for="pwd">PW 확인 :</label> 
			<input type="password" class="form-control" name="passwordcheck" id="passwordcheck" required="required">
			<div class="invalid-feedback">빈 칸을 채워주세요.</div>
		</div>
		<div class="form-group">
			<label for="nickname">이름 :</label> 
			<input type="text" class="form-control" name="username" id="username" required="required">
			<div class="invalid-feedback">빈 칸을 채워주세요.</div>
		</div>		
		<div class="form-group">
			<label for="nickname">nickname :</label> 
			<input type="text" class="form-control" name="nickname" id="nickname" required="required">
			<div class="invalid-feedback">빈 칸을 채워주세요.</div>
		</div>
		<div class="form-group">
			<label for="pwd">email :</label> 
			<input type="email" class="form-control" name="email" id="email" required="required">
			<div class="invalid-feedback">빈 칸을 채워주세요.</div>
		</div>
		<div class="form-group">
			<div class="d-flex justify-content-between">
				<label for="address">address :</label> 
				<button class="join-button" type="button" onClick="goPopup();">주소 검색</button>
			</div>
			<input type="text" class="form-control" id="address" name="address" readonly required="required">
			<div class="invalid-feedback">빈 칸을 채워주세요..</div>
		</div>	
		<div class="form-group">
			<label for="cellphone">휴대폰(- 빼고 입력하세요) :</label> 
			<input type="text" class="form-control" name="cellphone" id="cellphone" required="required">
			<div class="invalid-feedback">빈 칸을 채워주세요.</div>
		</div>		
		<div class="form-group d-flex justify-content-end">
			<button class="btn btn-default" type="submit">Join</button>
		</div>
	</form>

</div>

<script src="/DailyT/js/juso.js"></script>
<script src="/DailyT/js/join.js"></script>
</body>
</html>