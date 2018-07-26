package com.cg.mypaymentapp.service;
import java.math.BigDecimal;
import java.util.List;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;

public interface WalletService{
public Customer createAccount(Customer customer);
public Customer showBalance (String mobileno);
public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, BigDecimal amount);
public Customer depositAmount (String mobileNo,BigDecimal amount );
public Customer withdrawAmount(String mobileNo, BigDecimal amount);
public List<Transaction> recentTransactions(String mobileno);
public List<Customer> viewAllCustomers();
public List<Customer> viewCustomersWithLessBalance(BigDecimal bal);
}
