package com.korkmazyusufcan.accountdemo;

import com.korkmazyusufcan.accountdemo.model.Customer;
import com.korkmazyusufcan.accountdemo.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Objects;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AccountdemoApplication.class, args);

	}

	// For testing
	private final CustomerRepository customerRepository;
	public AccountdemoApplication(CustomerRepository customerRepository) {

		this.customerRepository = customerRepository;
	}


}
