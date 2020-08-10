package com.accolite.au.model;

public class InterfaceShape implements Shape {
    public String type;

    @Override
    public void getArea() {
        System.out.println("Area Calculated.");
    }
}
