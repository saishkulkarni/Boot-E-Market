<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body>

	<div class="header"></div>

	<div class="container">
		${pass} 	${fail} <br>
		<a href="/admin/product-approve"><button>Approve Product</button></a>
	
		<a href="/admin/customer-view"><button>View All Customer</button></a>
		
		<a href="/admin/merchant-view"><button>View All Merchant</button></a>
		
		<a href="/admin/payment-add"><button>Add Payment Method</button></a>
		
		<a href="/logout"><button>Logout</button></a>
	</div>

	<div class="footer"></div>

	<script type="text/javascript"
		src="/webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>

</body>
</html>