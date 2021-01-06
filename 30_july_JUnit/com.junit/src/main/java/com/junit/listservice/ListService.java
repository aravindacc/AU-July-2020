package com.junit.listservice;

import org.springframework.stereotype.Service;

import com.junit.entity.User;

@Service
public interface ListService {
	   public boolean addUser(User user);
	   public boolean checkEmail(String email);
	   public boolean checkAge(int age);
	   public boolean checkName(String name);
}
