package com.springoot.tutorial.SpringBootLearning.dynamic_filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilteringController {

	@GetMapping("/dynamic-filter")
	public MappingJacksonValue getDynamicFiltering() {
		
		DynamicFilteringBean dynamicFilteringBean = new DynamicFilteringBean("1", "2", "3");
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dynamicFilteringBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
	}
}
