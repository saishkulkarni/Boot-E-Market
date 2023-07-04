package org.jsp.emarket.controller;

import org.jsp.emarket.helper.Login;
import org.jsp.emarket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	@GetMapping("/login")
	public String gotoLogin(ModelMap model)
	{
		return "AdminLogin";
	}
	
	@PostMapping("/login")
	public String login(Login login,ModelMap model,HttpSession session)
	{
		return adminService.login(login,model,session); 
	}
}
