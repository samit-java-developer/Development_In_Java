<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="ds" url="jdbc:mysql:///enterprisejavabatch"
		driver="com.mysql.cj.jdbc.Driver" user="root" password="samit@123" />
		
	<sql:query var="result" dataSource="${ds}" >
    select * from students
    </sql:query>
	<h1>
		<c:forEach items="${result.rows}" var="row">
		  ${row.name}----${row.email}-----${row.city}-----${row.country}<br/>
		</c:forEach>
	</h1>
	
	
</body>
</html>