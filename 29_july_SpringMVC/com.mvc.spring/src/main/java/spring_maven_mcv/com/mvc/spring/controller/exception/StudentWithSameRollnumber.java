package spring_maven_mcv.com.mvc.spring.controller.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Student with same id found")
public class StudentWithSameRollnumber extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public StudentWithSameRollnumber(int id) {
		super("Student found with same id "+id);
	}
}
