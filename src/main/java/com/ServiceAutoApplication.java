package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class })
@ComponentScan("com")
public class ServiceAutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAutoApplication.class, args);
	}

}
