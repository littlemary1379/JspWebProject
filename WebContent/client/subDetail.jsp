<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 페이지 메인 배너-->
<div class="container-fluid">
	<img class="main-banner" src="/DailyT/img/text-banner-exam3.png">
</div>
<!-- 페이지 메인 배너 끝 -->

<!-- 제품 상세페이지 시작 -->
<div class="container">
	<div class="subDetail-item">
		<div class="subDetail-title">
			<h4>${subProduct.subName}</h4>
		</div>
		<hr />
		<div class="subDetail-preview d-flex">

			<img class="subDetail-preimage col-sm-6" src="${subProduct.subPhoto }">

			<div class="subDetail-precontent col-sm-6">
				<p>${subProduct.subPreview }</p>
				<!-- 할인율에 따른 분기점 -->
				<c:choose>
					<%--할인율이 있을 때의 출력 --%>
					<c:when test="${subProduct.subSale ne 0  }">
						<p style="text-decoration: line-through;">${subProduct.subPrice}원</p>
						<p>
							→
							<fmt:parseNumber value="${subProduct.subPrice*(1-subProduct.subSale/100) }" integerOnly="true" />
							원
						</p>
					</c:when>

					<%--할인율이 없을 때의 출력 --%>
					<c:when test="${subProduct.subSale eq 0  }">
						<p>${subProduct.subPrice}원</p>
					</c:when>
				</c:choose>
				<!-- 분기 종료 -->

				<!-- 기간 선택 폼 -->
				<form class="subscribe-buy" action="/DailyT/order?cmd=subscribe" method="post">
					<input type="hidden" id="subName" name="subName" value="${subProduct.subName}">
					<select class="subscribe-buy-term col-sm-12" id="subscribe-buy-term" name="subscribe-buy-term">
						<option>1개월</option>
						<option>3개월</option>
						<option>6개월</option>
						<option>12개월</option>
					</select>
					<button class="col-sm-12">신청하기</button>
				</form>
				<!-- 선택 폼 종료 -->
			</div>
		</div>
		<hr />

		<!-- 세부 내용 출력 -->
		<div class="subDetail-content">${subProduct.subContent}</div>
		<hr />
		<!-- 세부 내용 출력 종료 -->
	</div>
</div>

<!-- 제품 상세페이지 종료 -->

<!-- 제품 덧글 등록 시작 -->

<div class="container">
	<form id="subReply">
		<div class="subDetail-grade">
			<label>별점 :</label>
			<div class="form-check-inline">
				<label class="form-check-label" for="radio1"> <input type="radio" class="form-check-input" id="radio2" name="subGrade" value="1">★☆☆☆☆
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label" for="radio2"> <input type="radio" class="form-check-input" id="radio2" name="subGrade" value="2">★★☆☆☆
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="radio" class="form-check-input" id="radio2" name="subGrade" value="3">★★★☆☆
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="radio" class="form-check-input" id="radio2" name="subGrade" value="4">★★★★☆
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="radio" class="form-check-input" id="radio2" name="subGrade" value="5">★★★★★
				</label>
			</div>
		</div>

		<div class="form-group d-flex">
			<textarea class="form-control" rows="5" id="subContent"></textarea>
			<button type="button" onclick="writeSubReply(${subProduct.subId},${sessionScope.principal.custid})" class="col-sm-2">등록하기</button>
		</div>

	</form>
</div>
<!-- 덧글 등록 종료 -->
<hr />
<!-- 덧글 게시 시작 -->
<div class="container">
	<div class="subReply-total" id="subReply-total">
		<c:forEach items="${subReplies }" var="subReplies">
			<div id="subReply-${subReplies.replyid }">
				<div class="subReply-nickname d-flex justify-content-between">
					<p>${subReplies.nickname }
						/
						<c:choose>
							<c:when test="${subReplies.score eq 1}">
						★☆☆☆☆
					</c:when>
							<c:when test="${subReplies.score eq 2}">
						★★☆☆☆
					</c:when>
							<c:when test="${subReplies.score eq 3}">
						★★★☆☆
					</c:when>
							<c:when test="${subReplies.score eq 4}">
						★★★★☆
					</c:when>
							<c:when test="${subReplies.score eq 5}">
						★★★★★
					</c:when>
						</c:choose>
					</p>
					<c:if test="${sessionScope.principal.custid eq subReplies.custid }">
						<p>
							<i onclick="deleteSubReply(${subReplies.replyid });" class="fas fa fa-trash"></i>
						</p>
					</c:if>
				</div>
				<div class="subReply-content">
					<p>${subReplies.content }</p>
				</div>
				<hr />
			</div>
		</c:forEach>


	</div>
</div>
<!-- 덧글 게시 종료 -->
<script src="/DailyT/js/subReply.js"></script>