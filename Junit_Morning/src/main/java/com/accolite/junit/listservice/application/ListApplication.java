package com.accolite.junit.listservice.application;

import com.accolite.junit.entity.User;
import com.accolite.junit.listservice.ListService;
import com.accolite.junit.listservice.impl.ListServiceImpl;

public class ListApplication {

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
