<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
</head>
<body>

	<div class="header"></div>

	<div class="container">
		<form action="/merchant/forgotpassword" method="post">
			Enter Email: <input type="email" name="email"><br>
			<button>Send OTP</button>
			<button type="reset">Cancel</button>
		</form>
		<br>
		<br> <a href="/merchant/login"><button>Back</button></a>
	</div>

	<div class="footer"></div>

</body>
</html>