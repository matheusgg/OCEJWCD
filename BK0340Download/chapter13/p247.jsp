<%@ page import="java.util.*, java.text.DateFormat" %>
<%
  Calendar cal = Calendar.getInstance();
  boolean morning = ( cal.get(Calendar.AM_PM) == Calendar.AM );
%>
<p>
Good
  <% if(morning) { %>
    morning.
  <% } else { %>
    afternoon.
  <% } %>
The date is <% out.write( DateFormat.getDateInstance().format(cal.getTime()) ); %>
and the time now is <% out.write( DateFormat.getTimeInstance().format(cal.getTime()) ); %>
</p>
