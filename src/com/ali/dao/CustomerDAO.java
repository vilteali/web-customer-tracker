package com.ali.dao;

import java.util.List;

import com.ali.model.Customer;

public interface CustomerDAO {

	List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);
	
}
