package com.unq.ViandasYaGrupoC2C022019.log4j;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PropertiesFileLog4j {

	static Logger logger = Logger.getLogger(PropertiesFileLog4j.class);
	
	public static void main(String[] args) {
		String log4jConfigFile = System.getProperty("user.dir")
									+ File.separator + "\\src\\main\\resources\\" +
									"application.properties";
		
		PropertyConfigurator.configure(log4jConfigFile);
		logger.debug("this is a debug log messages");
		logger.info("this is a info log messages");
		logger.warn("this is a warning log massages");
	}
}
