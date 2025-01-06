<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		UserName is:: ${param.userName} <br />
		<c:catch var="e">
			<%
			int age = Integer.parseInt(request.getParameter("userAge"));
			%>
	UserAge is :: ${param.userAge}
	</c:catch>
		<c:if test="${e!=null}">
	Oops.. Exception raised ${e}
	</c:if>
		<br />
    User_height is:: ${param.userHeight}
	</h1>
</body>
</html>