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

	<sql:update var="count" dataSource="${ds}">
        insert into students(`name`,`email`,`city`,`country`) values(?,?,?,?)
        <sql:param value="deepak"></sql:param>
		<sql:param value="deepak@gmail.com"></sql:param>
		<sql:param value="bbk"></sql:param>
		<sql:param value="India"></sql:param>
	</sql:update>

	<h1>the total rows affacted :: ${count}</h1>


</body>
</html>