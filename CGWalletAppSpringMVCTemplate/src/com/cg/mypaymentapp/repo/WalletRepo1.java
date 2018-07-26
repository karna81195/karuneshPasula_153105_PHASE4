package com.cg.mypaymentapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cg.mypaymentapp.beans.Transaction;

public interface WalletRepo1 extends JpaRepository<Transaction, String>,CrudRepository<Transaction, String> {
List<Transaction> findByMobileNo(String mobileNo);
}
