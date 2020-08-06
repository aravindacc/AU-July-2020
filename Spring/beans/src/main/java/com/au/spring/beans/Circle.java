package com.au.spring.beans;

public class Circle implements Shape {

    public String Type;
    private int radius;
    private Points center;

    public Circle()
    {}

    public Circle(String Type,int radius, Points center)
    {
        this.setType(Type);
        this.setRadius(radius);
        this.setCenter(center);;
    }

    public void setType(String t)
    {
        Type = t;
    }

    public String getType() {
        return Type;
    }

    public Points getCenter() {
        return center;
    }

    public void setCenter(Points center) {
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