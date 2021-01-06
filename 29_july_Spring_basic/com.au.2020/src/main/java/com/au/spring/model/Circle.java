package com.au.spring.model;


public class Circle implements shape {

	public String Type;
	private int radius;
	private Point center;	
	
	public Circle()
	{}
	
	public Circle(String Type,int radius, Point center)
	{
		this.setType(Type);
		this.setRadius(radius);
		this.setCenter(center);;
	}
	
	public void setType(String t)
	{
		Type = t;
	}

	public void getType() {
		System.out.println("Type : "+Type);
	}

	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public double area()
	{
		double pi = 3.142;
		return pi*radius*radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	
}
