package com.ali.service;

import java.util.List;

import com.ali.model.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);
	
}
