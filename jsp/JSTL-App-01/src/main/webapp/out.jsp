<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red; text-align: center;">
		<c:out value="WELCOME TO JSTL CODING........." /></br>
		The user_name is:: <c:out value="${param.user}"/></br>
		The password is :: <c:out value="${param.password}" default="Guest"/>
	</h1>
</body>
</html>