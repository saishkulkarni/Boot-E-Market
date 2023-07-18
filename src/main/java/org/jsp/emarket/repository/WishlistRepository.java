package org.jsp.emarket.repository;

import org.jsp.emarket.dto.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

	Wishlist findByName(String name);

}
