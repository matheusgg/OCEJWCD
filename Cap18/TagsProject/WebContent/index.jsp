<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="ct" uri="http://classicTags.com"%>
<%@ taglib prefix="st" uri="http://simpleTags.com"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Taglib Project</title>
</head>
<body>
	<h1>Classic Tags</h1>

	<ct:conditionalWriter condition="${empty param.test}">
		Condicao satisfeita
	</ct:conditionalWriter>

	<ct:include url="page.jsp" />

	<c:set var="item" value="Teste" />
	${item}
	<br />

	<ct:loop begin="0" end="5" var="item">
		Valor ${item}
		<br />
	</ct:loop>

	${item}

	<h1>Simple Tags</h1>
	<st:conditionalWriter test="true">
		Simple Tag Conditional Writer
	</st:conditionalWriter>

	<br />
	<br />

	<!-- Quando atributos dinamicos sao utilizados, o corpo da tag deve ser informado dentro da action jsp:body -->
	<st:dynamicTag attr="Teste">
		<jsp:attribute name="attr2">Teste2</jsp:attribute>
		<jsp:attribute name="attr3">Teste3</jsp:attribute>
		<jsp:body>
			<h3>Dynamic Tag</h3>
		</jsp:body>
	</st:dynamicTag>

	<br />

	<st:attrFragmentTag>
		<jsp:attribute name="attrFragment">
			Fragmento atributo
		</jsp:attribute>

		<jsp:body>
			<h3>Attribute Fragment</h3>
		</jsp:body>
	</st:attrFragmentTag>

	<br />

	<st:scriptVariableTag var="itemVar" end="5">
		${itemVar}
		<br />
	</st:scriptVariableTag>
</body>
</html>