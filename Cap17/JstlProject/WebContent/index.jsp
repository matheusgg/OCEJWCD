<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.io.Reader"%>
<%@page import="javax.servlet.jsp.jstl.core.LoopTagStatus"%>
<%@page import="javax.swing.JApplet"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Tag Library</title>
</head>
<body>
	<!-- JSTL e um conjunto de tags padroes utilizadas em paginas JSP's para realizar determinados processamentos. Atualmente esta na versao 1.2.
		 A versao 1.0 rt, direfentemente da versao 1.0 normal, possui atributos com suporte para expressoes (elementos de script ou el) que sao
		 avaliadas em tempo de requisicao.-->
	<h1>Tag Library</h1>

	<jsp:text>==================================================================================================================================</jsp:text>
	<br />
	<!-- c:out avalia o que esta em value e envia para a resposta. Essa tag realiza a conversao de caracteres xml ilegais autmaticamente, isto e,
		os sinais de menor e maior sao convertidos para entidades xml &lt; e &gt; antes de serem enviados para a resposta. Para desabilitar
		esse comportamento basta informar o valor false no atributo escapeXml (que por padrao e true).  -->
	<c:out value='<%="Teste out <>"%>' escapeXml="true" />
	<br />

	<!-- E possivel especificar um texto padrao para ser exibido caso o valor informado em value seja vazio ou null. Basta informar o atributo default
		 ou especificar um texto no corpo da tag (mas nunca ambos os mesmo tempo, senao um erro de traducao ocorrera) -->
	<c:out value="${param.teste}">
		Parametro nao encontrado
	</c:out>
	<br />
	<c:out value="${param.teste}" default="Nada para exibir" />

	<br />
	<jsp:text>==================================================================================================================================</jsp:text>
	<br />

	<!-- c:catch cria um bloco try catch em volta do conteudo de seu corpo informado, desta forma caso alguma excecao ocorra no bloco informado dentro
		 dessa tag, a excessao sera suprimida e o processamento da JSP continuara normalmente. Caso o atributo var seja informado, um objeto throwable
		 que representa a excecao gerada dentro de c:catch e armazenado dentro do escopo de pagina em um atributo com o nome definido em var-->
	<c:catch var="ex">
		<%
			String param = request.getParameter("teste");
				if (param == null) {
					throw new RuntimeException("Parametro nao informado!");
				}
		%>
	</c:catch>
	${ex}

	<br />
	<jsp:text>==================================================================================================================================</jsp:text>
	<br />

	<%
		pageContext.setAttribute("attr", "pagina", PageContext.PAGE_SCOPE);
		pageContext.setAttribute("attr", "request", PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("attr", "sessao", PageContext.SESSION_SCOPE);
		pageContext.setAttribute("attr", "applicacao", PageContext.APPLICATION_SCOPE);
	%>
	Antes da remocao:
	<p>${pageScope.attr}
		<br /> ${requestScope.attr} <br /> ${sessionScope.attr} <br /> ${applicationScope.attr} <br />
	</p>

	<!-- c:remove remove o atributo com o nome especificado em var de todos os escopos onde o mesmo for encontrado. Essa tag
		 usa a mesma logica do metodo removeAttribute de JspContext, isto e, remove o atributo informado de todos os escopos
		 que for encontrado. Caso o atributo scope seja informado, c:remove removera o atributo apenas do escopo definido. -->
	<c:remove var="attr" />

	Depois da remocao:
	<p>${pageScope.attr}
		<br /> ${requestScope.attr} <br /> ${sessionScope.attr} <br /> ${applicationScope.attr} <br />
	</p>

	<br />
	<jsp:text>==================================================================================================================================</jsp:text>
	<br />

	<!-- Com c:set e possivel definir um atributo de escopo. Var especifica o nome do atributo, scope especifica o escopo onde esse atributo sera
		 definido (caso nao seja informado o escopo de pagina sera assumido), value especifica o valor do atributo. -->
	<c:set var="attr1" value="Teste Page Scope" />
	<c:set var="attr1" value="Teste Session Scope" scope="session" />

	<!-- E possivel definir o value do atributo que sera setado apenas informando o valor dentro do corpo da tag c:set, neste caso, o atributo value
		 nao pode ser informado, senao uma excecao em tempo de traducao ocorrera. -->
	<c:set var="attr1" scope="request">
		Teste Request Scope
	</c:set>
	<p>
		${pageScope.attr1} <br /> ${sessionScope.attr1} <br /> ${requestScope.attr1}
	</p>

	<!-- c:set possui uma segunda utilizacao que se assemelha a action setProperty -->
	<jsp:useBean id="cliente" class="model.ClienteBean">
		<jsp:setProperty name="cliente" property="nome" value="Matheus" />
	</jsp:useBean>
	${cliente.nome}

	<!-- E possivel definir um valor para alguma propriedade de um objeto alvo. A expressao em target deve resultar em um bean ou um mapa, enquanto que 
		 o que esta em value ou no crpo da tag sera utilizado como valor para ser definido na propriedade informada. -->
	<c:set target="${cliente}" property="nome" value="Matheus Gomes" />
	<br />${cliente.nome}

	<br />
	<jsp:text>==================================================================================================================================</jsp:text>
	<br />

	<!-- A tag c:if e utilizada para avaliar uma expressao informada em test. Caso a expressao seja verdadeira, o corpo de c:if e executado.
		 Se o atributo var for informado, o valor da expressao de test e armazenado em um atributo de escopo. O escopo pode ser definido 
		 em scope, e caso nao seja informado, o escopo de pagina e utilizado. Se o atributo escope estiver presente, var se torna obrigatorio. -->
	<c:if test="${not empty param.test}" scope="request" var="testParam">
		O parametro test foi informado
	</c:if>

	<br /> ${requestScope.testParam}

	<br />
	<jsp:text>==================================================================================================================================</jsp:text>
	<br />

	<!-- c:choose funciona como blocos if...else if...else. E obrigatorio pelo menos um c:when. Caso a condicao no primeiro c:when seja true,
		 entao o corpo de when e executado e o fluxo sai do c:choose, caso o este seja false, o segundo c:when e avaliado da mesma forma que 
		 o primeiro. Caso os testes de todos os whens retornem false, entao c:otherwise sera executado (c:otherwise funciona como um caso 
		 dafault de um switch case) -->
	<c:choose>
		<c:when test="${2 > 3}">
			Primeiro when
		</c:when>
		<c:when test="true">
			Segundo when
		</c:when>
		<c:otherwise>
			Otherwise
		</c:otherwise>
	</c:choose>

	<br />
	<jsp:text>==================================================================================================================================</jsp:text>
	<br />

	<!-- c:forEach pode ser utilizada para realizar um determinado look. Begin especifica o indice inicial. End especifica o indice final (inclusive).
		 Var especifica o valor atual do contador enquanto step especifica o valor de incremento (sendo 1 por padrao) -->
	<c:forEach begin="0" end="5" step="1" var="count">
		Interacao ${count}<br />
	</c:forEach>
	<br />
	<br />

	<%
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(1);
		lista.add(2);
		lista.add(3);

		pageContext.setAttribute("lista", lista);
		pageContext.setAttribute("palavra", "aaaa,b,c,d,e,");

		Map<String, Integer> mapa = new HashMap<String, Integer>();
		mapa.put("Item1", 1);
		mapa.put("Item2", 2);
		mapa.put("Item3", 3);

		pageContext.setAttribute("mapa", mapa);
	%>

	<!-- O atributo items e utilizado para informar uma colecao que sera iterada. Neste caso, var assumira o valor
		 de cada item da colecao em cada interacao. -->
	<c:forEach items="${lista}" var="item" step="2">
		Item ${item} da lista. Tipo: ${item['class']}
		<br />
	</c:forEach>
	<br />
	<br />

	<!-- Alem de colecoes, e possivel informar uma String em items, deste modo, caso a String seja separada por virgula(,),
		 ela sera tokenizada (um split por virgula sera feito), e var assumira o valor de cada token -->
	<c:forEach items="${palavra}Test,e" var="letra">
		Letra: ${letra} <br />
	</c:forEach>
	<br />
	<br />

	<!-- E possivel iterar sobre um mapa. Deste modo, var assumira o valor corrente de cada entrada do mapa (Map.Entry) -->
	<c:forEach items="${mapa}" var="entry">
		${entry.key} - ${entry.value} - Tipo: ${entry['class']}
		<br />
	</c:forEach>
	<br />
	<br />

	<!-- VarStatus define uma variavel que possui informacoes sobre a iteracao atual. O tipo de varStatus e LoopTagStatus. -->
	<c:forEach items="${mapa}" varStatus="status">
		<!-- O valor corrente do item dessa iteracao (mosmo valor de var) -->
		Current: <%=((LoopTagStatus) pageContext.getAttribute("status")).getCurrent()%>
		<br />

		<!-- O contador de iteracoes -->
		Count: <%=((LoopTagStatus) pageContext.getAttribute("status")).getCount()%>
		<br />

		<!-- O indice da iteracao -->
		Index: <%=((LoopTagStatus) pageContext.getAttribute("status")).getIndex()%>
		<br />

		<!-- Indica se esta e a primeira iteracao -->
		First: <%=((LoopTagStatus) pageContext.getAttribute("status")).isFirst()%>
		<br />

		<!-- Indica se esta e a ultima iteracao -->
		Last: <%=((LoopTagStatus) pageContext.getAttribute("status")).isLast()%>
		<br />

		<!-- O valor definido no atributo begin -->
		Begin: <%=((LoopTagStatus) pageContext.getAttribute("status")).getBegin()%>
		<br />

		<!-- O valor definido no atributo end -->
		End: <%=((LoopTagStatus) pageContext.getAttribute("status")).getEnd()%>
		<br />

		<!-- O valor definido no atributo step -->
		Step: <%=((LoopTagStatus) pageContext.getAttribute("status")).getStep()%>
		<br />
		<br />
	</c:forEach>

	<br />
	<jsp:text>==================================================================================================================================</jsp:text>
	<br />

	<!-- Apesar do c:forEach manipular e tokenizar Strings, c:forTokens e uma tag criada justamente para este proposito, onde items
		 deve resultar em uma String que sera tokenizada. E possivel definir um delimitador personalizado atraves de delims. Var e varStatus
		 possuem as mesmas regras de c:forEach -->
	<c:forTokens items="${palavra}" delims="," var="token" varStatus="status">
		<c:choose>
			<c:when test="${status.last}">
				${status.current}
			</c:when>
			<c:otherwise>
				${token} <br />
			</c:otherwise>
		</c:choose>
	</c:forTokens>

	<br />
	<jsp:text>==================================================================================================================================</jsp:text>
	<br />

	<!-- c:url e utilizada para reescrita de URL onde o modo de rastreamento de sessao por cookies nao pode ser utilizado e
		 o JSESSIONID deve ser incluido como um parametro na URL. Utiliza a logica do metodo encodeURL de HttpServletResponse-->
	<c:url value="page.jsp" />
	<br />

	<!-- E possivel definir caminhos relativos ao contexto ou ao recurso, neste caso, um caminho relativo ao contexto e utilizado, desta forma,
		 c:url colocara o context root da aplicacao antes da / -->
	<c:url value="/page.jsp" />
	<br />

	<!-- Quando o valor e informado vazio e o JSESSIONID precisa ser inserido na URL, c:url reescreve a URL completa (caminho absoluto), 
		 inserindo esquema, servidor, pagina, entre outros: Ex: http://localhost:8080/JstlProject/;jsessionid=D10EE5C61BFFF33FD58B646B46FCC837 -->
	<c:url value="" />
	<br />

	<!-- Caso seja necessario acessar um recurso externo a aplicacao, c:url fornece o atributo context, que possibilita
		 informar o contexto externo. Desta forma a url reescrita se iniciara pelo contexto externo seguido pelo valor de value.
		 Quando context e informado, ambos value e context devem comecar com / -->
	<c:url value="/servlets" context="/examples" />
	<br />

	<!-- Caso o atributo var seja declarado, a URL reescrita por c:url e salva em um atributo de escopo (definido pelo escopo informado ou page por
		padrao). Alem disso, e possivel informar parametros que serao inseridos na URL atraves de c:param -->
	<c:url value="/page.jsp" var="url" scope="request">
		<c:param name="param" value="teste" />
	</c:url>
	<br /> URL reescrita salva no atributo url de escopo de requisicao: ${url}

	<br />
	<jsp:text>==================================================================================================================================</jsp:text>
	<br />

	<!-- c:import importa um recurso para a pagina JSP. Esse recurso pode ser da aplicacao ou externo. Caso seja um recurso externo,
		 e possivel utilizar o atributo context para recuperar o caminho desse recurso no container. c:import utiliza o mecanismo de RequestDispatcher
		 para fazer a inclusao de recursos. Caso o recurso nao seja localizado, uma excecao sera lancada. -->
	<c:import url="page.jsp" var="teste" />

	<!-- Caso varReader seja especificado, o recurso que esta sendo importado e armazenado em um objeto do tipo Reader em um atributo de escopo.
		 Deste modo, a escrita do recurso na resposta pode ser feita manualmente. VarReader nao pode ser declarado ao mesmo tempo que var, este
		 ultimo e utilizado para armazenar um atributo de escopo nomeado com o conteudo de var. O valor desse atributo e o recurso que esta sendo importado.
		 Como varReader e um atributo de escopo de bloco, e possivel acessa-lo apenas dentro do corpo de c:import -->
	<c:import url="/page.jsp" varReader="reader">
		<%
			Reader reader = (Reader) pageContext.getAttribute("reader");
				out.println(reader);
		%>
	</c:import>
</body>
</html>