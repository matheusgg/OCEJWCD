<%-- When using the wrapper, we will always see 'desirable' content. 
     When not using the wrapper, sometimes the page will fail to display; in that case, consult your server logs and you'll see an IllegalStateException
     caused by the response already being committed.
     Clearly the use of the wrapper gives more preferable results! --%>

<%@ page contentType="text/plain" %>
<% /* Pragma/no-cache ensures this page isn't cached by the browser */
   response.setHeader("pragma", "no-cache"); %>
<html>
  <head>
    <title>Test Page</title>
  </head>
  <body>
    <p>Body Content</p>

    <%-- Forceably flush the buffer here to show the difference between having the wrapper and not --%>
    <% response.flushBuffer(); %>

    <%-- This file checks authorisation; without our buffer, this throws IllegalStateException (you may need to look in system logs) --%>
    <%@ include file="auth.jsp" %>
  </body>
</html>
