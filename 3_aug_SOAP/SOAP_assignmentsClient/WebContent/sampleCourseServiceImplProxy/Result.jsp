<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleCourseServiceImplProxyid" scope="session" class="com.soap.accolite.service.impl.CourseServiceImplProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleCourseServiceImplProxyid.setEndpoint(request.getParameter("endpoint"));
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
        com.soap.accolite.service.impl.CourseServiceImpl getCourseServiceImpl2mtemp = sampleCourseServiceImplProxyid.getCourseServiceImpl();
if(getCourseServiceImpl2mtemp == null){
%>
<%=getCourseServiceImpl2mtemp %>
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
        String rollno_0id=  request.getParameter("rollno10");
        int rollno_0idTemp  = Integer.parseInt(rollno_0id);
        boolean deleteCourse7mtemp = sampleCourseServiceImplProxyid.deleteCourse(rollno_0idTemp);
        String tempResultreturnp8 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteCourse7mtemp));
        %>
        <%= tempResultreturnp8 %>
        <%
break;
case 12:
        gotMethod = true;
        String rollno_1id=  request.getParameter("rollno19");
        int rollno_1idTemp  = Integer.parseInt(rollno_1id);
        com.soap.accolite.model.Course getCourse12mtemp = sampleCourseServiceImplProxyid.getCourse(rollno_1idTemp);
if(getCourse12mtemp == null){
%>
<%=getCourse12mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">name:</TD>
<TD>
<%
if(getCourse12mtemp != null){
java.lang.String typename15 = getCourse12mtemp.getName();
        String tempResultname15 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typename15));
        %>
        <%= tempResultname15 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getCourse12mtemp != null){
%>
<%=getCourse12mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 21:
        gotMethod = true;
        com.soap.accolite.model.Course[] getAllCourses21mtemp = sampleCourseServiceImplProxyid.getAllCourses();
if(getAllCourses21mtemp == null){
%>
<%=getAllCourses21mtemp %>
<%
}else{
        String tempreturnp22 = null;
        if(getAllCourses21mtemp != null){
        java.util.List<com.soap.accolite.model.Course> listreturnp22= java.util.Arrays.asList(getAllCourses21mtemp);
        for(com.soap.accolite.model.Course s : listreturnp22)
        {

            %>{
             Id:<%=s.getId()%>
            ,Name:<%=s.getName()%>
            }<br/><%
        }
        tempreturnp22 = listreturnp22.toString();
        }
}
break;
case 24:
        gotMethod = true;
        String name_3id=  request.getParameter("name29");
            java.lang.String name_3idTemp = null;
        if(!name_3id.equals("")){
         name_3idTemp  = name_3id;
        }
        String id_4id=  request.getParameter("id31");
        int id_4idTemp  = Integer.parseInt(id_4id);
        %>
        <jsp:useBean id="com1soap1accolite1model1Course_2id" scope="session" class="com.soap.accolite.model.Course" />
        <%
        com1soap1accolite1model1Course_2id.setName(name_3idTemp);
        com1soap1accolite1model1Course_2id.setId(id_4idTemp);
        boolean addCourse24mtemp = sampleCourseServiceImplProxyid.addCourse(com1soap1accolite1model1Course_2id);
        String tempResultreturnp25 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addCourse24mtemp));
        %>
        <%= tempResultreturnp25 %>
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