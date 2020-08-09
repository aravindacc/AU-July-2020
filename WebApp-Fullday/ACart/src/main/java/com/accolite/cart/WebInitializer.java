package com.accolite.cart;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.accolite.cart.config.SpringConfig;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] { SpringConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}