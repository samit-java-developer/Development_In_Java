<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="x" value="10" scope="request"/>
<c:set var="y" value="20" scope="request"/>
<c:set var="sum" value="${x+y}" scope="session" />
<h1 style="color: red; text-align: center;">
     The result is:: <c:out value="${sum}"></c:out>
</h1>
</body>
</html>