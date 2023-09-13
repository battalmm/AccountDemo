package com.korkmazyusufcan.accountdemo.mapper;

import com.korkmazyusufcan.accountdemo.dto.CustomerAccountDto;
import com.korkmazyusufcan.accountdemo.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomerAccountMapper {

    private final TransactionMapper transactionMapper;
    public CustomerAccountMapper(TransactionMapper transactionMapper) {
        this.transactionMapper = transactionMapper;
    }

    public CustomerAccountDto toDto(Account account) {
        return new CustomerAccountDto(
                Objects.requireNonNull(account.getId()),
                account.getBalance(),
                account.getTransactionsList()
                        .stream()
                        .map(transactionMapper::toDto)
                        .collect(Collectors.toSet()),
                account.getCreationDate());
    }
}
