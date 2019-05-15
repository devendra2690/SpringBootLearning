package com.springoot.tutorial.SpringBootLearning.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.springoot.tutorial.SpringBootLearning.interceptor.InterceptorForDispatcherOne;
import com.springoot.tutorial.SpringBootLearning.interceptor.InterceptorForDispatcherTwo;

@Component
public class InterceptorConfiguration extends WebMvcConfigurerAdapter{

    @Autowired
    InterceptorForDispatcherOne interceptorForDispatcherOne;
 
    @Autowired
    InterceptorForDispatcherTwo interceptorForDispatcherTwo;
	 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		/*You can register interceptor for a particular URL pattern. If you do not specify any url pattern
		  Interceptor will intercept each and every url. 
         */		
		registry.addInterceptor(interceptorForDispatcherOne).addPathPatterns("/landing/login3/**");
		registry.addInterceptor(interceptorForDispatcherTwo);
	}	
}
