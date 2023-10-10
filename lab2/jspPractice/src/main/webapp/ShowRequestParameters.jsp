<%@ 
	page language="java"
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import = "java.util.Map"
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>ShowRequestParameters</title>
</head>
<body>

<%@ include file="header.html" %>

<%
// get parameters
Map<String, String[]> parameters = request.getParameterMap();

if (parameters.isEmpty()) { 
%>
	<p>There are no parameters</p>
<%
}
else {
%>
	<p>The following parameters were passed:</p>
	<ul>
	<%
	for (String param : parameters.keySet()) {
	%>
	   	<li><%=param%> = <%=request.getParameter(param)%></li>
	<%
	}
	%>
	</ul>
<%
}
%>

</body>
</html>