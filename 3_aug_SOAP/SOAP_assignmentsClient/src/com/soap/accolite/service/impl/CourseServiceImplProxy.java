package com.soap.accolite.service.impl;

public class CourseServiceImplProxy implements com.soap.accolite.service.impl.CourseServiceImpl {
  private String _endpoint = null;
  private com.soap.accolite.service.impl.CourseServiceImpl courseServiceImpl = null;
  
  public CourseServiceImplProxy() {
    _initCourseServiceImplProxy();
  }
  
  public CourseServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initCourseServiceImplProxy();
  }
  
  private void _initCourseServiceImplProxy() {
    try {
      courseServiceImpl = (new com.soap.accolite.service.impl.CourseServiceImplServiceLocator()).getCourseServiceImpl();
      if (courseServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)courseServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)courseServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (courseServiceImpl != null)
      ((javax.xml.rpc.Stub)courseServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.soap.accolite.service.impl.CourseServiceImpl getCourseServiceImpl() {
    if (courseServiceImpl == null)
      _initCourseServiceImplProxy();
    return courseServiceImpl;
  }
  
  public boolean deleteCourse(int rollno) throws java.rmi.RemoteException{
    if (courseServiceImpl == null)
      _initCourseServiceImplProxy();
    return courseServiceImpl.deleteCourse(rollno);
  }
  
  public com.soap.accolite.model.Course getCourse(int rollno) throws java.rmi.RemoteException{
    if (courseServiceImpl == null)
      _initCourseServiceImplProxy();
    return courseServiceImpl.getCourse(rollno);
  }
  
  public com.soap.accolite.model.Course[] getAllCourses() throws java.rmi.RemoteException{
    if (courseServiceImpl == null)
      _initCourseServiceImplProxy();
    return courseServiceImpl.getAllCourses();
  }
  
  public boolean addCourse(com.soap.accolite.model.Course s) throws java.rmi.RemoteException{
    if (courseServiceImpl == null)
      _initCourseServiceImplProxy();
    return courseServiceImpl.addCourse(s);
  }
  
  
}