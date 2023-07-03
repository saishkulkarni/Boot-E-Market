package org.jsp.emarket.dao;

import org.jsp.emarket.dto.Merchant;
import org.jsp.emarket.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {

	@Autowired
	MerchantRepository merchantRepository;

	public Merchant findByEmail(String email) {
		return merchantRepository.findByEmail(email);
	}

	public Merchant findByMobile(long mobile) {
		return merchantRepository.findByMobile(mobile);
	}

	public Merchant save(Merchant merchant) {
		return merchantRepository.save(merchant);
	}

}
