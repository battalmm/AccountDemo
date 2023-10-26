package com.korkmazyusufcan.accountdemo;

import com.korkmazyusufcan.accountdemo.dto.AccountCustomerDto;
import com.korkmazyusufcan.accountdemo.dto.CreateAccountRequestDto;
import com.korkmazyusufcan.accountdemo.dto.TransactionDto;
import com.korkmazyusufcan.accountdemo.model.Account;
import com.korkmazyusufcan.accountdemo.model.Customer;
import com.korkmazyusufcan.accountdemo.model.Transaction;
import com.korkmazyusufcan.accountdemo.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class TestSupport {

    public Customer createCustomer(){
        return new Customer(
                "customer-id",
                "customer-name",
                "customer-surname",
                Set.of());
    }

    public AccountCustomerDto createAccountCustomerDto(){
        return new AccountCustomerDto(
                "customer-id",
                "customer-name",
                "customer-surname");
    }

    public Account createAccount(int balance, Customer customer) {
        return new Account(
                "",
                new BigDecimal(balance),
                customer,
                Set.of());
    }

    public Transaction createTransaction(Account account, BigDecimal initialCredit){
        return new Transaction(
                initialCredit,
                TransactionType.INITIAL,
                account,
                "transaction-id"
        );
    }

    public TransactionDto createTransactionDto(int amount){
        return new TransactionDto(
                "transaction-id",
                LocalDateTime.now(),
                new BigDecimal(amount),
                TransactionType.INITIAL
        );
    }

    public CreateAccountRequestDto generateCreateAccountRequest(int initialCredit) {
        return generateCreateAccountRequest("customer-id", initialCredit);
    }

    public CreateAccountRequestDto generateCreateAccountRequest(String customerId, int initialCredit) {
        return new CreateAccountRequestDto(customerId, new BigDecimal(initialCredit));
    }

}
