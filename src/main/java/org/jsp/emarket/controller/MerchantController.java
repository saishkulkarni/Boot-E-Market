package org.jsp.emarket.controller;

import java.io.IOException;

import org.jsp.emarket.dto.Merchant;
import org.jsp.emarket.dto.Product;
import org.jsp.emarket.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

	@Autowired
	MerchantService merchantService;

	@GetMapping("/login")
	public String gotoLogin() {
		return "MerchantLogin";
	}

	@GetMapping("/forgotpassword")
	public String gotoForgotoPassword() {
		return "MerchantForgotPassword";
	}

	@GetMapping("/signup")
	public String gotoSignup() {
		return "MerchantSignup";
	}

	@PostMapping("/signup")
	public String signup(ModelMap model, Merchant merchant, @RequestParam String date, @RequestParam MultipartFile pic)
			throws IOException {
		return merchantService.signup(model, merchant, date, pic);
	}

	@PostMapping("/verify-otp/{email}")
	public String verifyOtp(@PathVariable String email, @RequestParam int otp, ModelMap model) {
		return merchantService.verifyOtp(email, otp, model);
	}

	@GetMapping("/resend-otp/{email}")
	public String resendOtp(@PathVariable String email, ModelMap model) {
		return merchantService.resendOtp(email, model);
	}

	@PostMapping("/forgotpassword")
	public String sendForgotOtp(@RequestParam String email, ModelMap model) {
		return merchantService.sendForgotOtp(email, model);
	}

	@PostMapping("/forgot-otp/{email}")
	public String submitForgotOtp(@PathVariable String email, @RequestParam int otp, ModelMap model) {
		return merchantService.submitForgotOtp(email, otp, model);
	}

	@GetMapping("/resend-forgot-otp/{email}")
	public String resendForgotOtp(@PathVariable String email, ModelMap model) {
		return merchantService.resendForgotOtp(email, model);
	}

	@PostMapping("/reset-password")
	public String setPassword(@RequestParam String email, @RequestParam String password, ModelMap model) {
		return merchantService.setPassword(email, password, model);
	}

	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, ModelMap model,
			HttpSession session) {
		return merchantService.login(email, password, model, session);
	}
	
	@GetMapping("/product-add")
	public String gotoAddProductPage(HttpSession session,ModelMap model)
	{
		if(session.getAttribute("merchant")==null)
		{
			model.put("fail", "Session Expied Login Again");
			return "MerchantLogin";
		}
		else {
			model.put("merchant", session.getAttribute("merchant"));
			return "AddProduct";
		}
	}
	
	@PostMapping("/product-add")
	public String addProduct(HttpSession session,ModelMap model,Product product,@RequestParam MultipartFile pic) throws IOException
	{
		if(session.getAttribute("merchant")==null)
		{
			model.put("fail", "Session Expied Login Again");
			return "MerchantLogin";
		}
		else {
			return merchantService.addProduct(product,model,pic,session);
		}
	}
	
	@GetMapping("/product-view")
	public String fetchAllProducts(HttpSession session,ModelMap model)
	{
		if(session.getAttribute("merchant")==null)
		{
			model.put("fail", "Session Expied Login Again");
			return "MerchantLogin";
		}
		else {
			return merchantService.fetchAllProducts(session,model);
		}
	}
	
	@GetMapping("/product-delete/{id}")
	public String deleteProduct(@PathVariable int id,HttpSession session,ModelMap model)
	{
		if(session.getAttribute("merchant")==null)
		{
			model.put("fail", "Session Expied Login Again");
			return "MerchantLogin";
		}
		else {
			return merchantService.deleteProduct(session,model,id);
		}
	}
	
	@GetMapping("/product-update/{id}")
	public String updateProduct(@PathVariable int id,HttpSession session,ModelMap model)
	{
		if(session.getAttribute("merchant")==null)
		{
			model.put("fail", "Session Expied Login Again");
			return "MerchantLogin";
		}
		else {
			return merchantService.updateProduct(model,id);
		}
	}
	
	@PostMapping("/product-update")
	public String updateProduct(Product product,HttpSession session,ModelMap model)
	{
		if(session.getAttribute("merchant")==null)
		{
			model.put("fail", "Session Expied Login Again");
			return "MerchantLogin";
		}
		else {
			return merchantService.updateProduct(model,product,session);
		}
	}
	
	
}
