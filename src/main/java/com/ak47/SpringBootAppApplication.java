package com.ak47;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
		System.out.println(":::::::::::::::: Running on port 8080 ::::::::::::::::");
		System.out.println();
	}

	@Bean
	public ModelMapper modelMappper() {
		return new ModelMapper();
	}
}
