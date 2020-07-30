package spring_maven_mcv.com.mvc.spring.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Student not found")
public class StudentNotFound extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public StudentNotFound(int id) {
		super("Student not found with id "+id);
	}
}
