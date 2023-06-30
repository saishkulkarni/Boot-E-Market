package org.jsp.emarket.controller;

import java.io.IOException;

import org.jsp.emarket.dto.Merchant;
import org.jsp.emarket.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


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
	public String signup(ModelMap model,Merchant merchant,@RequestParam String date,@RequestParam MultipartFile pic) throws IOException
	{
		return merchantService.signup(model,merchant,date,pic);
	}
}
