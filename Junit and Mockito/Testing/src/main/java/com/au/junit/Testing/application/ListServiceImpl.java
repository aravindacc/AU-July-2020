package com.au.junit.Testing.application;

import com.au.junit.Testing.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


@Slf4j
@Service
public class ListServiceImpl implements ListService {

    static List<User> list = new ArrayList<User>();

    final Logger log = LoggerFactory.getLogger(ListServiceImpl.class);


    @Override
    public boolean addUser(User user) {
        if(user != null && checkAge(user.getAge()) && checkName(user.getName()))
        {
            return list.add(user);
        }else
        {
            log.error("Inserting user in list failed");
            return false;
        }
    }


    public boolean checkAge(int age)
    {
        if (age > 0 && age <= 90) {
            return true;
        }
        else {
            String error = "Invalid age between 1-90 : "+age;
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