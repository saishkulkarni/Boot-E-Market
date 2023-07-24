package org.jsp.emarket.repository;

import org.jsp.emarket.dto.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>
{

}
