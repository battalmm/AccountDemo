package com.korkmazyusufcan.accountdemo.service;
import com.korkmazyusufcan.accountdemo.dto.AccountDto;
import com.korkmazyusufcan.accountdemo.dto.CreateAccountRequestDto;
import com.korkmazyusufcan.accountdemo.mapper.AccountMapper;
import com.korkmazyusufcan.accountdemo.model.Account;
import com.korkmazyusufcan.accountdemo.model.Customer;
import com.korkmazyusufcan.accountdemo.model.Transaction;
import com.korkmazyusufcan.accountdemo.model.TransactionType;
import com.korkmazyusufcan.accountdemo.repository.AccountRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.HashSet;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.accountMapper = accountMapper;
    }

    public AccountDto createAccount(CreateAccountRequestDto createAccountRequestDto){
        Customer customer = customerService.findCustomerById(createAccountRequestDto.getCustomerId());

        Account account = new Account(
                createAccountRequestDto.getInitialCredit(),
                customer
        );

        if(createAccountRequestDto.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(
                    createAccountRequestDto.getInitialCredit(),
                    TransactionType.INITIAL,
                    account
            );

            account.getTransactionsList().add(transaction);
        }

        accountRepository.save(account);
        return accountMapper.toDto(account);
    }

}
