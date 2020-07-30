<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="<c:url value="/resources/style.css"/>" rel="stylesheet"/>
    </head>
    <body>	
	    <div class="header">
	    <a href="/com.mvc.spring/StudentList" class="btn">All data</a>
	    </div>
	    <div class="body">
		   	 <h1 class="w-100">Add Student</h1>
	        
	        <form action="/com.mvc.spring/welcome" method="post">
        		<label>Roll number</label><br>
	        	<input type="text" name="id" class="textbox"  required/><BR>
	        	<label>Name</label><br>
	        	<input type="text" name="name"  class="textbox"  required /><br>
	        	<input type="submit" value="Add Student" class="btnsbmt"/>
	        </form>
	    </div>
        
        
    </body>
</html>
