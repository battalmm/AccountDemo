package com.korkmazyusufcan.accountdemo.repository;

import com.korkmazyusufcan.accountdemo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
