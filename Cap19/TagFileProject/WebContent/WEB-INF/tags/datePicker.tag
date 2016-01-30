<%-- Configuracao da Tag --%>
<% 
	// Como a adicao do atributo no escopo de pagina do wrapper acontece dentro do metodo set, para ser possivel
	// a utilizacao desse atributo atraves de expressoes EL, e necessario definir esse valor atraves do metodo set.
	if(this.maxlength == null){
		this.setMaxlength(10);
	}

	if(this.placeholder == null){
		this.placeholder = "Escolha uma data";	
	}
	
	if(this.dateFormat == null){
		this.dateFormat = "dd/mm/yy";
	}
%>

<%-- Todo o conteudo de uma Tag File (com excecao das diretivas) e passado para o metodo doTag e enviado ao metodo write
	 do objeto implicito out, desta forma, nao ha problema em declarar importacoes de scripts e arquivos css no topo da Tag File. --%>
<script src="resources/js/jquery-1.10.2.js"></script>
<script src="resources/js/jquery-ui-1.10.4.custom.js"></script>
<link href="resources/css/ui-darkness/jquery-ui-1.10.4.custom.css" rel="stylesheet" />

<script type="text/javascript">
	$(function() {
		$(<%= "\"#" + this.id + "\""%>).datepicker({
			dateFormat : <%= "\"" + this.dateFormat + "\""%>
		});
	});
</script>

<%-- Tags Files sao uma forma de criar tags simples que tem como objetivo gerar conteudo HTML, tarefa essa que se 
	 torna muito complexa e verbosa quando o trabalho e feito com handler classes. Tags Files sao como paginas JSP,
	 porem quando traduzidas, viram SimpleTags, dessa forma todas as restricoes das SimpleTags tambem se aplicam para
	 Tag Files (nao e permitido o uso de scripts JSP no corpo de SimpleTags e TagFiles). O conteudo de uma Tag File
	 e inserido dentro do metodo doTag do codigo fonte gerado. Tag Files nao precisam ser declaradas no DD (web.xml),
	 desse modo possuem varias diretivas que possibilitam a configuracao da Tag assim como no web.xml. A diretiva page 
	 padrao JSP e substituida pela diretiva tag, que possui varias opcoes de configuracao de Tag File. Alem disso, existe
	 a diretiva attribute, que serve para declarar atributos da tag. Tag Files possuem a extensao tag (para arquivos Jsp's) ou
	 tagx (para JSP Document's) --%>
<%-- Scriptlets sao validas como conteudo de uma Tag File, mas nunca como corpo da tag --%>
<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"  dynamic-attributes="attrs" trimDirectiveWhitespaces="true"%>

<%-- Dentro de Tag Files e possivel importar outras taglibs --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Os atributos de Tags Files sao tratados de uma forma um pouco diferente dos atributos de Tags normais. Esses atributos sao 
	 armazenados em um escopo de pagina que fica disponivel apenas dentro da Tag File, alem disso variaveis de instancia sao criadas
	 dentro do codigo fonte gerado, e para cada variavel metodos getters e setters sao gerados. Desta forma, quando um metodo set e chamado,
	 alem de definir o valor do atributo de instancia, esse valor tambem e adicionado como atributo de pagina no JspContextWrapper. --%>
<%-- Quando o container identifica uma tag file em um arquivo jsp, o metodo setJspContext e chamado e o container passa o JspContext
	 (ou PageContext) para a tag file, porem apos essa invocacao, um JspContextWrapper e criado para encapsular o JspContext passado,
	 dessa forma, todos os atributos declarados dentro da Tag File sao armazenados dentro desse JspContextWrapper, e nao dentro do JspContext
	 original, por este motivo os atributos da Tag File ficam disponiveis apenas dentro da Tag File. --%>
<%-- Atributos e variaveis so podem ser configuradas dentro de tag files, pois nao ha elementos <attribute> ou <variable> no arquivo TLD --%>
<%@ attribute name="id" required="true" rtexprvalue="false" type="java.lang.String"%>

<%-- Por padrao o valor de type e java.lang.String e nao e permitido o uso de primitivos. --%>
<%@ attribute name="maxlength" type="java.lang.Integer"%>
<%@ attribute name="placeholder" type="java.lang.String"%>
<%@ attribute name="dateFormat" %>

<%-- HTML que sera gerado pela Tag File --%>
<input type="text" id="${id}" name="${id}" maxlength="${maxlength}" placeholder="<%= this.placeholder%>">

<%-- Tag File possui quase os mesmos objetos implicitos disponiveis nas paginas JSP's, com excecao de exception e page. Alem disso,
	 o objeto implicito pageContext e substituido por jspContext --%>