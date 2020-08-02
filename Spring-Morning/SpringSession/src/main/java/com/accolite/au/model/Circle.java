package com.accolite.au.model;

public class Circle {
    private Shape shape;
    private String type;
    private Point center;

    public Circle(Shape shape, String type) {
        this.shape = shape;
        this.type = type;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void draw(){
        System.out.println("inside " + type);
        System.out.println("Center: (" + center.getX() + ", " + center.getY() + ")");
        System.out.println();
    }

//    public void getArea() {
//        System.out.println("Area of circle.");
//    }
}
