<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<h1>Hello ${merchant.getName()}, Enter Below Details</h1>
<form action="/merchant/product-add" method="post" enctype="multipart/form-data">
Name:<input type="text" name="name"><br>
Price:<input type="text" name="price"><br>
Quantity:<input type="number" name="stock"><br>
Image:<input type="file" name="pic"><br>
Description:<input type="text" name="description"><br>
<button>Add Product</button><button type="reset">Cancel</button>
</form>
<br>
<a href="/jsp/MerchantHome.jsp"><button>Back</button></a>
</body>
</html>