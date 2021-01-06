<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleStudentCourseServiceImplProxyid" scope="session" class="com.soap.accolite.service.impl.StudentCourseServiceImplProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleStudentCourseServiceImplProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        com.soap.accolite.service.impl.StudentCourseServiceImpl getStudentCourseServiceImpl2mtemp = sampleStudentCourseServiceImplProxyid.getStudentCourseServiceImpl();
if(getStudentCourseServiceImpl2mtemp == null){
%>
<%=getStudentCourseServiceImpl2mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 7:
        gotMethod = true;
        com.soap.accolite.model.Student_course[] getAllStudentWithCourses7mtemp = sampleStudentCourseServiceImplProxyid.getAllStudentWithCourses();
if(getAllStudentWithCourses7mtemp == null){
%>
<%=getAllStudentWithCourses7mtemp %>
<%
}else{
        String tempreturnp8 = null;
        if(getAllStudentWithCourses7mtemp != null){
        java.util.List<com.soap.accolite.model.Student_course> listreturnp8= java.util.Arrays.asList(getAllStudentWithCourses7mtemp);
        for(com.soap.accolite.model.Student_course sc:listreturnp8)
        {
        	%>
            Course : <%=sc.getCourse().getName()%>
            ,Student : <%=sc.getStudent().getName()%><br/>
            <%	
        }
        tempreturnp8 = listreturnp8.toString();
        }
        
}
break;
case 10:
        gotMethod = true;
        String rollno_0id=  request.getParameter("rollno13");
        int rollno_0idTemp  = Integer.parseInt(rollno_0id);
        String courseid_1id=  request.getParameter("courseid15");
        int courseid_1idTemp  = Integer.parseInt(courseid_1id);
        boolean deleteCourseToStudent10mtemp = sampleStudentCourseServiceImplProxyid.deleteCourseToStudent(rollno_0idTemp,courseid_1idTemp);
        String tempResultreturnp11 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteCourseToStudent10mtemp));
        %>
        <%= tempResultreturnp11 %>
        <%
break;
case 17:
        gotMethod = true;
        String rollno_2id=  request.getParameter("rollno20");
        int rollno_2idTemp  = Integer.parseInt(rollno_2id);
        String courseid_3id=  request.getParameter("courseid22");
        int courseid_3idTemp  = Integer.parseInt(courseid_3id);
        int getStudentCoursesId17mtemp = sampleStudentCourseServiceImplProxyid.getStudentCoursesId(rollno_2idTemp,courseid_3idTemp);
        String tempResultreturnp18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getStudentCoursesId17mtemp));
        %>
        <%= tempResultreturnp18 %>
        <%
break;
case 24:
        gotMethod = true;
        String rollno_4id=  request.getParameter("rollno27");
        int rollno_4idTemp  = Integer.parseInt(rollno_4id);
        com.soap.accolite.model.Course[] getCourseOfStudent24mtemp = sampleStudentCourseServiceImplProxyid.getCourseOfStudent(rollno_4idTemp);
if(getCourseOfStudent24mtemp == null){
%>
<%=getCourseOfStudent24mtemp %>
<%
}else{
        String tempreturnp25 = null;
        if(getCourseOfStudent24mtemp != null){
        java.util.List<com.soap.accolite.model.Course> listreturnp25= java.util.Arrays.asList(getCourseOfStudent24mtemp);
        for(com.soap.accolite.model.Course s : listreturnp25)
        {
            %>{
             Id:<%=s.getId()%>
            ,Name:<%=s.getName()%>
            }<br/><%
        }
        
        tempreturnp25 = listreturnp25.toString();
        }
}
break;
case 29:
        gotMethod = true;
        String courseId_5id=  request.getParameter("courseId32");
        int courseId_5idTemp  = Integer.parseInt(courseId_5id);
        com.soap.accolite.model.Student[] getStudentOfCourse29mtemp = sampleStudentCourseServiceImplProxyid.getStudentOfCourse(courseId_5idTemp);
if(getStudentOfCourse29mtemp == null){
%>
<%=getStudentOfCourse29mtemp %>
<%
}else{
        String tempreturnp30 = null;
        if(getStudentOfCourse29mtemp != null){
        java.util.List<com.soap.accolite.model.Student> listreturnp30= java.util.Arrays.asList(getStudentOfCourse29mtemp);
        for(com.soap.accolite.model.Student s : listreturnp30)
        {
            %>{
            Rollno:<%=s.getRollno()%>
            ,Name:<%=s.getName()%>
            ,Age:<%=s.getAge()%>
            }<br/><%
        }
        tempreturnp30 = listreturnp30.toString();
        }
}
break;
case 34:
        gotMethod = true;
        String rollno_6id=  request.getParameter("rollno37");
        int rollno_6idTemp  = Integer.parseInt(rollno_6id);
        String courseid_7id=  request.getParameter("courseid39");
        int courseid_7idTemp  = Integer.parseInt(courseid_7id);
        boolean assignCourseToStudent34mtemp = sampleStudentCourseServiceImplProxyid.assignCourseToStudent(rollno_6idTemp,courseid_7idTemp);
        String tempResultreturnp35 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(assignCourseToStudent34mtemp));
        %>
        <%= tempResultreturnp35 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>