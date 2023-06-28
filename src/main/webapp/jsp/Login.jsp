<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="container">
	<h1>${fail}</h1>
		<h2>This is Admin Login Page</h2>
		<form action="/admin/login" method="post">
			Email: <input type="text" name="email"><br> Password:<input
				type="password" name="password"><br>
			<button>Login</button>
			<button type="reset">Cancel</button>
		</form>
	</div>
</body>
</html>