<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>DailyT 홈페이지입니다.</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="/DailyT/css/nav.css">
<link rel="stylesheet" href="/DailyT/css/login.css">
<link rel="stylesheet" href="/DailyT/css/home.css">
<link rel="stylesheet" href="/DailyT/css/join.css">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

<!-- 섬머노트용 cdn -->

<!-- 섬머노트용 cdn 종료 -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="/DailyT/js/nav.js"></script>
</head>
<body>
	<div class="container-fluid">
		<!-- 로그아웃만 구현 -->
		<div class="nav1">
			<ul class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link" href="/DailyT/cust?cmd=logout">로그아웃</a></li>
			</ul>
		</div>
		<!--로그아웃 내비게이션 종료-->

		<!-- 홈으로 돌아가는 버튼만 있는 내비게이션 -->
		<div class="nav2">
			<nav class="navbar navbar-menu navbar-expand-sm">

				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/DailyT/admin?cmd=home"> <img src="/DailyT/img/dailyT-100px.png" alt="Logo" style="width: 50px;"></a></li>
				</ul>
			</nav>
		</div>
	</div>
	<!-- 홈버튼 내비게이션 종료 -->