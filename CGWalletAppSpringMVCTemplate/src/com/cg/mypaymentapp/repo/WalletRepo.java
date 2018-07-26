package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.mypaymentapp.beans.Customer;

public interface WalletRepo extends JpaRepository<Customer, String>{
	@Query("select customer from Customer customer join customer.wallet w where w.balance<:bal")
	List<Customer> find(@Param("bal")BigDecimal bal);
}
