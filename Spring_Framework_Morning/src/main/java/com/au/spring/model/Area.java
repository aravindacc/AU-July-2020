package com.au.spring.model;

public class Area {
	 public void getArea(Triangle obj)
	    {
	        System.out.println("Area of Triangle given "+ obj.area());
	    }

	    public void getArea(Circle obj)
	    {
	        System.out.println("Area of Circle given "+ obj.area());
	    }
}
