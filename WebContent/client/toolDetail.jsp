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
	<div class="proDetail-item">
		<div class="proDetail-title">
			<h4>${product.proName}</h4>
		</div>
		<hr />
		<div class="proDetail-preview d-flex">

			<img class="proDetail-preimage col-sm-6" src="${product.proPhoto }">

			<div class="proDetail-precontent col-sm-6">
				<p>${product.preview }</p>
				<!-- 할인율에 따른 분기점 -->
				<c:choose>
					<%--할인율이 있을 때의 출력 --%>
					<c:when test="${product.proSale ne 0  }">
						<c:set var="proPrice" value="${product.proPrice*(1-product.proSale/100) }" />
						<p style="text-decoration: line-through;">${product.proPrice}원</p>
						<p>
							→
							<fmt:parseNumber value="${product.proPrice*(1-product.proSale/100) }" integerOnly="true" />
							원
						</p>
					</c:when>

					<%--할인율이 없을 때의 출력 --%>
					<c:when test="${product.proSale eq 0  }">
						<c:set var="proPrice" value="${product.proPrice}" />
						<p>${product.proPrice}원</p>
					</c:when>
				</c:choose>
				<!-- 분기 종료 -->

				<!-- 갯수 선택 폼 -->
				<form class="proscribe-buy" action="">
					<label for="amount">갯수 :</label> <input type="text" class="form-control" id="amount" name="amount">
					<div class="d-flex">
						<button class="col-sm-6">구매하기</button>
						<button class="col-sm-6" type="button" onclick="addCart('${product.proName}','${product.proPhoto }','${proPrice }');">장바구니</button>
					</div>
				</form>
				<!-- 갯수 입력 폼 종료 -->
			</div>
		</div>
		<hr />

		<!-- 세부 내용 출력 -->
		<div class="proDetail-content">${product.proContent}</div>
		<hr />
		<!-- 세부 내용 출력 종료 -->
	</div>
</div>

<!-- 제품 상세페이지 종료 -->

<!-- 제품 덧글 등록 시작 -->

<div class="container">
	<form id="proReply">
		<div class="proDetail-grade">
			<label>별점 :</label>
			<div class="form-check-inline">
				<label class="form-check-label" for="radio1"> <input type="radio" class="form-check-input" id="radio" name="proGrade" value="1">★☆☆☆☆
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label" for="radio2"> <input type="radio" class="form-check-input" id="radio" name="proGrade" value="2">★★☆☆☆
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="radio" class="form-check-input" id="radio" name="proGrade" value="3">★★★☆☆
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="radio" class="form-check-input" id="radio" name="proGrade" value="4">★★★★☆
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="radio" class="form-check-input" id="radio" name="proGrade" value="5">★★★★★
				</label>
			</div>
		</div>

		<div class="form-group d-flex">
			<textarea class="form-control" rows="5" id="proContent"></textarea>
			<button type="button" onclick="writeProReply(${product.proId},${sessionScope.principal.custid})" class="col-sm-2">등록하기</button>
		</div>

	</form>
</div>
<!-- 덧글 등록 종료 -->
<hr />
<!-- 덧글 게시 시작 -->
<div class="container">
	<div class="proReply-total" id="proReply-total">
		<c:forEach items="${proReplies }" var="proReplies">
			<div id="proReply-${proReplies.replyid }">
				<div class="proReply-nickname d-flex justify-content-between">
					<p>${proReplies.nickname }
						/
						<c:choose>
							<c:when test="${proReplies.score eq 1}">
						★☆☆☆☆
					</c:when>
							<c:when test="${proReplies.score eq 2}">
						★★☆☆☆
					</c:when>
							<c:when test="${proReplies.score eq 3}">
						★★★☆☆
					</c:when>
							<c:when test="${proReplies.score eq 4}">
						★★★★☆
					</c:when>
							<c:when test="${proReplies.score eq 5}">
						★★★★★
					</c:when>
						</c:choose>
					</p>
					<c:if test="${sessionScope.principal.custid eq proReplies.custid }">
						<p>
							<i onclick="deleteProReply(${proReplies.replyid });" class="fas fa fa-trash"></i>
						</p>
					</c:if>
				</div>
				<div class="proReply-content">
					<p>${proReplies.content }</p>
				</div>
				<hr />
			</div>
		</c:forEach>


	</div>
</div>
<!-- 덧글 게시 종료 -->
<script src="/DailyT/js/proReply.js"></script>
<script src="/DailyT/js/purchase.js"></script>