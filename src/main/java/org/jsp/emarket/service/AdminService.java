package org.jsp.emarket.service;

import java.util.List;

import org.jsp.emarket.dto.Customer;
import org.jsp.emarket.dto.Merchant;
import org.jsp.emarket.dto.Payment;
import org.jsp.emarket.dto.Product;
import org.jsp.emarket.helper.Login;
import org.jsp.emarket.repository.CustomerRepository;
import org.jsp.emarket.repository.MerchantRepository;
import org.jsp.emarket.repository.PaymentRepository;
import org.jsp.emarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	MerchantRepository merchantRepository;
	
	@Autowired
	PaymentRepository paymentRepository; 

	public String login(Login login, ModelMap model, HttpSession session) {
		model.put("name", "Admin");
		if (login.getEmail().equals("admin")) {
			if (login.getPassword().equals("admin")) {
				session.setAttribute("admin", "admin");
				model.put("pass", "Login Success");
				return "AdminHome";
			} else {
				model.put("fail", "Incorrect Password");
			}
		} else {
			model.put("fail", "Incorrect Email");
		}
		return "AdminLogin";
	}

	public String fetchAllProducts(ModelMap model) {
		List<Product> list=productRepository.findAll();
		if(list.isEmpty())
		{
			model.put("fail", "No Products Found");
			return "AdminHome";
		}
		else {
			model.put("products", list);
			return "AdminDisplayProduct";
		}
	}

	public String changeStatus(ModelMap model, int id) {
		Product product=productRepository.findById(id).orElse(null);
		if(product.isStatus())
		{
			product.setStatus(false);
		}
		else {
			product.setStatus(true);
		}
		productRepository.save(product);
		model.put("pass", "Status Changed Success");
		List<Product> list=productRepository.findAll();
		if(list.isEmpty())
		{
			model.put("fail", "No Products Found");
			return "AdminHome";
		}
		else {
			model.put("products", list);
			return "AdminDisplayProduct";
		}
	}

	public String viewCustomers(ModelMap model) {
		List<Customer> list=customerRepository.findAll();
		if(list.isEmpty())
		{
			model.put("fail", "No Customer Data Found");
			return "AdminHome";
		}
		else {
			model.put("customers", list);
			return "AdminDisplayCustomer";
		}
	}
	
	public String viewMerchants(ModelMap model) {
		List<Merchant> list=merchantRepository.findAll();
		if(list.isEmpty())
		{
			model.put("fail", "No Merchant Data Found");
			return "AdminHome";
		}
		else {
			model.put("merchants", list);
			return "AdminDisplayMerchant";
		}
	}

	public String addPaymentPage(Payment payment, ModelMap model) {
		
		Payment payment2=paymentRepository.findByName(payment.getName());
		if(payment2==null)
		{
		paymentRepository.save(payment);
		model.put("pass", "Payment method Added Successfully");
		return "AdminHome";
		}
		else {
			model.put("fail", "Payment method Already Exists");
			return "AddPaymentOption";
		}
	}

}
