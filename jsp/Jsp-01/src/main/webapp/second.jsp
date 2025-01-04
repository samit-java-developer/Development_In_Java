<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Page Scope attribute::
	<%=pageContext.getAttribute("p",1)%></br>
	Request Scope attribute::
	<%=pageContext.getAttribute("r",2)%></br>
	Session Scope attribute::
	<%=pageContext.getAttribute("s",3)%></br>
	Application Scope attribute::
	<%=pageContext.getAttribute("a",4)%></br>
</body>
</html>