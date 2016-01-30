<?xml version="1.0" encoding="UTF-8" ?>

<!-- Quando o root element nao e especificado e nem a versao do documento, a versao 2.0 ou posterior e assumida por padrao. -->
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:jsp="http://java.sun.com/JSP/Page">

<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" info="10" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>JSP Document</title>
</head>
<body>
	<h1>JSP Document</h1>

	<!-- Quando um secao CDATA e inserida dentro de uma scriptlet ou declaration, o conteudo e enviado literalmente para o codigo fonte da servlet.
		 Caso essa sessao CDATA nao estivesse sido inserida, um erro de validacao ocorreria, pois o sinal de menor e ilegal em um documento XML,
		 pois identifica o inicio de um elemento. -->
	<jsp:scriptlet><![CDATA[boolean b = Integer.valueOf(this.getServletInfo()) < 10;]]></jsp:scriptlet>
	<jsp:expression>b</jsp:expression>
	<br />

	<!-- Quando uma sessao CDATA e inserida dentro de text ou no corpo da pagina, o conteudo e ignorado pelo tradutor e enviado diretamente para a resposta. -->
	<jsp:text>
		<![CDATA[boolean b = Integer.valueOf(this.getServletInfo()) < 10;]]>
	</jsp:text>
	
	<br />
	<!-- Include e utilizado para inclusao de conteudo dinamico no documento JSP -->
	<jsp:include page="/AppServlet" />
</body>
</html>
