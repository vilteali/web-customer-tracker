package com.ali.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> customer) {
		return Customer.class.isAssignableFrom(customer);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		
	}
	
	

}
