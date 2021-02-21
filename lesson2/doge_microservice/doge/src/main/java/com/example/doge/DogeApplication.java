package com.example.doge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DogeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogeApplication.class, args);
	}

}
