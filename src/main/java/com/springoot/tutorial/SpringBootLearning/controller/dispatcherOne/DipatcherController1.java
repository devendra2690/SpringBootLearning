package com.springoot.tutorial.SpringBootLearning.controller.dispatcherOne;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springoot.tutorial.SpringBootLearning.exception.handler.CustomApplicationException;

@Controller
@RequestMapping(path="/landing")
public class DipatcherController1 {

	
	@GetMapping(path="/login")
	public String loginPage() {
		
		return "hello";
	}
	
	@GetMapping(path="/login3")
	public String loginPage1() {
		
		return "hello";
	}
	
	@GetMapping(path="/customException")
	public String customExceptoionMethod() {
		
		if(true) {
			throw new CustomApplicationException("Error occured while Running application for dispatcher 1.");
		}
		return "hello";
	}
}
