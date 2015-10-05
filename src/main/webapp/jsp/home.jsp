<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Events</title>
</head>
<body>

<h1>Spring Events</h1>

<form:form name="input" method="post" modelAttribute="event">
Create Event: <form:input type="text" path="name"/>

<input type="submit" value="Submit">
</form:form>


<br>
<div>
<c:forEach var="event" items="${allRegisteredEvents}">
	${event.name} <br>
</c:forEach>
</div>

<c:forEach var="subscriber" items="${allSubscribers}">
	${subscriber.toString()} <br>
</c:forEach>
</div>


</body>
</html>