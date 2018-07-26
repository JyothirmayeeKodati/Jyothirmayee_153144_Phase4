package com.cg.walletApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.walletApp.beans.Customer;
import com.cg.walletApp.beans.Transactions;

@Controller
public class URIController {
	
	@RequestMapping(value="/")
	public String getIndexPage() {
		return "indexPage";	
	}
	
	@RequestMapping(value="/login")
	public String getLoginPage() {
		return "loginPage";
	}
	
	@RequestMapping(value="/registration")
	public String getRegistrationPage() {
		return "registrationPage";
	}
	
	@RequestMapping(value="/showBalance")
	public String getShowBalancePage() {
		return "showBalancePage";
	}
	
	@RequestMapping(value="/depositAmountPage")
	public String getdepositAmount() {
		return "depositAmountPage";
	}
	
	@RequestMapping(value="/withdrawAmountPage")
	public String getWithdrawAmount() {
		return "withdrawAmountPage";
	}
	
	@RequestMapping(value="/fundTransferPage")
	public String getFundTransfer() {
		return "fundTransferPage";
	}
	
	@RequestMapping(value="/printAllTransactionsPage")
	public String getAllPrintTransactions() {
		return "transactionPage";
	}
	@RequestMapping(value="/showBalanceSuccess")
	public String ShowBalanceSuccess() {
		return "showBalanceSuccess";
	}
	@RequestMapping(value="/logout")
	public String logout() {
		return "logoutPage";
	}
		
	//main obj has to be created and wallet obj will be created by framework->dependency injection
	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}
	
	@ModelAttribute("transactions1")
	public Transactions getTransactions() {
		return new Transactions();
	}

}
