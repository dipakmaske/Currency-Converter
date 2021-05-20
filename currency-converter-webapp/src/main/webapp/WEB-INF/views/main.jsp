<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Currency Converter</title>

</head>
<body style="background-color: powderblue;">
	<h3 style="text-align: right;">
		<a href='<spring:url value="/user/logout"/>'>Logout</a>
	</h3>
	<h1 style="text-align: center;">Welcome to Currency Converter</h1>
	<h2 style="text-align: center;">Hello, ${sessionScope.userName}</h2>
	<h2 style="text-align: center;">Date : ${sessionScope.date}</h2>
	<hr>
	<form:form method="post" modelAttribute="currency">
		<table style="background-color: powderblue; margin: auto;">

			<tr>
				<td>Convert From</td>
				<td><select id="from" name="from">
						<option value="USD">USD</option>
						<option value="INR">INR</option>
						<option value="EUR">EUR</option>
						<option value="GBP">GBP</option>
						<option value="NZD">NZD</option>
						<option value="HUF">HUF</option>
						<option value="AUD">AUD</option>
						<option value="JPY">JPY</option>
				</select></td>
			</tr>
			<tr>
				<td>Convert To</td>
				<td><select id="convertTo" name="convertTo">
						<option value="INR">INR</option>
						<option value="EUR">EUR</option>
						<option value="USD">USD</option>
						<option value="GBP">GBP</option>
						<option value="NZD">NZD</option>
						<option value="HUF">HUF</option>
						<option value="AUD">AUD</option>
						<option value="JPY">JPY</option>
				</select></td>
			</tr>
			<tr>
				<td>Enter Amount</td>
				<td><form:input path="amount" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Convert" /></td>
			</tr>
		</table>

		<center>
			<h2>Currency Convert Result</h2>
		</center>
		<center>
			<h3>${requestScope.output}</h3>
		</center>
		<hr>
		<br>

		<h2 style="text-align: center;">History</h2>

		<table style="background-color: powderblue; margin: auto;"
			class="table table-striped table-dark">
			<tr>
				<th>Sr.</th>
				<th>From</th>
				<th>ConvertTo</th>
				<th>Amount</th>
				<th>Output</th>
				<th>Date</th>
			<tr>
				<c:forEach var="c" items="${sessionScope.historyData}">
					<tr>
						<td>${c.cid}</td>
						<td>${c.from}</td>
						<td>${c.convertTo}</td>
						<td>${c.amount}</td>
						<td>${c.output}</td>
						<td>${c.date}</td>

					</tr>
				</c:forEach>
		</table>
	</form:form>
</body>
</html>