package com.au.spring.beans;
import java.util.Map;
import org.springframework.beans.factory.annotation.Required;

public class Triangle implements Shape {

    public String Type;
    private Points pointA;
    private Points pointB;
    private Points pointC;

    private Map<Character, Points> pointMap;

    public void setType(String t)
    {
        Type = t;
    }

    public String getType() {

        return null;
    }

    public Points getPointA() {
        return pointA;
    }

    @Required
    public void setPointA(Points pointA) {
        this.pointA = pointA;
    }

    public Points getPointB() {
        return pointB;
    }

    public void setPointB(Points pointB) {
        this.pointB = pointB;
    }

    public Points getPointC() {
        return pointC;
    }

    public void setPointC(Points pointC) {
        this.pointC = pointC;
    }

    public Map<Character, Points> getPointMap() {
        return pointMap;
    }

    public void setPointMap(Map<Character, Points> pointMap) {
        this.pointMap = pointMap;
    }


    public float area()
    {
        return Math.abs((pointA.getX()*(pointB.getY() -pointC.getY()) + pointB.getX()*(pointC.getY() -pointA.getY()) + pointC.getX()*(pointA.getY()- pointB.getY()))/2);
    }

}