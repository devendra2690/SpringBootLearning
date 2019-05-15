package com.springoot.tutorial.SpringBootLearning.dispatcherServlet;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.springoot.tutorial.SpringBootLearning.controller.dispatcherTwo") 
public class DispatcherServeltTwo {

}
