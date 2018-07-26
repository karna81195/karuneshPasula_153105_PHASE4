<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<div align="center">
		<h2></h2>
		<table>
			<form:form action="fundTransfer" method="post"
				modelAttribute="customer">
				
				<tr>
					<td>Enter mobile number to transfer amount:</td>
					<td><form:input path="mobileNo" size="30" /></td>
					<td><form:errors path="mobileNo" cssClass="error" /></td>
					
				</tr>
				<tr>
					<td>amount:</td>
					<td><form:input path="wallet.balance" size="30" /></td>
					<td><form:errors path="wallet.balance" cssClass="error" /></td>
					
				</tr>
				<tr>
				<td><input type="submit" value="Submit"/></td>
			</form:form>
			</table>
			</div>
</body>
</html>