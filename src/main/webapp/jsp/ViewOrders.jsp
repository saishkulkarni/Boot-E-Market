<%@page import="org.jsp.emarket.dto.Item"%>
<%@page import="org.jsp.emarket.dto.ShoppingOrder"%>
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
	List<ShoppingOrder> orders = (List<ShoppingOrder>) request.getAttribute("orders");
	%>
	<table>
		<tr>
			<th>Order Id</th>
			<th>Order Date</th>
			<th>Delivery Date</th>
			<th>PAyment Method</th>
			<th>Items</th>
			<th>Total Amount</th>
		</tr>
		<%
		for (ShoppingOrder order : orders) {
		%>
		<tr>
			<th><%=order.getId()%></th>
			<th><%=order.getDeliveryDate().minusDays(3)%></th>
			<th><%=order.getDeliveryDate()%></th>
			<th><%=order.getPaymentMode()%></th>
			<th>
				<%
				for (Item item : order.getItems()) {
				%> <%=item.getName()%> <%
 }
 %>
			</th>
			<th><%=order.getTotalPrice()%></th>
		</tr>
		<%
		}
		%>

	</table>
	<br>
	<a href="/jsp/CustomerHome.jsp"><button>Back</button></a>
</body>
</html>