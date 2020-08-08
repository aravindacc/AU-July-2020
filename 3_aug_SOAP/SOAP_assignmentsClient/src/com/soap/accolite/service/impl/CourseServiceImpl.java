/**
 * CourseServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.soap.accolite.service.impl;

public interface CourseServiceImpl extends java.rmi.Remote {
    public boolean deleteCourse(int rollno) throws java.rmi.RemoteException;
    public com.soap.accolite.model.Course getCourse(int rollno) throws java.rmi.RemoteException;
    public com.soap.accolite.model.Course[] getAllCourses() throws java.rmi.RemoteException;
    public boolean addCourse(com.soap.accolite.model.Course s) throws java.rmi.RemoteException;
}
