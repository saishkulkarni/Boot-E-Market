package org.jsp.emarket.repository;

import org.jsp.emarket.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	Customer findByEmail(String email);

	Customer findByMobile(long mobile);
}
