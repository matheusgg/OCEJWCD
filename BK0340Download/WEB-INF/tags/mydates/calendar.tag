<%@ tag import="java.util.Calendar" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%-- Note that these directives could be configured in the TLD instead --%>

<%@ attribute name="year" required="true" type="java.lang.Integer" description="Year of calendar" %>
<%@ attribute name="month" required="true" type="java.lang.Integer" description="Month of calendar" %>
<%@ attribute name="diary" required="true" type="java.lang.String[][]" description="String[] entries for each day" %>
<%@ attribute name="startofweek" required="false" type="java.lang.Integer" description="Number for the start day (Sunday=1, Monday=2, ..., Saturday=7)" %>

<%@ attribute name="varEntries" required="true" rtexprvalue="false" description="Name for each day's exported entries" %>
<%@ attribute name="varDay" required="true" rtexprvalue="false" description="Name for the day's exported number" %>

<%@ variable name-from-attribute="varEntries" alias="entries" variable-class="java.lang.String[]" scope="NESTED" description="Entries for the particular date" %>
<%@ variable name-from-attribute="varDay" alias="daynum" variable-class="java.lang.Integer" scope="NESTED" description="Entries for the particular date" %>

<%-- Scriplet initialisation code: JSP scripting elements are valid as content in tag files, 
     but not in the bodies of the actions they represent! --%>
<% 
  /* Obtain the year and month as ints from the page-scoped attributes */
  int year = ((Integer)jspContext.getAttribute("year")).intValue();
  int month = ((Integer)jspContext.getAttribute("month")).intValue();


  Calendar cal = Calendar.getInstance();
  /* Set year and month (0 based) - default day to 1st of the month */
  cal.set(year, month-1, 1);

  /* Store this in the page-scope to allow EL to access it */
  jspContext.setAttribute("calendar", cal);
  int maxday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
  jspContext.setAttribute("maxday", maxday);

  /* NOTE: Although we probably shouldn't rely on this, DAY_OF_WEEK takes the value 1 for Sunday,
     2 for Monday ... up to 7 for Saturday. We will use this later */
  int startday = cal.get(Calendar.DAY_OF_WEEK);
  jspContext.setAttribute("startday", startday);

  /* Convert textual 'startofweek' value into number */
  Integer startofweekobj = (Integer) jspContext.getAttribute("startofweek");
  int startofweek = (startofweekobj == null ? 1 : startofweekobj.intValue());
  jspContext.setAttribute("startofweek", startofweek);

  /* The 'startcondition' is an offset; it represents the index of the cell 
     just before the first cell to be filled. */
  int startcondition = (startday - startofweek) % 7;
  if(startcondition < 0) {
    startcondition += 7;
  }
  jspContext.setAttribute("startcondition", startcondition);

  /* We need to calculate the final cell number - this is the 'maxday + startconditon' rounded
     to the next highest multiple of 7 */
  int maxcount = maxday + startcondition;
  if(maxcount % 7 != 0) {
      maxcount += 7 - (maxcount % 7);
  }
  jspContext.setAttribute("maxcount", maxcount);
%>

<%-- NOTE: Other than comments, no JSP scripting elements follow. We could therefore
     offload all the previous scripting code into a helper class/servlet, leaving this tag file as a 
     purely scriptless JSP (using EL rather than scripting elements). --%>
     

<table>
  <tr><th colspan="7"><fmt:formatDate value="${ calendar.time }" pattern="MMMMMMMMM yyyy" /></th></tr>

  <%-- Output the headings - this could also be formatted for different languages using another 
       custom or JSTL action --%>
  <tr>
    <c:forEach begin="${ startofweek }" end="${ startofweek + 6 }" var="counter">
      <th>
        <c:choose>
          <c:when test="${ counter % 7 == 1 }">Su</c:when>
          <c:when test="${ counter % 7 == 2 }">M</c:when>
          <c:when test="${ counter % 7 == 3 }">Tu</c:when>
          <c:when test="${ counter % 7 == 4 }">W</c:when>
          <c:when test="${ counter % 7 == 5 }">Th</c:when>
          <c:when test="${ counter % 7 == 6 }">F</c:when>
          <c:when test="${ counter % 7 == 0 }">Sa</c:when>
        </c:choose>
      </th>
    </c:forEach>
  </tr>

  <%-- Generates the cells in the table (starting top-left with index 1) --%>
  <c:forEach begin="1" end="${ maxcount }" step="1" var="counter">
    <%-- If we are at the start of a new week, start a new row --%>
    <c:if test="${ counter % 7 == 1 }">
      <jsp:text><![CDATA[<tr>]]></jsp:text>
    </c:if>

    <td>

    <%-- Only invoke the body if this is a valid day (non-empty cell) --%>
    <c:if test="${ counter > startcondition && counter <= (maxday + startcondition) }">
      <%-- Configure the variables for this date, then invoke the body --%>
      <c:set var="daynum" value="${ counter - startcondition }" />
      <c:set var="entries" value="${ diary[daynum] }" />
      <jsp:doBody />
    </c:if>

    </td>

    <%-- If we are at the end of a week, end this row --%>
    <c:if test="${ counter % 7 == 0 }">
      <jsp:text><![CDATA[</tr>]]></jsp:text>
    </c:if>
  </c:forEach>
</table>
