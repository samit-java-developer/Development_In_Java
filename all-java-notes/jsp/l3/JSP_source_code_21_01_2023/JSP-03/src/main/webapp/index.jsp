<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1> Registration form</h1>
		<form method="get" action='./process.jsp'>
			<table>
				<tr>
					<th>NAME</th>
					<td>
						<input type='text' name='name'/>
					</td>
				</tr>
				<tr>
					<th>AGE</th>
					<td>
						<input type='text' name='age'/>
					</td>
				</tr>
				<tr>
					<th>ADDRESS</th>
					<td>
						<input type='text' name='address'/>
					</td>
				</tr>
				<tr>
					<th></th>
					<td>
						<input type='submit' value='reg'/>
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>