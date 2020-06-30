<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/adminNav.jsp"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<div class="container">
  <h2>이벤트 관리</h2>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>이벤트 번호</th>
        <th>이벤트 이름</th>
        <th>시작 날짜</th>
        <th>종료 날짜</th>
        <th>  </th>
        <th>  </th>
                         
      </tr>
    </thead>
    
    <tbody>
    <c:forEach var="events" items="${events }" >
      <tr id="events-${events.eventId }">
        <td>${events.eventId }</td>
        <td>${events.eventName }</td>
        <td>${events.eventStartDate }</td>
        <td>${events.eventFinishDate }</td>
        <td><a href="/DailyT/admin?cmd=eventUpdate&eventId=${events.eventId }"><button>수정</button></a></td>
        <td><button onClick="eventDelete(${events.eventId})">삭제</button></td>                  
      </tr>
    </c:forEach> 

    </tbody>
  </table>
</div>
<script src="/DailyT/js/eventDelete.js"></script>
</body>
</html>
