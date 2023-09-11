package com.korkmazyusufcan.accountdemo.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime transactionDate = LocalDateTime.now();

    private BigDecimal transactionAmount;

    private TransactionType transactionType = TransactionType.INITIAL;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (!id.equals(that.id)) return false;
        if (!transactionDate.equals(that.transactionDate)) return false;
        if (!transactionAmount.equals(that.transactionAmount)) return false;
        if (transactionType != that.transactionType) return false;
        return Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + transactionDate.hashCode();
        result = 31 * result + transactionAmount.hashCode();
        result = 31 * result + transactionType.hashCode();
        return result;
    }
}

 enum  TransactionType {
    INITIAL,TRANSFER
}