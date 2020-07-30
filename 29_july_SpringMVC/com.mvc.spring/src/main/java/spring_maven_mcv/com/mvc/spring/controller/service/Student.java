package spring_maven_mcv.com.mvc.spring.controller.service;

public class Student {
	private int id;
	private String name;
	
	public Student() {
	}
	
	public Student(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
