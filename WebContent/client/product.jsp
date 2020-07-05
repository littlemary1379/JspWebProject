<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>
<link rel="stylesheet" href="/DailyT/css/subscribe.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- 페이지 메인 배너-->
<div class="container-fluid">
	<img class="main-banner" src="/DailyT/img/banner-exam5.png">
</div>
<!-- 페이지 메인 배너 끝 -->

<!-- 제품 전시 시작 -->
<div class="container">

	<!-- 카테고리별 버튼 -->
	<div class="product-button d-flex">
		<button  class="mr-2" onclick="prolistChange('전체');"><i class="fas fa-glass-cheers"></i><br />전체</button>
		<button  class="mr-2" onclick="prolistChange('홍차');"><i class="fas fa-mug-hot	"></i><br />홍차</button>
		<button  class="mr-2" onclick="prolistChange('녹차');"><i class="fas fa-coffee"></i><br />녹차</button>
		<button  class="mr-2" onclick="prolistChange('백차');"><i class="fas fa-glass-whiskey"></i><br />백차</button>

	</div>
	<!-- 버튼 종료 -->

	<!-- 전시 제품 진열 -->
	<div class="product">
		<div class="category-title">
			<h4>제품 전체</h4>
		</div>
		<hr />

		<!-- 카테고리는 한 줄당 3개씩 -->
		<div id="products-category" class="3product-category d-flex">
			<c:forEach items="${products }" var="products">
				<div class="card" style="width: 400px">
					<img class="card-img-top" src="${products.proPhoto }" alt="Card image" style="width: 100%">
					<div class="card-body">
						<h4 class="card-title">${products.proName }</h4>
						<p class="card-text">${products.preview }</p>
						<a href="/DailyT/client?cmd=proDetail&proId=${products.proId }" class="btn btn-primary stretched-link">자세히 보기</a>
					</div>

				</div>
			</c:forEach>
		</div>

		<hr />

	</div>

</div>
<!-- 제품 전시 종료 -->

<script src="/DailyT/js/productlist.js"></script>
