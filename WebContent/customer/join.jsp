<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="../include/nav.jsp"%>


<div class="container h-100 col-md-6">
	<h4>Join</h4>
	<!-- ȸ������ �Է� �� -->	
	<form class="form col-md-12">
		<!-- ID �Է�, �ߺ�Ȯ�� �� -->
		<div class="form-group">
			<label class="ID-label">ID :</label> 
			<input type="text" class="form-control" name="userID" id="userID">
			<button class="btn btn-primary"> ID �ߺ� Ȯ��</button>
		</div>
		<div class="form-group">
			<label for="pwd">PW :</label>
			<input type="password" class="form-control" name="password" id="password">
		</div>
		<div class="form-group">
			<label for="pwd">PW Ȯ�� :</label> 
			<input type="password" class="form-control" name="passwordcheck" id="passwordcheck">
		</div>
		<div class="form-group">
			<label for="nickname">nickname :</label> 
			<input type="text" class="form-control" name="nickname" id="nickname">
		</div>
		<div class="form-group">
			<label for="pwd">email :</label> 
			<input type="email" class="form-control" name="email" id="email">
		</div>
		<div class="form-group">
			<label for="address">address :</label> 
			<input type="button" onClick="goPopup();" value="�ּ� �˻�"/>
			<input type="text" class="form-control" id="address" name="address" readonly>
		</div>
		<div class="form-group">
			<label for="address">�� �ּ� :</label> 
			<input type="text" class="form-control" id="detailaddress" name="detailaddress">
		</div>		
		<div class="form-group">
			<label for="cellphone">�޴���(- ���� �Է��ϼ���) :</label> 
			<input type="text" class="form-control" name="cellphone" id="cellphone">
		</div>		
		<div class="form-group d-flex justify-content-end">
			<button class="btn btn-primary" type="submit">Join</button>
		</div>
	</form>

</div>

<script src="/DailyT/js/juso.js"></script>
</body>
</html>