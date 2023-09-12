package com.korkmazyusufcan.accountdemo.mapper;

import com.korkmazyusufcan.accountdemo.dto.CustomerDto;
import com.korkmazyusufcan.accountdemo.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    private final AccountMapper accountMapper;

    public CustomerMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public CustomerDto toDto(Customer customer){
        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getAccount().stream().map(accountMapper::toDto).collect(Collectors.toSet()));

    }

}
