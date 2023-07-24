<%@page import="java.util.List"%>
<%@page import="org.jsp.emarket.dto.Payment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Select One Payment Option</h1>
<form action="/customer/placeorder" method="post">
<%List<Payment> list=(List<Payment>)request.getAttribute("list"); %>
<%for(Payment payment:list) {%>
<input type="radio" name="pid" value="<%=payment.getId()%>"><%=payment.getName() %>
<br>
<%} %>
<button>Submit</button>
</form>
</body>
</html>