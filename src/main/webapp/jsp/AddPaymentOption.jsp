<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${fail}
	<form action="/admin/payment-add" method="post">
		Enter Payment Method Name:<input type="text" name="name">
		<button>Add</button>
		<button type="reset">Cancel</button>
	</form>
	<br>
	<a href="/jsp/AdminHome.jsp"><button>Back</button></a>
</body>
</html>