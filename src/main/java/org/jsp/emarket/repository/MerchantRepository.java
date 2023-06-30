package org.jsp.emarket.repository;

import org.jsp.emarket.dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, String> {

	Merchant findByEmail(String email);

	Merchant findByMobile(long mobile);

}
