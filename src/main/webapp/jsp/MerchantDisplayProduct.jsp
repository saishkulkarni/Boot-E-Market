<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="org.jsp.emarket.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
	<%
	List<Product> products = (List<Product>) request.getAttribute("products");
	%>
	${pass}
	<h1>Product Details</h1>
	<table border="2px solid black">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Image</th>
			<th>Price</th>
			<th>Stock</th>
			<th>Description</th>
			<th>Delete</th>
			<th>Update</th>
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
			<th><%=product.getQuantity()%></th>
			<th><%=product.getDescription()%></th>
			<th><a href="/merchant/product-delete/<%=product.getId()%>"><button>Delete</button></a></th>
			<th><a href="/merchant/product-update/<%=product.getId()%>"><button>Update</button></a></th>
		</tr>

		<%
		}
		%>
	</table>
<a href="/jsp/MerchantHome.jsp"><button>Back</button></a>
</body>
</html>