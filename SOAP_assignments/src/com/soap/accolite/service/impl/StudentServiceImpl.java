package com.soap.accolite.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.soap.accolite.model.Student;
import com.soap.accolite.service.StudentService;

public class StudentServiceImpl implements StudentService {

	public static Map<Integer,Student> students = new HashMap<Integer,Student>();
	
	@Override
	public boolean addStudent(Student s) {
		if(students.get(s.getRollno()) != null) return false;
		students.put(s.getRollno(), s);
		return true;
	}

	@Override
	public boolean deleteStudent(int rollno) {
		if(students.get(rollno) == null) return false;
		students.remove(rollno);
		return true;
	}

	@Override
	public Student getStudent(int rollno) {
		return students.get(rollno);
	}

	@Override
	public Student[] getAllStudents() {
		Set<Integer> ids = students.keySet();
		Student[] p = new Student[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = students.get(id);
			i++;
		}
		return p;
	}

	@Override
	public boolean changeAge(int rollno, int age) {
		Student student = students.get(rollno);
		if(student!=null)
		{
			student.setAge(age);
			return true;
		}
		return false;
	}

}
