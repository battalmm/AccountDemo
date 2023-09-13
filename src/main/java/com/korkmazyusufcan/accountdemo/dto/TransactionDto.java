package com.korkmazyusufcan.accountdemo.dto;
import com.korkmazyusufcan.accountdemo.model.TransactionType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionDto {
    private String id;
    private LocalDateTime transactionDate;
    private BigDecimal transactionAmount;
    private TransactionType transactionType;

    public TransactionDto(){}

    public TransactionDto(String id,
                          LocalDateTime transactionDate,
                          BigDecimal transactionAmount,
                          TransactionType transactionType) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionDto that = (TransactionDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(transactionDate, that.transactionDate))
            return false;
        if (!Objects.equals(transactionAmount, that.transactionAmount))
            return false;
        return transactionType == that.transactionType;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (transactionDate != null ? transactionDate.hashCode() : 0);
        result = 31 * result + (transactionAmount != null ? transactionAmount.hashCode() : 0);
        result = 31 * result + (transactionType != null ? transactionType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id=" + id +
                ", transactionDate=" + transactionDate +
                ", transactionAmount=" + transactionAmount +
                ", transactionType=" + transactionType +
                '}';
    }
}
