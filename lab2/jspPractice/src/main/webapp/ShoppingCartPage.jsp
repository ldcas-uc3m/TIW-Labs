<%@ page 
	language="java"
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="beans.ShoppingCart"
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Carros</title>
	</head>
	<body>
	
	<%@ include file="header.html" %>
	
	<p>Mi carro:</p>
	<%-- <jsp:useBean id="cart" class="beans.ShoppingCart" /> --%>
	<% ShoppingCart cart = (ShoppingCart) request.getAttribute("data"); %>
	<ul>
		<li>Número de productos: <jsp:getProperty name="cart" property="numProds" /> </li>
		<li>Precio total: <jsp:getProperty name="cart" property="price" /> </li>
	</ul>
	
	</body>
</html>