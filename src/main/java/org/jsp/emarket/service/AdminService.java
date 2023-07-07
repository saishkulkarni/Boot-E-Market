package org.jsp.emarket.service;

import java.util.List;

import org.jsp.emarket.dto.Product;
import org.jsp.emarket.helper.Login;
import org.jsp.emarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminService {
	
	@Autowired
	ProductRepository productRepository;

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

}
