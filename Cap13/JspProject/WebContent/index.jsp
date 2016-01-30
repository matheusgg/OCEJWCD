<?xml version="1.0" encoding="US-ASCII" ?>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII" />
<title>JSP Page</title>
</head>
<body>
	<h1>JSP Page</h1>
	<p>JavaServer Pages e um tecnologia criada para facilitar o desenvolvimento de paginas com conteudo dinamico. JSP's nada mais sao do que servlets e possuem
		um clico de vida de 8 fases. A primeira vez que uma pagina JSP e solicitada, ha um pequeno delay decorrente do processamento dessas fases:</p>

	<ul>
		<li>
			<p>Validacao: Quando a pagina JSP e implantada no servidor, o container realiza a validacao da pagina para verificar se todas as taglibs e expressoes
				estao disponiveis para a fase de traducao.</p>
		</li>
		<li>
			<p>Traducao: Nesta fase, o container gera um arquivo de codigo fonte (.java) humanamente entendivel que nada mais e do que uma servlet que escrevera o
				conteudo para o cliente.</p>
		</li>
		<li>
			<p>Compilacao: Nesta fase, o codigo fonte gerado e compilado e um arquivo .class e gerado.</p>
		</li>
		<li>
			<p>Carregamento da classe: A servlet criada e carregada na memoria pelo class loader.</p>
		</li>
		<li>
			<p>Instanciacao: Apos o carregamento da servlet pelo class loader, a classe e instanciada.</p>
		</li>
		<li>
			<p>Inicializacao: Depois de a servlet foi instanciada ela e preenchida atraves da chamada ao metodo jspInit(), semelhante ao metodo init() das servlets.</p>
		</li>
		<li>
			<p>Servico: Depois que a servlet foi inicializada, o metodo _jspService(HttpServletRequest, HttpServletResponse) e chamado para escrever o conteudo da
				JSP para o cliente.</p>
		</li>
		<li>
			<p>Destruicao: Quando a JSP e desimplantada do container, o metodo jspDestroy() e chamado.</p>
		</li>
	</ul>
</body>
</html>