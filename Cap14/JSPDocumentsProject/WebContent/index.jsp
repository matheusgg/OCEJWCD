<?xml version="1.0" encoding="US-ASCII" ?>

<!-- JSP documents sao paginas JSP's bem estruturadas que seguem a estrutura de um arquivo XML. Foram desenvolvidas para facilitar
	 o desenvolvimento de paginas por parte dos programadores e para diminuir scripts nas paginas. -->

<!-- Com JSP Documents ha um ganho de performance na hora da criacao do codigo fonte, pois com elas, o container sabe o que esperar,
	 pois sao arquivos XML, desta forma, o processo de criacao do fonte e otimizado. -->

<!-- Antes da fase de traducao, para cada pagina JSP, o container cria um arquivo conhecido como "XML View", a partir deste arquivo o container
	 realiza as tarefas de criacao dos codigos fontes das servlets. Caso seja uma JSP Page, o container realiza o processamento padrao para
	 criacao de uma servlet para a mesma, porem, se for um JSP Document (uma pagina JSP bem estruturada), o container realiza tarefas de 
	 otimizacao para geracao do codigo fonte da servlet que representara essa pagina. Porem e importante lembrar de que antes da fase de traducao,
	 seja JSP page ou JSP Document, um arquivo XML View e gerado e a partir dele o codigo fonte da servlet e criado. -->

<!-- Assim como todo XML, JSP Documents possuem um root element com um namespace e um prefixo que sera utilizado como alias para os elementos do documento. 
	 A declaracao do root element e opcional, uma vez que e permitido declarar o namespace no elemento HTML. -->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" />

	<!-- Por padrao, a especificacao diz que o namespace do elementos de uma JSP Document deve possuir o alias "jsp" -->
	<html xmlns="http://www.w3.org/1999/xhtml" xmlns:jsp="http://java.sun.com/JSP/Page">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII" />
<title>JSP Documents</title>
</head>
<body>
	<h1>Jsp Documents</h1>
	<jsp:declaration>private int valor = 10;</jsp:declaration>
	<jsp:scriptlet>request.setAttribute("img", "img/logo.png");</jsp:scriptlet>

	<p>
		<jsp:expression>request.getRemoteAddr()</jsp:expression>
		<br />
		<jsp:expression>"Valor: " + valor</jsp:expression>
	</p>

	<!-- Nao e possivel utilizar elementos de script (declaracoes, scriptlets, expressoes e comentarios) em JSP Documents, logo o codigo abaixo esta incorreto -->
	<!-- Uma alternativa e utilizar as secoes CDATA, que sao ignoradas pelo tradutor e enviadas diretamente para a resposta, ou seja,
		 nao sao inseridas no codigo fonte. -->
	<![CDATA[<img src="]]>
	<jsp:expression>request.getAttribute("img")</jsp:expression>
	<![CDATA[" width="150" height="100" />]]>

	<!-- Outra alternativa e utilizar a Expression Language -->
	<img src="${requestScope.img}" width="150" height="100" style="margin-left: 30px" />

	<!-- Ou -->
	<img src="${requestScope['img']}" width="150" height="100" style="margin-left: 30px" />
</body>
	</html>
</jsp:root>