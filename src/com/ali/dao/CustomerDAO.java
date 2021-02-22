package com.ali.dao;

import java.util.List;

import com.ali.model.Customer;

public interface CustomerDAO {

	List<Customer> getCustomers();
	
	Customer getCustomer(Integer id);

	void saveCustomer(Customer theCustomer);
	
	void updateCustomer(Customer theCustomer);

	void deleteCustomer(Integer id);
	
}
