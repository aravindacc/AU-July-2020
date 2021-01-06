package com.au.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.au.spring.model.Circle;
import com.au.spring.model.AreaCollector;
import com.au.spring.model.Triangle;

public class MainClass {
	public static void main(String []arg) {
		System.out.print("hello");
		@SuppressWarnings("resource")
		ApplicationContext context = new 
		ClassPathXmlApplicationContext("spring.xml");

	    AreaCollector c = context.getBean(AreaCollector.class);
		
	    Triangle triangle = context.getBean(Triangle.class);
	    triangle.getType();
	    System.out.println(triangle.getPointA());
	    System.out.println(triangle.getPointB());
	    System.out.println(triangle.getPointC());
	    c.getArea(triangle);
	    
	    System.out.println(triangle.getPointMap().toString());
	    triangle.area();
	    

	    Circle circle =  (Circle) context.getBean(Circle.class);
	    circle.getType();
	    System.out.println(circle.getCenter());
	    c.getArea(circle);
	    
	}
}
