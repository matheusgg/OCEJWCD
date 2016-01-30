<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" body-content="scriptless"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- A importacao de page.jsp causara um erro de traducao, pois a pagina page.jsp possui a diretiva page,
	 e como tag files nao podem declarar a diretiva page, uma excecao sera lancada. Caso uma pagina que esteja
	 sendo importanda possua alguma informacao invalida para uma tag file, uma excecao sera lancada em 
	 tempo de traducao  --%>
<%-- <%@ include file="/page.jsp" %> --%>

<%--Atriutos --%>
<%@ attribute name="begin" required="true" rtexprvalue="false" type="java.lang.Integer"%>
<%@ attribute name="end" required="true" rtexprvalue="false" type="java.lang.Integer"%>
<%@ attribute name="var" required="true" rtexprvalue="false" type="java.lang.String"%>

<%-- Fragment Attribute --%>
<%@ attribute name="frag" fragment="true"%>

<%-- Variable --%>
<%-- Diferentemente das variaveis declaradas no TLD para Tags classicas ou SimpleTags, o objetivo dessas variaveis e passar
	 valores definidos na tag para a pagina JSP que esta chamando essa action. Neste caso, a variavel "varAlias" que tera seu
	 nome dado pelo atributo "var" tera seu valor atualizado e passado para index.jsp. Desa forma, dentro da action em index.jsp
	 e possivel utilizar essa variavel. --%>
<%@ variable alias="varAlias" name-from-attribute="var" scope="NESTED" variable-class="java.lang.Integer" declare="true"%>

<!-- Essa variavel sera declarada em index.jsp com o nome statusTest antes da execucao dessa tag e tera seu valor definido somente apos
	 a finalizacao de out.tag. Caso o escopo fosse AT_END, a variavel seria declarada e inicializada somente apos a execucao do metodo
	 doTag de out.tag -->
<%@ variable name-given="statusTest" scope="AT_BEGIN" variable-class="java.lang.Integer" declare="true"%>

<c:forEach begin="<%=this.begin%>" end="${end}" step="1" var="forVar">
	<%
		jspContext.setAttribute("varAlias", jspContext.findAttribute("forVar"));
	%>
	<jsp:doBody />
	<br />
</c:forEach>

<%
	jspContext.setAttribute("statusTest", 10);
%>

<%-- Como index.jsp definiu o atributo session para false, o objeto session encapsulado por jspContextWrapper
	 estara nulo, porem nenhum excecao sera lancada em tempo de traducao. --%>
<h3>
	Session
	<%=session%></h3>

<!-- Apenas os atributos de escopo de pagina sao tratados de forma especial quando tag files sao utilizadas,
	 porem o conteudo desse fragmento sera colocado em um atributo de escopo de requisicao, desta forma sera
	 possivel utilizar esse atributod na pagina que esta chamando essa action. -->
<jsp:invoke fragment="frag" var="frag" scope="request" />
