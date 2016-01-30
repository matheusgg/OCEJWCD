<%-- E possivel declarar outro "contentType" na pagina que esta sendo incluida desde que este tenha o mesmo valor declarado na pagina principal. --%>
<%-- E possivel declarar varios "pageEncoding" com valores diferentes desde que estejam no inicio da pagina JSP --%>
<%@ page import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h3>
	Banner page included:
	<%=new Date()%>
</h3>
