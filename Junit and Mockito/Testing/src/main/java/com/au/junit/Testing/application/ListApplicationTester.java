package com.au.junit.Testing.application;

import com.au.junit.Testing.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ListApplicationTester {


    @InjectMocks
    ListApplication listApplication;



    @Test
    public void adduser()
    {
        User user = new User();
        user.setName("Rajdeep");
        user.setEmail("Rajdeep8709@gmail.com");
        user.setAge(23);
        user.setCity("Biharsharif");
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
        int age = 23;
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
        int age = 91;
        Assert.assertEquals(false,listApplication.checkAge(age));
    }

    @Test
    public void checkAgeMaxBoundaryValid()
    {
        int age = 90;
        Assert.assertEquals(true,listApplication.checkAge(age));
    }

    @Test
    public void checkNameValid()
    {
        String name = "Rajdeep";
        Assert.assertEquals(true,listApplication.checkName(name));
    }

    @Test
    public void checkNameValidWithSpace()
    {
        String name = "Rajdeep Kumar";
        Assert.assertEquals(true,listApplication.checkName(name));
    }

    @Test
    public void checkNameInValidWithSpecialCharacter()
    {
        String name = "Rajdeep.kumar";
        Assert.assertEquals(false,listApplication.checkName(name));
    }



}