package com.Todo.RestApi.controller;

import com.Todo.RestApi.model.TodoItem;
import com.Todo.RestApi.repo.TodoRepo;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Member;
import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {
    @Autowired
    private TodoRepo todoRepo;

    @GetMapping
    public List<TodoItem> findall(){
        return todoRepo.list;
    }
    @PostMapping
    public TodoItem save(HttpServletRequest request){
        System.out.print("printing");
        String id  = request.getParameter("id");
        String name = request.getParameter("name");
        TodoItem obj  = new TodoItem();
        obj.setId(Long.parseLong(id));
        obj.setTitle(name);
        obj.setDone(true);
        //System.out.println("title : "+obj.getTitle());
        TodoRepo.add(obj);
        return obj;

     }

//     System.out.print("printing");
//    String id  = request.getParameter("id");
//    String name = request.getParameter("itemName");
//    TodoItem obj  = new TodoItem();
//        obj.setId(Long.parseLong(id));
//        obj.setTitle(name);
//        obj.setDone(false);
}
