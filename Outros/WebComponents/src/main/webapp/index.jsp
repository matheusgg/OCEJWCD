<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.io.Reader"%>
<%@page import="javax.servlet.descriptor.JspPropertyGroupDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Index</title>
</head>
<body>
	<h1>Index</h1>

	<form action="Servlet2" enctype="multipart/form-data" method="post">
		<input type="file" name="file" /> <input type="submit" />
	</form>
	<hr />

	<jsp:useBean id="cliente" class="model.Cliente" scope="request">
		<jsp:setProperty property="nome" name="cliente" value="Matheus Gomes" />
	</jsp:useBean>

	<%@ include file="page1.jsp"%>
	<%-- 		<jsp:include page="page1.jsp" /> --%>
	<hr />

	<c:catch var="ex">
		<%
			int x = 10;
				System.out.println(x / 0);
		%>
	</c:catch>
	<%=pageContext.getAttributesScope("ex")%>
	<hr />

	<c:import url="http://www.google.com.br" varReader="google">
		<%
			Reader r = (Reader) pageContext.findAttribute("google");
		%>
		<%=r%>
	</c:import>
	<hr />

	${"${headerValues}"}
	<br /> ${headerValues}
	<hr />

	<c:out value="<Teste>" default="Teste" />
	<hr />

	<![CDATA[Teste]]>
</body>
</html>