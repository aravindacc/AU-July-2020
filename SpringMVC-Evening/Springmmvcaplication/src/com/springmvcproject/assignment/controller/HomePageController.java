package com.springmvcproject.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcproject.assignment.dto.Student;
import com.springmvcproject.assignmentException.DuplicateIDException;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/")
public class HomePageController {
	static List<Student> studentList = new ArrayList<>();
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home(ModelMap model) {

		return new ModelAndView("home", "student", new Student());

	}

	@RequestMapping(value = "/addstudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student, BindingResult result, ModelMap model) {
		 
		boolean ifDuplicateIDExists=false;
		
		  try { 
			  
			  checkforExistingStudent(student,studentList); 
		  
		  } catch
		  (DuplicateIDException e) { 
		  e.printStackTrace();
		  
		  ifDuplicateIDExists=true;
		  }
		
		  if(!ifDuplicateIDExists) {
		Student newStudent = new Student();
		newStudent.setId(student.getId());
		newStudent.setFirstName(student.getFirstName());
		newStudent.setLastName(student.getLastName());
		newStudent.setDepartment(student.getDepartment());
		
		studentList.add(newStudent);
		model.addAttribute("list", studentList);
		return "viewstudent";
	}else {
		model.addAttribute("student",student);
		return "error";
		}
	}

	@RequestMapping("/viewstudent")
	public String viewstudent(Model m) {
		 
		m.addAttribute("list", studentList);
		return "viewstudent";
	}

	

	

	@RequestMapping(value = "/deletestudent/{id}")
	public String deleStudent(@ModelAttribute("student") Student student, BindingResult result, ModelMap model) {
		

		for (Student studen : studentList) {

			if (studen.getId().equals(student.getId())) {
				studentList.remove(studen);
				model.addAttribute("list", studentList);
				return "viewstudent"; 
				
			}
		}
		
		return "viewstudent";

	}

	@RequestMapping(value = "/editstudent/{id}")
	public String editstudent(@PathVariable String id, Model model) {

		for (Student student : studentList) {

			if (student.getId().equals(id)) {
				model.addAttribute("command", student);
				return "editstudentdetails";
			}
		}
		return null;
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("student") Student student, Model model) {
		 
		for (Student studen : studentList) {

			if (studen.getId().equals(student.getId())) {
				studentList.remove(studen);
				studentList.add(student);
				model.addAttribute("list", studentList);
				return "viewstudent";
			}
		}
		return null;
	}



	private void checkforExistingStudent(Student student, List<Student> studentList) throws DuplicateIDException {

		for (Student studen : studentList) {

			if (studen.getId().equals(student.getId())) {

				throw new DuplicateIDException("Student with ID:" + student.getId() + "already exists");
				
			}
		}
		

	}
}
