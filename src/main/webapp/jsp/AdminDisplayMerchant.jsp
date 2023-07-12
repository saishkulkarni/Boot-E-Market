<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="org.jsp.emarket.dto.Merchant"%>
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
	List<Merchant> merchants = (List<Merchant>) request.getAttribute("merchants");
	%>
	<h1>Merchant Details</h1>
	<table border="2px solid black">
		<tr>
			<th>Email</th>
			<th>Name</th>
			<th>Image</th>
			<th>Gender</th>
			<th>Date of Birth</th>
			<th>Address</th>
		</tr>
		<%
		for (Merchant merchant : merchants) {
		%>
		<tr>
			<th><%=merchant.getEmail()%></th>
			<th><%=merchant.getName()%></th>
			<th>
				<%
				String base64 = Base64.encodeBase64String(merchant.getPicture());
				%> <img src="data:image/jpeg;base64,<%=base64%>" alt="Picture"
				style="width: 100px; height: auto;">
			</th>
			<th><%=merchant.getGender()%></th>
			<th><%=merchant.getDob()%></th>
			<th><%=merchant.getAddress()%></th>
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