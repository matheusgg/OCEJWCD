<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Page4</title>
</head>
<body>
	<h1>Page4</h1>

	<form action="page5.jsp?param1=Teste" method="post">
		Sexo: Masculino <input type="radio" name="sexo" /> Feminino <input type="radio" name="sexo" /> <br /> Nome: <input type="text" name="param2" /> <input
			type="submit" value="Go to page 5" />
	</form>
</body>
</html>