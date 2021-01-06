package com.junit.listservice.application;


import com.junit.entity.User;
import com.junit.listservice.ListService;
import com.junit.listservice.impl.ListServiceImpl;

public class ListApplication  {

	ListService listService =  new ListServiceImpl();
	
	public boolean addUser(User user) {
		
		return listService.addUser(user);
	}

	public boolean checkEmail(String email) {
		return listService.checkEmail(email);
	}

	public boolean checkAge(int age) {
		return listService.checkAge(age);
	}

	public boolean checkName(String name) {
		return listService.checkName(name);
	}

}
