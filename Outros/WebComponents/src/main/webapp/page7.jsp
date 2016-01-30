<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Page 7</title>
</head>
<body>
	<jsp:useBean id="cliente" class="model.Cliente">
		<jsp:setProperty property="*" name="cliente" />
	</jsp:useBean>

	<jsp:getProperty property="nome" name="cliente" />

	<br />
	<jsp:text>Testeee</jsp:text>

	<br />
	<%-- 	<jsp:expression>pageContext</jsp:expression> --%>

	<br />
	<jsp:include page="page8.jsp">
		<jsp:param value="Test" name="paramTest" />
	</jsp:include>

	<br /> ${3 / 0}

	<br /> ${pageContext}
</body>
</html>