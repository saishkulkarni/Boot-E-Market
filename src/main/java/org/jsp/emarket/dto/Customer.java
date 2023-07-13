package org.jsp.emarket.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Component
@Entity
@Data
public class Customer {
	private String name;
	@Id
	private String email;
	private long mobile;
	private String password;
	private LocalDate dob;
	private String gender;
	private String address;
	private String token;
	private boolean status;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	ShoppingCart shoppingCart;
}
