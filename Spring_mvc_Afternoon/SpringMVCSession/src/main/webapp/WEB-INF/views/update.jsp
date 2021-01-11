<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home</title>
	<link href="<c:url value="/resources/style.css"/>" rel="stylesheet"/>
   
</head>
<body>

		   <div >
	    <a href="/SpringMVCSession/" class="btn">Home</a>
	    <a href="/SpringMVCSession/getList" class="btn">List of Students</a>
	    </div>
	    <br>
	    <br>
	    
	    <div>
	        
	        <form action="/SpringMVCSession/update" method="post">
        	&nbsp; &nbsp;	<label>Student ID</label><br>
	        &nbsp; &nbsp;	<input type="number" name="id" value="${id}" class="textbox" style="background-color:#f4f4f4" readonly="readonly"  required="true" /><BR>
	        &nbsp; &nbsp;	<label>First Name</label><br>
	        &nbsp; &nbsp;	<input type="text" name="firstname"  value="${firstname}"   class="textbox"  required="true" /><br>
	        &nbsp; &nbsp;	<label>Last Name</label><br>
	        &nbsp; &nbsp;	<input type="text" name="lastname"  value="${lastname}"  class="textbox"  required="true" /><br>
	        &nbsp; &nbsp;	<label>Department</label><br>
	        &nbsp; &nbsp;	<input type="text" name="dept"  value="${dept}"  class="textbox"  required="false" /><br>
	        &nbsp; &nbsp;	<input type="submit" value="Update Student" class="btnsbmt"/>
	    		<a href="/SpringMVCSession/" class="btnsbmt">Cancel</a>
	        </form>
	    </div>
        <br>
     
		
		
</body>
</html>