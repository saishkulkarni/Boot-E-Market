package org.jsp.emarket.repository;

import org.jsp.emarket.dto.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer>
{

	Payment findByName(String name);

}
