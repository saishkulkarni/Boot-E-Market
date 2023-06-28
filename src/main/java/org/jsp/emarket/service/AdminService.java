package org.jsp.emarket.service;

import org.jsp.emarket.helper.Login;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	public boolean login(Login login) {
		if (login.getEmail().equals("admin") && login.getPassword().equals("admin"))
			return true;
		else
			return false;
	}

}
