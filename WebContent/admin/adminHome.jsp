<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/adminNav.jsp"%>
<div class="container">
	<div class="list-group">
		<a href="/DailyT/admin?cmd=proreg" class="list-group-item list-group-item-action">단품 등록</a>
		<a href="/DailyT/admin?cmd=prolist" class="list-group-item list-group-item-action">단품 관리</a> 

		<a href="/DailyT/admin?cmd=subreg" class="list-group-item list-group-item-action">정기구독 등록</a>
		<a href="/DailyT/admin?cmd=sublist" class="list-group-item list-group-item-action">정기구독 관리</a>
		
		<a href="/DailyT/admin?cmd=eventreg" class="list-group-item list-group-item-action">이벤트 등록</a>
		<a href="/DailyT/admin?cmd=eventlist" class="list-group-item list-group-item-action">이벤트 관리</a> 
		
		<a href="/DailyT/admin?cmd=custlist" class="list-group-item list-group-item-action">회원 관리</a>
	</div>
</div>

</body>
</html>