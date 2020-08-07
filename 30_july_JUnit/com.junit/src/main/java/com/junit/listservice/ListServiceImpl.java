package com.junit.listservice;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.junit.entity.User;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class ListServiceImpl implements ListService {

	static List<User> list = new ArrayList<User>(); 
	
	final Logger log = LoggerFactory.getLogger(ListServiceImpl.class);

	
	public boolean addUser(User user) {
		if(user != null && checkAge(user.getAge()) && checkEmail(user.getEmail()) && checkName(user.getName()))
		{
			return list.add(user);
		}else
		{
			log.error("Inserting user in list failed");
			return false;
		}
	}

	public boolean checkEmail(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		if(pattern.matcher(email).matches())
			return true;
		else {
			String error = "Invalid Email format : "+email;
			log.error(error);
			return false;
		}
	}

	public boolean checkAge(int age) 
	{	
		if (age > 0 && age <= 100) {
			return true;
		}
		else {
			String error = "Invalid age between 1-100 : "+age;
			log.error(error);
			return false;
		}
	}

	public boolean checkName(String name) {
		String regex = "^[aA-zZ ]{5,29}$";
		Pattern pattern = Pattern.compile(regex);
		if(pattern.matcher(name).matches())
			return true;
		else {
			String error = "Invalid name format : "+name;
			log.error(error);
			return false;
		}
	}

}
