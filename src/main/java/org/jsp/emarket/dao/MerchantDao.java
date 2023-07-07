package org.jsp.emarket.dao;

import org.jsp.emarket.dto.Merchant;
import org.jsp.emarket.dto.Product;
import org.jsp.emarket.repository.MerchantRepository;
import org.jsp.emarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {

	@Autowired
	MerchantRepository merchantRepository;

	@Autowired
	ProductRepository productRepository;

	public Merchant findByEmail(String email) {
		return merchantRepository.findByEmail(email);
	}

	public Merchant findByMobile(long mobile) {
		return merchantRepository.findByMobile(mobile);
	}

	public Merchant save(Merchant merchant) {
		return merchantRepository.save(merchant);
	}

	public Product findProductByName(String name) {
		return productRepository.findByName(name);
	}

	public Product findProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}

	public void removeProduct(Product product) {
		productRepository.delete(product);
	}

}
