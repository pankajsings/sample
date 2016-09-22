package com.example.customer.service;

import java.util.List;

import com.example.customer.model.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);
	List<Customer> findAllCustomer();
}
