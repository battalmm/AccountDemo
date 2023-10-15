package com.korkmazyusufcan.accountdemo.service;

import com.korkmazyusufcan.accountdemo.TestSupport;
import com.korkmazyusufcan.accountdemo.mapper.AccountMapper;
import com.korkmazyusufcan.accountdemo.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest extends TestSupport {

    private  AccountRepository accountRepository;
    private  CustomerService customerService;
    private  AccountMapper accountMapper;
    private  AccountService accountService;

    @BeforeEach
    public void setUp(){
        customerService = Mockito.mock(CustomerService.class);
        accountRepository = Mockito.mock(AccountRepository.class);
        accountMapper = Mockito.mock(AccountMapper.class);

        accountService = new AccountService(accountRepository,customerService,accountMapper);
    }

}