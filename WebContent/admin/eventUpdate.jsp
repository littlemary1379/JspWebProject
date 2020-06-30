<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/adminNav.jsp"%>

<!-- nav에 들어가면 인식을 못해서 빼둔 링크. 부가기능용(섬머노트, datepicker)용 -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- 종료 -->

<!--등록에 필요한 정보 : 상품 이름, 사진, 가격, 상품 세부내역-->

<div class="container">
<h4>이벤트 수정</h4>
	<form action="/DailyT/admin?cmd=eventUpdateProc" method="post" enctype="multipart/form-data">
		<!-- Id값 들고 가기 위한 hidden -->
		<div class="form-group">
			<input type="hidden" class="form-control" id="eventId" name="eventId" value="${event.eventId }">
		</div>
		<!-- hidden 종료 -->
		<div class="form-group">
			<label for="proname">이벤트 이름 : </label> 
			<input type="text" class="form-control" id="eventname" name="eventname" value="${event.eventName }">
		</div>
		
		<div class="form-group">
			<label for="proDate">이벤트 시작 : </label> 
			<input type="text" class="form-control" id="datepicker" name="eventStartDate" value="${event.eventStartDate }">
		</div>
		
		<div class="form-group">
			<label for="proDate">이벤트 종료 : </label> 
			<input type="text" class="form-control" id="datepicker2" name="eventFinishDate" value="${event.eventFinishDate }">
		</div>
		
		<div class="form-group bg-light">
			<label for="subPhoto">배너 : </label> 
			<input type="file" class="form-control" name="eventBanner" id="eventBanner" />
		</div>
		<div class="form-group">
			<label for="preview">내용 미리보기:</label>
			<textarea class="form-control" rows="5" id="eventpreview" name="eventpreview">${event.eventPreview }</textarea>
		</div>
		<div class="form-group">
			<label for="content">세부 내용:</label>
			<textarea class="form-control" rows="5" id="summernote" name="eventContent">${event.eventContent }</textarea>
		</div>
		<button type="submit" class="btn btn-primary">이벤트 수정</button>
	</form>
	<!-- 등록 폼 종료 -->

	<!-- 부가기능용(섬머노트, datepicker)용 스크립트 -->
	<script>
		$('#summernote').summernote({
			tabsize : 2,
			height : 300
		});

		var date = null;
		$(function() {
			$("#datepicker").datepicker({
				onSelect : function(picker) {
					date = $("#datepicker").val();
					console.log(date)
				},
				format : "yyyy-mm-dd",
				language : "ko"
			})
			
			$("#datepicker2").datepicker({
				onSelect : function(picker) {
					date = $("#datepicker").val();
					console.log(date)
				},
				format : "yyyy-mm-dd",
				language : "ko"
			})

		});
	</script>
	<!-- 스크립트 종료 -->

</div>

