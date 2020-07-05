<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- 페이지 메인 배너-->
<div class="container-fluid">
	<img class="main-banner" src="/DailyT/img/text-banner-exam3.png">
</div>
<!-- 페이지 메인 배너 끝 -->

<!-- 구독용 제품 전시 시작 -->
<div class="container">
	<!-- 카테고리별 버튼 -->
	<div class="subscribe-button d-flex">
		<button class="col sm-2 mr-2" onclick="brandChange('brand');">
			<i class="fas fa-heart"></i><br />브랜드 스토리
		</button>
		<button class="col sm-2 mr-2" onclick="brandChange('map');">
			<i class="fas fa-mug-hot"></i><br />쇼룸
		</button>
	</div>
	<!-- 버튼 종료 -->
	<hr />
	<!-- 브랜드 소개서(img) 시작 -->
	<div class="container">
		<div class="brand-img d-flex">
			<div id="map" style="width: 50%; height: 400px;"></div>
			<div class="col-md-6 align-self-center">
				<p>부산시 부산진구 중앙대로 -</p>
				<p>tel : 010-0000-1111</p>
				<script src="/DailyT/js/kakaoWebMap.js"></script>
			</div>
		</div>
	</div>
	<!-- 브랜드 소개서 종료 -->
</div>
<script src="/DailyT/js/brandlist.js"></script>
<%@ include file="../include/footer.jsp"%>

