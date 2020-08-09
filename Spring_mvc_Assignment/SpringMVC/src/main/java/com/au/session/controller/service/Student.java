package com.au.session.controller.service;

public class Student {
	
	private int id;
	private String firstname;
	private String lastname;
	private String dept;
	
	public Student(){
	}
	
	public Student(int id, String firstname, String lastname, String dept)
	{
		this.setId(id);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setDept(dept);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	

}
