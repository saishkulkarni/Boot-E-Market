<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Home</title>
</head>
<body>
	${pass}
	<br>
	<a href="/customer/products-view"><button>View Products</button></a>
	<a href="/customer/cart-view"><button>View Cart</button></a>
	<a href="/customer/wishlist-view"><button>View Wishlist</button></a>
	<a href="/customer/orders-view"><button>View Orders</button></a>
	<a href="/logout"><button>Logout</button></a>
</body>
</html>