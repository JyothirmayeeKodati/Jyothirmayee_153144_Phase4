<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Login</h1>		
			<!-- registerCustomer method is called -->
		<form action="findCustomer" method="post" >
			<table cellpadding="6" cellspacing="2" align="center">

				<tr>
					<td>Mobile Number</td>
					<td><input type="text" name="mobileNo" size="30" /></td>
					<!--  <td><errors path="mobileNo" cssClass="error" /></td>-->
				</tr>

				<tr>
					<td><input type="submit" name="submit" value="login" />
					<td><input type="reset" name="submit" value="Clear Form" />
				</tr>
			</table>
		</form>
	<div>
		<font color="red">
			<c:if test="${not empty errorMessage }">
			${errorMessage}</c:if>
		</font>
	</div>
</body>
</html>