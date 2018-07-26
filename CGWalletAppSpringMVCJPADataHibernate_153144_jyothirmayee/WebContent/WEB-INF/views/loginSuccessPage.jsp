<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h2>Welcome ${customer.name}</h2><br>
		<h2>Balance is: ${customer.wallet.balance}</h2><br>
		<h3>Menu</h3>
		<a href="showBalance">Show Balance</a>
		<a href="depositAmountPage">Deposit Amount</a><br> 
		 <a href="withdrawAmountPage">Withdraw Amount</a><br> 
		 <a href="fundTransferPage">Fund Transfer</a><br> 
		 <a href="printAllTransactionsPage">Print Transactions</a><br>
		 <a href="getAllCustomers">Get All Customers</a><br>
		 <a href="getCustomers">Get Min Bal Customers</a>
		 
	
		<a href="logout">Logout</a>	
</body>
</html>