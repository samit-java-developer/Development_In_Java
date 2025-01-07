<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<c:import url="first.jsp">
		<c:param name="java" value="navin"></c:param>
		<c:param name="jee" value="nitin"></c:param>
		<c:param name="spring" value="hyder"></c:param>
	</c:import>
</body>
</html>