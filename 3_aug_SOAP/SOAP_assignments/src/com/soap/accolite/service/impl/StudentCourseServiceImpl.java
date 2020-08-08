package com.soap.accolite.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.soap.accolite.model.Course;
import com.soap.accolite.model.Student;
import com.soap.accolite.model.Student_course;
import com.soap.accolite.service.StudentCourseService;
public class StudentCourseServiceImpl implements StudentCourseService {

	private static Map<Integer,Student_course> studentcourses = new HashMap<Integer,Student_course>();
	private static int idGenerator=0;

	@Override
	public boolean assignCourseToStudent(int rollno,int courseid) {
		if(getStudentCoursesId(rollno, courseid) != -1) return false;
		Student student = StudentServiceImpl.students.get(rollno);
		Course course = CourseServiceImpl.courses.get(courseid);
		Student_course sc = new Student_course();
		sc.setCourse(course);
		sc.setStudent(student);
		sc.setId(idGenerator++);
		studentcourses.put(sc.getId(), sc);
		return true;
	}


	@Override
	public Student_course[] getAllStudentWithCourses() {
		Set<Integer> ids = studentcourses.keySet();
		Student_course[] p = new Student_course[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = studentcourses.get(id);
			i++;
		}
		return p;
	}

	@Override
	public boolean deleteCourseToStudent(int rollno, int courseid) {
		
		int id = getStudentCoursesId(rollno, courseid);
		if(id != -1)
		{
			studentcourses.remove(id);
			return true;
		}
		return false;
	}
	
	public int getStudentCoursesId(int rollno, int courseid) {
		Set<Integer> ids = studentcourses.keySet();
		for(Integer id : ids){
			Student_course sc = studentcourses.get(id);
			if(sc.getCourseId() == courseid && sc.getStudentRollno() == rollno)
			{
				return sc.getId();
			}
		}
		return -1;
	}


	@Override
	public Course[] getCourseOfStudent(int rollno) {
		List<Course> list = new ArrayList<Course>();
		Set<Integer> ids = studentcourses.keySet();
		for(Integer id : ids){
			Student_course sc = studentcourses.get(id);
			if(sc.getStudentRollno() == rollno)
			{
				list.add(sc.getCourse());
			}
		}
		return list.toArray(new Course[0]);
	}


	@Override
	public Student[] getStudentOfCourse(int courseId) {
		List<Student> list = new ArrayList<Student>();
		Set<Integer> ids = studentcourses.keySet();
		for(Integer id : ids){
			Student_course sc = studentcourses.get(id);
			if(sc.getCourseId() == courseId)
			{
				list.add(sc.getStudent());
			}
		}
		return list.toArray(new Student[0]);
	}
	
	

}
