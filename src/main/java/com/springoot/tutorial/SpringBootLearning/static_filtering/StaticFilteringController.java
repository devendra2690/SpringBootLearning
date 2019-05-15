package com.springoot.tutorial.SpringBootLearning.static_filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticFilteringController {

	@GetMapping("/fieldLevel/static-filtering")
	public SomeBean getSomeBean() {
		
		return new SomeBean("value", "value2", "value3");
	}
	
	@GetMapping("/classLevel/static-filtering")
	public SomeOtherBean getSomeOtherBean() {
		
		return new SomeOtherBean("value1", "value2", "value3");
	}
}
