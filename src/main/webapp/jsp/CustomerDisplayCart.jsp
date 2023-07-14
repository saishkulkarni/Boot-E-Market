<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="org.jsp.emarket.dto.Item"%>
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
	List<Item> items = (List<Item>) request.getAttribute("items");
	%>
	<h1>Product Details</h1>
	<table border="2px solid black">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Image</th>
			<th>Description</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Remove</th>
		</tr>
		<%
		for (Item item : items) {
		%>
		<tr>
			<th><%=item.getId()%></th>
			<th><%=item.getName()%></th>
			<th>
				<%
				String base64 = Base64.encodeBase64String(item.getImage());
				%> <img src="data:image/jpeg;base64,<%=base64%>" alt="Picture"
				style="width: 100px; height: auto;">
			</th>
			<th><%=item.getDescription()%></th>
			<th><%=item.getQuantity()%></th>
			<th><%=item.getPrice()%></th>
			<th><a href="/customer/cart-remove/<%=item.getId()%>"><button>Remove</button></a></th>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<a href="/jsp/CustomerHome.jsp"><button>Back</button></a>
</body>
</html>