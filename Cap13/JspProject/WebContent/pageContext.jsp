<?xml version="1.0" encoding="US-ASCII" ?>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" errorPage="index.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII" />
<title>PageContext</title>
</head>
<body>
	<%-- PageContext e uma classe que fornece informacoes para a JSP. Teoricamente, paginas JSP nao precisam ser executadas em um ambiente Java EE, 
		 desta forma foi criada uma maneira uniforme de se recuperar e adicionar configuracoes no contexto de pagina, isto e, o contexto JSP. PageContext
		 extende JspContext que e uma classe generica, assim como PageContext, que fornece meios para adicionar e recuperar atributos de todos os escopos
		 em paginas JSP's.--%>

	<h1>PageContext</h1>
	<%
		// Adicionando atributo nos escopos
		request.setAttribute("attr", "Atributo adicionado no Request");
		session.setAttribute("attr", "Atributo adicionado na Sessao");
		application.setAttribute("attr", "Atributo adicionado na Aplicacao");
		application.setAttribute("attr2", "Atributo adicionado na Aplicacao");
		pageContext.setAttribute("attr", "Atributo adicionado na PageContext");
		pageContext.setAttribute("attr2", "Atributo adicionado na PageContext");
		
		// O metodo pushBody(Writer) substitui o writer padrao e faz todos os dados passarem a ser escritos no writer informado.
		// O objeto implicito out e salvo e pode ser restaurado atraves da chamada ao metodo popBody().
		// ByteArrayOutputStream os = new ByteArrayOutputStream();
		// PrintWriter pw = new PrintWriter(os, true);
		// Substitui o writer padrao pelo informado.
		// JspWriter jspWriter = pageContext.pushBody(pw);

		// Restaura o objeto implicito out salvo apos a chamada ao metodo pushBody(Writer) 
		// jspWriter = pageContext.popBody();

		// Metodo utilizado par manipulacao manual de excecoes e realiza o redirecionamento para a pagina de erro especificada.
		// if(true){
		// pageContext.handlePageException(new IllegalArgumentException("Teste"));			
		// }
	%>

	<p>
		<%-- O metodo findAttribute(String) procura o atributo com o nome informado em todos os escopos iniciando pelo mais especifico seguindo a seguinte ordem:
		 page, request, session e application. Quando o atributo e encontrado, em qualquer um dos escopos, a pesquisa e encerrada e o valor e retornado. 
		 Caso o atributo nao seja encontrado em nenhum dos escopos, este metodo retornara null. --%>
		<%="findAttribute(String): " + pageContext.findAttribute("attr")%>
		<br />

		<%-- Semelhante aos metodos getAttribute(String) de request, session e application, retorna o atributo com o nome especificado no escopo de pagina. --%>
		<%="getAttribute(String): " + pageContext.getAttribute("attr")%>
		<br />

		<%-- Este metodo retorna o atributo com o nome especificado no escopo informado. O escopo deve ser uma das contantes presentes na classe PageContext:
			 page=1, request=2, session=3, application=4. --%>
		<%="getAttribute(String, int): " + pageContext.getAttribute("attr", PageContext.APPLICATION_SCOPE)%>
		<br />

		<%-- Retorna os nomes de todos os atributos no escopo informado. Caso o escopo informado nao exista uma excecao sera lancada.--%>
		<%="getAttributeNamesInScope(int): " + pageContext.getAttributeNamesInScope(PageContext.REQUEST_SCOPE)%>
		<br />

		<%-- Retorna o escopo do atributo com o nome especificado. O valor retornado sera o primeiro escopo encontrado que e uma das contantes de PageContext.
			 A ordem de pesquisa comeca em page, request, session e application. --%>
		<%="getAttributesScope(String): " + pageContext.getAttributesScope("attr")%>
		<br />

		<%
			// Removendo o atributo do escopo de pagina
			pageContext.removeAttribute("attr2");

			// O metodo removeAttributo e sobrecarregado para receber o escopo onde este atributo reside.
			pageContext.removeAttribute("attr2", PageContext.APPLICATION_SCOPE);

			// Adicionando um atributo na requisicao atraves de page context
			pageContext.setAttribute("attr3", "Atributo adicionado ao request atraves de pageContext", PageContext.REQUEST_SCOPE);
		%>

		<%="getAttribute(String): " + pageContext.getAttribute("attr3", PageContext.REQUEST_SCOPE)%>
		<br />
	</p>
</body>
</html>