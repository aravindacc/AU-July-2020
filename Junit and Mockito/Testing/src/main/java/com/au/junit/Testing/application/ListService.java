package com.au.junit.Testing.application;

import com.au.junit.Testing.entity.User;


public interface ListService {
    boolean addUser(User user);
    boolean checkAge(int age);
    boolean checkName(String name);
}