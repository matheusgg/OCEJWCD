<h1>Included</h1>

<!-- Caso o nome de atributo informado em property nao for encontrado, uma excecao em tempo de execucao ocorrera. -->
<!-- Um atributo cliente foi definido em index.jsp, porem outro atributo cliente sera criado nesta jsp, pois o escopo
	 e diferente daquele declarado em index.jsp. Para se utilizar o mesmo bean criado em index, e necessario ter uma
	 action useBean identica a utilizada na pagina que faz a inclusao, ou utilizar a diretiva include para incluir 
	 essa pagina em index.jsp -->
<jsp:useBean id="cliente" beanName="${beanName}" type="model.Cliente">
	<jsp:setProperty name="cliente" property="nome" value="Teste in Page" />
</jsp:useBean>

<br />

<!-- O valor do atributo nome sera recuperado do atributo de escopo de pagina cliente criado acima, nao o atributo cliente
	 declarado em index.jsp. Caso a action useBean acima seja comentada, ou seja, removida, uma excecao ocorrera, pois o atributo cliente
	 nao sera encontrado no escopo dessa JSP, logo um erro de traducao ocorrera. -->
<jsp:getProperty name="cliente" property="nome" />