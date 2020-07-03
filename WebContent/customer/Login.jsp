<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container h-100 col-md-6">
	<h3 class="customer-title">Login</h3>
	<!-- 정보 입력 폼 -->
	<form class="customer-form col-md-12" method="post" action="/DailyT/cust?cmd=loginProc">
		<div class="form-group">
			<label class="ID-label" for="userID">ID :</label> 
			<input type="text" class="form-control" id="userID" name="userID">
		</div>
		<div class="form-group">
			<label for="password">PW :</label> 
			<input type="password" class="form-control" id="password" name="password">
		</div>
		<div class="form-group d-flex justify-content-end">
			<button class="btn btn-default" type="submit">Login</button>
		</div>
		<hr/>
		<label class="information-tag">아이디, 비밀번호를 잊으셨나요?</label>
		<div class="form-group d-flex justify-content-end">
			<button class= "mr-1" type="button" onclick="location.href='/DailyT/cust?cmd=findID'">ID 찾기</button>
			<button type="button" onclick="location.href='/DailyT/cust?cmd=findPW'">PW 찾기</button>
		</div>
	</form>
	<!-- 정보 입력 폼 종료 -->
	<hr/>
	<div class="join-text d-flex justify-content-end">
		<label class="information-tag mr-2 align-self-center">아직 회원이 아니신가요? </label>
		<button class="join-button" type="button" onclick="location.href='/DailyT/cust?cmd=join'">회원가입</button>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>