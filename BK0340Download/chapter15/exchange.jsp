<%@ page contentType="text/plain" %>
<%@ taglib uri="http://www.garnerpress.com/books/scwcd1.4/elfunctions" prefix="elfuncs" %>
From GBP to USD: ${ elfuncs:exchange('GBP', "USD", 15.4) }
Otherwise: ${ elfuncs:exchange("GBP", 'YEN', 15.4) }