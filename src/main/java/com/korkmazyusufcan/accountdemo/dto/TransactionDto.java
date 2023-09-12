package com.korkmazyusufcan.accountdemo.dto;

import com.korkmazyusufcan.accountdemo.model.Account;
import com.korkmazyusufcan.accountdemo.model.TransactionType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto {
    private Long id;
    private LocalDateTime transactionDate;
    private BigDecimal transactionAmount;
    private TransactionType transactionType;
    private AccountDto account;

    public TransactionDto(){}

    public TransactionDto(Long id,
                          LocalDateTime transactionDate,
                          BigDecimal transactionAmount,
                          TransactionType transactionType,
                          AccountDto account) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public AccountDto    getAccount() {
        return account;
    }

    public void setAccount(AccountDto account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionDto that = (TransactionDto) o;

        if (!id.equals(that.id)) return false;
        if (!transactionDate.equals(that.transactionDate)) return false;
        if (!transactionAmount.equals(that.transactionAmount)) return false;
        if (transactionType != that.transactionType) return false;
        return account.equals(that.account);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + transactionDate.hashCode();
        result = 31 * result + transactionAmount.hashCode();
        result = 31 * result + transactionType.hashCode();
        result = 31 * result + account.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id=" + id +
                ", transactionDate=" + transactionDate +
                ", transactionAmount=" + transactionAmount +
                ", transactionType=" + transactionType +
                ", account=" + account +
                '}';
    }
}
