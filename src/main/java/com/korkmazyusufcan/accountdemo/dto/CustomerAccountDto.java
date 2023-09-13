package com.korkmazyusufcan.accountdemo.dto;

import com.korkmazyusufcan.accountdemo.mapper.TransactionMapper;
import com.korkmazyusufcan.accountdemo.model.Account;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomerAccountDto {
    private String id;
    private BigDecimal balance;
    private Set<TransactionDto> transactions;
    private LocalDateTime creationDate;

    public CustomerAccountDto(String id,
                              BigDecimal balance,
                              Set<TransactionDto> transactions,
                              LocalDateTime creationDate) {
        this.id = id;
        this.balance = balance;
        this.transactions = transactions;
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerAccountDto that = (CustomerAccountDto) o;

        if (!id.equals(that.id)) return false;
        if (!balance.equals(that.balance)) return false;
        if (!Objects.equals(transactions, that.transactions)) return false;
        return creationDate.equals(that.creationDate);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + balance.hashCode();
        result = 31 * result + (transactions != null ? transactions.hashCode() : 0);
        result = 31 * result + creationDate.hashCode();
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Set<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionDto> transactions) {
        this.transactions = transactions;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
