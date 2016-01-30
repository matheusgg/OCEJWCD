<?xml version="1.0" encoding="US-ASCII" ?>

<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" info="Teste"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII" />
<title>Objetos Implicitos</title>
</head>
<body>
	<!-- Como e possivel especificar codigos que serao inseridos dentro do metodo jspService, surgiu a necessidade de acessar alguns objetos comuns,
		 esses objetos sao conhecidos como "objetos implicitos" e podem ser utilizados dentro de scriptlets e espressoes. Existem 9 objetos implicitos:
		 application, config, page, pageContext, request, response, session, out, exception. Com excecao de application, request e session, todos os
		 demais objetos implicitos possuem escopo de pagina. -->
	<h1>Objetos Implicitos</h1>
	<p>
		<%
			// application: ServletContext
			out.println("application: " + application);
			out.println("<br />");
			
			// config: ServletConfig
			out.println("config: " + config);
			out.println("<br />");
			
			// page: Object (e uma instancia da propria servlet, ou seja, pagina JSP)
			out.println("page: " + page);
			out.println("<br />");
			
			// request: ServletRequest (ou HttpServletRequest se o protocolo for http)
			out.println("request: " + request);
			out.println("<br />");
			
			// response: ServletResponse (ou HttpServletResponse se o protocolo for http)
			out.println("response: " + response);
			out.println("<br />");
			
			// session: HttpSession
			out.println("session: " + session);
			out.println("<br />");
			
			// pageContext: PageContext
			out.println("pageContext: " + pageContext);
			out.println("<br />");
			
			// out: JspWriter
			out.println("out: " + out);
		%>
	</p>
</body>
</html>