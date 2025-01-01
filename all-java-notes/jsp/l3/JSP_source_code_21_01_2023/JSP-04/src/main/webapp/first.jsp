<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First Page</title>
</head>
<body>
	<h1>Welcome to iNeuron + Physics Wallah</h1>
	<jsp:include page="second.jsp">
		<jsp:param value="Java" name="sub1"/>
		<jsp:param value="JEE" name="sub2"/>
		<jsp:param value="Framework" name="sub3"/>
		<jsp:param value="Algorithms" name="sub4"/>
		<jsp:param value="System Design" name="sub5"/>
	</jsp:include>
</body>
</html>