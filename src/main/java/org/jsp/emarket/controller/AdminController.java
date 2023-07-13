package org.jsp.emarket.controller;

import org.jsp.emarket.dto.Payment;
import org.jsp.emarket.helper.Login;
import org.jsp.emarket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("/login")
	public String gotoLogin(ModelMap model) {
		return "AdminLogin";
	}

	@PostMapping("/login")
	public String login(Login login, ModelMap model, HttpSession session) {
		return adminService.login(login, model, session);
	}

	@GetMapping("/product-approve")
	public String viewAllProducts(HttpSession session, ModelMap model) {

		if (session.getAttribute("admin") == null) {
			model.put("fail", "Session Expied Login Again");
			return "AdminLogin";
		} else {
			return adminService.fetchAllProducts(model);
		}
	}

	@GetMapping("/product-changestatus/{id}")
	public String changeStatus(@PathVariable int id,ModelMap model, HttpSession session) {
		if (session.getAttribute("admin") == null) {
			model.put("fail", "Session Expied Login Again");
			return "AdminLogin";
		} else {
			return adminService.changeStatus(model,id);
		}
	}
	
	@GetMapping("/customer-view")
	public String viewCustomers(ModelMap model, HttpSession session)
	{
		if (session.getAttribute("admin") == null) {
			model.put("fail", "Session Expied Login Again");
			return "AdminLogin";
		} else {
			return adminService.viewCustomers(model);
		}
	}
	
	@GetMapping("/merchant-view")
	public String viewMerchants(ModelMap model, HttpSession session)
	{
		if (session.getAttribute("admin") == null) {
			model.put("fail", "Session Expied Login Again");
			return "AdminLogin";
		} else {
			return adminService.viewMerchants(model);
		}
	}
	
	@GetMapping("/payment-add")
	public String loadAddPaymentPage(ModelMap model, HttpSession session)
	{
		if (session.getAttribute("admin") == null) {
			model.put("fail", "Session Expied Login Again");
			return "AdminLogin";
		} else {
			return "AddPaymentOption";
		}
	}
	
	@PostMapping("/payment-add")
	public String addPaymentPage(Payment payment,ModelMap model, HttpSession session)
	{
		if (session.getAttribute("admin") == null) {
			model.put("fail", "Session Expied Login Again");
			return "AdminLogin";
		} else {
			return adminService.addPaymentPage(payment,model);
		}
	}  
}
