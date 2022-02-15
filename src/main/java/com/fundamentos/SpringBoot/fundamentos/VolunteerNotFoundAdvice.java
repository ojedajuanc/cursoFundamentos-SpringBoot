package com.fundamentos.SpringBoot.fundamentos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class VolunteerNotFoundAdvice {
	
	@ResponseBody //signals that this advice is rendered straight into the response body
	@ExceptionHandler(VolunteerNotFoundException.class) // configures the advice to only respond if a volunteer exception is thrown
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String volunteerNotFoundHandler(VolunteerNotFoundException ex) {
		return ex.getMessage();
	}

}
