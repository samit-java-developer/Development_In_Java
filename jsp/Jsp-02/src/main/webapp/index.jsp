<%!Integer id;
	String name;
	String address;
	Integer age;%>

<%
id = Integer.parseInt(request.getParameter("id"));
name = request.getParameter("name");
address = request.getParameter("address");
age = Integer.parseInt(request.getParameter("age"));
%>


<jsp:useBean id="student" class="com.samit.Student">
	<%-- <jsp:setProperty property="id" name="student" value='<%=id%>' />
	<jsp:setProperty property="name" name="student" value='<%=name%>' />
	<jsp:setProperty property="address" name="student" value='<%=address%>' />
	<jsp:setProperty property="age" name="student" value='<%=age%>' /> --%>

	<%--if the instance variable and input are same --%>
	<jsp:setProperty property="*" name="student" />
</jsp:useBean>



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body>

	<center>
		<h1>Student Details</h1>
		<table border="1">
			<tr>
				<th>Id</th>
				<td><jsp:getProperty property="id" name="student" /></td>
			</tr>
			<tr>
				<th>Name</th>
				<td><jsp:getProperty property="name" name="student" /></td>
			</tr>
			<tr>
				<th>Address</th>
				<td><jsp:getProperty property="address" name="student" /></td>
			</tr>
			<tr>
				<th>Age</th>
				<td><jsp:getProperty property="age" name="student" /></td>
			</tr>
		</table>
	</center>



</body>
</html>