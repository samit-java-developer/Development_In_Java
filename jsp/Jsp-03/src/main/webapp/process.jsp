<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Processing....</title>
</head>
<body>
	<%!String name;
	String address;
	Integer age;

	static Connection con = null;
	static Statement stmt = null;
	ResultSet rs = null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/enterprisejavabatch";
			String user = "root";
			String password = "samit@123";
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}%>

	<%
	name = request.getParameter("name");
	address = request.getParameter("address");
	age = Integer.parseInt(request.getParameter("age"));
	rs = stmt.executeQuery("select * from users where name='" + name + "'");
	boolean isAvailble = rs.next();
	if (isAvailble) {
	%>
	<jsp:forward page="existed.jsp"></jsp:forward>
	<%
	} else {
	int rowAfftected = stmt.executeUpdate(
			String.format("insert into users(`name`,`address`,`age`)values('%s','%s',%d)", name, address, age));
	if (rowAfftected == 1) {
	%>
	<jsp:forward page="sucess.jsp"></jsp:forward>
	<%
	} else {
	%>
	<jsp:forward page="failure.jsp"></jsp:forward>
	<%
	}
	}
	%>

</body>
</html>