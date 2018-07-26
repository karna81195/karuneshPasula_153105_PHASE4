
package com.cg.mypaymentapp.service;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.repo.WalletRepo;
import com.cg.mypaymentapp.repo.WalletRepo1;

@Component(value="walletService")
public class WalletServiceImpl implements WalletService{
	long millis=System.currentTimeMillis();
	@Autowired
	private WalletRepo repo;
	@Autowired
	private WalletRepo1 repo1;
	public Customer createAccount(Customer customer){
     return repo.save(customer);
    }
	public Customer showBalance(String mobileNo) {
		if(!isValidMobile(mobileNo)){
			throw new InvalidInputException("Invalid Mobile number");
		}
		else{
		Customer customer=repo.findOne(mobileNo);
		if(customer!=null){
			return customer;
		}
		else
			throw new InvalidInputException("account with mobile number not found ");
		}
	}
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		if( !isValidMobile(sourceMobileNo) || !isValidMobile(targetMobileNo) || !isValidAmount(amount)){
			throw new InvalidInputException("Sorry , your details are incorrect");
		}
		Customer sourceCustomer=repo.findOne(sourceMobileNo);
		Customer destCustomer=repo.findOne(targetMobileNo);
		if(sourceCustomer!=null && destCustomer!=null){	
			Wallet balance1 = sourceCustomer.getWallet();
			Wallet balance2 = destCustomer.getWallet();
			if(balance1.getBalance().compareTo(amount) > 0){
				BigDecimal remainBalance = balance1.getBalance().subtract(amount);
				BigDecimal addedBalance = balance2.getBalance().add(amount);
				balance1.setBalance(remainBalance);
				balance2.setBalance(addedBalance);
				
				String transactionType1="Transfered";
				String transactionType2="Recieved";
				Date date = new java.sql.Date(millis); 
				Transaction transaction1 = new Transaction(sourceMobileNo,transactionType1,  date ,remainBalance );
				Transaction transaction2 = new Transaction(targetMobileNo,transactionType2 , date,addedBalance);
				repo.save(sourceCustomer);
				repo1.save(transaction1);
				repo1.save(transaction2);
				repo.save(destCustomer);
				return sourceCustomer;
			}
			else{
				throw new InsufficientBalanceException("insufficient balance");
			}
		}
		else{
			throw new InvalidInputException("account with mobile number not found ");
		}
	}
	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		if( !isValidMobile(mobileNo) || !isValidAmount(amount)){
			throw new InvalidInputException("Sorry , your details are incorrect");
		}
		Customer customer = repo.findOne(mobileNo);
		if(customer!= null){
			Wallet wallet = customer.getWallet();
			BigDecimal money=wallet.getBalance().add(amount);
			wallet.setBalance(money);
			
			String transactionType="Credit";
			Date date = new java.sql.Date(millis); 
			Transaction transaction = new Transaction(mobileNo,transactionType, date,money);
			repo.save(customer);
			repo1.save(transaction);
			return customer;
		}
		else{
			throw new InvalidInputException("account with mobile number not found ");
		}
	}
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		if( !isValidMobile(mobileNo) || !isValidAmount(amount)){
			throw new InvalidInputException("Sorry , your details are incorrect");
		}
		Customer customer = repo.findOne(mobileNo);
		if(customer!= null){
			Wallet balance = customer.getWallet();
			if(balance.getBalance().compareTo(amount)>0){
				BigDecimal withdrawedBalance = balance.getBalance().subtract(amount);
				balance.setBalance(withdrawedBalance);
				BigDecimal total= customer.getWallet().getBalance();
				
				String transactionType="Debit";
				Date date = new java.sql.Date(millis); 
				Transaction transaction = new Transaction(mobileNo,transactionType, date, total);
				repo.save(customer);
				repo1.save(transaction);
				return customer;
			}
			else{
				throw new InsufficientBalanceException("Insufficient balance ");
			}
		}
		else{
			throw new InvalidInputException("account with mobile number not found ");
		}
	}
	@Override
	public List<Transaction> recentTransactions(String mobileNo) {
		List<Transaction> transaction=repo1.findByMobileNo(mobileNo);
		return transaction;
	}
	@Override
	public List<Customer> viewAllCustomers() {
		
		return repo.findAll();
	}
	@Override
	public List<Customer> viewCustomersWithLessBalance(BigDecimal bal) {
		
		return repo.find(bal);
	}
	private boolean isValidMobile(String mobileNo) {
		if(String.valueOf(mobileNo).matches("[1-9][0-9]{9}")){
			return true;
		}		
		else{
			return false;
		}
	}
	
	private boolean isValidAmount(BigDecimal amount){
		BigDecimal val = new BigDecimal("0");
		if(amount.compareTo(val)>0){
			return true;
		}
		else{
			return false;
		}
	}
	private boolean isValidName(String name){
		if(name.isEmpty()){
			return false; 
		}
		else{
			return true;
		}
	}

	
}

