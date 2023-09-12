package com.korkmazyusufcan.accountdemo.dto;

import com.korkmazyusufcan.accountdemo.model.Account;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;


public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<AccountDto> account;

    public CustomerDto(){}

    public CustomerDto(Long id,
                       String firstName,
                       String lastName,
                       Set<AccountDto> account) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<AccountDto> getAccount() {
        return account;
    }

    public void setAccount(Set<AccountDto> account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerDto that = (CustomerDto) o;

        if (!id.equals(that.id)) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        return Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", account=" + account +
                '}';
    }
}
