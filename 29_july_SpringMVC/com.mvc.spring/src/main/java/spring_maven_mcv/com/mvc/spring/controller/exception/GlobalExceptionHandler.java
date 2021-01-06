package spring_maven_mcv.com.mvc.spring.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler(StudentNotFound.class)
	public ModelAndView handleStudentNotFound(HttpServletRequest req, Exception ex)
	{
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", req.getRequestURL());
	    
	    modelAndView.setViewName("error");
	    return modelAndView;		
	}
	
	@ExceptionHandler(StudentWithSameRollnumber.class)
	public ModelAndView handleStudentWithSameRollnumber(HttpServletRequest req, Exception ex)
	{
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", req.getRequestURL());	    
	    modelAndView.setViewName("error");
	    return modelAndView;		
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest req, Exception ex)
	{
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", req.getRequestURL());	    
	    modelAndView.setViewName("error");
	    return modelAndView;		
	}
}
