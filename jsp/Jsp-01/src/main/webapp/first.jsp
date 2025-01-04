<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	pageContext.setAttribute("p", "page");
	request.setAttribute("r", "request");
	session.setAttribute("s", "session");
	application.setAttribute("a", "application");
	
	pageContext.forward("second.jsp");
	%>
</body>
</html>