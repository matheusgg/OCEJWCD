<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/xml" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>JspConfig</title>
</head>
<body>
	<h3>JspConfig</h3>
	#{initParam}

	<h3>Multipart com JSP</h3>
	<form action="JspConfig2" method="post" enctype="multipart/form-data">
		<input type="file" name="file1" /> <input type="submit" />
	</form>
</body>
</html>