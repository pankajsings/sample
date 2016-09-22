package com.example.customer.dao;

import java.util.List;

import com.example.customer.model.Customer;

public interface CustomerDao {
	void addCustomer(Customer customer);
	 
	List<Customer> findAllCustomer(); 
}
