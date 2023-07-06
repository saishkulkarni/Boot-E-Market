package org.jsp.emarket.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Component
@Data
public class Merchant {
	private String name;
	@Id
	private String email;
	private long mobile;
	private String password;
	private LocalDate dob;
	private String gender;
	private String address;
	private int otp;
	private boolean status;

	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	byte[] picture;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Product> products;
}
