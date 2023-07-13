package org.jsp.emarket.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jsp.emarket.dao.CustomerDao;
import org.jsp.emarket.dto.Customer;
import org.jsp.emarket.dto.Item;
import org.jsp.emarket.dto.Product;
import org.jsp.emarket.dto.ShoppingCart;
import org.jsp.emarket.helper.Login;
import org.jsp.emarket.helper.SendMail;
import org.jsp.emarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jakarta.servlet.http.HttpSession;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	SendMail mail;

	@Autowired
	Item item;

	public String signup(Customer customer, String date, ModelMap model) {
		customer.setDob(LocalDate.parse(date));

		if (customerDao.findByEmail(customer.getEmail()) != null
				|| customerDao.findByMobile(customer.getMobile()) != null) {
			model.put("fail", "Email or Mobile Should not be repeated");
			return "CustomerSignup";
		}
		String token = "ekart" + new Random().nextInt(10000, 999999);
		customer.setToken(token);

		if (mail.sendLink(customer)) {
			customerDao.save(customer);
			model.put("pass", "Verification Link sent to Email click it to create account");
			return "CustomerLogin";
		} else {
			model.put("fail", "Something went Wrong, Check email and try again");
			return "CustomerSignup";
		}
	}

	public String verifyLink(String email, String token, ModelMap model) {
		Customer customer = customerDao.findByEmail(email);
		if (customer.getToken().equals(token)) {
			customer.setStatus(true);
			customer.setToken(null);
			customerDao.save(customer);
			model.put("pass", "Account Created Successfully");
			return "CustomerLogin";
		} else {
			model.put("fail", "Incorrect Link");
			return "CustomerLogin";
		}
	}

	public String login(Login login, HttpSession session, ModelMap model) {
		Customer customer = customerDao.findByEmail(login.getEmail());
		if (customer == null) {
			model.put("fail", "Incorrect Email");
			return "CustomerLogin";
		} else {
			if (customer.getPassword().equals(login.getPassword())) {
				if (customer.isStatus()) {
					session.setAttribute("customer", customer);
					model.put("pass", "Login Success");
					return "CustomerHome";
				} else {
					model.put("fail", "Mail verification Pending, Click on Forgot password and verify otp");
					return "CustomerLogin";
				}
			} else {
				model.put("fail", "Incorrect Password");
				return "CustomerLogin";
			}
		}
	}

	public String forgotLink(String email, ModelMap model) {
		Customer customer = customerDao.findByEmail(email);
		if (customer == null) {
			model.put("fail", "Incorrect Email");
			return "CustomerForgotPassword";
		} else {
			String token = "ekart" + new Random().nextInt(10000, 999999);
			customer.setToken(token);
			customerDao.save(customer);
			if (mail.sendResetLink(customer)) {
				model.put("pass", "Verification Link sent to Email click it to create account");
				return "CustomerLogin";
			} else {
				model.put("fail", "Something went Wrong, Check email and try again");
				return "CustomerSignup";
			}
		}

	}

	public String resetPassword(String email, String token, ModelMap model) {
		Customer customer = customerDao.findByEmail(email);
		if (customer.getToken().equals(token)) {
			customer.setStatus(true);
			customer.setToken(null);
			model.put("customer", customerDao.save(customer));
			return "CustomerResetPassword";
		} else {
			model.put("fail", "Something went wrong");
			return "CustomerLogin";
		}
	}

	public String setPassword(String email, String password, ModelMap model) {
		Customer customer = customerDao.findByEmail(email);
		customer.setPassword(password);
		customerDao.save(customer);

		model.put("pass", "Password Reset Success");
		return "CustomerLogin";
	}

	public String fetchProducts(ModelMap model, HttpSession session) {
		List<Product> list = productRepository.findByStatus(true);
		if (session.getAttribute("customer") == null) {
			model.put("fail", "Session Expired Login Again");
			return "CustomerLogin";
		} else {
			if (list.isEmpty()) {
				model.put("fail", "No Products Present");
				return "CustomerHome";
			} else {
				model.put("products", list);
				return "CustomerDisplayProducts";
			}
		}
	}

	public String addToCart(ModelMap model, HttpSession session, int id) {
		Customer customer = (Customer) session.getAttribute("customer");
		if (customer == null) {
			model.put("fail", "First Login to Add Product to Cart");
			return "CustomerLogin";
		} else {
			Product product = productRepository.findById(id).orElse(null);

			item.setDescription(product.getDescription());
			item.setImage(product.getImage());
			item.setName(product.getName());
			item.setPrice(product.getPrice());
			item.setQuantity(1);

			ShoppingCart cart = customer.getShoppingCart();
			if (cart == null) {
				cart = new ShoppingCart();
			}
			List<Item> items = cart.getItems();
			if (items == null) {
				items = new ArrayList<>();
			}
			items.add(item);

			cart.setItems(items);

			customer.setShoppingCart(cart);

			customerDao.save(customer);

			model.put("pass", "Product Added Success");
			return "CustomerHome";
		}
	}

	public String viewCart(ModelMap model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		if (customer == null) {
			model.put("fail", "First Login to view Cart");
			return "CustomerLogin";
		} else {

			if (customer.getShoppingCart() == null || customer.getShoppingCart().getItems() == null
					|| customer.getShoppingCart().getItems().isEmpty()) {
				model.put("fail", "No Items in cart");
				return "CustomerHome";
			} else {
				List<Item> items = customer.getShoppingCart().getItems();
				model.put("items", items);
				return "CustomerDisplayCart";
			}
		}

	}

}
