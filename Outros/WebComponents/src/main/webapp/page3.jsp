<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="comp" uri="http://components.com.br"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Page 3</title>
</head>
<body>
	<h1>Page3</h1>
	<c:out value="${comp:sayHello()}" />

	<form action="Servlet3?txt=Gomes" method="post">
		<input type="text" name="TXT" /> <input type="text" name="txt" /><input type="submit" />
	</form>

	${requestScope}

	<hr />
	<comp:simpleMsg meuAttr="teste" msg="Teste Atributos Dinamicos" />

	<hr />
	<jsp:useBean id="teste" beanName="model.Cliente" type="model.Cliente" />
</body>
</html>