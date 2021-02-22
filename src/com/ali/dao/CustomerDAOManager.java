package com.ali.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ali.model.Customer;

@Repository
public class CustomerDAOManager implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",
																Customer.class);
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}
	
	@Override
	public Customer getCustomer(Integer id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currentSession.get(Customer.class, id);
		
		return theCustomer;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public void updateCustomer(Customer theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		theCustomer = currentSession.get(Customer.class, theCustomer.getId());
		
	}

	@Override
	public void deleteCustomer(Integer id) {

		Session currentSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currentSession.get(Customer.class, id);
		currentSession.delete(theCustomer);
		
	}

	@Override
	public List<Customer> searchCustomers(String searchCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		final String query = "from Customer where lower(firstName) like :theName or lower(lastName) like :theName";
		
		if (searchCustomer != null && searchCustomer.trim().length() > 0) {
			theQuery = currentSession.createQuery(query, Customer.class);
			theQuery.setParameter("theName", "%" + searchCustomer.toLowerCase() + "%");
		} else {
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

}
