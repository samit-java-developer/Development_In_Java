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
	<h1>Select Any No...</h1>
	<form action="./index.jsp">
		<select name="combo">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
		</select> <input type="submit" />
	</form>

	<c:set var='day' value='${param.combo}' />

	<c:choose>
		<c:when test="${day==1}">
           SUNDAY
        </c:when>
		<c:when test="${day==2}">
           MONDAY
        </c:when>
		<c:when test="${day==3}">
           TUESDAY
        </c:when>
		<c:when test="${day==4}">
           WEDNESDAY
        </c:when>
		<c:when test="${day==5}">
           THRUSDAY
        </c:when>
		<c:when test="${day==6}">
           FRIDAY
        </c:when>
		<c:when test="${day==7}">
           SATURDAY
        </c:when>
		<c:otherwise>
           SELECT NO BETWEEN 1 AND 7
        </c:otherwise>
	</c:choose>
</body>
</html>