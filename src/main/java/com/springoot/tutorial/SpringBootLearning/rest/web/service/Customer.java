package com.springoot.tutorial.SpringBootLearning.rest.web.service;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Customer {

	private int id;
	
	@Size(min=1,message="Customer Name should be atleast one size.")
	@ApiModelProperty
	private String name;
			
	public Customer() {
		
	}
	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
}
