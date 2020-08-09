package com.au.session.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.au.session.controller.service.StudentService;
import com.au.session.controller.exception.StudentNotExist;
import com.au.session.controller.model.StudentWithSameRollNumber;
import com.au.session.controller.service.Student;

@Controller
public class HomeController {
	
	@Autowired
	StudentService studentservice;
	
	
	//root location mapping
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		
//		ModelAndView mv= new ModelAndView("home");
//		mv.addObject("name", "neeraj");
//		System.out.println("This is homecontroller");
		return new ModelAndView("home");
	}
	
	//Student list mapping
	@RequestMapping(value="/getList")
	public ModelAndView getAlldata(HttpServletResponse response) throws IOException{
		ArrayList<Student> list = studentservice.getAlldata();
		ModelAndView model = new ModelAndView("showList");
		model.addObject("list",list);
		return model;
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public ModelAndView welcome(@RequestParam("id") int id,@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,@RequestParam("dept") String dept) throws Exception{		
		if(!studentservice.insert(new Student(id,firstname,lastname,dept)))
			throw new StudentWithSameRollNumber(id);
		ModelAndView model = new ModelAndView("index");
		model.addObject("id",id);
		model.addObject("firstname",firstname);
		return model;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam("id") int id,@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,@RequestParam("dept") String dept) throws Exception{		
		if(!studentservice.update(id, new Student(id,firstname,lastname,dept)))
			throw new StudentWithSameRollNumber(id);
		ModelAndView model = new ModelAndView("index");
		model.addObject("id",id);
		model.addObject("firstname",firstname);
		return model;
	}
	
	@RequestMapping(value="/update/{id}")
	public ModelAndView updateItem(@PathVariable int id) throws Exception
	{
		Student obj  = studentservice.getStudent(id);
		if(obj == null)
			throw new StudentNotExist(id);
		
		ModelAndView model = new ModelAndView("update");
		model.addObject("id",obj.getId());
		model.addObject("firstname",obj.getFirstname());
		model.addObject("lastname",obj.getLastname());
		model.addObject("dept",obj.getDept());
		return model;
	}
	
	
	@RequestMapping(value="/delete/{id}")
	public ModelAndView deleteItem(@PathVariable int id) throws Exception
	{
		if(!studentservice.delete(id))
			throw new StudentNotExist(id);
		return new ModelAndView("redirect:/getList");
	}
}
