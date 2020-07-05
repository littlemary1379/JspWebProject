<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>
<link rel="stylesheet" href="/DailyT/css/subscribe.css">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!-- 페이지 메인 배너-->
<div class="container-fluid">
	<img class="main-banner" src="/DailyT/img/text-banner-exam3.png">
</div>
<!-- 페이지 메인 배너 끝 -->

<!-- 이벤트 목록 시작 -->
<div class="container">
<div class="event-title">
	<h4> 전체 이벤트 목록 </h4>
	</div>
	<hr/>
	<div id="subscribe-items">
		<c:forEach items="${events }" var="events">
			<div class="subscribe-item">
				<div class="subscribe-title">
					<h5>${events.eventName}</h5>
				</div>
				<hr />
				<div class="subscribe-preview d-flex">

					<img class="subscribe-preimage col-sm-8" src="${events.eventBanner }">

					<div class="subscribe-precontent col-sm-4">
						<p>${events.eventPreview }</p>
						<p>${events.eventStartDate } ~ ${events.eventFinishDate }</p>
						
					</div>
				</div>
				<br/>
				<button class="subscribe-detail col-sm-12" onclick="location.href='/DailyT/client?cmd=subDetail&subId=${events.eventId }'">자세히 보기</button>
				<hr />
			
			</div>
		</c:forEach>
	</div>
</div>
<!-- 구독용 제품 전시 끝 -->


</body>
</html>