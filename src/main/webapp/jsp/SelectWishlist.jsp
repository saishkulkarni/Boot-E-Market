<%@page import="org.jsp.emarket.dto.Wishlist"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select WishList</title>
</head>
<body>
<h1>Select One Option</h1>

<a href="/customer/wishlist-create/${id}"><button>Create New WishList</button></a><br>

<%List<Wishlist> wishlists=(List<Wishlist>)request.getAttribute("wishlists");
if(wishlists!=null){
	for(Wishlist wishlist:wishlists){
%>
<br>
<a href="/customer/wishlist-add/<%=wishlist.getId()%>/${id}"><button><%=wishlist.getName()%></button></a><br>

<%} }%>

</body>
</html>