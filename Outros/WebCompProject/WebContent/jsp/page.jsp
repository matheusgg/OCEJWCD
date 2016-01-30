<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" import="model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>JavaServer Pages</title>
</head>
<body>
	<h1>JavaServer Pages</h1>

	<%-- DIRETIVA INCLUDE --%>
	<%--<%@ include file="/index.jsp"%>--%>

	<%-- ACTION INCLUDE --%>
	<%-- 	<jsp:include page="/index.jsp"> --%>
	<%-- 		<jsp:param value="Teste" name="var" /> --%>
	<%-- 	</jsp:include> --%>

	<%-- ACTION ELEMENT, ATTRIBUTE --%>
	<%-- 	<jsp:element name="root"> --%>
	<%-- 		<jsp:element name="cliente"> --%>
	<%-- 			<jsp:attribute name="nome">Matheus</jsp:attribute> --%>
	<%-- 			<jsp:body>Teste</jsp:body> --%>
	<%-- 		</jsp:element> --%>
	<%-- 	</jsp:element> --%>

	<%-- USE BEAN --%>
	<%
		// 		Cliente cliente = new Cliente();
		// 		cliente.setNome("Matheus");

		// 		pageContext.setAttribute("cli", cliente, PageContext.SESSION_SCOPE);
	%>
	<jsp:useBean id="cli" beanName="model.Cliente" type="model.Cliente">
		<jsp:attribute name="scope">request</jsp:attribute>
		<jsp:body>
			<jsp:setProperty property="nome" name="cli" value="Matheus" />
		</jsp:body>
	</jsp:useBean>

	<jsp:getProperty property="nome" name="cli" />
	<jsp:setProperty property="*" name="cli" />

	<br />
	<jsp:getProperty property="nome" name="cli" />
	<br />
	<jsp:getProperty property="idade" name="cli" />

	<br /><jsp:include page="/index.jsp" />
</body>
</html>