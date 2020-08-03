package com.auth.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);

		//call java method
		//RestTemplate restTemplate = new RestTemplate();
		//User obj = restTemplate.getForObject("http://localhost:8080/usertoken", User.class);


	}



}
