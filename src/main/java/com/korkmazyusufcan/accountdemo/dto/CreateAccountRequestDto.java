package com.korkmazyusufcan.accountdemo.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


public class CreateAccountRequestDto {

    @NotBlank(message = "Customer id could not be null")
    private String customerId;
    @Min(value = 0,message = "Initial credit could not be negative")
    private BigDecimal initialCredit;

    public CreateAccountRequestDto() {
    }

    public CreateAccountRequestDto(String customerId, BigDecimal initialCredit) {
        this.customerId = customerId;
        this.initialCredit = initialCredit;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(BigDecimal initialCredit) {
        this.initialCredit = initialCredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreateAccountRequestDto that = (CreateAccountRequestDto) o;

        if (!customerId.equals(that.customerId)) return false;
        return initialCredit.equals(that.initialCredit);
    }

    @Override
    public int hashCode() {
        int result = customerId.hashCode();
        result = 31 * result + initialCredit.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CreateAccountRequestDto{" +
                "customerId=" + customerId +
                ", initialCredit=" + initialCredit +
                '}';
    }
}
