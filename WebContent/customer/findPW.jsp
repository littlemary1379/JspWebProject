<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container h-100 col-md-6">
	<h3 class="customer-title">PW 찾기</h3>
	<form class="customer-form col-md-12 was-validated" method="post" action="/DailyT/cust?cmd=findPWProc">
		<div class="form-group">
			<label class="ID-label" for="userID">이름 :</label> 
			<input type="text" class="form-control" id="username" name="username" required="required">
		</div>
		<div class="form-group">
			<label for="userID">ID :</label> 
			<input type="text" class="form-control" id="userID" name="userID" required="required">
		</div>		
		<div class="form-group">
			<label for="email">Email :</label> 
			<input type="email" class="form-control" id="email" name="email" required="required">
		</div>
		<br/>
		<div class="form-group d-flex justify-content-end">
			<button type="submit">PW 찾기</button>
		</div>
	</form>
</div>

<%@ include file="../include/footer.jsp"%>