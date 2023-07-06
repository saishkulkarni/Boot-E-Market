package org.jsp.emarket.helper;

import org.jsp.emarket.dto.Customer;
import org.jsp.emarket.dto.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class SendMail {

	@Autowired
	JavaMailSender mailSender;

	public boolean sendOtp(Merchant merchant) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

		try {
			helper.setFrom("E-Market");
			helper.setTo(merchant.getEmail());
			helper.setSubject("Verify Email for Account Creation");

			String gender = null;
			if (merchant.getGender().equals("male"))
				gender = "Mr. ";
			else
				gender = "Ms. ";

			String content = "<h1>Hello " + gender + " " + merchant.getName() + ",<h1>"
					+ "<h1>Thank you for showing interest in creating an account with us we look forward to collabrate enter the below otp to verify your account</h1>"
					+ "<h1>OTP: " + merchant.getOtp();

			helper.setText(content, true);
			mailSender.send(mimeMessage);
			return true;

		} catch (MessagingException e) {
			return false;
		}

	}

	public boolean sendLink(Customer customer) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

		try {
			helper.setFrom("E-Market");
			helper.setTo(customer.getEmail());
			helper.setSubject("Verify Email for Account Creation");

			String gender = null;
			if (customer.getGender().equals("male"))
				gender = "Mr. ";
			else
				gender = "Ms. ";

			String link = "http://localhost:8055/customer/verify-otp/" + customer.getEmail() + "/"
					+ customer.getToken();
			;
			String content = "<h1>Hello " + gender + " " + customer.getName() + ",<h1>"
					+ "<h1>Thank you for showing interest in creating an account with us we look forward to collabrate click the below link to verify your account</h1>"
					+ "<h1>Link: <a href='" + link + "'>Click</a> </h1>";

			helper.setText(content, true);
			mailSender.send(mimeMessage);
			return true;

		} catch (MessagingException e) {
			return false;
		}
	}

	public boolean sendResetLink(Customer customer) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

		try {
			helper.setFrom("E-Market");
			helper.setTo(customer.getEmail());
			helper.setSubject("Verify Email for Account Creation");

			String gender = null;
			if (customer.getGender().equals("male"))
				gender = "Mr. ";
			else
				gender = "Ms. ";

			String link = "http://localhost:8055/customer/reset-password/" + customer.getEmail() + "/"
					+ customer.getToken();
			;
			String content = "<h1>Hello " + gender + " " + customer.getName() + ",<h1>"
					+ "<h1>Thank you for showing interest in creating an account with us we look forward to collabrate click the below link to verify your account</h1>"
					+ "<h1>Link: <a href='" + link + "'>Click</a> </h1>";

			helper.setText(content, true);
			mailSender.send(mimeMessage);
			return true;

		} catch (MessagingException e) {
			return false;
		}
	}
}
