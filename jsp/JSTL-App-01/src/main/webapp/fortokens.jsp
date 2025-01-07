<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OUTPUT PASGE</title>
</head>
<body>
	<c:forTokens items="samit,deepak,abhishek,karunesh" delims=","
		var="name">
		<h1>The name is :: ${name}</h1>
	</c:forTokens>
</body>
</html>