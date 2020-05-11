 package com.cogni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class PMangement {
	public static void main(String[] args) {
		SpringApplication.run(PMangement.class, args);
	}

}
