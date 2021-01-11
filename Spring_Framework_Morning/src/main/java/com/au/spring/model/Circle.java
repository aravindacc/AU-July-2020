package com.au.spring.model;

public class Circle implements Shape {

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
    
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
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
}
