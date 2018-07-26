<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Details of Customers with minimum balance</h2>
		<h5>
			<br>
		</h5>
		<br>
		<table>
			<tr>
				<th>Mobile Number</th>
				<th>Name</th>
				<th>Amount</th>
			</tr>
			<c:forEach items="${customer}" var="customers">
				<tr>
					<td>${customers.mobileNo}</td>
					<td> ${customers.name}</td>
					<td> ${customers.wallet.balance}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>