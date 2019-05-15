package com.springoot.tutorial.SpringBootLearning.controller.dispatcherTwo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/landing")
public class DispatcherControllerTwo {

	@GetMapping(path="/login2")
	public String loginPage() {
		
		return "login2";
	}
}
