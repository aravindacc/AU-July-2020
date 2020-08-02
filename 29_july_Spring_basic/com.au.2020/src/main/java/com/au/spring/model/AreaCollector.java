package com.au.spring.model;

public class AreaCollector {
	public void getArea(Triangle obj)
	{
		System.out.println("Area : "+obj.area());
	}
	
	public void getArea(Circle obj)
	{
		System.out.println("Area : "+obj.area());
	}
}
