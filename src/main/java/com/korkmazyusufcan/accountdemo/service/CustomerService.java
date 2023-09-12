package com.korkmazyusufcan.accountdemo.service;

import com.korkmazyusufcan.accountdemo.dto.CustomerDto;
import com.korkmazyusufcan.accountdemo.exception.CustomerNotFoundException;
import com.korkmazyusufcan.accountdemo.mapper.CustomerMapper;
import com.korkmazyusufcan.accountdemo.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository,
                           CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto getCustomerById(String id){
        return  customerMapper
                .toDto(customerRepository
                        .findById(id)
                        .orElseThrow(
                () -> new CustomerNotFoundException("Customer could not find by id: " + id)
        ));
    }

    public List<CustomerDto> getAllCustomers(){
        return customerRepository
                .findAll()
                .stream().map(customerMapper::toDto)
                .collect(Collectors.toList());
    }
}
