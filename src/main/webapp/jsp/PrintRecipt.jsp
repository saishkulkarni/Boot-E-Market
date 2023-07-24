<%@page import="org.jsp.emarket.dto.Item"%>
<%@page import="java.util.List"%>
<%@page import="org.jsp.emarket.dto.ShoppingOrder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${pass}
	<br> Customer Name:${customer.getName() }
	<br> Payment Method:${order.getPaymentMode()}
	<br> Expected Delivery Date:${order.getDeliveryDate()}
	<br>
	<%
	ShoppingOrder order = (ShoppingOrder) request.getAttribute("order");
	List<Item> items = order.getItems();
	%>
	<table>
		<tr>
			<th>Name</th>

			<th>Quantity</th>

			<th>Price</th>
		</tr>

		<%
		for (Item item : items) {
		%>
		<tr>
			<th><%=item.getName()%></th>

			<th><%=item.getQuantity()%></th>

			<th><%=item.getPrice()%></th>
		</tr>
		<%
		}
		%>
	</table>
	Total Price:${order.getTotalPrice()}
	<br>
	<button onclick="window.print()">Print</button>
	<br>
	<a href="/jsp/CustomerHome.jsp"><button>Back</button></a>
</body>
</html>