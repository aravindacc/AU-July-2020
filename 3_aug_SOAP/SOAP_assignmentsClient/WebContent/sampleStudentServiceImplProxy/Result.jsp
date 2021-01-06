<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleStudentServiceImplProxyid" scope="session" class="com.soap.accolite.service.impl.StudentServiceImplProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleStudentServiceImplProxyid.setEndpoint(request.getParameter("endpoint"));
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
        com.soap.accolite.service.impl.StudentServiceImpl getStudentServiceImpl2mtemp = sampleStudentServiceImplProxyid.getStudentServiceImpl();
if(getStudentServiceImpl2mtemp == null){
%>
<%=getStudentServiceImpl2mtemp %>
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
        boolean deleteStudent7mtemp = sampleStudentServiceImplProxyid.deleteStudent(rollno_0idTemp);
        String tempResultreturnp8 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteStudent7mtemp));
        %>
        <%= tempResultreturnp8 %>
        <%
break;
case 12:
        gotMethod = true;
        com.soap.accolite.model.Student[] getAllStudents12mtemp = sampleStudentServiceImplProxyid.getAllStudents();
if(getAllStudents12mtemp == null){
%>
<%=getAllStudents12mtemp %>
<%
}else{
        String tempreturnp13 = null;
        if(getAllStudents12mtemp != null){
        java.util.List<com.soap.accolite.model.Student> listreturnp13= java.util.Arrays.asList(getAllStudents12mtemp);
        for(com.soap.accolite.model.Student s : listreturnp13)
        {
            %>{
            Rollno:<%=s.getRollno()%>
            ,Name:<%=s.getName()%>
            ,Age:<%=s.getAge()%>
            }<br/><%
        }
        tempreturnp13 = listreturnp13.toString();
        }
}
break;
case 15:
        gotMethod = true;
        String age_2id=  request.getParameter("age20");
        int age_2idTemp  = Integer.parseInt(age_2id);
        String name_3id=  request.getParameter("name22");
            java.lang.String name_3idTemp = null;
        if(!name_3id.equals("")){
         name_3idTemp  = name_3id;
        }
        String rollno_4id=  request.getParameter("rollno24");
        int rollno_4idTemp  = Integer.parseInt(rollno_4id);
        %>
        <jsp:useBean id="com1soap1accolite1model1Student_1id" scope="session" class="com.soap.accolite.model.Student" />
        <%
        com1soap1accolite1model1Student_1id.setAge(age_2idTemp);
        com1soap1accolite1model1Student_1id.setName(name_3idTemp);
        com1soap1accolite1model1Student_1id.setRollno(rollno_4idTemp);
        boolean addStudent15mtemp = sampleStudentServiceImplProxyid.addStudent(com1soap1accolite1model1Student_1id);
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addStudent15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
break;
case 26:
        gotMethod = true;
        String rollno_5id=  request.getParameter("rollno35");
        int rollno_5idTemp  = Integer.parseInt(rollno_5id);
        com.soap.accolite.model.Student getStudent26mtemp = sampleStudentServiceImplProxyid.getStudent(rollno_5idTemp);
if(getStudent26mtemp == null){
%>
<%=getStudent26mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">age:</TD>
<TD>
<%
if(getStudent26mtemp != null){
%>
<%=getStudent26mtemp.getAge()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">name:</TD>
<TD>
<%
if(getStudent26mtemp != null){
java.lang.String typename31 = getStudent26mtemp.getName();
        String tempResultname31 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typename31));
        %>
        <%= tempResultname31 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">rollno:</TD>
<TD>
<%
if(getStudent26mtemp != null){
%>
<%=getStudent26mtemp.getRollno()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 37:
        gotMethod = true;
        String rollno_6id=  request.getParameter("rollno40");
        int rollno_6idTemp  = Integer.parseInt(rollno_6id);
        String age_7id=  request.getParameter("age42");
        int age_7idTemp  = Integer.parseInt(age_7id);
        boolean changeAge37mtemp = sampleStudentServiceImplProxyid.changeAge(rollno_6idTemp,age_7idTemp);
        String tempResultreturnp38 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(changeAge37mtemp));
        %>
        <%= tempResultreturnp38 %>
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