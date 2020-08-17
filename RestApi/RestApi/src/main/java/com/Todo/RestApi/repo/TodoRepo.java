package com.Todo.RestApi.repo;

import com.Todo.RestApi.controller.TodoController;
import com.Todo.RestApi.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

//public interface TodoRepo extends JpaRepository<TodoItem,Long> {
//
//}

@Service
public class TodoRepo
{
    public static ArrayList<TodoItem> list;
    public TodoRepo()
    {
        list = new ArrayList<TodoItem>();
    }

    public static void add(TodoItem item) {

        list.add(item);

    }
}
