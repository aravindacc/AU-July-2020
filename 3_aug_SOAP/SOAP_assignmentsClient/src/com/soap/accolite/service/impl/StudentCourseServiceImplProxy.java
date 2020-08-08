package com.soap.accolite.service.impl;

public class StudentCourseServiceImplProxy implements com.soap.accolite.service.impl.StudentCourseServiceImpl {
  private String _endpoint = null;
  private com.soap.accolite.service.impl.StudentCourseServiceImpl studentCourseServiceImpl = null;
  
  public StudentCourseServiceImplProxy() {
    _initStudentCourseServiceImplProxy();
  }
  
  public StudentCourseServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initStudentCourseServiceImplProxy();
  }
  
  private void _initStudentCourseServiceImplProxy() {
    try {
      studentCourseServiceImpl = (new com.soap.accolite.service.impl.StudentCourseServiceImplServiceLocator()).getStudentCourseServiceImpl();
      if (studentCourseServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)studentCourseServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)studentCourseServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (studentCourseServiceImpl != null)
      ((javax.xml.rpc.Stub)studentCourseServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.soap.accolite.service.impl.StudentCourseServiceImpl getStudentCourseServiceImpl() {
    if (studentCourseServiceImpl == null)
      _initStudentCourseServiceImplProxy();
    return studentCourseServiceImpl;
  }
  
  public com.soap.accolite.model.Student_course[] getAllStudentWithCourses() throws java.rmi.RemoteException{
    if (studentCourseServiceImpl == null)
      _initStudentCourseServiceImplProxy();
    return studentCourseServiceImpl.getAllStudentWithCourses();
  }
  
  public boolean deleteCourseToStudent(int rollno, int courseid) throws java.rmi.RemoteException{
    if (studentCourseServiceImpl == null)
      _initStudentCourseServiceImplProxy();
    return studentCourseServiceImpl.deleteCourseToStudent(rollno, courseid);
  }
  
  public int getStudentCoursesId(int rollno, int courseid) throws java.rmi.RemoteException{
    if (studentCourseServiceImpl == null)
      _initStudentCourseServiceImplProxy();
    return studentCourseServiceImpl.getStudentCoursesId(rollno, courseid);
  }
  
  public com.soap.accolite.model.Course[] getCourseOfStudent(int rollno) throws java.rmi.RemoteException{
    if (studentCourseServiceImpl == null)
      _initStudentCourseServiceImplProxy();
    return studentCourseServiceImpl.getCourseOfStudent(rollno);
  }
  
  public com.soap.accolite.model.Student[] getStudentOfCourse(int courseId) throws java.rmi.RemoteException{
    if (studentCourseServiceImpl == null)
      _initStudentCourseServiceImplProxy();
    return studentCourseServiceImpl.getStudentOfCourse(courseId);
  }
  
  public boolean assignCourseToStudent(int rollno, int courseid) throws java.rmi.RemoteException{
    if (studentCourseServiceImpl == null)
      _initStudentCourseServiceImplProxy();
    return studentCourseServiceImpl.assignCourseToStudent(rollno, courseid);
  }
  
  
}