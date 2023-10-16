package com.korkmazyusufcan.accountdemo.service;

import com.korkmazyusufcan.accountdemo.TestSupport;
import com.korkmazyusufcan.accountdemo.dto.AccountCustomerDto;
import com.korkmazyusufcan.accountdemo.dto.AccountDto;
import com.korkmazyusufcan.accountdemo.dto.CreateAccountRequestDto;
import com.korkmazyusufcan.accountdemo.dto.TransactionDto;
import com.korkmazyusufcan.accountdemo.exception.CustomerNotFoundException;
import com.korkmazyusufcan.accountdemo.mapper.AccountMapper;
import com.korkmazyusufcan.accountdemo.model.Account;
import com.korkmazyusufcan.accountdemo.model.Customer;
import com.korkmazyusufcan.accountdemo.model.Transaction;
import com.korkmazyusufcan.accountdemo.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

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

    @Test
    public void createAccount_whenInitialCreditsEqualsZero_shouldReturnAccountDtoWithEmptyTransaction(){

        CreateAccountRequestDto createAccountRequestDto = generateCreateAccountRequest(0);
        Customer customer = createCustomer();
        Account account = createAccount(0,customer);
        AccountDto accountDto = new AccountDto("account-id",BigDecimal.ZERO, account.getCreationDate(),createAccountCustomerDto(),Set.of());

        Mockito.when(customerService.findCustomerById("customer-id")).thenReturn(customer);
        Mockito.when(accountRepository.save(account)).thenReturn(account);
        Mockito.when(accountMapper.toDto(account)).thenReturn(accountDto);

        AccountDto result = accountService.createAccount(createAccountRequestDto);
        assertEquals(accountDto,result);

    }

    @Test
    public void createAccount_whenInitialCreditsMoreThanZero_shouldReturnAccountDtoWithInitialTransaction(){
        CreateAccountRequestDto createAccountRequestDto = generateCreateAccountRequest(0);
        Customer customer = createCustomer();
        Account account = createAccount(950,customer);
        Transaction transaction = createTransaction(account,new BigDecimal(950));
        TransactionDto transactionDto = createTransactionDto(950);
        AccountDto accountDto = new AccountDto("account-id",BigDecimal.ZERO, account.getCreationDate(),createAccountCustomerDto(),Set.of(transactionDto));

        Mockito.when(customerService.findCustomerById("customer-id")).thenReturn(customer);
        Mockito.when(accountRepository.save(account)).thenReturn(account);
        Mockito.when(accountMapper.toDto(account)).thenReturn(accountDto);

        AccountDto result = accountService.createAccount(createAccountRequestDto);
        assertEquals(accountDto,result);
    }

    @Test
    public void createAccount_whenCustomerIdNotFound_shouldThrowCustomerNotFoundException(){

        CreateAccountRequestDto createAccountRequestDto = generateCreateAccountRequest("customer-not-found-id",0);

        Mockito.when(customerService.findCustomerById(createAccountRequestDto.getCustomerId())).thenThrow(CustomerNotFoundException.class);

        assertThrows(CustomerNotFoundException.class,()-> accountService.createAccount(createAccountRequestDto));

        Mockito.verify(customerService).findCustomerById(createAccountRequestDto.getCustomerId());
        Mockito.verifyNoInteractions(accountRepository);
        Mockito.verifyNoInteractions(accountMapper);
    }

}