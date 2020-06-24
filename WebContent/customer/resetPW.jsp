<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container h-100 col-md-6">
	<h4 id="FindPW-title">PW 재설정하기</h4>
	<form class="form col-md-12 was-validated" method="post" action="/DailyT/cust?cmd=ResetPWProc">
		<div class="form-group">
			<label for="resetPW">PW :</label> 
			<input type="password" class="form-control" id="resetPW" name="resetPW" required="required">
		</div>		
		<div class="form-group">
			<label for="resetPWCheck">PW 재확인 :</label> 
			<input type="password" class="form-control" id="resetPWCheck" name="resetPWCheck" required="required">
		</div>
		<div class="form-group d-flex justify-content-end">
			<button class="btn btn-primary" type="submit">PW 재설정</button>
		</div>
	</form>
</div>

</body>
</html>