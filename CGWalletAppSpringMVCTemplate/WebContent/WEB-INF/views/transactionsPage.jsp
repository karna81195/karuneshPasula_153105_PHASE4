<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>your transactions</title>
</head>
<body>

	<table border= 1>
		<tr>
			<th style="background-color:skyblue">Mobile Number</th>
			<th style="background-color:skyblue">Transaction date</th>
			<th style="background-color:skyblue">transaction type</th>
			<th style="background-color:skyblue">Available Balance</th>
			
		</tr>
		<c:forEach items="${transaction1}" var="item">
		<tr>
		<td>${item.mobileNo}</td>
		<td>${item.tdate}</td>
		<td>${item.transactionType}</td>
		<td>${item.amount}</td>
		</tr>
		
		</c:forEach>
	</table>
	
</body>
</html>