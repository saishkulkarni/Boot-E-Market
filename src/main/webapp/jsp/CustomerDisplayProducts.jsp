<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="org.jsp.emarket.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Product> products = (List<Product>) request.getAttribute("products");
	%>
	<h1>Product Details</h1>
	<table border="2px solid black">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Image</th>
			<th>Price</th>
			<th>Stock</th>
			<th>Description</th>
			<th>Add to Cart</th>
			<th>Add to Wishlist</th>
		</tr>
		<%
		for (Product product : products) {
		%>
		<tr>
			<th><%=product.getId()%></th>
			<th><%=product.getName()%></th>
			<th>
				<%
				String base64 = Base64.encodeBase64String(product.getImage());
				%> <img src="data:image/jpeg;base64,<%=base64%>" alt="Picture"
				style="width: 100px; height: auto;">
			</th>
			<th><%=product.getPrice()%></th>
			<th><%=product.getStock()%></th>
			<th><%=product.getDescription()%></th>
			<th><a href="/customer/cart-add/<%=product.getId()%>"><button>Add</button></a></th>
			<th><a href="/customer/wishlist-add/<%=product.getId()%>"><button>Add</button></a></th>	
		</tr>

		<%
		}
		%>
	</table>
	<br>   
	<br>
	<a href="/jsp/CustomerHome.jsp"><Button>Back</Button> </a>
</body>
</html>