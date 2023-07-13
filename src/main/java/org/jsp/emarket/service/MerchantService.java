package org.jsp.emarket.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jsp.emarket.dao.MerchantDao;
import org.jsp.emarket.dto.Merchant;
import org.jsp.emarket.dto.Product;
import org.jsp.emarket.helper.SendMail;
import org.jsp.emarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Service
public class MerchantService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	MerchantDao merchantDao;

	@Autowired
	SendMail mail;

	public String signup(ModelMap model, Merchant merchant, String date, MultipartFile pic) throws IOException {
		merchant.setDob(LocalDate.parse(date));

		byte[] picture = new byte[pic.getInputStream().available()];
		pic.getInputStream().read(picture);
		merchant.setPicture(picture);

		if (merchantDao.findByEmail(merchant.getEmail()) != null
				|| merchantDao.findByMobile(merchant.getMobile()) != null) {
			model.put("fail", "Email or Mobile Should not be repeated");
			return "MerchantSignup";
		}
		int otp = new Random().nextInt(100000, 999999);
		merchant.setOtp(otp);

		if (mail.sendOtp(merchant)) {
			Merchant merchant2 = merchantDao.save(merchant);
			model.put("merchant", merchant2);
			return "SignupOtp";
		} else {
			model.put("fail", "Something went Wrong, Check email and try again");
			return "MerchantSignup";
		}
	}

	public String verifyOtp(String email, int otp, ModelMap model) {
		Merchant merchant = merchantDao.findByEmail(email);
		if (merchant.getOtp() == otp) {
			merchant.setStatus(true);
			merchant.setOtp(0);
			merchantDao.save(merchant);
			model.put("pass", "Account Created Successfully");
			return "MerchantLogin";
		} else {
			model.put("fail", "Incorrect OTP");
			model.put("extra", "Again");
			model.put("merchant", merchant);
			return "SignupOtp";
		}
	}

	public String resendOtp(String email, ModelMap model) {
		Merchant merchant = merchantDao.findByEmail(email);
		int otp = new Random().nextInt(100000, 999999);
		merchant.setOtp(otp);

		if (mail.sendOtp(merchant)) {
			Merchant merchant2 = merchantDao.save(merchant);
			model.put("merchant", merchant2);
			model.put("pass", "Otp resend Success");
			return "SignupOtp";
		} else {
			model.put("fail", "Something went Wrong, Check email and try again");
			return "MerchantSignup";
		}
	}

	public String sendForgotOtp(String email, ModelMap model) {
		Merchant merchant = merchantDao.findByEmail(email);
		if (merchant == null) {
			model.put("fail", "Email Doesn't Exist Signup First");
			return "MerchantSignup";
		} else {
			int otp = new Random().nextInt(100000, 999999);
			merchant.setOtp(otp);

			if (mail.sendOtp(merchant)) {
				Merchant merchant2 = merchantDao.save(merchant);
				model.put("merchant", merchant2);
				model.put("pass", "Otp Sent Success");
				return "ForgotOtp";
			} else {
				model.put("fail", "Something went Wrong, Check email and try again");
				return "MerchantForgotPassword";
			}
		}

	}

	public String submitForgotOtp(String email, int otp, ModelMap model) {
		Merchant merchant = merchantDao.findByEmail(email);
		if (merchant.getOtp() == otp) {
			merchant.setStatus(true);
			merchant.setOtp(0);
			merchantDao.save(merchant);
			model.put("merchant", merchant);
			model.put("pass", "Account Verified Successfully");
			return "MerchantResetPassword";
		} else {
			model.put("fail", "Incorrect OTP");
			model.put("extra", "Again");
			model.put("merchant", merchant);
			return "ForgotOtp";
		}
	}

	public String resendForgotOtp(String email, ModelMap model) {
		Merchant merchant = merchantDao.findByEmail(email);
		int otp = new Random().nextInt(100000, 999999);
		merchant.setOtp(otp);

		if (mail.sendOtp(merchant)) {
			Merchant merchant2 = merchantDao.save(merchant);
			model.put("merchant", merchant2);
			model.put("pass", "Otp resend Success");
			return "ForgotOtp";
		} else {
			model.put("fail", "Something went Wrong, Check email and try again");
			return "MerchantForgotPassword";
		}
	}

	public String setPassword(String email, String password, ModelMap model) {
		Merchant merchant = merchantDao.findByEmail(email);
		merchant.setPassword(password);
		merchantDao.save(merchant);

		model.put("pass", "Password Reset Success");
		return "MerchantLogin";
	}

	public String login(String email, String password, ModelMap model, HttpSession session) {
		Merchant merchant = merchantDao.findByEmail(email);
		if (merchant == null) {
			model.put("fail", "Incorrect Email");
			return "MerchantLogin";
		} else {
			if (merchant.getPassword().equals(password)) {
				if (merchant.isStatus()) {
					session.setAttribute("merchant", merchant);
					model.put("pass", "Login Success");
					return "MerchantHome";
				} else {
					model.put("fail", "Mail verification Pending, Click on Forgot password and verify otp");
					return "MerchantLogin";
				}
			} else {
				model.put("fail", "Incorrect Password");
				return "MerchantLogin";
			}
		}
	}

	public String addProduct(Product product, ModelMap model, MultipartFile pic, HttpSession session)
			throws IOException {
		Merchant merchant = (Merchant) session.getAttribute("merchant");

		byte[] image = new byte[pic.getInputStream().available()];
		pic.getInputStream().read(image);

		product.setImage(image);
		product.setName(merchant.getName() + "-" + product.getName());

		Product product2 = merchantDao.findProductByName(product.getName());
		if (product2 != null) {
			product.setId(product2.getId());
			product.setStock(product.getStock() + product2.getStock());
		}

		List<Product> products = merchant.getProducts();
		if (products == null) {
			products = new ArrayList<>();
		}
		products.add(product);
		merchant.setProducts(products);

		session.setAttribute("merchant", merchantDao.save(merchant));
		model.put("pass", "Product Added Successfully");
		return "MerchantHome";
	}

	public String fetchAllProducts(HttpSession session, ModelMap model) {
		Merchant merchant = (Merchant) session.getAttribute("merchant");

		if (merchant.getProducts() == null || merchant.getProducts().isEmpty()) {
			model.put("fail", "Products Not Found");
			return "MerchantHome";
		} else {
			model.put("products", merchant.getProducts());
			return "MerchantDisplayProduct";
		}
	}

	public String deleteProduct(HttpSession session, ModelMap model, int id) {
		Product product = merchantDao.findProductById(id);
		Merchant merchant = (Merchant) session.getAttribute("merchant");
		merchant.getProducts().remove(product);
		merchantDao.save(merchant);
		merchantDao.removeProduct(product);
		model.put("pass", "Deleted Successfully");
		if (merchant.getProducts() == null || merchant.getProducts().isEmpty()) {
			model.put("fail", "Products Not Found");
			return "MerchantHome";
		} else {
			model.put("products", merchant.getProducts());
			model.put("pass", "Deleted Success");
			return "MerchantDisplayProduct";
		}
	}

	public String updateProduct(ModelMap model, int id) {
		Product product = merchantDao.findProductById(id);
		model.put("product", product);
		return "MerchantUpdateProduct";
	}

	public String updateProduct(ModelMap model, Product product, HttpSession session) {
		product.setImage(merchantDao.findProductById(product.getId()).getImage());
		product.setStatus(merchantDao.findProductById(product.getId()).isStatus());
		productRepository.save(product);
		model.put("pass", "Product UpdatedSuccessfully");
		Merchant merchant1=(Merchant) session.getAttribute("merchant");
		Merchant merchant=merchantDao.findByEmail(merchant1.getEmail());
		session.setAttribute("merchant", merchant);
		if (merchant.getProducts() == null || merchant.getProducts().isEmpty()) {
			model.put("fail", "Products Not Found");
			return "MerchantHome";
		} else {
			model.put("products", merchant.getProducts());
			model.put("pass", "Updated Success");
			return "MerchantDisplayProduct";
		}
	}

}
