package org.jsp.emarket.repository;

import java.util.List;

import org.jsp.emarket.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);

	List<Product> findByStatus(boolean flag);

}
