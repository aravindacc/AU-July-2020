package com.au.spring.model;
import java.util.Map;
import org.springframework.beans.factory.annotation.Required;

public class Triangle implements Shape{
	
	private String type;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	private Map<Character, Point>  pointMap;
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	
	public Point getPointA() {
		return pointA;
	}

	@Required
	public void setPointA(Point pointA) {
		this.pointA = pointA;
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
	
	
	public Map<Character, Point> getPointMap() {
		return pointMap;
	}


	public void setPointMap(Map<Character, Point> pointMap) {
		this.pointMap = pointMap;
	}


	public float area()
	{
		return Math.abs((pointA.getX()*(pointB.getY() -pointC.getY()) + pointB.getX()*(pointC.getY() -pointA.getY()) + pointC.getX()*(pointA.getY()- pointB.getY()))/2);
	}


	


	
}
