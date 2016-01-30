<?xml version="1.0" encoding="US-ASCII" ?>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII" />
<title>UseBean</title>
</head>
<body>
	<h1>UseBean</h1>

	<%
		request.setAttribute("beanName", "model.Cliente");
		request.setAttribute("nome", "Matheus");
		request.setAttribute("attr", "cliente3");
	%>

	<!-- E possivel utilizar expressoes EL apenas no atributo beanName -->
	<jsp:useBean id="cliente" beanName="${beanName}" type="model.Cliente">
		<jsp:setProperty name="cliente" property="nome" value="Teste in Index" />
	</jsp:useBean>


	<!-- E possivel utilizar expressoes EL somente no atributo value de setProperty. Caso o valor do atributo
		 property de setProperty nao for encontrado no bean estanciado, uma excecao sera lancada. -->
	<jsp:useBean id="cliente2" class="model.Cliente" scope="request">
		<jsp:setProperty name="cliente2" property="nome" value="Matheus" />
	</jsp:useBean>

	<jsp:include page="page.jsp" />

	<!-- Uma excecao sera lancada caso a diretiva include seja utilizada, pois como as duas JSP's serao mescladas, ou seja,
		 uma unica Servlet sera gerada para produzir o conteudo das duas JSP's, a variavel local cliente sera duplicada, 
		 gerando assim um erro de traducao. -->
	<%-- 		<%@ include file="page.jsp"%> --%>

	<p>
		Cliente1:
		<!-- Nao e possivel utilizar expressoes EL nos atributos de getProperty -->
		<jsp:getProperty property="nome" name="cliente" />
		<br />Cliente2:
		<jsp:getProperty property="nome" name="cliente2" />

		<!-- Caso esse bean nao seja encontrado, ou esteja em alguma pagina sendo incluida depois deste ponto,
			 uma excecao sera lancada -->
		<!-- 		<br />Cliente2: -->
		<%-- 		<jsp:getProperty property="nome" name="cliente3" /> --%>
	</p>
	<%-- 	<jsp:include page="page.jsp" /> --%>


	<!-- Com o coringa em property nao e necessario definir os atributos value ou param. -->
	<jsp:useBean id="cliente3" class="model.Cliente" scope="request">
		<jsp:setProperty property="*" name="cliente3" />
	</jsp:useBean>
	<p>
		Cliente3:
		<!-- Caso o atributo informado em property nao seja encontrado no atributo cliente3, um erro de traducao sera lancado -->
		<jsp:getProperty property="nome" name="cliente3" />
	</p>
</body>
</html>