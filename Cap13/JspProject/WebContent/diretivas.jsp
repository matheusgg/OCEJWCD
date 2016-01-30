<?xml version="1.0" encoding="US-ASCII" ?>

<!-- Ha quatro tipos de elementos de script que indicam que este conteudo deve ser processado, e nao simplesmente escrito para o cliente: 
	Diretivas, Declaracoes, Scriptlets e Expressoes. -->

<%-- As Diretivas disponibilizam informacoes para o container no momento da traducao e geralmente comecam com <%@ e podem ser de tres tipos: 
	 page, taglib e include. Cada tipo de diretiva possui um conjunto de atributos nome/valor --%>
<!-- Page: Permite indicar informacoes sobre a pagina JSP para o tradutor durante o processo de traducao. -->
<!-- Taglib: Permite especificar uma taglib que sera utilizada na pagina JSP. -->
<!-- Include: Permite especificar um conteudo que sera incluido na pagina JSP. -->
<!-- "import" e possivel especificar uma lista separada por virgula de pacotes ou classes que devem ser importadas no arquivo fonte gerado;
	 "session" indica que essa JSP tera participacao na sessao e que o objeto implicito session estara disponivel. Caso seja definido como true (padrao)
	 indica que quando o usuario solicitar essa JSP e uma sessao ainda nao estiver criada, uma nova sessao sera criada (isso e equivalente a
	 req.getSession());
	 "buffer" indica o tamanho do buffer a ser utilizado pelo objeto implicito JspWriter out (o padrao e none); 
	 "autoFlush" indica se o conteudo do buffer deve ser enviado para o cliente quando estiver cheio (true) ou, caso esteja cheio, uma execao devera sera lancada (false);
	 "info" permite especificar uma informacao que pode ser recuperada atraves de ServletConfig.getServletInfo();
	 "isErrorPage" indica se essa JSP e um algo de pagina de erro de outra pagina, ou seja, se esse atributo estiver marcado como false, o objeto
	 implicito exception nap estara disponivel e qualquer tentativa de utilizacao dele resultara em um erro de traducao. Caso seja true, o objeto implicito
	 exception estara disponivel;
	 "contentType" indica o tipo de conteudo dessa JSP que sera definido no metodo setContentType();
	 "isELIgnored" permite especificar se expressoes deverao ser ignoradas ou nao. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="US-ASCII" import="java.text.*, java.io.BufferedInputStream" session="true"
	buffer="32kb" autoFlush="true" info="Teste" isErrorPage="false" isELIgnored="false"%>
<!-- Atributos de diretivas de paginas que possuem multiplos valores podem ser declarados mais de uma vez. -->
<%@ page import="java.math.*"%>
<!-- Nao e possivel declarar mais de um contentType com valores diferentes na mesma JSP, isso gerara um excecao em tempo de traducao, mesmo se essa diretiva
	 estiver um outras JSP que estao incluidas nessa pagina, pois no final, apenas um arquivo fonte e gerado com todo o conteudo da JSP mais as inclusoes. -->
<!--  E possivel declarar varios contentType desde que tenham o mesmo valor -->
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"%> --%>


<!-- Na diretiva taglib, e permitido especificar apenas tagdir ou uri, nunca as duas ao mesmo tempo, senao uma excecao ocorrera. -->
<%-- <%@ taglib prefix="p" tagdir="diretorio da tag" uri="caminho da taglib" %> --%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII" />
<title>Script Elements - Diretivas</title>
</head>
<body>
	<h1>Diretivas</h1>

	<!-- Com a diretiva include e possivel incluir um arquivo informando o caminho relativo ao contexto ou a pagina JSP que esta incluindo o recurso.
		 No final, apenas um arquivo fonte (.java) e gerado com todo o condeudo da JSP mais os conteudos dos arquivos que foram incluidos. Se algum
		 erro ocorrer em qualquer um dos arquivos que estao sendo incluidos, a traducao de todos os arquivos falhara. A inclusao e avaliacao dos
		 recursos incluidos sao feitas na fase de traducao, desta forma, este e um mecanismo indicado para incluir recursos estaticamente que nao
		 sofrem alteracoes em tempo de execucao. Para recursos que realizam processamento e geram conteudo dinamico, esta solucao nao e adequada. -->
	<%@ include file="banner.jsp"%>
</body>
</html>