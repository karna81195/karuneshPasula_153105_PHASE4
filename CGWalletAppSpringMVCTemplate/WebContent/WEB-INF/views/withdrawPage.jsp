<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<style>
.error{
	color:red;
	font-weight:bold;
}
</style>
</head>
<body>
<div align="center">
		
		
			<form:form action="withdraw" method="post"
				modelAttribute="customer">
				<table>
				<tr>
					<td>Amount:</td>
					<td><form:input path="wallet.balance" size="30" /></td>
					<td><form:errors path="wallet.balance" cssClass="error" /></td>
				</tr>
				<tr>
				<td><input type="submit" value="Submit"/></td>
				</tr>
				</table>
			</form:form>
			
				</div>
				<div>
				<font color="red"><c:if test="${not empty errorMessage }">
			${errorMessage}</c:if></font>
		
			</div>
		
</body>
</html>