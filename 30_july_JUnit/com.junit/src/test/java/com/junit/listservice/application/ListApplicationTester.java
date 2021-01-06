package com.junit.listservice.application;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.junit.entity.User;

@RunWith(SpringRunner.class)
public class ListApplicationTester {
	
	
	  @InjectMocks
	  ListApplication listApplication;
		

	  
	  @Test
	  public void adduser()
	  {
		User user = new User();
		user.setName("Mukesh");
		user.setEmail("Suthar786@gmail.com");
		user.setAge(24);
		user.setCity("nsp");
		Assert.assertEquals(true, listApplication.addUser(user));
	  }
	  
	  @Test
	  public void addUserNull()
	  {
		  User user = null;
		  Assert.assertEquals(false,listApplication.addUser(user));
	  }	

	  @Test
	  public void checkAgeValid()
	  {
		  int age = 24;	  
		  Assert.assertEquals(true,listApplication.checkAge(age));
	  }

	  @Test
	  public void checkAgeMinimumBoundaryInvalid()
	  {
		  int age = 0;	  
		  Assert.assertEquals(false,listApplication.checkAge(age));
	  }

	  @Test
	  public void checkAgeMinimumBoundaryValid()
	  {
		  int age = 1;	  
		  Assert.assertEquals(true,listApplication.checkAge(age));
	  }

	  @Test
	  public void checkAgeMaxBoundaryInValid()
	  {
		  int age = 101;	  
		  Assert.assertEquals(false,listApplication.checkAge(age));
	  }
	  
	  @Test
	  public void checkAgeMaxBoundaryValid()
	  {
		  int age = 100;	  
		  Assert.assertEquals(true,listApplication.checkAge(age));
	  }
	  
	  @Test
	  public void checkNameValid()
	  {
		  String name = "Mukesh";
		  Assert.assertEquals(true,listApplication.checkName(name));
	  }	 
	  
	  @Test
	  public void checkNameValidWithSpace()
	  {
		  String name = "Mukesh Suthar";
		  Assert.assertEquals(true,listApplication.checkName(name));
	  }	  
	  
	  @Test
	  public void checkNameInValidWithSpecialCharacter()
	  {
		  String name = "Mukesh@Suthar";
		  Assert.assertEquals(false,listApplication.checkName(name));
	  }
	  
	  @Test
	  public void checkEmailValid()
	  {
		  String email = "sutharm786@gmail.com";
		  Assert.assertEquals(true,listApplication.checkEmail(email));
	  }

	  @Test
	  public void checkEmailInValid()
	  {
		  String email = ".sutharm786@gmail.com";
		  Assert.assertEquals(false,listApplication.checkEmail(email));
	  }
	  

	  
	  
	  
}