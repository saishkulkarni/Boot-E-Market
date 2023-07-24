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

	@GetMapping("/products-view")
	public String fetchAllProducts(ModelMap model, HttpSession session) {
		return customerService.fetchProducts(model, session);
	}

	@GetMapping("/cart-add/{id}")
	public String addToCart(ModelMap model, HttpSession session, @PathVariable int id) {
		return customerService.addToCart(model, session, id);
	}

	@GetMapping("/cart-view")
	public String viewCart(ModelMap model, HttpSession session) {
		return customerService.viewCart(model, session);
	}

	@GetMapping("/cart-remove/{id}")
	public String removeFromCart(HttpSession session, ModelMap model, @PathVariable int id) {
		return customerService.removeFromCart(session, model, id);
	}

	@GetMapping("/wishlist-add/{id}")
	public String addToWishlist(ModelMap model, HttpSession session, @PathVariable int id) {
		return customerService.loadWishlist(model, session, id);
	}

	@GetMapping("/wishlist-create/{id}")
	public String gotoWishlist(ModelMap model, HttpSession session, @PathVariable int id) {
		return customerService.gotoWishlist(model, session, id);
	}

	@PostMapping("/wishlist-create/{id}")
	public String createWishlist(ModelMap model, HttpSession session, @PathVariable int id, @RequestParam String name) {
		return customerService.createWishlist(model, session, id, name);
	}

	@GetMapping("/wishlist-view")
	public String viewWishlist(ModelMap model, HttpSession session) {
		return customerService.viewWishlist(model, session);
	}

	@GetMapping("/wishlist/product-view/{id}")
	public String viewWishlistProducts(@PathVariable int id, ModelMap model, HttpSession session) {
		return customerService.viewWishlistProducts(id, model, session);
	}

	@GetMapping("/wishlist-add/{wid}/{pid}")
	public String addToWishList(@PathVariable int wid, @PathVariable int pid, ModelMap model, HttpSession session) {
		return customerService.addToWishList(model, session, wid, pid);
	}

	@GetMapping("/wishlist-remove/{wid}/{pid}")
	public String removeFromWishList(@PathVariable int wid, @PathVariable int pid, ModelMap model,
			HttpSession session) {
		return customerService.removeFromWishList(model, session, wid, pid);
	}

	@GetMapping("/wishlist-delete/{wid}")
	public String removeWishList(@PathVariable int wid, ModelMap model, HttpSession session) {
		return customerService.removeWishList(model, session, wid);
	}

	@GetMapping("/placeorder")
	public String checkPayment(ModelMap model, HttpSession session) {
		return customerService.checkPayment(model, session);
	}

	@PostMapping("/placeorder")
	public String checkAddress(ModelMap model, HttpSession session, @RequestParam int pid) {
		return customerService.checkAddress(model, session, pid);
	}

	@PostMapping("/sumbmitorder")
	public String submitOrder(ModelMap model, HttpSession session, @RequestParam int pid,
			@RequestParam String address) {
		return customerService.submitOrder(model, session, pid, address);
	}

	@GetMapping("/orders-view")
	public String viewOrder(ModelMap model, HttpSession session)
	{
		return customerService.viewOrders(model,session);
	}
}
