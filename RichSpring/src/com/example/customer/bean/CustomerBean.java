package com.example.customer.bean;

import java.io.Serializable;
import java.util.List;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import com.example.customer.service.impl.CustomerServiceImpl;

public class CustomerBean implements Serializable{
	private static final long serialVersionUID = 1L;
	CustomerServiceImpl customerService;
	public String name;
	public String address;
	public CustomerServiceImpl getCustomerService() {
		return customerService;
	}
	//test1
	public void setCustomerService(CustomerServiceImpl customerService) {
		this.customerService = customerService;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Customer> getCustomerList(){
		return customerService.findAllCustomer();
	}
	public String addCustomer(){
		 
		Customer cust = new Customer();
		cust.setName(getName());
		cust.setAddress(getAddress());
		 
		customerService.addCustomer(cust);
		 
		clearForm();
		 
		return "";
	}
	private void clearForm(){
		setName("");
		setAddress("");
	} 
}
