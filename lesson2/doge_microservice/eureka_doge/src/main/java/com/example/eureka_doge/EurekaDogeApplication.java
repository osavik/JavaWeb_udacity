package com.example.eureka_doge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDogeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDogeApplication.class, args);
	}

}
