<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Redirect</title>
</head>
<body>
	<h1>Redirect</h1>

	<!-- c:redirect utilizar o mecanismo de HttpServletResponse.sendRedirect() para realizar um redirecionamento. Neste caso,
		 um redirecionamento para um contexto externo esta sendo executado. Esse recurso e externo a aplicacao porem esta no mesmo container.
		 E possivel especificar parametros para serem inseridos na url atraves de c:param. A URL pode ser relativa ao recurso ou ao context root. -->

	<!-- c:param e utilizada para inserir parametros na URL. Os atributos de c:param podem ser expressoes. Quando o valor nao e informado, 
		 o que esta no corpo da tag e assumido como valor. Caso a tag nao possua um corpo ou value, o valor do parametro e vazio. Caso o atributo
		 value seja especificado e a tag possua um corpo, o que esta em value tem prioridade e e assumido por padrao. -->
	<c:redirect url="/servlets" context="/examples">
		<c:param name="test" value="valor" />
		<c:param name="test2">
			${param.test2}
		</c:param>
		<c:param name="test3" />
	</c:redirect>
	<%-- 	<c:redirect url="http://www.google.com.br" /> --%>
</body>
</html>