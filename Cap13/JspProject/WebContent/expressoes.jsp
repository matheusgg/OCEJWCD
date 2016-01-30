<?xml version="1.0" encoding="US-ASCII" ?>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII" />
<title>Expressoes</title>
</head>
<body>
	<%-- Para diminuir as chamadas a out.write() dentro dos scriptlets, as expressoes foram criadas. Com elas, o conteudo e avaliado e convertido para 
		 uma String (toString()), entao o metodo out.write() e chamado e essa String e escrita na resposta. Isso poupa o trabalho de chamar out.write()
		 todo tempo. Expressoes nao devem terminar com ; (uma vez que a extring gerada por uma expressao sera passada para o metodo write(), um erro de
 		 sintaxe ocorreria, ja que ficaria out.write(minhaString;);) e comecam com '<%='. O codigo das expressoes e inserido dentro do metodo jspService(). --%>
	<h1>Expressoes</h1>

	<!-- Expressoes sao inseridas dentro do metodo jspService e nao devem terminar com ; -->
	<%="Data de hoje: " + new Date()%>

	<%-- Um ultimo elemento de script e o comentario, tudo que esta dentro dele nao sera inserido na classe gerada, desta forma nao sera enviado
		 para o cliente, pois sera ignorado pelo tradutor. --%>
</body>
</html>