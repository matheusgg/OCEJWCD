<?xml version="1.0" encoding="US-ASCII" ?>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII" />
<title>Declaracoes</title>
</head>
<body>
	<%-- Declaracoes e uma forma de inserir codigo java personalizado diretamente no codigo fonte da servlet gerada. Declaracoes iniciam com <%! e todo o codigo
		 dentro desse delimitador e inserido diretamente no codigo fonte gerado. O codigo dentro das declaracoes sao sempre inseridos no inicio do codigo fonte 
		 da servlet gerada. --%>
	<h1>Declaracoes</h1>
	<%!//Variavel global que sera inserida no codigo fonte gerado.
	private int valor;%>
	<%!public void metodoTeste() {
		System.out.println("Metodo que sera inserido no codigo fonte da servlet gerado");
	}

	// Sobrescrevendo o metodo _jspInit(). Apesar de nao ser o mesmo metodo (o que nao caracteriza uma sobrescrita), o metodo jspInit()
	// e chamado durante o processamento da JSP.
	public void jspInit() {
		System.out.println("jspInit: " + this.valor);
	}%>
</body>
</html>