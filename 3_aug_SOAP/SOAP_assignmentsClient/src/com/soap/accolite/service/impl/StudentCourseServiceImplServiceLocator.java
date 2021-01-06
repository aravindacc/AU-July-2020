/**
 * StudentCourseServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.soap.accolite.service.impl;

public class StudentCourseServiceImplServiceLocator extends org.apache.axis.client.Service implements com.soap.accolite.service.impl.StudentCourseServiceImplService {

    public StudentCourseServiceImplServiceLocator() {
    }


    public StudentCourseServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StudentCourseServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StudentCourseServiceImpl
    private java.lang.String StudentCourseServiceImpl_address = "http://localhost:9090/SOAP_assignments/services/StudentCourseServiceImpl";

    public java.lang.String getStudentCourseServiceImplAddress() {
        return StudentCourseServiceImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StudentCourseServiceImplWSDDServiceName = "StudentCourseServiceImpl";

    public java.lang.String getStudentCourseServiceImplWSDDServiceName() {
        return StudentCourseServiceImplWSDDServiceName;
    }

    public void setStudentCourseServiceImplWSDDServiceName(java.lang.String name) {
        StudentCourseServiceImplWSDDServiceName = name;
    }

    public com.soap.accolite.service.impl.StudentCourseServiceImpl getStudentCourseServiceImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StudentCourseServiceImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStudentCourseServiceImpl(endpoint);
    }

    public com.soap.accolite.service.impl.StudentCourseServiceImpl getStudentCourseServiceImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.soap.accolite.service.impl.StudentCourseServiceImplSoapBindingStub _stub = new com.soap.accolite.service.impl.StudentCourseServiceImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getStudentCourseServiceImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStudentCourseServiceImplEndpointAddress(java.lang.String address) {
        StudentCourseServiceImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.soap.accolite.service.impl.StudentCourseServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.soap.accolite.service.impl.StudentCourseServiceImplSoapBindingStub _stub = new com.soap.accolite.service.impl.StudentCourseServiceImplSoapBindingStub(new java.net.URL(StudentCourseServiceImpl_address), this);
                _stub.setPortName(getStudentCourseServiceImplWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("StudentCourseServiceImpl".equals(inputPortName)) {
            return getStudentCourseServiceImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.service.accolite.soap.com", "StudentCourseServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.service.accolite.soap.com", "StudentCourseServiceImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StudentCourseServiceImpl".equals(portName)) {
            setStudentCourseServiceImplEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
