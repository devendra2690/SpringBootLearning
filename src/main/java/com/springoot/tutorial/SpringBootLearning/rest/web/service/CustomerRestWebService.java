package com.springoot.tutorial.SpringBootLearning.rest.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestWebService {

	@Autowired
	CustomerDummyDao customerDummyDao;

	@Autowired
	ResourceBundleMessageSource  messageSource;
	
	
	@GetMapping("/getAllUser")
	public List<Customer> getListOfCustomer() {
		
		return customerDummyDao.getAllUser();
	}
	
	@GetMapping("/getUserDetails/{id}")
	public Customer getCustomerDetails(@PathVariable("id") int id) {
		
		return customerDummyDao.getCustomerDetails(id);
	}
	
	
	@GetMapping("/getUserDetails/getResponseInXML/{id}")
	public Customer getCustomerDetailsByXMLResponse(@PathVariable("id") int id) {
		
		return customerDummyDao.getCustomerDetails(id);
	}
	
	@PostMapping("/addCustomer")
	public List<Customer> addCustomer(@RequestBody Customer customer) {
		
		return customerDummyDao.addCustomer(customer);
	}
	
	
	@GetMapping("/getUserDetails/hateos/{id}")
	public Resource<Customer> getCustomerDetailsWithHATEOS(@PathVariable("id") int id) {
		
		Customer customer = customerDummyDao.getCustomerDetails(id);
		Resource<Customer> resource = new Resource<Customer>(customer);
		
		ControllerLinkBuilder controllerLinkBuilder = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getListOfCustomer());
		resource.add(controllerLinkBuilder.withRel("all-user"));
		
		ControllerLinkBuilder controllerLinkBuilder2 = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(getClass(),"{id}").getCustomerDetails(id));
		resource.add(controllerLinkBuilder2.withRel("user-by-id"));
		
		return resource;
	}
	
	
	@GetMapping("/getMessge/useInternationalization")
	public String getMessage() {
		
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
}
