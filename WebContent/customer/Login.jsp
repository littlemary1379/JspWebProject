<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="../include/nav.jsp"%>
<link rel="stylesheet" href="/DailyT/css/Login.css">
<div class="container h-100 col-md-6">
	<h4>Login</h4>
	<form class="form col-md-12">
		<div class="form-group">
			<label class="ID-label" for="usr">ID :</label> 
			<input type="text" class="form-control" id="usr">
		</div>
		<div class="form-group">
			<label for="pwd">PW :</label> 
			<input type="password" class="form-control" id="pwd">
		</div>
		<div class="form-group d-flex justify-content-end">
			<button class="btn btn-primary" type="submit">Login</button>
		</div>
		<hr/>
		<label class="information-tag">아이디, 비밀번호를 잊으셨나요?</label>
		<div class="form-group d-flex justify-content-end">
			<button class="btn btn-primary mr-1" type="button">ID 찾기</button>
			<button class="btn btn-primary" type="button">PW 찾기</button>
		</div>
	</form>
	<div class="join d-flex justify-content-end">
		<label class="information-tag mr-2 align-self-center">아직 회원이 아니신가요? </label>
		<button class="btn btn-primary" type="button">회원가입</button>
	</div>
</div>


</body>
</html>