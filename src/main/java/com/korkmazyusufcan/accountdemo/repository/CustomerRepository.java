package com.korkmazyusufcan.accountdemo.repository;
import com.korkmazyusufcan.accountdemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
