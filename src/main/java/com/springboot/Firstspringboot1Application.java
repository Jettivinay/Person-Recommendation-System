package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Firstspringboot1Application {

	public static void main(String[] args) {
		SpringApplication.run(Firstspringboot1Application.class, args);
	}

}
