package com.interview.cab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *  Main class
 *
 * @author Krupa N
 */
@SpringBootApplication
public class CabServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CabServiceApplication.class, args);
	}
}