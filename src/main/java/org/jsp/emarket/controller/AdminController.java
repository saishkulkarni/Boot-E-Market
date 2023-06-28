package org.jsp.emarket.controller;

import org.jsp.emarket.helper.Login;
import org.jsp.emarket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	@GetMapping("/login")
	public String gotoLogin() {
		return "Login";
	}

	@PostMapping("/login")
	public String login(Login login,ModelMap map) {
		if(adminService.login(login))
		{
			map.put("pass", "Admin Login Success");
			return "AdminHome";
		}
		else
		{
		map.put("fail", "Invalid Credentials");
		return "Login";
		}
	}
}
