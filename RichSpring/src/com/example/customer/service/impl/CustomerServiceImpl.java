package com.example.customer.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.customer.dao.CustomerDao;
import com.example.customer.dao.impl.CustomerDaoImpl;
import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;

public class CustomerServiceImpl implements CustomerService , Serializable{
	
	CustomerDaoImpl customerDao;
	
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.addCustomer(customer);
	}
	
	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		return customerDao.findAllCustomer();
	}
	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDaoImpl customerDao) {
		this.customerDao = customerDao;
	}

	

}
