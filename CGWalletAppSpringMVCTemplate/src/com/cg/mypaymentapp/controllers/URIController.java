package com.cg.mypaymentapp.controllers;

import java.awt.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;
@Controller
public class URIController {
	
	@RequestMapping(value="/")
	public String getIndexPage() {
	return "indexPage";
	}
	@RequestMapping(value="/register")
	public String getRegisterPage() {
	return "registerPage";
	}
	
	@ModelAttribute("customer")
	public Customer getCustomer(){
		return new Customer();
	}
	
	@ModelAttribute("transaction1")
	public Transaction getTransaction(){
		return new Transaction();
	}
	@RequestMapping(value="/login")
	public String getLoginPage() {
	return "loginPage";
	}
	
	

	@RequestMapping(value="/Deposit")
	public String getdepositPage() {
		return "DepositPage";
	}
	
	@RequestMapping(value="/Withdraw")
	public String getwithdrawPage() {
		return "withdrawPage";
	}
	@RequestMapping(value="/FundTransfer")
	public String getShowBalancePage() {
		return "FundTransferPage";
	}

}
