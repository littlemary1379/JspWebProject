<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- 페이지 메인 배너-->
<div class="container-fluid">
	<img class="main-banner" src="/DailyT/img/banner-exam7.png">
</div>
<!-- 페이지 메인 배너 끝 -->

<!-- 구독용 제품 전시 시작 -->
<div class="container">
	<!-- 카테고리별 버튼 -->
	<div class="subscribe-button d-flex">
		<button class="mr-2" onclick="sublistChange('전체');">
			<i class="fas fa-heart"></i><br />구독 전체
		</button>
		<button class="mr-2" onclick="sublistChange('정기');">
			<i class="fas fa-mug-hot"></i><br />정기 구독
		</button>
		<button class="mr-2" onclick="sublistChange('시즌');">
			<i class="fas fa-umbrella-beach"></i><br />시즌 구독
		</button>
	</div>
	<!-- 버튼 종료 -->
	<hr/>
	<div id="subscribe-items">
		<c:forEach items="${subProducts }" var="subProducts">
			<div class="subscribe-item">
				<div class="subscribe-title">
					<h4>
						<b>${subProducts.subName}</b>
					</h4>
				</div>
				<hr />
				<div class="subscribe-preview d-flex">

					<img class="subscribe-preimage col-sm-6" src="${subProducts.subPhoto }">

					<div class="subscribe-precontent col-sm-6">
						<p>${subProducts.subPreview }</p>
						<!-- 할인율에 따른 분기점 -->
						<c:choose>
							<%--할인율이 있을 때의 출력 --%>
							<c:when test="${subProducts.subSale ne 0  }">
								<p style="text-decoration: line-through;">${subProducts.subPrice}원</p>
								<p>
									→
									<c:set var="proPrice" value="${subProducts.subPrice*(1-subProducts.subSale/100) }" />
									<b><fmt:parseNumber value="${subProducts.subPrice*(1-subProducts.subSale/100) }" integerOnly="true" />
									원</b>
								</p>
							</c:when>

							<%--할인율이 없을 때의 출력 --%>
							<c:when test="${subProducts.subSale eq 0  }">
								<c:set var="proPrice" value="${subProducts.subPrice}" />
								<p>${subProducts.subPrice}원</p>
							</c:when>
						</c:choose>
						<!-- 분기 종료 -->
					</div>
				</div>
				<br />
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
<%@ include file="../include/footer.jsp"%>

</body>
</html>