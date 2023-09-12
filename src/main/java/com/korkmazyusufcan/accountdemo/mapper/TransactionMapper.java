package com.korkmazyusufcan.accountdemo.mapper;

import com.korkmazyusufcan.accountdemo.dto.TransactionDto;
import com.korkmazyusufcan.accountdemo.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    private final AccountMapper accountMapper;

    public TransactionMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public TransactionDto toDto(Transaction transaction){
        return new TransactionDto(
                transaction.getId(),
                transaction.getTransactionDate(),
                transaction.getTransactionAmount(),
                transaction.getTransactionType(),
                accountMapper.toDto(transaction.getAccount())
        );
    }
}
