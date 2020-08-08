package com.soap.accolite.service;

import com.soap.accolite.model.Student;

public interface StudentService {

	public boolean addStudent(Student s);
	
	public boolean deleteStudent(int rollno);
	
	public Student getStudent(int rollno);
	
	public Student[] getAllStudents();
	
	public boolean changeAge(int rollno, int age);
}
