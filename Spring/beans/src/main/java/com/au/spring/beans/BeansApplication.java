package com.au.spring.beans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BeansApplication {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();


		Area c = context.getBean(Area.class);

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
