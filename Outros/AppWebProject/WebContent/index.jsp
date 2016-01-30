<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Context Init Params</title>
</head>
<body>
	<h3>Parametros de inicializacao de contexto</h3>
	${initParam}

	<h3>EL Divisao por 0</h3>
	<%-- 	${10 / 0 eq 'Infinity'} --%>
	<br />

	<!-- 	<h3>Use Bean</h3> -->
	<%-- 	<jsp:useBean id="cliente" type="model.Cliente" scope="page" /> --%>
	<%-- 	<%=cliente.getNome()%> --%>

	<jsp:useBean id="endereco" class="model.Endereco">
		<jsp:setProperty property="rua" value="Rua Teste" name="endereco" />
		<jsp:setProperty property="cep" value="04419140" name="endereco" />
	</jsp:useBean>

	<jsp:useBean id="cliente1" class="model.Cliente">
		<jsp:setProperty property="nome" value="Matheus" name="cliente1" />
	</jsp:useBean>
	<c:set target="${cliente1}" property="endereco" value="${endereco}" />

	<jsp:getProperty property="endereco" name="cliente1" />
</body>
</html>