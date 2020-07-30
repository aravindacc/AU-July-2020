<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students</title>
        <link href="<c:url value="/resources/style.css"/>" rel="stylesheet"/>
    </head>
    <body>     
    
	    <div class="header">
	    <a href="/com.mvc.spring/" class="btn">Home</a>
	    </div>
	    
	    <div class="body">
	    <table>
	    <tr>
		    <th>Roll#
		    </th>
		    <th>
		    Student Name
		    </th>
		    <th>
		    &nbsp;
		    </th>
	    </tr>
	    
          <c:forEach var="student" items="${list}">   
          	<tr> <td>${student.id }</td> <td>${student.name }</td>
          	 <td><a href="./delete/${student.id}" class="btnsbmt">delete</a></td> </tr>
          </c:forEach>     
          
	    </table>
        </div> 
    </body>
</html>
