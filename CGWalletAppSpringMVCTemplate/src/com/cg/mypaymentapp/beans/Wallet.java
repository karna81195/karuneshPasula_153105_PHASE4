package com.cg.mypaymentapp.beans;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
public class Wallet implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mysgen")
	@SequenceGenerator(sequenceName="wallet_sequence", name="mysgen")
	private int wallet_id;
	private BigDecimal balance;

	
public Wallet() {
		super();
	}

public Wallet(int wallet_id, BigDecimal balance) {
	super();
	this.wallet_id = wallet_id;
	this.balance = balance;
}

public Wallet(BigDecimal amount) {
	this.balance=amount;
}

public BigDecimal getBalance() {
	return balance;
}

public void setBalance(BigDecimal balance) {
	this.balance = balance;
}

@Override
	public String toString() {
	return ", balance="+balance;
}

}
