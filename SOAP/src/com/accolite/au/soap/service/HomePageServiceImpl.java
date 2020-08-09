package com.accolite.au.soap.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.accolite.au.soap.model.Student;

@WebService(endpointInterface="com.accolite.au.soap.service.HomePageService", portName="SLPort", serviceName="SLService")
public class HomePageServiceImpl implements IHPService {
	private static List<Student> studentList;
	String viewstudent = "viewstudent";
	
    public HomePageServiceImpl() {
        initializeStudentList();
    }
    
    @Override
    @WebResult(name="student")
	public Student searchById(@WebParam(name="studentid") String id) throws Exception {
        for (Student s : studentList) if (s.getId() == id) return s;
        throw new Exception("No product found with id " + id);
    }
    
    @Override
    @WebResult(name="student")
	public Student[] getAllStudents() {
        Student[] student = new Student[studentList.size()];
        int i = 0;
        
        for (Student p : studentList) {
            student[i] = p;
            i++;
        }
        
        return student;
    }
    
    @Override
	public void insertStudent(@WebParam(name="student") Student student) {
    	studentList.add(student);
    }
    
    @Override
	public boolean deleteStudent(int id) {
		if(studentList.get(id) == null) return false;
		studentList.remove(id);
		return true;
	}
    
    private void initializeStudentList() {
        if (studentList == null) {
        	studentList = new ArrayList();
        	studentList.add(new Student("1", "Ram", "Gupta", "CSE"));
        	studentList.add(new Student("2", "Shyam", "Mathur", "ECE"));
        	studentList.add(new Student("3", "Rani", "Narayan", "CSE"));
        	studentList.add(new Student("4", "Hamid", "Hussain", "ME"));
        	studentList.add(new Student("5", "Sourav", "Goutam", "ECE"));
        }
    }
}
