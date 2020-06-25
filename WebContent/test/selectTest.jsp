<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/adminNav.jsp"%>
<div class="container">
	<h2>Form control: select</h2>
	<p>The form below contains two dropdown menus (select lists):</p>
	<form action="/action_page.php">
		<div class="form-group">
			<label for="sel1">Select list (select one):</label> 
			<select class="form-control" id="sel1" name="sellist1">
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
			</select>
		</div>
	</form>
</div>
