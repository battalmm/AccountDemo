package com.korkmazyusufcan.accountdemo.dto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class AccountDto {

    private String id;
    private BigDecimal balance;
    private LocalDateTime creationDate;
    private AccountCustomerDto customer;
    private Set<TransactionDto> transaction;

    public AccountDto(){}

    public AccountDto(String id,
                      BigDecimal balance,
                      LocalDateTime creationDate,
                      AccountCustomerDto customer,
                      Set<TransactionDto> transaction) {
        this.id = id;
        this.balance = balance;
        this.creationDate = creationDate;
        this.customer = customer;
        this.transaction = transaction;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public AccountCustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(AccountCustomerDto customer) {
        this.customer = customer;
    }

    public Set<TransactionDto> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<TransactionDto> transaction) {
        this.transaction = transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountDto that = (AccountDto) o;

        if (!id.equals(that.id)) return false;
        if (!balance.equals(that.balance)) return false;
        if (!creationDate.equals(that.creationDate)) return false;
        if (!customer.equals(that.customer)) return false;
        return Objects.equals(transaction, that.transaction);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + balance.hashCode();
        result = 31 * result + creationDate.hashCode();
        result = 31 * result + customer.hashCode();
        result = 31 * result + (transaction != null ? transaction.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", balance=" + balance +
                ", creationDate=" + creationDate +
                ", customer=" + customer +
                ", transaction=" + transaction +
                '}';
    }
}
