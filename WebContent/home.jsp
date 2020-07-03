<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/nav.jsp"%>

<!-- 이벤트 배너 시작 -->
<div class="container-fluid">
	<div id="demo" class="carousel slide" data-ride="carousel">

		<!-- Indicators -->
		<ul class="carousel-indicators">
			<li data-target="#demo" data-slide-to="0" class="active"></li>
			<li data-target="#demo" data-slide-to="1"></li>
			<li data-target="#demo" data-slide-to="2"></li>
		</ul>

		<!-- The slideshow -->
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/text-banner-exam1.png" alt="banner1">
			</div>
			<div class="carousel-item">
				<img src="img/text-banner-exam2.png" alt="banner2">
			</div>
			<div class="carousel-item">
				<img src="img/text-banner-exam3.png" alt="banner3">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="carousel-control-prev" href="#demo" data-slide="prev"> <span
			class="carousel-control-prev-icon"></span>
		</a> <a class="carousel-control-next" href="#demo" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>

	</div>

</div>

<%@ include file="../include/footer.jsp"%>

