<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<form action="./process.jsp">
		<table>
			<tr>
				<th>Name</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>Address</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<th>Age</th>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>