package com.soap.accolite.model;

import java.io.Serializable;

public class Student_course implements Serializable{
	private static final long serialVersionUID = -557757908132070434L;	
	
	private int id;
	private Student student;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	private Course course;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentRollno() {
		return  student.getRollno();
	}
	public int getCourseId() {
		return course.getId();
	}
}
