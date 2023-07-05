package org.jsp.emarket.dao;

import org.jsp.emarket.dto.Customer;
import org.jsp.emarket.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
	@Autowired
	CustomerRepository customerRepository;

	public Customer findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	public Customer findByMobile(long mobile) {
		return customerRepository.findByMobile(mobile);
	}

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
}
