package com.accolite.au.springsession;

import com.accolite.au.model.Circle;
import com.accolite.au.model.Triangle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {
    public static void main(String[] args){

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");

        Triangle triangle = context.getBean(Triangle.class);
        Circle circle = context.getBean(Circle.class);

        triangle.draw();
        circle.draw();

        triangle.printPointMap();

        System.out.println("For triangle");
        triangle.getShape().getArea();
        System.out.println();
        System.out.println("For circle");
        circle.getShape().getArea();


    }
}
