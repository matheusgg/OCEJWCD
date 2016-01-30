<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>JSTL</title>
</head>
<body>
	<h1>c:catch</h1>
	<c:catch var="ex">
		<%
			if (request.getParameter("erro") != null) {
					throw new ServletException("Excecao capturada pelo c:catch");
				}
		%>
	</c:catch>
	${pageScope.ex}

	<h1>c:choose</h1>
	<c:choose>
		<c:when test="${param.test}">
			Parametro test encontrado.
		</c:when>
		<c:otherwise>
			Parametro test nao encontrado.
		</c:otherwise>
	</c:choose>

	<h1>c:forEach</h1>
	<c:forEach begin="0" end="5" var="item">
		Item ${item}
	</c:forEach>

	<h1>c:forTokens</h1>
	<c:forTokens items="M,a,t,h,e,u,s" delims="," varStatus="status">
		${status.current}
	</c:forTokens>

	<h1>c:if</h1>
	<c:if test="${param.test}" var="condicao" scope="request">
		Parametro encontrado
	</c:if>
	<br /> Condicao do if: ${condicao}

	<h1>c:import</h1>
	<div style="border: 1px solid black; height: 100px; width: 900px; overflow: auto;">
		<c:import url="/page.jsp" />
		<c:import url="http://www.google.com.br" var="google" scope="request" />
	</div>
	Atributo de escopo de requisicao que contem o conteudo do import da pagina do Google: ${requestScope['google']['class']}

	<h1>c:out</h1>
	<c:out value="Matheus <>" default="Texto Padrao" />
	<br />
	<c:out value="${param.texto}">
		Parametro texto nao encontrado, exibindo texto padrao...
	</c:out>

	<h1>c:remove</h1>
	Removendo o atributo google do escopo de requisicao...
	<br />
	<c:remove var="google" />
	${empty requestScope['google']}

	<h1>c:set</h1>
	Adicionando atributo de sessao...
	<c:set var="attr" scope="session" value="Matheus" />
	<c:set var="attr2" scope="session">
		Gomes
	</c:set>
	<br /> ${attr} ${attr2}

	<h1>c:url</h1>
	<c:url value="/page.jsp" context="/JstlProject" var="url">
		<c:param name="param" value="Teste" />
		<c:param name="param">Teste 2</c:param>
	</c:url>
	<c:out value="${url}" />
</body>
</html>