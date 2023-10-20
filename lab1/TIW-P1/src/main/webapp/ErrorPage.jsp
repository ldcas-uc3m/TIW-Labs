<%@
	page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    session="false"
%>
<%@page import="java.io.IOException"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR PAGE</title>
</head>
<body>


  <h1> <%= exception.getMessage() %></h1>
  <%-- <p> <%= exception.toString() %> --%>

	<div class="solid-button-container">
	  <button type="submit" class="solid-button-button button">
	   	<span><a href="index.jsp">Volver al inicio</span>
	  </button>
	</div>
</body>
</html>