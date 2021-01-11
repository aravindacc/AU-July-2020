<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	<h2>Exception handling </h2>
	<h3>Debug Information:</h3>
	
	Requested URL= ${url}
	<br><br>
	Exception= ${exception.message}
	<br><br>
	<strong>Exception Stack Trace</strong>
	<br>
	<c:forEach items="${exception.stackTrace}" var="ste">
	${ste}
	</c:forEach>
</body>
</html>