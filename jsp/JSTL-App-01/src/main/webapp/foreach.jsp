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
	<%
	String[] names = { "samit", "deepak", "abhishek" };
	pageContext.setAttribute("names", names);
	List<String> ll = new ArrayList<>();
	ll.add("samit");
	ll.add("verma");
	ll.add("deepak");
	ll.add("kumar");
	pageContext.setAttribute("ll", ll);
	%>
	<c:forEach items="${names}" var="name">
		<h1>The data is:: ${name}</h1>
		<br />
	</c:forEach>
	<br />

	<c:forEach items="${ll}" var="ele">
		<h1>The data is:: ${ele}</h1>
		<br />
	</c:forEach>
</body>
</html>