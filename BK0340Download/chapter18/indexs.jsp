<%@ taglib uri="http://www.garnerpress.com/books/scwcd1.4/mysimpletags" prefix="mysimpletags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*" %>

<html>
<head>
  <title>SCWCD Tags Test</title>
</head>

<body>

<h1>Simple Tags</h1>

<h2>Conditional</h2>

<mysimpletags:if test="${ 2 < 3 }">
  <p>This should display okay</p>
</mysimpletags:if>

<mysimpletags:if test="${ 2 > 3 }">
  <p>This shouldn't display at all</p>
</mysimpletags:if>

<h2>for Loop</h2>

<mysimpletags:for start="10" end="-3" step="-2" var="mycount">
  <p>Counter is ${ mycount } using EL</p>
</mysimpletags:for>


<h2>Moderation</h2>

<%
  /* Get the helper */
  helpers.GuestbookHelper helper = new helpers.GuestbookHelper();

  /* Guestbook data: */
  pageContext.setAttribute("guestdata", helper.getEntries());

  /* Dictionary: */
  pageContext.setAttribute("sweardictionary", helper.getSwearDictionary());

%>

<table>
<tr><th>Date</th><th>Message</th></tr>
<mysimpletags:moderation data="${ guestdata }" replace="${ sweardictionary }" swearlimit="2" datevar="guestdate" textvar="guesttext">
  <tr>
    <td><fmt:formatDate value="${ guestdate }" type="both" dateStyle="long" timeStyle="short" /></td>
    <td>${ guesttext }</td>
  </tr>
</mysimpletags:moderation>
</table>

</body>
</html>