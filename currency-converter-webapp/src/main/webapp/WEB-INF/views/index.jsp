<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Currency Converter</title>
</head>
<body style="background-color:powderblue;">
	<h1 style="text-align: center;">Welcome to Currency Converter</h1>

	<h3 style="text-align: center;">
		New User <a href='<spring:url value="/user/register" />'>Register</a>
	</h3>
	<h3 style="text-align: center;">
		Existing User <a href='<spring:url value="/user/login" />'>Login</a>
	</h3>

</body>
</html>