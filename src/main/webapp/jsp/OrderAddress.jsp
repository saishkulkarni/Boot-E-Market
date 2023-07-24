<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Your Current Address
	<br>
	<form action="/customer/sumbmitorder" method="post">
		<input type="text" name="pid" value="${pid}" hidden="true"><br>
		<textarea name="address" id="ta" rows="5" cols="30">${address}</textarea>
		<button type="button" onclick="change()">Change Address</button>
		<br>
		<button>Place</button>
		<br>
	</form>

	<script type="text/javascript">
		function change() {
			document.getElementById('ta').disabled = false;
		}
	</script>
</body>
</html>