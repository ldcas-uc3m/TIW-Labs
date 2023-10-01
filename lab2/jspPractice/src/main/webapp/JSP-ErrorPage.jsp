<%@
	page language="java"
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isErrorPage="true"
 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error page</title>
</head>
<body>
<h1>&Oacute;w&Ograve; I'm s-sowwy &gt;~&lt; wiww wu forgive me? &Uacute;w&Ugrave;</h1>
<p>Error code: <%=request.getAttribute("javax.servlet.error.status_code")%></p>

</body>
</html>