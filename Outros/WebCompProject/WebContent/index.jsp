<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" import="model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Index</title>
</head>
<body>
	<h1>Index</h1>

	<%=request.isAsyncSupported()%>
	<br />
	<%=config.getServletName()%>
	<br />
	<%=request.getParameter("var")%>
	<br />
	<%=request.getRequestURI()%>
	<br />
	<%=request.getMethod()%>
	<br />

	<%-- 	<jsp:useBean id="cli" type="model.Cliente" scope="request"/> --%>
	<%-- 	<jsp:getProperty property="nome" name="cli"/> --%>
</body>
</html>