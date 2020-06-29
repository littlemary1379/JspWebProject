<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>
<link rel="stylesheet" href="/DailyT/css/subscribe.css">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!-- 페이지 메인 배너-->
<div class="container-fluid">
	<img class="main-banner" src="/DailyT/img/text-banner-exam3.png">
</div>
<!-- 페이지 메인 배너 끝 -->

<!-- 구독용 제품 전시 시작 -->
<div class="container">
	
	<!-- 카테고리별 버튼 -->
	<div class="subscribe-button d-flex">
		<button onclick="listChange('전체');">구독 전체</button>
		<button onclick="listChange('정기');">정기 구독</button>
		<button onclick="listChange('시즌');">시즌 구독</button>
	</div>
	<!-- 버튼 종료 -->
	
	<div id="subscribe-items">
		<c:forEach items="${subProducts }" var="subProducts">
			<div class="subscribe-item">
				<div class="subscribe-title">
					<h4>${subProducts.subName}</h4>
				</div>
				<hr />
				<div class="subscribe-preview d-flex">

					<img class="subscribe-preimage col-sm-6" src="${subProducts.subPhoto }">

					<div class="subscribe-precontent col-sm-6">
						<p>${subProducts.subPreview }</p>
						<p>${subProducts.subPrice }원</p>
					</div>
				</div>
				<button class="subscribe-detail col-sm-12" onclick="location.href='/DailyT/client?cmd=subDetail&subId=${subProducts.subId }'">자세히 보기</button>
				<hr />
			
			</div>
		</c:forEach>
	</div>
</div>
<!-- 구독용 제품 전시 끝 -->

<!-- 전시용 js 시작 -->
<script src="/DailyT/js/subscribelist.js"></script>
<!-- 전시용 js 종료 -->

</body>
</html>