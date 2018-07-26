<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Withdraw Amount</h1>

		<table cellpadding="6" cellspacing="2" align="center">
			<!-- depositAmount method is called -->
			<form:form action="withdrawAmount" method="post"
				modelAttribute="customer">

				<tr>
					<td>Mobile Number</td>
					<td><form:input path="mobileNo" name="mobileNo" size="30" /></td>
					<td><form:errors path="mobileNo" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Amount</td>
					<td><form:input path="wallet.balance" size="30" /></td>
					<td><form:errors path="wallet.balance" cssClass="error" /></td>
				</tr>

				<tr>
					<td><input type="submit" name="submit" value="withdraw" />
					<td><input type="reset" name="submit" value="Clear Form" />
				</tr>
			</form:form>
		</table>
	</div>
	<div>
		<font color="red">
			<c:if test="${not empty errorMessage }">
			${errorMessage}</c:if>
		</font>
	</div>
</body>
</html>