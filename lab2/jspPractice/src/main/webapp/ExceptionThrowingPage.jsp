<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Shown on exception</title>
</head>
<body>
<%@ include file="header.html" %>

<%! int errorTypeFlag = 3; %>

<!--  Throwing an exception -->
<% if (errorTypeFlag ==1 ) throw new IOException(); %>
<% if (errorTypeFlag ==3 )  Integer.parseInt("texto"); %>

</body>
</html>