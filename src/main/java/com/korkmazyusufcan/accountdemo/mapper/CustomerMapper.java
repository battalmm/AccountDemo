package com.korkmazyusufcan.accountdemo.mapper;
import com.korkmazyusufcan.accountdemo.dto.AccountCustomerDto;
import com.korkmazyusufcan.accountdemo.dto.CustomerDto;
import com.korkmazyusufcan.accountdemo.model.Customer;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {


    private final CustomerAccountMapper customerAccountMapper;

    public CustomerMapper(CustomerAccountMapper customerAccountMapper) {
        this.customerAccountMapper = customerAccountMapper;
    }

    public CustomerDto toDto(Customer customer){
        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getAccount()
                        .stream()
                        .map(customerAccountMapper::toDto)
                        .collect(Collectors.toSet()));

    }

    public AccountCustomerDto convertToAccountCustomer(Optional<Customer> from) {
        return from.map(f -> new AccountCustomerDto(f.getId(), f.getFirstName(), f.getLastName())).orElse(null);
    }

    public Customer toEntity(CustomerDto customerDto){
        return new Customer(
                customerDto.getFirstName(),
                customerDto.getLastName()
        );
    }

}
