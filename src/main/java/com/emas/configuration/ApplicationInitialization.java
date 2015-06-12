package com.emas.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitialization implements WebApplicationInitializer {

	@SuppressWarnings("rawtypes")
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		Class[] configs = { WebAppConfig.class };
		ctx.register(configs);
		ctx.setServletContext(servletContext);
//		servletContext.setInitParameter( "spring.profiles.active", profile );
		Dynamic servlet = servletContext.addServlet( "dispatcher", new DispatcherServlet(ctx) );
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
	}

	
}