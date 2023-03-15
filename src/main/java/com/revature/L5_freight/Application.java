package com.revature.L5_freight;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The @SpringBootApplication annotation enables automatic configuration of a Spring App.
 */
@SpringBootApplication
public class Application {
	/**
	 * set up a logger - to be used in the Aspect classes to apply logging to all Service class methods via AOP
	 */
	public static Logger log = LogManager.getLogger(Application.class);

	/**
	 * Automatically configure & run the Spring Application Context, start Controllers
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}