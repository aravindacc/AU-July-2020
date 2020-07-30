<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link href="<c:url value="/resources/style.css"/>" rel="stylesheet"/>
    </head>
    <body>
	    <div class="header">
	    <a href="/com.mvc.spring/" class="btn">Home</a>
	    <a href="/com.mvc.spring/StudentList" class="btn">Student List</a>
	    </div>
	    
	    <div class="body">
	        <h1>Hello  ${firstname} </h1>
	        <p>Welcome to Spring MVC....</p>
        </div>
    </body>
</html>
