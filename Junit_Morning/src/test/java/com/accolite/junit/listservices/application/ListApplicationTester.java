package com.accolite.junit.listservices.application;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.accolite.junit.entity.User;
import com.accolite.junit.listservice.application.ListApplication;

@RunWith(SpringRunner.class)
public class ListApplicationTester {

	@InjectMocks
	  ListApplication listApplication;
	
	@Test
	  public void adduser()
	  {
		User user = new User();
		user.setName("Neeraj");
		user.setEmail("neerajkumarsolanki@gmail.com");
		user.setAge(26);
		user.setCity("roorkee");
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
		  int age = 26;	  
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
		  String name = "Neeraj";
		  Assert.assertEquals(true,listApplication.checkName(name));
	  }	 
	  
	  @Test
	  public void checkNameValidWithSpace()
	  {
		  String name = "Neeraj solanki";
		  Assert.assertEquals(true,listApplication.checkName(name));
	  }	  
	  
	  @Test
	  public void checkNameInValidWithSpecialCharacter()
	  {
		  String name = "Neeraj@Solanki";
		  Assert.assertEquals(false,listApplication.checkName(name));
	  }
	  
	  @Test
	  public void checkEmailValid()
	  {
		  String email = "neerajkumarsolanki@gmail.com";
		  Assert.assertEquals(true,listApplication.checkEmail(email));
	  }

	  @Test
	  public void checkEmailInValid()
	  {
		  String email = ".neerajkumarsolanki@gmail.com";
		  Assert.assertEquals(false,listApplication.checkEmail(email));
	  }
	  
	  
	  
	  
	  
}
