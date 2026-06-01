package com.arl.arl_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ArlBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArlBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner showUrl() {
		return args -> {
			System.out.println();
			System.out.println("--------------------------------------------------");
			System.out.println("Backend is running:");
			System.out.println("Local: http://localhost:8080/");
			System.out.println("Books API: http://localhost:8080/api/books");
			System.out.println("--------------------------------------------------");
			System.out.println();
		};
	}
}