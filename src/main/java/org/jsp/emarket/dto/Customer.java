package org.jsp.emarket.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
}
