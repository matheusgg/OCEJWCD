<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<%-- Tag Files deve ficar localizadas dentro da pasta /WEB-INF/tags ou /META-INF/tags --%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="tags2" uri="http://tagFiles.com/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Tag Files</title>
</head>
<body>
	<p>
		Date:
		<tags:datePicker id="date" dateFormat="dd/mm/yy" maxlength="20" placeholder="Entre com uma data" />
	</p>

	<p>
		Writer:
		<tags:conditionalWriter test="true" bold="true" evaluateFragments="true">
			<jsp:attribute name="fragment">
				Fragment Attribute
			</jsp:attribute>

			<jsp:body>
				Teste
			</jsp:body>
		</tags:conditionalWriter>
	</p>

	<p>
		<tags2:out end="5" var="status" begin="0">
			<jsp:attribute name="frag">
				Attribute Fragment Test
			</jsp:attribute>
			<jsp:body>
				Item ${status}
			</jsp:body>
		</tags2:out>
	</p>

	<!-- statusTest sera definida dentro da servlet que representa index.jsp porem o seu valor foi definido
		 dentro da Tag File out. -->
	<%=statusTest%>
	
	<!-- Atributo de requisicao adicionado atraves de jsp:invoke em out.tag -->
	<p>${requestScope['frag']}</p>
</body>
</html>