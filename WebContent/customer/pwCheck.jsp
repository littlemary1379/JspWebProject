<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container h-100 col-md-6">
	<h4 id="FindID-title">회원정보 수정</h4>
	<form class="form col-md-12 was-validated" method="post" action="/DailyT/cust?cmd=custUpdate">
		<div class="form-group">
			<label class="ID-label" for="userID">고객님들의 보안을 위해 비밀번호를 한 번 더 입력해주세요.</label> 
			<input type="password" class="form-control" id="password" name="password" required="required">
		</div>
		<div class="form-group d-flex justify-content-end">
			<button class="btn btn-primary" type="submit">확인</button>
		</div>
	</form>
</div>

</body>
</html>