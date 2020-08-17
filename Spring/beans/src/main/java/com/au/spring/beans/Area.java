package com.au.spring.beans;

public class Area {
    public void getArea(Triangle obj)
    {
        System.out.println("Area of Triangle "+ obj.area());
    }

    public void getArea(Circle obj)
    {
        System.out.println("Area of Circle "+ obj.area());
    }

}

