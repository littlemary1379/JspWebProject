<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container h-100 col-md-6">
	<h4 id="login-title">Login</h4>
	<form class="form col-md-12" method="post" action="/DailyT/cust?cmd=loginProc">
		<div class="form-group">
			<label class="ID-label" for="userID">ID :</label> 
			<input type="text" class="form-control" id="userID" name="userID">
		</div>
		<div class="form-group">
			<label for="password">PW :</label> 
			<input type="password" class="form-control" id="password" name="password">
		</div>
		<div class="form-group d-flex justify-content-end">
			<button class="btn btn-primary" type="submit">Login</button>
		</div>
		<hr/>
		<label class="information-tag">아이디, 비밀번호를 잊으셨나요?</label>
		<div class="form-group d-flex justify-content-end">
			<a href="/DailyT/cust?cmd=findID"><button class="btn btn-primary mr-1" type="button">ID 찾기</button></a>
			<a href="/DailyT/cust?cmd=findPW"><button class="btn btn-primary" type="button">PW 찾기</button></a>
		</div>
	</form>
	<div class="join d-flex justify-content-end">
		<label class="information-tag mr-2 align-self-center">아직 회원이 아니신가요? </label>
		<a href="/DailyT/cust?cmd=join"><button class="btn btn-primary" type="button">회원가입</button></a>
	</div>
</div>


</body>
</html>