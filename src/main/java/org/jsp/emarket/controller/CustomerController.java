package org.jsp.emarket.controller;

import org.jsp.emarket.dto.Customer;
import org.jsp.emarket.helper.Login;
import org.jsp.emarket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

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

	@PostMapping("/signup")
	public String signup(Customer customer, @RequestParam String date, ModelMap model) {
		return customerService.signup(customer, date, model);
	}

	@GetMapping("/verify-otp/{email}/{token}")
	public String verifyLink(@PathVariable String email, @PathVariable String token, ModelMap model) {
		return customerService.verifyLink(email, token, model);
	}

	@PostMapping("/login")
	public String login(Login login, HttpSession session, ModelMap model) {
		return customerService.login(login, session, model);
	}

	@PostMapping("/forgot-link")
	public String forgotLink(@RequestParam String email, ModelMap model) {
		return customerService.forgotLink(email, model);
	}

	@GetMapping("/reset-password/{email}/{token}")
	public String resetPassword(@PathVariable String email, @PathVariable String token, ModelMap model) {
		return customerService.resetPassword(email, token, model);
	}

	@PostMapping("/reset-password")
	public String setPassword(@RequestParam String email, @RequestParam String password, ModelMap model) {
		return customerService.setPassword(email, password, model);
	}

}
