<%@page import="org.jsp.emarket.dto.Wishlist"%>
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
	List<Wishlist> wishlists = (List<Wishlist>) request.getAttribute("list");

	for (Wishlist wishlist : wishlists) {
	%>
	<br>
	<a href="/customer/wishlist/product-view/<%=wishlist.getId()%>"><button><%=wishlist.getName()%></button></a>
	<br>

	<%
	}
	%>
</body>
</html>