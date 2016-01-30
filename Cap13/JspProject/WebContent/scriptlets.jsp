<?xml version="1.0" encoding="US-ASCII" ?>
<%@ page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII" />
<title>Scriptlets</title>
</head>
<body>
	<%-- Scriptlets sao codigos java que sao inseridos dentro do metodo jspService do codigo fonte da jsp gerada. Todas as variaveis declaradas dentro
		 de um scriptlet sao variaveis locais de metodo, diferentemente das variaveis declaradas dentro das declaracoes, que sao variaveis globais.
 		 Scriptlets iniciam com <% --%>
	<h1>Scriptlets</h1>

	<%
		Calendar cal = Calendar.getInstance();
		boolean segunda = (cal.get(Calendar.DAY_OF_WEEK) == 2);
	%>

	<%
		if (segunda) {
	%>
	Hoje e segunda!!!
	<%
		} else {
	%>
	Hoje nao e segunda =/...
	<%
		out.println(DateFormat.getDateInstance(DateFormat.FULL).format(cal.getTime()));
		}
	%>
</body>
</html>