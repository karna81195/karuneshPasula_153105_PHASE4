<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>show balance</title>
</head>

<body>
	<div align ="center">
	<h2>Welcome ${customer.name}</h2>
	<h2>Your Mobile number is:-${customer.mobileNo}</h2>
	<h2>Your balance is:-${customer.wallet.balance}</h2>
	</div>

</body>

</html>