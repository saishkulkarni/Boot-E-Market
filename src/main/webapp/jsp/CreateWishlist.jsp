<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/customer/wishlist-create/${id}" method="post">
Enter WishList Name:<input type="text" name="name">
<button>Create</button>
</form>
</body>
</html>