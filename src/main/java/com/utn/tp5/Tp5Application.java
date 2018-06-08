package com.utn.tp5;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tp5Application {
	public static ModelMapper modelmapper;
	public static void main(String[] args) {
		modelmapper = new ModelMapper();
		SpringApplication.run(Tp5Application.class, args);
	}
}
