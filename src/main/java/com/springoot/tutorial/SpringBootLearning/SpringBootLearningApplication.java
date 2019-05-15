package com.springoot.tutorial.SpringBootLearning;

import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.springoot.tutorial.SpringBootLearning.dispatcherServlet.DispatcherServeltOne;
import com.springoot.tutorial.SpringBootLearning.dispatcherServlet.DispatcherServeltTwo;
import com.springoot.tutorial.SpringBootLearning.filter.FilterClassForDispatcherOne;
import com.springoot.tutorial.SpringBootLearning.filter.FilterClassForDispatcherTwo;

/**
 * ####### What is this class? ####### 
 * 
 * This is main class of spring boot application. This class is annotated with @SpringBootApplication.
 * This tell that this is main class and is configuration class. You can define multiple dispatcher servlet or filters or interceptor etc.  
 * 
 * @SpringBootApplication : This is internally represent three annotation: @configuration, @ComponentScan, @EnableAutoConfiguration
 * 
 *  @Configuration : This tell Spring boot that this configuration class and you should execute, read configuration mentioned in this class 
 *                   and load required bean in container.
 *  
 *  @ComponentScan : This tell additionally which package spring boot should scan to load required bean(Controller , Service etc.)
 *                   You can mention many package in array format. If we don't specify anything then it will scan all classes present in
 *                   SpringBootLearningApplication (main class) package or child package.                      
 *  
 *  @EnableAutoConfiguration: Spring boot try to be smarter by loading required dependency by reading dependency defined on classpath.
 * 
 
   ####### Why Extending SpringBootServletInitializer for Main class?? ####### 
 * 
 * This main class which is entry point of application.
 * You don't really need to extend SpringBootServletInitializer class if you are planning to create jar as packing of
 * this application.
 * 
 * But we need to extend SpringBootServletInitializer if we want to crate WAR file and deploy it on tomcat.
 * with extending, you need to add below entry in POM.xml to let tomcat know that this is main class.
 * Also you need to overide configure() method and configure SpringBootLearningApplication class.
 * 		
 * <properties>
 *  <start-class>com.springoot.tutorial.SpringBootLearning.SpringBootLearningApplication</start-class>
   </properties>
 * 
 * @author dpatil
 *
 */
@SpringBootApplication
public class SpringBootLearningApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLearningApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootLearningApplication.class);
	}
	
	/**
	 * 
	 * Setup Multiple Dispatcher Servlet in Spring Boot
	 * Below methods registerServletOne & registerServletTwo used for that
	 * @return
	 */
	@Bean
	public ServletRegistrationBean registerServletOne() {
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet();
       
		AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
		annotationConfigWebApplicationContext.register(DispatcherServeltOne.class);
		
		dispatcherServlet.setApplicationContext(annotationConfigWebApplicationContext);
		
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(dispatcherServlet,"/dispatcherOne/*");
		registrationBean.setLoadOnStartup(1);
		registrationBean.setName("dispatcherOne");
		
		return registrationBean;
	}
	
	@Bean
	public ServletRegistrationBean registerServletTwo() {
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		
		AnnotationConfigWebApplicationContext  annotationConfigWebApplicationContext  = new AnnotationConfigWebApplicationContext();
		annotationConfigWebApplicationContext.register(DispatcherServeltTwo.class);
		
		dispatcherServlet.setApplicationContext(annotationConfigWebApplicationContext);
		
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(dispatcherServlet, "/dispatcherTwo/*");
		registrationBean.setLoadOnStartup(2);
		registrationBean.setName("dispatcherTwo");
		
		return registrationBean;		
	}
	
	/**
	 * 
	 * Set Context Parameter in Spring Boot application
	 * 
	 * Update: in Spring Boot 1.2 using a ServletContextInitializer is no longer necessary. 
	 * You can now configure a parameter on the ServletContext in a single line in application.properties:

       server.context_parameters.p-name=-value

	 * @return
	 */
	@Bean
	public ServletContextInitializer contextIntitalizer() {
		
		return new ServletContextInitializer() {
			
			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				
				servletContext.setInitParameter("param-name", "param-value");
			}
		};
	}
	
	
	/**
	 * 
	 * Filter Registration in Spring boot.
	 * Seperate Filter for Seperate Dispatcher servlet.
	 * 
	 * registerFilterOne() for dispatcherOne
	 * registerFilterTwo() for dispatcherTwo
	 * 
	 * @return
	 */
	
	@Bean
	public FilterRegistrationBean registerFilterOne() {
		
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setOrder(1);
		filterRegistrationBean.setName("filter-one");
		filterRegistrationBean.setFilter(new FilterClassForDispatcherOne());
		filterRegistrationBean.addUrlPatterns("/dispatcherOne/*");
		
		return filterRegistrationBean;
	}
	
	@Bean
	public FilterRegistrationBean registerFilterTwo() {
		
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setOrder(1);
		filterRegistrationBean.setName("filter-two");
		filterRegistrationBean.setFilter(new FilterClassForDispatcherTwo());
		filterRegistrationBean.addUrlPatterns("/dispatcherTwo/*");
		
		return filterRegistrationBean;
	}
	
	
	@Bean
	public LocaleResolver localResolver() {
		
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		
		return localeResolver;
	}
	
	@Bean
	public ResourceBundleMessageSource bundleMessageSource() {
		
		ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
		bundleMessageSource.setBasename("messages");
	    return bundleMessageSource;
	}
}

