<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Student Details</title>
	<link href="<c:url value="/resources/style.css"/>" rel="stylesheet"/>
    
</head>
<body>

	</div> 
           <div>
	    <a href="/SpringMVCSession/" class="btn">Home</a>
	    </div>  
	    <div class="body">
	    <table>
	    <tr>
		    <th>Student ID</th><th>First Name</th><th>Last Name</th><th>Department</th>
		    <th>
		    &nbsp;
		    </th>
		    <th>
		    &nbsp;
		    </th>
	    </tr>
          <c:forEach var="student" items="${list}">   
          	<tr> <td>${student.id }</td> 
          	<td>${student.firstname }</td>
          	<td>${student.lastname }</td>
          	<td>${student.dept }</td>
          	 <td><a href="./update/${student.id}" class="btnsbmt">Edit</a> </td>
          	  <td><a href="./delete/${student.id}" class="btnsbmt">Delete</a> </td>
          	   </tr>
          </c:forEach>     
          
	    </table>
</body>
</html>