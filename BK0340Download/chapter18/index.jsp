<%@ taglib uri="http://www.garnerpress.com/books/scwcd1.4/mytags" prefix="mytags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*" %>

<html>
<head>
  <title>SCWCD Tags Test</title>
</head>

<body>

<h1>Classic Tags</h1>

<h2>Conditional</h2>

<mytags:if test="${ 2 < 3 }">
  <p>This should display okay</p>
</mytags:if>

<mytags:if test="${ 2 > 3 }">
  <p>This shouldn't display at all</p>
</mytags:if>

<h2>Include</h2>

<div><mytags:include page="included.txt" /></div>

<h2>for Loop</h2>

<mytags:for start="10" end="-3" step="-2" var="mycount">
  <p>Counter is <%= mycount %> using JSP, or ${ mycount } using EL</p>
</mytags:for>

<h2>Country Selection</h2>

<p>Select your country:</p>
<table>
  <tr><td><mytags:selectCountry /></td></tr>
  <tr><td><mytags:selectCountry name="formname" select="GB" /></td></tr>
  <tr><td><mytags:selectCountry lang="fr" name="countryfield" select="FR" style="background: #DDFFFF;" /></td></tr>
  <tr><td><mytags:selectCountry lang="de" name="countryfield" select="DE" style="background: #FFDDDD;" /></td></tr>
</table>


<h2>Moderation</h2>

<%
  /* Guestbook data: */
  Map<Date, String> guestdata = new Hashtable<Date, String>();

  /* To get a sample date, subtract some random number of milliseconds from the current time */
  Random rand = new Random();
  /* The masks on the random longs ensures that they are milliseconds in the last year or so */
  guestdata.put(new Date(System.currentTimeMillis() - (rand.nextLong() & 0x7FFFFFFFFL)), "This site is rubbish, uninformative and boring");
  guestdata.put(new Date(System.currentTimeMillis() - (rand.nextLong() & 0x7FFFFFFFFL)), "This site is rubbish and boring");
  guestdata.put(new Date(System.currentTimeMillis() - (rand.nextLong() & 0x7FFFFFFFFL)), "Totally uninformative pages");
  guestdata.put(new Date(System.currentTimeMillis() - (rand.nextLong() & 0x7FFFFFFFFL)), "Just so boring to read");
  pageContext.setAttribute("guestdata", guestdata);

  /* Dictionary: */
  Map<String, String> sweardictionary = new Hashtable<String, String>();

  /* Note that we use "\\*" instead of "*" because our replacement tag uses the regex
     replacements methods, and * is a reserved regex character. We could also build this
     escapement into the tag handler; note that "-" does not require escaping since it is 
     not reserved in regex outside character classes. */
  sweardictionary.put("rubbish", "ru\\*\\*\\*sh");
  sweardictionary.put("uninformative", "unin\\*\\*\\*\\*ative");
  sweardictionary.put("boring", "bo--ng");
  pageContext.setAttribute("sweardictionary", sweardictionary);

%>

<table>
<tr><th>Date</th><th>Message</th></tr>
<mytags:moderation data="${ guestdata }" replace="${ sweardictionary }" swearlimit="2" datevar="guestdate" textvar="guesttext">
  <tr>
    <td><fmt:formatDate value="${ guestdate }" type="both" dateStyle="long" timeStyle="short" /></td>
    <td><%= guesttext %></td>
  </tr>
</mytags:moderation>
</table>

</body>
</html>