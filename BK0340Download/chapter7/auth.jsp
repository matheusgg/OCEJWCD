<%
/* This code randomly decides whether we are authorised or not */
if(new java.util.Random().nextInt(2) == 0) {
    response.sendError(HttpServletResponse.SC_FORBIDDEN);
}
%>
