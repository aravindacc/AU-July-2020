package com.soap.accolite.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.soap.accolite.model.Course;
import com.soap.accolite.service.CourseService;

public class CourseServiceImpl implements CourseService {

	public static Map<Integer,Course> courses = new HashMap<Integer,Course>();
	
	@Override
	public boolean addCourse(Course s) {
		if(courses.get(s.getId()) != null) return false;
		courses.put(s.getId(), s);
		return true;
	}

	@Override
	public boolean deleteCourse(int rollno) {
		if(courses.get(rollno) == null) return false;
		courses.remove(rollno);
		return true;
	}

	@Override
	public Course getCourse(int rollno) {
		return courses.get(rollno);
	}

	@Override
	public Course[] getAllCourses() {
		Set<Integer> ids = courses.keySet();
		Course[] p = new Course[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = courses.get(id);
			i++;
		}
		return p;
	}


}
