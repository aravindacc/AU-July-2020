/**
 * CourseServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.soap.accolite.service.impl;

public class CourseServiceImplServiceLocator extends org.apache.axis.client.Service implements com.soap.accolite.service.impl.CourseServiceImplService {

    public CourseServiceImplServiceLocator() {
    }


    public CourseServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CourseServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CourseServiceImpl
    private java.lang.String CourseServiceImpl_address = "http://localhost:9090/SOAP_assignments/services/CourseServiceImpl";

    public java.lang.String getCourseServiceImplAddress() {
        return CourseServiceImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CourseServiceImplWSDDServiceName = "CourseServiceImpl";

    public java.lang.String getCourseServiceImplWSDDServiceName() {
        return CourseServiceImplWSDDServiceName;
    }

    public void setCourseServiceImplWSDDServiceName(java.lang.String name) {
        CourseServiceImplWSDDServiceName = name;
    }

    public com.soap.accolite.service.impl.CourseServiceImpl getCourseServiceImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CourseServiceImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCourseServiceImpl(endpoint);
    }

    public com.soap.accolite.service.impl.CourseServiceImpl getCourseServiceImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.soap.accolite.service.impl.CourseServiceImplSoapBindingStub _stub = new com.soap.accolite.service.impl.CourseServiceImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getCourseServiceImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCourseServiceImplEndpointAddress(java.lang.String address) {
        CourseServiceImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.soap.accolite.service.impl.CourseServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.soap.accolite.service.impl.CourseServiceImplSoapBindingStub _stub = new com.soap.accolite.service.impl.CourseServiceImplSoapBindingStub(new java.net.URL(CourseServiceImpl_address), this);
                _stub.setPortName(getCourseServiceImplWSDDServiceName());
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
        if ("CourseServiceImpl".equals(inputPortName)) {
            return getCourseServiceImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.service.accolite.soap.com", "CourseServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.service.accolite.soap.com", "CourseServiceImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CourseServiceImpl".equals(portName)) {
            setCourseServiceImplEndpointAddress(address);
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
