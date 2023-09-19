package com.korkmazyusufcan.accountdemo.repository;
import com.korkmazyusufcan.accountdemo.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
