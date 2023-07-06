package org.jsp.emarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@GetMapping("/")
	public String gotoHome() {
		return "Home";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap model) {
		session.invalidate();
		model.put("fail", "Logout Success");
		return "Home";
	}

}
