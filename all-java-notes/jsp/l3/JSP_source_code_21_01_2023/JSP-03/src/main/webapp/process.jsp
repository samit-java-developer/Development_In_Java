<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OUTPUT</title>
</head>
<body>
	<%!String name;
	String address;
	Integer age;

	//Resources for JDBC
	static Connection connection = null;
	static Statement stmt = null;
	ResultSet resultSet = null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/enterprisejavabatch";
			String username = "root";
			String password = "root123";
			connection = DriverManager.getConnection(url, username, password);
			stmt = connection.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}%>
	<%
		name = request.getParameter("name");
		age = Integer.parseInt(request.getParameter("age"));
		address = request.getParameter("address");
	
		resultSet = stmt.executeQuery("select id,name,age,address from users where name ='" + name + "'");
		boolean available = resultSet.next();
		if (available == true) {
	%>
			<jsp:forward page="./existed.jsp" />
	<%
		}
		else 
		{
			String sqlInsertQuery =String.format("insert into users(`name`,`age`,`address`)values('%s',%d,'%s')",name,age,address);
			int rowAffected = stmt.executeUpdate(sqlInsertQuery);
			if(rowAffected == 1){
	%>
				<jsp:forward page="./success.jsp" />
	<%}
			else{
	%>
				<jsp:forward page="./failure.jsp" />
	<%}
		}
	%>
		
</body>
</html>