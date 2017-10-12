<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">

.formtable {
	width: 400px;
	padding: 10px;
	border: 1px solid blue;
}

input[type=text] {
	width: 250px;
	
}

textarea {
	width: 250px;
	height: 300px;
}

.label {
	text-align: right;
	vertical-align: top;
}

.control {
	margin-left: 10px;
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>



<form method="post" action="${pageContext.request.contextPath}/docreate">

<table class="formtable">
<tr><td class="label">Name: </td><td><input class="control" name="name" type="text" /></td></tr>
<tr><td class="label">Email: </td><td><input class="control"  name="email" type="text" /></td></tr>
<tr><td class="label">Your offer: </td><td><textarea class="control"  name="text" rows="10" cols="10"></textarea></td></tr>
<tr><td class="label"> </td><td><input class="control"  value="Create advert" type="submit" /></td></tr>
</table>

</form>

</body>
</html>