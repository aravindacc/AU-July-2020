package com.accolite.au.model;

import java.util.Map;

//@Component
public class Triangle  { //implements Shape
    private Shape shape;
    private String type;
    private Point pointA, pointB, pointC;
    private Map<String, Point> pointMap;

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Map<String, Point> getPointMap() {
        return pointMap;
    }

    public void setPointMap(Map<String, Point> pointMap) {
        this.pointMap = pointMap;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public void setType(String type){
        this.type = type;
    }

    String getType(){
        return this.type;
    }

    public void draw(){
        System.out.println("inside " + type);
        System.out.println("Point A: (" + pointA.getX() + ", " + pointA.getY() + ")");
        System.out.println("Point B: (" + pointB.getX() + ", " + pointB.getY() + ")");
        System.out.println("Point C: (" + pointC.getX() + ", " + pointC.getY() + ")");
        System.out.println();
    }

    public void printPointMap(){
        System.out.println("PointMap: " + this.pointMap.keySet());
        pointMap.forEach((k,v) -> System.out.println(k + " - " + "(" +
                v.getX() + ", " + v.getY() + ")"));
        System.out.println();
    }

//    public void getArea() {
//        System.out.println("Area of triangle.");
//    }

}
