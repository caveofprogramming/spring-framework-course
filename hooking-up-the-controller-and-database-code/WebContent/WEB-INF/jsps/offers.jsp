<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>

<table class="offers">
<tr><td>Name</td><td>Email</td><td>Offer</td></tr>

<c:forEach var="offer" items="${offers}">
<tr>

<td><c:out value="${offer.name}"></c:out></td>

<td><c:out value="${offer.email}"></c:out></td>

<td><c:out value="${offer.text}"></c:out></td>
   
</tr>
</c:forEach>
</table>

</body>
</html>