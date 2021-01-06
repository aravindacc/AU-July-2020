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
	    <a href="/com.mvc.spring/" class="btn">Home</a>
	    <a href="/com.mvc.spring/StudentList" class="btn">Student List</a>
	    </div>
	    <div class="body">
		   	 <h1 class="w-100">Update Student</h1>
	        
	        <form action="/com.mvc.spring/update" method="post">
        		<label>Roll number </label><br>
	        	<input type="number" name="id" value="${id}" class="textbox" style="background-color:#f4f4f4" readonly="readonly"  required="true" /><BR>
	        	<label>First Name</label><br>
	        	<input type="text" name="firstname"  value="${firstname}"   class="textbox"  required="true" /><br>
	        	<label>Last Name</label><br>
	        	<input type="text" name="lastname"  value="${lastname}"  class="textbox"  required="true" /><br>
	        	<label>Department</label><br>
	        	<input type="text" name="dept"  value="${dept}"  class="textbox"  required="true" /><br>
	        	<input type="submit" value="Update Student" class="btnsbmt"/>
	    		<a href="/com.mvc.spring/" class="btnsbmt">Cancel</a>
	        </form>
	    </div>
        
        
    </body>
</html>
