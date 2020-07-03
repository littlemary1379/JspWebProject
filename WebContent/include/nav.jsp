<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    
<!DOCTYPE html>
<html lang="en">
<head>
<title>DailyT 홈페이지입니다.</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="/DailyT/css/nav.css">
<link rel="stylesheet" href="/DailyT/css/body.css">
<link rel="stylesheet" href="/DailyT/css/footer.css">


 <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
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
<script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="/DailyT/js/nav.js"></script>
</head>
<body>
	<div class="container-fluid">
		<!-- 로그인, 회원가입, 장바구니 내비게이션 -->
		<div class="nav1">
			<ul class="nav justify-content-end">
			<!-- if문을 통해 세션에 유저정보가 없으면 로그인, 회원가입/ 있다면 로그아웃, 회원정보 수정 띄우기-->
				<c:if test="${empty sessionScope.principal }">		
					<li class="nav-item"><a class="nav-link" href="/DailyT/cust?cmd=login">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="/DailyT/cust?cmd=join">회원가입</a></li>
					<li class="nav-item"><a class="nav-link" href="/DailyT/order?cmd=checkCart"><i class="fas fa fa-shopping-cart"></i></a></li>
				</c:if>	
				<c:if test="${not empty sessionScope.principal }">		
					<li class="nav-item"><a class="nav-link" href="/DailyT/cust?cmd=PWCheck">회원정보 수정</a></li>
					<li class="nav-item"><a class="nav-link" href="/DailyT/order?cmd=subscribeCheck">구독 확인</a></li>
					<li class="nav-item"><a class="nav-link" href="/DailyT/cust?cmd=logout">로그아웃</a></li>
					<li class="nav-item"><a class="nav-link" href="/DailyT/order?cmd=checkCart"><i class="fas fa fa-shopping-cart"></i></a></li>
				</c:if>	
			</ul>
		</div>
		<!-- 로그인, 회원가입, 장바구니 내비게이션 종료-->

		<!-- 브랜드 스토리, 정기구독, 단품, 도구, 이벤트 내비게이션 -->
		<div class="nav2">
			<nav class="navbar navbar-menu navbar-expand-sm justify-content-between">

				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/DailyT/index?cmd=home">
						<img src="/DailyT/img/dailyT-100px.png" alt="Logo" style="width: 50px;"></a>
					</li>
					<li class="nav-item2 col-md-3 align-self-center">
					<a class="nav-link" href="#">브랜드</a>
						<ul class="detail-nav2 ">
							<li><a class="detail-nav-link" href="#">브랜드 스토리</a></li>
							<li><a class="detail-nav-link" href="#">쇼룸</a></li>
						</ul></li>
					<li class="nav-item3 col-md-3 align-self-center"><a class="nav-link" href="/DailyT/client?cmd=sublist&season=all">정기구독</a>
						<ul class="detail-nav3">
							<li><a class="detail-nav-link" href="/DailyT/client?cmd=sublist&season=origin">정기 구독</a></li>
							<li><a class="detail-nav-link" href="/DailyT/client?cmd=sublist&season=season">시즌 구독</a></li>
						</ul></li>
					<li class="nav-item4 col-md-3 align-self-center"><a class="nav-link" href="/DailyT/client?cmd=prolist&category=all">단품</a>
						<ul class="detail-nav4">
							<li><a class="detail-nav-link" href="/DailyT/client?cmd=prolist&category=blacktea">홍차</a></li>
							<li><a class="detail-nav-link" href="/DailyT/client?cmd=prolist&category=greentea">녹차</a></li>
							<li><a class="detail-nav-link" href="/DailyT/client?cmd=prolist&category=whitetea">백차</a></li>
						</ul></li>
					<li class="nav-item5 col-md-3 align-self-center"><a class="nav-link" href="/DailyT/client?cmd=toollist&category=all">도구</a>
						<ul class="detail-nav5">
							<li><a class="detail-nav-link" href="/DailyT/client?cmd=toollist&category=package">스타터팩</a></li>
							<li><a class="detail-nav-link" href="/DailyT/client?cmd=toollist&category=tool">다구</a></li>
						</ul></li>
					<li class="nav-item  col-md-3 align-self-center"><a class="nav-link" href="/DailyT/client?cmd=eventlist">이벤트</a>
					</li>
				</ul>
			</nav>
		</div>
	</div>
	<!-- 브랜드 스토리, 정기구독, 단품, 도구, 이벤트 내비게이션 종료 -->