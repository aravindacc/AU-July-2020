package com.au.junit.Testing.application;

import com.au.junit.Testing.entity.User;

public class ListApplication  {

    ListService listService =  new ListServiceImpl();

    public boolean addUser(User user) {

        return listService.addUser(user);
    }


    public boolean checkAge(int age) {
        return listService.checkAge(age);
    }

    public boolean checkName(String name) {
        return listService.checkName(name);
    }

}
