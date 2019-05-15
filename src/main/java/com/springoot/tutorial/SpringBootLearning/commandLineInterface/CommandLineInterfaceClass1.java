package com.springoot.tutorial.SpringBootLearning.commandLineInterface;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * CommandLineRunner interface in Spring Boot provides an option to run a specific piece of code when the application is fully started. 
 * This interface called automatically by the Spring Boot after the initial bootstrapping of application.
 * 
 * When to Use CommandLineRunner
	CommandLineRunner interface in Spring Boot application is an important tool. Here are some of the common use cases for this interface.
	
	Preparing application initial data.
	Source data from external services.
 * 
 * 
 * @author dpatil
 *
 */

@Component
@Order(1)
public class CommandLineInterfaceClass1 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
	
		System.out.println("Command Line Runner 1");
	}
}
