<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/mydates" prefix="dates" %>

<%
  String[][] diary = new String[31][];
  diary[5] = new String[]{ "Anniversary" };
  diary[18] = new String[]{ "Business meeting" };

  pageContext.setAttribute("myplans", diary);
%>

<style>
  table { border-collapse:collapse; border:solid black 0.5pt; }
  table td { width:12pt; height:12pt; border:solid black 0.5pt; }
</style>

<!-- HTML form for changing year/start day -->
<form method="GET" action="">
  Calendar year: <input type="text" maxlength="4" name="year" value="${ param['year'] }" />
  Week beginning: <select name="weekbegins">
    <option value="1">Sunday</option>
    <option value="2">Monday</option>
    <option value="3">Tuesday</option>
    <option value="4">Wednesday</option>
    <option value="5">Thursday</option>
    <option value="6">Friday</option>
    <option value="7">Saturday</option>
  </select>
  <input type="submit" />
</form>

<c:forEach begin="1" end="12" var="thisMonth">
  <dates:calendar year="${ (empty param['year']) ? 2006 : param['year'] }" month="${ thisMonth }" diary="${ myplans }" varDay="todayNum" varEntries="dayEntries" startofweek="${ (empty param['weekbegins']) ? 1 : param['weekbegins'] }">
    <span style="<c:if test="${ !(empty dayEntries) }">background-color:yellow;</c:if>"><a href="?year=${ param['year'] }&month=${ thisMonth }">${ todayNum }</a></span>
  </dates:calendar>
</c:forEach>


<dates:calendarx year="${ param['year'] }" month="${ param['month'] }" diary="${ myplans }" varDay="todayNum" varEntries="dayEntries">
  <h3>${ todayNum }</h3>
  <c:if test="${ !(empty dayEntries) }">
    <c:forEach items="${ dayEntries }" var="thisEntry">
      ${ thisEntry },
    </c:forEach>
  </c:if>
</dates:calendarx>