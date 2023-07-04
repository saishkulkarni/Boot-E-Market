package org.jsp.emarket.service;

import org.jsp.emarket.helper.Login;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminService {

	public String login(Login login, ModelMap model,HttpSession session) {
		model.put("name", "Admin");
		if(login.getEmail().equals("admin"))
		{
			if(login.getPassword().equals("admin"))
			{
				session.setAttribute("admin", "admin");
				model.put("pass", "Login Success");
				return "AdminHome";
			}
			else {
				model.put("fail", "Incorrect Password");
			}
		}
		else {
			model.put("fail", "Incorrect Email");
		}
		return "AdminLogin";
	}

}
