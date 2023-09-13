package com.korkmazyusufcan.accountdemo;

import com.korkmazyusufcan.accountdemo.model.Customer;
import com.korkmazyusufcan.accountdemo.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Objects;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountdemoApplication {

	private static CustomerRepository customerRepository;
	public AccountdemoApplication(CustomerRepository customerRepository) {

		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {


		SpringApplication.run(AccountdemoApplication.class, args);


		Customer customer = customerRepository.save(new Customer("Yusuf Can", "Korkmaz"));
		Customer customer2 = customerRepository.save(new Customer("Oguzcan", "Korkmaz"));
		Customer customer3 = customerRepository.save(new Customer("Serap", "Korkmaz"));

		System.out.println(customer.getId());
		System.out.println(customer2.getId());
		System.out.println(customer3.getId());

	}

}
