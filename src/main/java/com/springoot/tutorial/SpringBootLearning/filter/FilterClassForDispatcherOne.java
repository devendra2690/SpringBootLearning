package com.springoot.tutorial.SpringBootLearning.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterClassForDispatcherOne implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("######################### Filter for Dispatcher One");
		chain.doFilter(req, res);
	}
}
