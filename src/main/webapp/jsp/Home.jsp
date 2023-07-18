<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>E-Market</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/5.3.0/css/bootstrap.min.css">
</head>

<body>

	<div class="header"></div>

	<div class="container">
		<h1>${fail}</h1>
		<h1>${pass}</h1>
		<a href="/admin/login" class="btn btn-success">Admin</a> <a
			href="/merchant/login" class="btn btn-warning">Merchant</a> <a
			href="/customer/login" class="btn btn-danger">Customer</a>
	</div>

	<div class="footer"></div>

	<script type="text/javascript"
		src="/webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
</body>
</html>