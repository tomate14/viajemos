package com.example.viajemos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ViajemosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViajemosApplication.class, args);
	}

}
