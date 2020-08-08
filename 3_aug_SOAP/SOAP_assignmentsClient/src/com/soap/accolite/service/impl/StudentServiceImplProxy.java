package com.soap.accolite.service.impl;

public class StudentServiceImplProxy implements com.soap.accolite.service.impl.StudentServiceImpl {
  private String _endpoint = null;
  private com.soap.accolite.service.impl.StudentServiceImpl studentServiceImpl = null;
  
  public StudentServiceImplProxy() {
    _initStudentServiceImplProxy();
  }
  
  public StudentServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initStudentServiceImplProxy();
  }
  
  private void _initStudentServiceImplProxy() {
    try {
      studentServiceImpl = (new com.soap.accolite.service.impl.StudentServiceImplServiceLocator()).getStudentServiceImpl();
      if (studentServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)studentServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)studentServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (studentServiceImpl != null)
      ((javax.xml.rpc.Stub)studentServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.soap.accolite.service.impl.StudentServiceImpl getStudentServiceImpl() {
    if (studentServiceImpl == null)
      _initStudentServiceImplProxy();
    return studentServiceImpl;
  }
  
  public boolean deleteStudent(int rollno) throws java.rmi.RemoteException{
    if (studentServiceImpl == null)
      _initStudentServiceImplProxy();
    return studentServiceImpl.deleteStudent(rollno);
  }
  
  public com.soap.accolite.model.Student[] getAllStudents() throws java.rmi.RemoteException{
    if (studentServiceImpl == null)
      _initStudentServiceImplProxy();
    return studentServiceImpl.getAllStudents();
  }
  
  public boolean addStudent(com.soap.accolite.model.Student s) throws java.rmi.RemoteException{
    if (studentServiceImpl == null)
      _initStudentServiceImplProxy();
    return studentServiceImpl.addStudent(s);
  }
  
  public com.soap.accolite.model.Student getStudent(int rollno) throws java.rmi.RemoteException{
    if (studentServiceImpl == null)
      _initStudentServiceImplProxy();
    return studentServiceImpl.getStudent(rollno);
  }
  
  public boolean changeAge(int rollno, int age) throws java.rmi.RemoteException{
    if (studentServiceImpl == null)
      _initStudentServiceImplProxy();
    return studentServiceImpl.changeAge(rollno, age);
  }
  
  
}