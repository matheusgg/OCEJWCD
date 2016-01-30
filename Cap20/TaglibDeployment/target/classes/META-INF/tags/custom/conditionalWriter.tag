<%@ tag language="java" pageEncoding="UTF-8"%>
<%-- Atributos em tag files nao podem ser de tipos primitivos --%>
<%@ attribute name="test" required="true" rtexprvalue="true" type="java.lang.Boolean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- Quando a Tag File este em um arquivo jar separado, e necessario que esteja dentro da pasta /META-INF/tags
	 ou qualquer subpasta. Alem disso, quando tags ou tag files estao em um arquivo jar, um TLD e necessario
	 para recferenciar a taglib que representa essas tags. Isso nao e necessario quando uma tag file esta
	 diretamente na pasta /WEB-INF do projeto, neste caso, um TLD nao e obrigatorio, pois o container
	 ira criar um implicito para representar essas tags, a unica obrigatoriedade e que a tag file deve
	 estar contida dentro da pasta /WEB-INF/tags ou qualquer subpasta.--%>
<c:if test="${test}">
	<jsp:doBody />
</c:if>

