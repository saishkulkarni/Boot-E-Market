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
		${fail }
		<form action="/customer/forgot-link" method="post">
			Enter Email: <input type="email" name="email"><br>
			<button>Send Link</button>
			<button type="reset">Cancel</button>
		</form>
		<br> <br> <a href="/customer/login"><button>Back</button></a>
	</div>

	<div class="footer"></div>
</body>
</html>