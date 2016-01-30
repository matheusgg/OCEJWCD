<%@ taglib uri="http://www.garnerpress.com/books/scwcd1.4/mycooptags" prefix="mytags" %>

<html>
<head>
  <title>SCWCD Tags Test</title>
</head>

<body>

<h1>Cooperating Tags</h1>

<mytags:choose>
  <mytags:when test="${ 2 < 3 }">This evaluates to true</mytags:when>
  <mytags:whens test="${ 3 > 2 }">This should not appear (despite being true)</mytags:whens>
  <mytags:otherwises>This should not appear</mytags:otherwises>
</mytags:choose>

<mytags:chooses>
  <mytags:when test="${ 3 < 2 }">This should not appear (evaluates to false)</mytags:when>
  <mytags:whens test="${ 3 > 2 }">This should be outputted</mytags:whens>
  <mytags:otherwises>This should not appear</mytags:otherwises>
</mytags:chooses>

<mytags:chooses>
  <mytags:when test="${ 3 < 2 }">This evaluates to false</mytags:when>
  <mytags:whens test="${ 1 > 5 }">This should not appear</mytags:whens>
  <mytags:otherwise>Otherwise should be executed</mytags:otherwise>
</mytags:chooses>

</body>
</html>
