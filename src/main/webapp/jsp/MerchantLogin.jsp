<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Merchant Login</title>
</head>
<body>

	<div class="header"></div>


	<div class="container">
		<h1>${fail}</h1>
		<h1>${pass}</h1>
		<div class="form">
			<form action="/merchant/login" method="post">
				Email: <input type="text" name="email"><br> Password: <input
					type="password" name="password"><br>
				<button>Login</button>
				<button type="reset">Cancel</button>
			</form>
			<br> <a href="/merchant/forgotpassword">Forgot Password?</a> <br>
			<br> <a href="/merchant/signup">New?Click here to Signup</a> <br>
			<br> <a href="/"><button>Back</button></a>
		</div>
	</div>

	<div class="footer"></div>

	<script type="text/javascript"
		src="/webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>

</body>
</html>