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
		
			<form:form action="viewOptions" method="post"
				modelAttribute="customer">
				<tr>
					<td>MobileNumber:</td>
					<td><form:input path="mobileNo" size="30" /></td>
					
				</tr>
				<tr>
				<td><input type="submit" value="Submit"/></td>
			</form:form>
			<font color="red"><c:if test="${not empty errorMessage }">
			${errorMessage}</c:if></font>
			</div>
</body>
</html>