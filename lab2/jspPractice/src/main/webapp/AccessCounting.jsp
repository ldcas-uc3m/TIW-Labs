<%@ 
	page language="java"
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
<!DOCTYPE html>
<html>
<%! 
int count = 0;
public int UpdateCounter() {
	return ++count;
}
%>
<head>
<meta charset="ISO-8859-1">
<title>Un... dos... tres...</title>
</head>
<body>


<%@ include file="header.html" %>

<p>Ésta página ha sido visitada <%= UpdateCounter() %> veces.</p>

</body>
</html>