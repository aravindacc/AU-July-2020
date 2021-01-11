<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div class="body">
		   	 <h1 >STUDENTS DETAILS TO BE FILLED HERE!</h1>
	    
	        
	        <form action="/SpringMVCSession/insert" method="post">
        		<label>Enter Student ID</label><br>
	        	<input type="number" name="id" class="textbox"  required="true" /><BR>
	        	<label>Enter First Name</label><br>
	        	<input type="text" name="firstname"  class="textbox"  required="true" /><br>
	        	<label>Enter Last Name</label><br>
	        	<input type="text" name="lastname"  class="textbox"  required="true" /><br>
	        	<label>Enter Department</label><br>
	        	<input type="text" name="dept"  class="textbox"  required="true" /><br>
	        	<input type="submit" value="Click to Add Student" class="btnsbmt"/>
	        </form>
	    </div>
        
         <div><br>
	    <a href="/SpringMVCSession/getList/" class="btn">List of Students</a>
	    </div>
    </body>
</html>
