package org.jsp.emarket.repository;

import org.jsp.emarket.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>
{

	Product findByName(String name);

}
