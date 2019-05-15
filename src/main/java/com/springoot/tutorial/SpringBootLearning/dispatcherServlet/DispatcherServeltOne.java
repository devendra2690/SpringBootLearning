package com.springoot.tutorial.SpringBootLearning.dispatcherServlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.springoot.tutorial.SpringBootLearning.controller.dispatcherOne") 
public class DispatcherServeltOne {
	
    /**
     * Registering View resolver for dispatcher servlet or front controller
     * 
     */
	@Bean
	public ViewResolver internalViewResolver() {
		
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		
		internalResourceViewResolver.setViewClass(JstlView.class);
		internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
		internalResourceViewResolver.setSuffix(".jsp");		
		return internalResourceViewResolver;
	}	
}
