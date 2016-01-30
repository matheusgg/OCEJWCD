<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Async Test</title>
</head>
<body>
	<h3><%=request.isAsyncSupported()%></h3>

	<%
		Cliente cliente = new Cliente("Matheus");
		// 		cliente.setNome("Matheus");
		pageContext.setAttribute("cliente", cliente, PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("num", "10", PageContext.REQUEST_SCOPE);
	%>

	<p>
		<br />${(cliente)['nome']} <br />${teste % 2} <br />${num + 20}
	</p>
	<hr />

	<jsp:useBean id="cli" class="model.Cliente" />
	<jsp:setProperty property="nome" name="cli" param="nome" />
	<jsp:getProperty property="nome" name="cli" />
	<hr />

	<%-- PODREEEEE DEMAIS --%>
	<a href="<c:url value='page.jsp'><c:param name='nome' value='Matheus'>Teste</c:param></c:url>">URL</a>
	<hr />

</body>
</html>