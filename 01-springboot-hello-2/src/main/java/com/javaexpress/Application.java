package com.javaexpress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan(basePackages = {"org.javaexpress"})
// base package to sub packages - com.javaexpress ---> com.javaexpress.models or services or dao
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
