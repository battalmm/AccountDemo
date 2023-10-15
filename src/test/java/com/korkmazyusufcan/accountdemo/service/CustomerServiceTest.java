package com.korkmazyusufcan.accountdemo.service;

import com.korkmazyusufcan.accountdemo.dto.CustomerDto;
import com.korkmazyusufcan.accountdemo.exception.CustomerNotFoundException;
import com.korkmazyusufcan.accountdemo.mapper.CustomerMapper;
import com.korkmazyusufcan.accountdemo.model.Customer;
import com.korkmazyusufcan.accountdemo.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    private  CustomerRepository customerRepository;
    private  CustomerMapper customerMapper;
    private CustomerService customerService;
    @BeforeEach
    void setUp() {
        customerMapper = Mockito.mock(CustomerMapper.class);
        customerRepository = Mockito.mock(CustomerRepository.class);

        customerService = new CustomerService(customerRepository, customerMapper);
    }

    @Test
    void getCustomerById_whenCustomerIdExist_shouldReturnCustomerDto(){

        String customerId = "customer-id";
        CustomerDto customerDto = new CustomerDto(customerId,"customer-name","customer-surname", Set.of());
        Customer customer = new Customer(customerId,"customer-name","customer-surname", Set.of());

        Mockito.when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
        Mockito.when(customerMapper.toDto(customer)).thenReturn(customerDto);

        CustomerDto result = customerService.getCustomerById(customerId);

        assertEquals(result,customerDto);
    }

    @Test
     void getCustomerById_whenCustomerIdNotFound_shouldThrowCustomerNotFoundException(){

        String notExistedCustomerId = "not-existed-id";

        Mockito.when(customerRepository.findById(notExistedCustomerId)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomerById(notExistedCustomerId));

        Mockito.verifyNoInteractions(customerMapper);
    }

    @Test
    void findCustomerById_whenCustomerExist_shouldReturnCustomer(){

        String customerId = "customer-id";
        Customer customer = new Customer(customerId,"customer-name","customer-surname", Set.of());

        Mockito.when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        Customer result = customerService.findCustomerById(customerId);

        assertEquals(customer,result);
    }

    @Test
    void findCustomerById_whenCustomerIdNotFound_shouldThrowCustomerNotFoundException(){

        String notExistedCustomerId = "not-existed-id";

        Mockito.when(customerRepository.findById(notExistedCustomerId)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> customerService.findCustomerById(notExistedCustomerId));

    }

    @AfterEach
    void tearDown() {}
}