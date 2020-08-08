package com.au.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.au.spring.model.Area;
import com.au.spring.model.Circle;
import com.au.spring.model.Triangle;

@SpringBootApplication
public class SpringMain {

	public static void main(String[] args) {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		
		Area a= context.getBean(Area.class);
		
		Triangle triangle=context.getBean(Triangle.class);
		triangle.getType();
		System.out.println(triangle.getPointA());
		System.out.println(triangle.getPointB());
		System.out.println(triangle.getPointC());
		a.getArea(triangle);
		
		System.out.println(triangle.getPointMap().toString());
		triangle.area();
		
		Circle circle =  (Circle) context.getBean(Circle.class);
		circle.getType();
		System.out.println(circle.getCenter());
		a.getArea(circle);

	}

}
