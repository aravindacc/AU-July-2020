package com.junit.listservice;

import com.junit.entity.User;

public interface ListService {
	   public boolean addUser(User user);
	   public boolean checkEmail(String email);
	   public boolean checkAge(int age);
	   public boolean checkName(String name);
}
