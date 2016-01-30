<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="http://custom.com/tags"%>

<!-- Um mesmo TLD pode ser referenciado de duas formas diferentes. Atraves da URI ou do caminho relativo ao contexto -->
<%@ taglib prefix="custom" uri="http://tags.com/custom"%>
<%-- <%@ taglib prefix="custom" uri="/WEB-INF/tags.tld"%> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>TagLib Descriptor Project</title>
</head>
<body>
	<h1>TagLib Descriptor Project</h1>

	<tag:customWriter test="true">
		Teste
	</tag:customWriter>

	<br />

	<custom:conditionalWriter test="true">
		Teste 2
	</custom:conditionalWriter>

	<br />
	<custom:boldWriter>Negrito</custom:boldWriter>
</body>
</html>