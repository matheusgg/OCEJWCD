<?xml version="1.0" encoding="UTF-8" ?>

<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:c="http://tags.com/custom" version="2.0">
	<!-- Em JSP Documents para referenciar um TLD utilizando um caminho relativo ao contexto, e necessario informar o prefixo 
		 urn:jsptld:/ (Ex.: xmlns:c="urn:jsptld:/WEB-INF/tags.tld"). -->

	<!-- Para referenciar um diretorio de tags files utilizando um caminho relativo ao contexto, e necessario informar o prefixo 
		 urn:jsptagdir:/ (Ex.: xmlns:c="urn:jsptagdir:/WEB-INF/tags.tld"). -->

	<jsp:text>
		<![CDATA[<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">]]>
	</jsp:text>

	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Page</title>
</head>
<body>
	<c:boldWriter>Teste</c:boldWriter>
</body>
	</html>
</jsp:root>