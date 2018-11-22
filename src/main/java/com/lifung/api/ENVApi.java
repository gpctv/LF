package com.lifung.api;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

public class ENVApi {

	public boolean condition(ServletContext servletContext) throws Exception {
		 
		Properties prop = new Properties();
		System.out.println(servletContext.getRealPath("/WEB-INF/jdbc.properties"));
		
		InputStream  input = null;
		input = new FileInputStream( servletContext.getRealPath("/WEB-INF/jdbc.properties"));
		prop.load(input);
		String condition=prop.getProperty("jdbc.databaseurl");
		System.out.println(condition);
		boolean c=false;
		if(null == condition || "".equals(condition)) {
			c=false;
		}else {
			c=condition.contains("VMSGWMSDBUT4");
		}
		return c; 
	}
}
