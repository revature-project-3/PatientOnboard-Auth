package com.patientonboard.authenticationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PatientOnboardAuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientOnboardAuthenticationServiceApplication.class, args);
	}

}
