<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="org.jsp.emarket.dto.Customer"%>
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
	List<Customer> customers = (List<Customer>) request.getAttribute("customers");
	%>
	<h1>Customer Details</h1>
	<table border="2px solid black">
		<tr>
			<th>Email</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Date of Birth</th>
			<th>Address</th>
		</tr>
		<%
		for (Customer customer : customers) {
		%>
		<tr>
			<th><%=customer.getEmail()%></th>
			<th><%=customer.getName()%></th>
			<th><%=customer.getGender()%></th>
			<th><%=customer.getDob()%></th>
			<th><%=customer.getAddress()%></th>
		</tr>

		<%
		}
		%>
	</table>
	<br>
	<br>
	<a href="/jsp/AdminHome.jsp"><Button>Back</Button> </a>
</body>
</html>