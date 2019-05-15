package com.springoot.tutorial.SpringBootLearning.rest.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDummyDao {

	private static List<Customer> customerList = new ArrayList<>();
	
	static {
		
		customerList.add(new Customer(1,"Devendra"));
		customerList.add(new Customer(2,"Rashmi"));
		customerList.add(new Customer(3,"Golu"));
		customerList.add(new Customer(4,"Amit"));
	}
	
	
	public List<Customer> getAllUser() {
		
		return customerList;
	}
	
	public Customer getCustomerDetails(int id) {
		
		for (Customer customer : customerList) {
			
			if(customer.getId() == id) {
				
				return customer;
			}
		}
		
		return null;
	}
	
	public List<Customer> addCustomer(Customer customer) {
		
		customerList.add(customer);
		
		return customerList;
	}
}
