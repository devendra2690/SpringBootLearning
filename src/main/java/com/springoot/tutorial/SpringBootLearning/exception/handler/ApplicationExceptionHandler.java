package com.springoot.tutorial.SpringBootLearning.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The @ControllerAdvice is an annotation, to handle the exceptions globally.

 * @author dpatil
 *
 */
@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(value=CustomApplicationException.class)
	public ResponseEntity<Object> cutomExpetion(CustomApplicationException customApplication) {
		return new ResponseEntity<> (customApplication.getErrorMessage(),HttpStatus.NOT_FOUND); 
	}
}
