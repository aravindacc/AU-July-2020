package com.au.session.controller.model;

public class StudentWithSameRollNumber extends Exception{
	
	private static final long serialVersionUID= 1L;
	
	public StudentWithSameRollNumber(int id) {
		super("Two students are found with same Roll Number "+ id);
		System.out.println("Two students are found with same Roll Number");
	}

}
