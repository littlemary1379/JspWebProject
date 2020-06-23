<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>DailyT 홈페이지입니다.</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="/DailyT/css/nav.css">
<link rel="stylesheet" href="/DailyT/css/login.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="/DailyT/js/nav.js"></script>
</head>
<body>
	<div class="container-fluid">
		<!-- 로그인, 회원가입, 장바구니 내비게이션 -->
		<div class="nav1">
			<ul class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link" href="#">로그인</a></li>
				<li class="nav-item"><a class="nav-link" href="#">회원가입</a></li>
				<li class="nav-item"><a class="nav-link" href="#"><i
						class="fas fa fa-shopping-cart"></i></a></li>
			</ul>
		</div>
		<!-- 로그인, 회원가입, 장바구니 내비게이션 종료-->

		<!-- 브랜드 스토리, 정기구독, 단품, 도구, 이벤트 내비게이션 -->
		<div class="nav2">
			<nav class="navbar navbar-menu navbar-expand-sm">

				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#"><img
							src="/DailyT/img/dailyT-100px.png" alt="Logo" style="width: 40px;"></a>
					</li>
					<li class="nav-item2 col-md-4"><a class="nav-link" href="#">브랜드
							스토리</a>
						<ul class="detail-nav2">
							<li><a class="detail-nav-link" href="#">브랜드 스토리</a></li>
							<li><a class="detail-nav-link" href="#">쇼룸</a></li>
						</ul></li>
					<li class="nav-item3 col-md-4"><a class="nav-link" href="#">정기구독</a>
						<ul class="detail-nav3">
							<li><a class="detail-nav-link" href="#">시즌 구독</a></li>
							<li><a class="detail-nav-link" href="#">정기 구독</a></li>
						</ul></li>
					<li class="nav-item4 col-md-4"><a class="nav-link" href="#">단품</a>
						<ul class="detail-nav4">
							<li><a class="detail-nav-link" href="#">홍차</a></li>
							<li><a class="detail-nav-link" href="#">녹차</a></li>
							<li><a class="detail-nav-link" href="#">백차</a></li>
						</ul></li>
					<li class="nav-item5 col-md-4"><a class="nav-link" href="#">도구</a>
						<ul class="detail-nav5">
							<li><a class="detail-nav-link" href="#">스타터팩</a></li>
							<li><a class="detail-nav-link" href="#">다구</a></li>
						</ul></li>
					<li class="nav-item  col-md-4"><a class="nav-link" href="#">이벤트</a>
					</li>
				</ul>
			</nav>
		</div>
	</div>
	<!-- 브랜드 스토리, 정기구독, 단품, 도구, 이벤트 내비게이션 종료 -->