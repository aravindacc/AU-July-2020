/**
 * Student_course.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.soap.accolite.model;

public class Student_course  implements java.io.Serializable {
    private com.soap.accolite.model.Course course;

    private int courseId;

    private int id;

    private com.soap.accolite.model.Student student;

    private int studentRollno;

    public Student_course() {
    }

    public Student_course(
           com.soap.accolite.model.Course course,
           int courseId,
           int id,
           com.soap.accolite.model.Student student,
           int studentRollno) {
           this.course = course;
           this.courseId = courseId;
           this.id = id;
           this.student = student;
           this.studentRollno = studentRollno;
    }


    /**
     * Gets the course value for this Student_course.
     * 
     * @return course
     */
    public com.soap.accolite.model.Course getCourse() {
        return course;
    }


    /**
     * Sets the course value for this Student_course.
     * 
     * @param course
     */
    public void setCourse(com.soap.accolite.model.Course course) {
        this.course = course;
    }


    /**
     * Gets the courseId value for this Student_course.
     * 
     * @return courseId
     */
    public int getCourseId() {
        return courseId;
    }


    /**
     * Sets the courseId value for this Student_course.
     * 
     * @param courseId
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }


    /**
     * Gets the id value for this Student_course.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Student_course.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the student value for this Student_course.
     * 
     * @return student
     */
    public com.soap.accolite.model.Student getStudent() {
        return student;
    }


    /**
     * Sets the student value for this Student_course.
     * 
     * @param student
     */
    public void setStudent(com.soap.accolite.model.Student student) {
        this.student = student;
    }


    /**
     * Gets the studentRollno value for this Student_course.
     * 
     * @return studentRollno
     */
    public int getStudentRollno() {
        return studentRollno;
    }


    /**
     * Sets the studentRollno value for this Student_course.
     * 
     * @param studentRollno
     */
    public void setStudentRollno(int studentRollno) {
        this.studentRollno = studentRollno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Student_course)) return false;
        Student_course other = (Student_course) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.course==null && other.getCourse()==null) || 
             (this.course!=null &&
              this.course.equals(other.getCourse()))) &&
            this.courseId == other.getCourseId() &&
            this.id == other.getId() &&
            ((this.student==null && other.getStudent()==null) || 
             (this.student!=null &&
              this.student.equals(other.getStudent()))) &&
            this.studentRollno == other.getStudentRollno();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCourse() != null) {
            _hashCode += getCourse().hashCode();
        }
        _hashCode += getCourseId();
        _hashCode += getId();
        if (getStudent() != null) {
            _hashCode += getStudent().hashCode();
        }
        _hashCode += getStudentRollno();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Student_course.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.accolite.soap.com", "Student_course"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("course");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.accolite.soap.com", "course"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.accolite.soap.com", "Course"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("courseId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.accolite.soap.com", "courseId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.accolite.soap.com", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("student");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.accolite.soap.com", "student"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.accolite.soap.com", "Student"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("studentRollno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.accolite.soap.com", "studentRollno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
