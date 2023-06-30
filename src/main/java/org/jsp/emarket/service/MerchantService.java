package org.jsp.emarket.service;

import java.io.IOException;
import java.time.LocalDate;

import org.jsp.emarket.dao.MerchantDao;
import org.jsp.emarket.dto.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;


@Service
public class MerchantService {
	
	@Autowired
	MerchantDao merchantDao;

	public String signup(ModelMap model,Merchant merchant, String date, MultipartFile pic) throws IOException {
		merchant.setDob(LocalDate.parse(date));
		
		byte[] picture=new byte[pic.getInputStream().available()];
		pic.getInputStream().read(picture);
		merchant.setPicture(picture);
		
		if(merchantDao.findByEmail(merchant.getEmail())!=null || merchantDao.findByMobile(merchant.getMobile())!=null)
		{
			model.put("fail", "Email or Mobile Should not be repeated");
			return "/merchant/signup";
		}
		
		//Logic for generating otp
		//Logic For Sending Mail
		
		merchantDao.save(merchant);
		
		return null;
		
	}

}
