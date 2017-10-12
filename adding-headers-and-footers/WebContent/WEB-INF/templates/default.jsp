<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
</head>
<body>

<div>
<tiles:insertAttribute name="header"></tiles:insertAttribute>
</div>
<div>
<tiles:insertAttribute name="content"></tiles:insertAttribute>
</div>
<div>
<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>


</body>
</html>