package com.cg.mypaymentapp.controllers;

import java.util.List;
import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;
import com.cg.mypaymentapp.service.WalletService;


@Controller
public class CustomerActionController {
	public static String mobileNo;
	@Autowired
	WalletService walletService;
	@RequestMapping(value="/registerCustomer")
	public ModelAndView registerCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult result) {
		if(result.hasErrors()) return new ModelAndView("registerPage");
			walletService.createAccount(customer);
				return new ModelAndView("registrationSuccessPage","customer",customer);
	}
	@RequestMapping(value="/viewOptions")
		public ModelAndView viewOptions(@ModelAttribute("customer") Customer customer){
			
		try {
			mobileNo=customer.getMobileNo();
			Customer customer1=walletService.showBalance(mobileNo);
			return new ModelAndView("Menu","customer",customer);
		} catch (Exception e) {
			
			return new ModelAndView("loginPage","errorMessage",e.getMessage());
		}
			
		
		}
	@RequestMapping(value="/showBalance")
	public ModelAndView viewOptions(){
	Customer customer=walletService.showBalance(mobileNo);
		return new ModelAndView("showBalancePage","customer",customer);
	
	}
	@RequestMapping(value="/deposit")
	public ModelAndView deposit(@ModelAttribute("customer")@RequestParam("wallet.balance")BigDecimal amount){
	
	try {
		
		Customer customer1= walletService.depositAmount(mobileNo, amount);
		return new ModelAndView("showBalancePage","customer",customer1);
	} catch (Exception e) {
		
		return new ModelAndView("depositPage","errorMessage",e.getMessage());
	}
		
	
	}
	@RequestMapping(value="/withdraw")
	public ModelAndView withdraw(@ModelAttribute("customer")Customer customer,@RequestParam("wallet.balance")BigDecimal amount){
	
	try {
		Customer customer1 = walletService.withdrawAmount(mobileNo, amount);
		return new ModelAndView("showBalancePage","customer",customer1);
	} catch (Exception e) {
		return new ModelAndView("withdrawPage","errorMessage",e.getMessage());
	}
		
	
	}
	@RequestMapping(value="/fundTransfer")
	public ModelAndView fundTransfer(@ModelAttribute("customer")@RequestParam("mobileNo")String targetMobileNo,@RequestParam("wallet.balance")BigDecimal amount){
	Customer customer;
	try {
		customer = walletService.fundTransfer(mobileNo, targetMobileNo, amount);
		return new ModelAndView("showBalancePage","customer",customer);
	} catch (Exception e) {
		return new ModelAndView("withdrawPage","errorMessage",e.getMessage());
	}
	
	
	}
	@RequestMapping(value="/printTransactions")
	public ModelAndView viewtransactions(){
	List<Transaction> transactions=walletService.recentTransactions(mobileNo);
		return new ModelAndView("transactionsPage","transaction1",transactions);
	
	}

}
