package com.korkmazyusufcan.accountdemo.service;

import com.korkmazyusufcan.accountdemo.repository.AccountRepository;

public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


}
