package com.cg.mypaymentapp.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Transaction implements Serializable{
	
	private BigDecimal amount;
	private Date tdate;
	private String mobileNo;
	private String transactionType;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mysgen")
	@SequenceGenerator(sequenceName="my_sequencee",name="mysgen")
	
	private int id;
	public Transaction() {
		super();
	}
	public Transaction(String mobileNo,  String transactionType,Date tdate,BigDecimal amount) {
		super();
		this.amount = amount;
		this.tdate = tdate;
		this.mobileNo = mobileNo;
		this.transactionType = transactionType;
	
	}
	
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", tdate=" + tdate + ", mobileNo=" + mobileNo + ", transactionType="
				+ transactionType + ", id=" + id + "]";
	}
	
	
	
	
		
	
}
