package org.jsp.emarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@GetMapping("/login")
	public String gotoLogin() {
		return "CustomerLogin";
	}

	@GetMapping("/forgotpassword")
	public String gotoForgotoPassword() {
		return "CustomerForgotPassword";
	}

	@GetMapping("/signup")
	public String gotoSignup() {
		return "CustomerSignup";
	}
}
