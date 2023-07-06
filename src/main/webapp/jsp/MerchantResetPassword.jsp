<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter New Password</title>
</head>
<body>
	<h1>Hello ${merchant.getName()} your OTP Verification is Success</h1>
	<h2>Enter New Password</h2>
	<form action="/merchant/reset-password" method="post">
		<input type="hidden" name="email" value="${merchant.getEmail()}"
			required="required"> <input type="password" name="password">
		<button>Reset Password</button>
		<button type="reset">Cancel</button>
	</form>
</body>
</html>