<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<script src="/DailyT/js/FinishSubscribe.js"></script>
<div class="container">
	<div class="subscribeCheck">
		<p>고객님이 현재 구독하고 계신 제품은</p>
		<p>
		<c:forEach items="${subscribes }" var="subscribes">
			${subscribes.subscribeKind }, 
		</c:forEach>
		입니다.
		</p>
		<p>종료 기간은</p>
		<c:forEach items="${subscribes }" var="subscribes">
			<script type="text/javascript">
				finishSubscribe("${subscribes.subscribeDate }");
			</script>,
		</c:forEach>입니다.
	
	</div>

</div>
